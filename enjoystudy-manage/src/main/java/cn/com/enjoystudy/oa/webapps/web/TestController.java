package cn.com.enjoystudy.oa.webapps.web;

import cn.com.enjoystudy.oa.bean.base.EmployeeAccount;
import cn.com.enjoystudy.oa.bean.study.*;
import cn.com.enjoystudy.oa.common.Constants;
import cn.com.enjoystudy.oa.service.study.*;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/web/test")
public class TestController extends PaperController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private TeachCourseService teachCourseService;
    @Autowired
    private CourseVideoService courseVideoService;
    @Autowired
    private EmployeeCourseStudyService employeeCourseStudyService;
    @Autowired
    private EmployeeExaminationPaperService employeeExaminationPaperService;

    @RequestMapping("course-check")
    public JSONObject courseCheck(@RequestParam String courseId) {
        EmployeeAccount account = getCurrentUser();
        if (null != account) {
            if (account.getCategory().equals(Constants.ACCOUNT_CATEGORY_STUDENT)) {
                if (null != account.getFirstLoginState() && account.getFirstLoginState()) {
                    return resultError("进入考试前，请您先修改好您的个人资料，以免后期带来不便，谢谢合作！");
                }
            }

            boolean flag = true;
            Course course = courseService.getById(courseId);

            if (null != course.getFreeState() && course.getFreeState().equals(Boolean.FALSE)) {
                TeachCourseSO teachCourseSO = new TeachCourseSO();
                teachCourseSO.setEmployeeId(getCurrentUser().getId());
                teachCourseSO.setCourseId(courseId);
                List<TeachCourse> teachCourseList = teachCourseService.learnCourseList(teachCourseSO);
                if (CollectionUtils.isNotEmpty(teachCourseList)) {
                    boolean exists = false;
                    for (TeachCourse teachCourse : teachCourseList) {
                        if (courseId.equals(teachCourse.getCourseId())) {
                            exists = true;
                            break;
                        }
                    }
                    flag = exists;
                }
            }

            if (flag) {
                if (null != course.getStudyToExamState() && course.getStudyToExamState()) {
                    CourseVideoSO videoSO = new CourseVideoSO();
                    videoSO.setCourseId(course.getId());
                    long videoAmount = courseVideoService.getCount(videoSO);
                    long studyAmount = employeeCourseStudyService.getStudyAmount(account.getId(), course.getId());
                    if (videoAmount >= studyAmount) {
                        return resultError("该课程需要学习完成后方可考试！");
                    }
                }

                EmployeeExaminationPaperSO paperSO = new EmployeeExaminationPaperSO();
                paperSO.setCourseId(course.getId());
                paperSO.setEmployeeId(account.getId());
                List<EmployeeExaminationPaper> employeeExaminationPaperList = employeeExaminationPaperService.list(paperSO);

                String paperId = "";
                JSONObject result = resultSuccess();

                if (CollectionUtils.isNotEmpty(employeeExaminationPaperList)) {
                    boolean testing = false;
                    for (EmployeeExaminationPaper paper : employeeExaminationPaperList) {
                        if (!paper.getTestState().equals(Constants.TEST_STATE_END)) {
                            if (new Date().before(paper.getEndTime())) {
                                testing = true;
                                paperId = paper.getId();
                                break;
                            }
                        }
                    }

                    if (testing == false) {
                        if (course.getTestAmount().equals(-1) || employeeExaminationPaperList.size() <= course.getTestAmount()) {
                            paperId = saveEmployeeExaminationPaper(account, course);
                        }
                    }
                } else {
                    paperId = saveEmployeeExaminationPaper(account, course);
                }

                result.put("paperId", paperId);
                return  result;
            }
        } else {
            return resultError("请先登录系统再考试！");
        }
        return resultError();
    }

    @RequestMapping("paper-test")
    public ModelAndView paperTest(@RequestParam String paperId) {
        // 单选题
        List<EmployeeExaminationQuestion> list1 = new ArrayList<EmployeeExaminationQuestion>();
        // 多选题
        List<EmployeeExaminationQuestion> list2 = new ArrayList<EmployeeExaminationQuestion>();
        // 判断题
        List<EmployeeExaminationQuestion> list4 = new ArrayList<EmployeeExaminationQuestion>();

         EmployeeExaminationPaper paper = employeeExaminationPaperService.getById(paperId);

        if (null != paper) {
            if (CollectionUtils.isNotEmpty(paper.getQuestionList())) {
                for (EmployeeExaminationQuestion question : paper.getQuestionList()) {
                    if (question.getCategory().equals(1)) {
                        list1.add(question);
                    } else if (question.getCategory().equals(2)) {
                        list2.add(question);
                    } else if (question.getCategory().equals(4)) {
                        list4.add(question);
                    }
                }
            }
        }

        ModelAndView mv = new ModelAndView("web/test/paper-test");
        mv.getModel().put("paper", paper);
        mv.getModel().put("list1", list1);
        mv.getModel().put("list2", list2);
        mv.getModel().put("list4", list4);
        return mv;
    }
}
