package cn.com.enjoystudy.oa.webapps.manage.study;

import cn.com.enjoystudy.oa.bean.base.EmployeeAccount;
import cn.com.enjoystudy.oa.bean.study.*;
import cn.com.enjoystudy.oa.filter.ManageSessionFilter;
import cn.com.enjoystudy.oa.service.study.*;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("/manage/study/employee-examination")
public class EmployeeExaminationController extends BaseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private EmployeeExaminationPaperService employeeExaminationPaperService;
    @Autowired
    private EmployeeExaminationQuestionService employeeExaminationQuestionService;
    @Autowired
    private EmployeeExaminationQuestionAnalysisService employeeExaminationQuestionAnalysisService;
    @Autowired
    private EmployeeExaminationQuestionItemService employeeExaminationQuestionItemService;
    @Autowired
    private CourseVideoService courseVideoService;
    @Autowired
    private EmployeeCourseStudyService employeeCourseStudyService;
    @Autowired
    private StorePaperService storePaperService;
    @Autowired
    private StoreQuestionService storeQuestionService;
    @Autowired
    private StoreQuestionAnalysisService storeQuestionAnalysisService;
    @Autowired
    private StoreQuestionItemService storeQuestionItemService;

    @RequestMapping("course-index")
    public ModelAndView courseIndex() {
        ModelAndView mv = new ModelAndView("manage/study/employee-examination/course-index");
        return mv;
    }

    @RequestMapping("course-list")
    @ResponseBody
    public JSONObject courseList(CourseSO so) {
        so.setTestState(2);
        PageInfo<Course> pageInfo = courseService.findPag(so);
        JSONObject json = resultSuccess();
        json.put("datas", pageInfo.getList());
        json.put("total", pageInfo.getTotal());
        json.put("pages", pageInfo.getPages());
        return json;
    }

    @RequestMapping("check-test")
    @ResponseBody
    public JSONObject checkTest(@RequestParam("courseId") String courseId) {
        Course course = courseService.getById(courseId);
        if (null != course && course.getTestState().equals(2)) {
            Subject subject = SecurityUtils.getSubject();
            Object object = subject.getSession().getAttribute(ManageSessionFilter.DEFAULT_LOGIN_USER);
            EmployeeAccount account = (EmployeeAccount) object;

            EmployeeExaminationPaperSO paperSO = new EmployeeExaminationPaperSO();
            paperSO.setCourseId(course.getId());
            List<EmployeeExaminationPaper> list = employeeExaminationPaperService.list(paperSO);

            if (null != list && list.size() > 0) {
                boolean flag = false;
                String paperId = "";
                for (EmployeeExaminationPaper paper : list) {
                    if (paper.getTestState().equals(1) || paper.getTestState().equals(2)) {
                        paperId = paper.getId();
                        flag = true;
                        break;
                    } else if (paper.getTestScore() < paper.getPassScore()) {
                        flag = true;
                        break;
                    }
                }

                if (StringUtils.isBlank(paperId)) {
                    if (flag) {
                        if (list.size() <= course.getTestAmount()) {
                            CourseVideoSO videoSO = new CourseVideoSO();
                            videoSO.setCourseId(course.getId());
                            long videoAmount = courseVideoService.getCount(videoSO);
                            long studyAmount = employeeCourseStudyService.getStudyAmount(account.getId(), course.getId());

                            if (studyAmount >= videoAmount) {
                                paperId = saveEmployeeExaminationPaper(account, course);
                                JSONObject json = resultSuccess("成功领取考卷。");
                                json.put("paperId", paperId);
                                return json;
                            } else {
                                return resultError("课程视频尚未学习完成，暂不能参加该课程考试。");
                            }
                        } else {
                            return resultError("您已经超过补考次数！不能再进行考试，请您回去复习再申请考试，加油！");
                        }
                    } else {
                        return resultError("您不需要参与本课程的考试！");
                    }
                } else {
                    JSONObject json = resultSuccess("成功领取考卷。");
                    json.put("paperId", paperId);
                    return json;
                }
            } else {
                String paperId = saveEmployeeExaminationPaper(account, course);
                JSONObject json = resultSuccess("成功领取考卷。");
                json.put("paperId", paperId);
                return json;
            }
        } else {
            return resultError("考试尚未开始或已经结束");
        }
    }

    private String saveEmployeeExaminationPaper(EmployeeAccount account, Course course) {
        StorePaperSO paperSO = new StorePaperSO();
        paperSO.setCourseId(course.getId());
        List<StorePaper> storePaperList = storePaperService.list(paperSO);
        if (null != storePaperList && storePaperList.size() > 0) {
            Calendar calendar = Calendar.getInstance();

            Random random = new Random();
            StorePaper storePaper = storePaperList.get(random.nextInt(storePaperList.size()));

            EmployeeExaminationPaper examinationPaper = new EmployeeExaminationPaper();
            examinationPaper.setEmployeeId(account.getId());
            examinationPaper.setEmployeeName(account.getFullName());
            examinationPaper.setCourseId(course.getId());
            examinationPaper.setCourseName(course.getName());
            examinationPaper.setPaperId(storePaper.getId());
            examinationPaper.setPaperTitle(storePaper.getTitle());
            examinationPaper.setStartTime(calendar.getTime());
            calendar.add(Calendar.MINUTE, storePaper.getDuration());
            examinationPaper.setEndTime(calendar.getTime());
            examinationPaper.setTestScore(0);
            examinationPaper.setPassState(false);
            examinationPaper.setPassScore(storePaper.getPassScore());
            examinationPaper.setTotalScore(storePaper.getTotalScore());
            examinationPaper.setJoinState(1);
            examinationPaper.setTestState(1);
            examinationPaper.setSingleAmount(0);
            examinationPaper.setMultiAmount(0);
            examinationPaper.setFillAmount(0);
            examinationPaper.setCheckAmount(0);
            examinationPaper.setJudgeAmount(0);

            employeeExaminationPaperService.insert(examinationPaper);

            StoreQuestionSO questionSO = new StoreQuestionSO();
            questionSO.setPaperId(storePaper.getId());
            List<StoreQuestion> storeQuestionList = storeQuestionService.list(questionSO);
            if (null != storeQuestionList && storeQuestionList.size() > 0) {

                for (StoreQuestion storeQuestion : storeQuestionList) {
                    EmployeeExaminationQuestion examinationQuestion = new EmployeeExaminationQuestion();
                    examinationQuestion.setPaperId(examinationPaper.getId());
                    examinationQuestion.setQuestionId(storeQuestion.getId());
                    examinationQuestion.setCategory(storeQuestion.getCategory());
                    examinationQuestion.setScore(storeQuestion.getScore());
                    examinationQuestion.setTitle(storeQuestion.getTitle());
                    examinationQuestion.setAnswerState(1);
                    examinationQuestion.setRightState(false);
                    employeeExaminationQuestionService.insert(examinationQuestion);

                    StoreQuestionItemSO questionItemSO = new StoreQuestionItemSO();
                    questionItemSO.setQuestionId(storeQuestion.getId());
                    List<StoreQuestionItem> storeQuestionItemList = storeQuestionItemService.list(questionItemSO);
                    if (null != storeQuestionItemList && storeQuestionItemList.size() > 0) {
                        for (StoreQuestionItem storeQuestionItem : storeQuestionItemList) {
                            List<EmployeeExaminationQuestionItem> employeeExaminationQuestionItemList = new ArrayList<EmployeeExaminationQuestionItem>();

                            EmployeeExaminationQuestionItem examinationQuestionItem = new EmployeeExaminationQuestionItem();
                            examinationQuestionItem.setTitle(storeQuestionItem.getTitle());
                            examinationQuestionItem.setAnswer(storeQuestionItem.getAnswer());
                            examinationQuestionItem.setCheckState(false);
                            examinationQuestionItem.setQuestionId(examinationQuestion.getId());
                            employeeExaminationQuestionItemService.insert(examinationQuestionItem);
                        }
                    }

                    StoreQuestionAnalysis questionAnalysis = storeQuestionAnalysisService.getAnalysisQuestionId(storeQuestion.getId());
                    if (null != questionAnalysis) {
                        EmployeeExaminationQuestionAnalysis examinationQuestionAnalysis = new EmployeeExaminationQuestionAnalysis();
                        examinationQuestionAnalysis.setContent(questionAnalysis.getContent());
                        examinationQuestionAnalysis.setQuestionId(examinationQuestion.getId());
                        employeeExaminationQuestionAnalysisService.insert(examinationQuestionAnalysis);
                    }

                }
            }
            return examinationPaper.getId();
        }
        return null;
    }

    @RequestMapping("paper-test")
    public ModelAndView paperTest(@RequestParam("paperId") String paperId) {
        ModelAndView mv = new ModelAndView("manage/study/employee-examination/paper-test");
        mv.getModel().put("paperId", paperId);
        return mv;
    }

    @RequestMapping("paper-details")
    @ResponseBody
    public JSONObject paperDetails(@RequestParam("paperId") String paperId) {
        EmployeeExaminationPaper paper = employeeExaminationPaperService.getById(paperId);
        JSONObject json = resultSuccess();
        json.put("paper", paper);
        return json;
    }

    @RequestMapping("save-answer")
    @ResponseBody
    public JSONObject saveAnswer(@RequestBody EmployeeExaminationQuestionSO so) {
        List<EmployeeExaminationQuestionItem> itemList = employeeExaminationQuestionService.findItemByQuestionId(so.getId());

        if (null != itemList && itemList.size() > 0) {
            Boolean[] r = new Boolean[itemList.size()];
            Boolean[] c = new Boolean[itemList.size()];

            int i = 0;
            for (EmployeeExaminationQuestionItem item : so.getItemList()) {
                EmployeeExaminationQuestionItem questionItem = employeeExaminationQuestionItemService.getById(item.getId());
                questionItem.setCheckState(item.getCheckState());
                employeeExaminationQuestionItemService.update(questionItem);

                r[i] = questionItem.getAnswer();
                c[i] = item.getCheckState();
                i++;
            }

            boolean right = Arrays.equals(r, c);

            EmployeeExaminationQuestion question = employeeExaminationQuestionService.getById(so.getId());
            question.setAnswerState(3);
            question.setRightState(right);
            employeeExaminationQuestionService.update(question);
        }
        return resultSuccess();
    }

    @RequestMapping("save-paper")
    @ResponseBody
    public JSONObject savePaper(@RequestBody EmployeeExaminationPaperSO so) {
        Subject subject = SecurityUtils.getSubject();
        Object object = subject.getSession().getAttribute(ManageSessionFilter.DEFAULT_LOGIN_USER);
        EmployeeAccount account = (EmployeeAccount) object;

        EmployeeExaminationPaper paper = employeeExaminationPaperService.getById(so.getId());
        if (account.getId().equals(paper.getEmployeeId())) {
            int testScore = 0;

            for (EmployeeExaminationQuestion oq : paper.getQuestionList()) {
                for (EmployeeExaminationQuestion nq : so.getQuestionList()) {
                    if (oq.getId().equals(nq.getId())) {
                        Boolean[] r = new Boolean[paper.getQuestionList().size()];
                        Boolean[] c = new Boolean[paper.getQuestionList().size()];

                        int i = 0;
                        for (EmployeeExaminationQuestionItem oi : oq.getItemList()) {
                            for (EmployeeExaminationQuestionItem ni : nq.getItemList()) {
                                if (oi.getId().equals(ni.getId())) {
                                    oi.setCheckState(ni.getCheckState());
                                    employeeExaminationQuestionItemService.update(oi);

                                    r[i] = oi.getAnswer();
                                    c[i] = ni.getCheckState();

                                    i++;
                                    break;
                                }
                            }
                        }

                        boolean right = Arrays.equals(r, c);

                        oq.setAnswerState(3);
                        oq.setRightState(right);
                        if (right) {
                            testScore += oq.getScore();
                        }
                        employeeExaminationQuestionService.update(oq);
                        break;
                    }
                }
            }

            paper.setSubmitTime(new Date());
            paper.setTestScore(testScore);
            if (testScore >= paper.getPassScore()) {
                paper.setPassState(true);
            } else {
                paper.setPassState(false);
            }
            paper.setTestState(3);
            employeeExaminationPaperService.update(paper);

            return resultSuccess("本次考试成绩为：" + testScore + "，考试为：" + (paper.getPassState() ? "不及格" : "不及格"));
        } else {
            return resultError("不能提交别人的考卷！");
        }
    }


    @RequestMapping("score-index")
    public ModelAndView paperTest() {
        ModelAndView mv = new ModelAndView("manage/study/employee-examination/score-index");
        return mv;
    }

    @RequestMapping("score-list")
    @ResponseBody
    public JSONObject scoreList(EmployeeExaminationPaperSO so) {
        Subject subject = SecurityUtils.getSubject();
        Object object = subject.getSession().getAttribute(ManageSessionFilter.DEFAULT_LOGIN_USER);
        EmployeeAccount account = (EmployeeAccount) object;

        so.setEmployeeId(account.getId());

        PageInfo<EmployeeExaminationPaper> pageInfo = employeeExaminationPaperService.findPage(so);
        JSONObject json = resultSuccess();
        json.put("datas", pageInfo.getList());
        json.put("total", pageInfo.getTotal());
        json.put("pages", pageInfo.getPages());
        return json;
    }
}
