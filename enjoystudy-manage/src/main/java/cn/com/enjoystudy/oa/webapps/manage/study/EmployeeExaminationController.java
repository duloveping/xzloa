package cn.com.enjoystudy.oa.webapps.manage.study;

import cn.com.enjoystudy.oa.bean.base.EmployeeAccount;
import cn.com.enjoystudy.oa.bean.study.*;
import cn.com.enjoystudy.oa.bean.sys.SysSequence;
import cn.com.enjoystudy.oa.common.Constants;
import cn.com.enjoystudy.oa.filter.ManageSessionFilter;
import cn.com.enjoystudy.oa.service.base.EmployeeAccountService;
import cn.com.enjoystudy.oa.service.study.*;
import cn.com.enjoystudy.oa.service.sys.SysSequenceService;
import cn.com.enjoystudy.oa.webapps.web.PaperController;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/manage/study/employee-examination")
public class EmployeeExaminationController extends PaperController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private EmployeeExaminationPaperService employeeExaminationPaperService;
    @Autowired
    private EmployeeExaminationQuestionService employeeExaminationQuestionService;
    @Autowired
    private EmployeeExaminationQuestionItemService employeeExaminationQuestionItemService;
    @Autowired
    private CourseVideoService courseVideoService;
    @Autowired
    private EmployeeCourseStudyService employeeCourseStudyService;
    @Autowired
    private EmployeeCertificateService employeeCertificateService;
    @Autowired
    private SysSequenceService sysSequenceService;
    @Autowired
    private EmployeeAccountService employeeAccountService;
    @Autowired
    private TeachCourseService teachCourseService;

    @RequestMapping("course-index")
    public ModelAndView courseIndex() {
        ModelAndView mv = new ModelAndView("manage/study/employee-examination/course-index");
        return mv;
    }

    @RequestMapping("course-list")
    @ResponseBody
    public JSONObject courseList(TeachCourseSO so) {
        EmployeeAccount account = getCurrentUser();
        so.setEmployeeId(account.getId());
        so.setTestState(2);
        PageInfo<TeachCourse> pageInfo = teachCourseService.learnCoursePage(so);
        return resultSuccess(pageInfo);
    }

    @RequestMapping("check-test")
    @ResponseBody
    public JSONObject checkTest(@RequestParam("courseId") String courseId) {
        JSONObject json = resultSuccess();

        EmployeeAccount account = getCurrentUser();
        boolean firstFlag = true;
        if (account.getCategory().equals(Constants.ACCOUNT_CATEGORY_STUDENT)) {
            if (null != account.getFirstLoginState() && account.getFirstLoginState()) {
                firstFlag = false;
                json = resultError("进入考试前，请您先修改好您的个人资料，以免后期带来不便，谢谢合作！");
            }
        }

        if (firstFlag) {
            /*
             * 1.判断该课程是否处于开始考试状态；
             * 2.判断该课程是否需要学习完成后方可考试；
             * 3.判断学习是否参与过该课程的考试；
             * 4.判断考试次数是否超过该课程补考次数（注意：-1为无限次数补考机会）
             */
            Course course = courseService.getById(courseId);
            if (null != course && course.getTestState().equals(2)) {
                boolean studyFlag = false;

                if (course.getStudyToExamState() == false) {
                    studyFlag = true;
                } else {
                    CourseVideoSO videoSO = new CourseVideoSO();
                    videoSO.setCourseId(course.getId());
                    long videoAmount = courseVideoService.getCount(videoSO);
                    long studyAmount = employeeCourseStudyService.getStudyAmount(account.getId(), course.getId());
                    if (studyAmount >= videoAmount) {
                        studyFlag = true;
                    }
                }

                if (studyFlag) {
                    EmployeeExaminationPaperSO paperSO = new EmployeeExaminationPaperSO();
                    paperSO.setCourseId(course.getId());
                    paperSO.setEmployeeId(account.getId());
                    List<EmployeeExaminationPaper> list = employeeExaminationPaperService.list(paperSO);

                    String paperId = "";
                    if (null != list && list.size() > 0) {

                        boolean testFlag = false;
                        Integer testState = Constants.TEST_STATE_WAIT;

                        for (EmployeeExaminationPaper paper : list) {
                            // 判断考生的考卷是否处于考试中
                            if (paper.getTestState().equals(Constants.TEST_STATE_WAIT) || paper.getTestState().equals(Constants.TEST_STATE_START)) {
                                if (paper.getEndTime().before(new Date())) {
                                    paperId = paper.getId();
                                    testState = paper.getTestState();
                                    testFlag = true;
                                    break;
                                }
                            }

                            if (paper.getTestScore() < paper.getPassScore()) {
                                testState = Constants.TEST_STATE_END;
                                testFlag = true;
                                break;
                            }

                            if (paper.getTestState().equals(1) || paper.getTestState().equals(2)) {
                                testFlag = true;
                                break;
                            } else if (paper.getTestScore() < paper.getPassScore()) {
                                testFlag = true;
                                break;
                            }
                        }

                        if (testFlag) {
                            if (course.getTestAmount().equals(-1) || list.size() <= course.getTestAmount()) {
                                if (testState.equals(Constants.TEST_STATE_END)) {
                                    paperId = saveEmployeeExaminationPaper(account, course);
                                }

                                json = resultSuccess("成功领取考卷。");
                                json.put("paperId", paperId);
                            } else {
                                json = resultError("您已经超过补考次数！不能再进行考试，请您回去复习再申请考试，加油！");
                            }
                        }
                    } else {
                        paperId = saveEmployeeExaminationPaper(account, course);
                        json = resultSuccess("成功领取考卷。");
                        json.put("paperId", paperId);
                    }
                }
            } else {
                json = resultError("考试尚未开始或已经结束");
            }
        }
        return json;
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
        EmployeeAccount account = employeeAccountService.getById(getCurrentUser().getId());

        EmployeeExaminationPaper paper = employeeExaminationPaperService.getById(so.getId());
        if (account.getId().equals(paper.getEmployeeId())) {
            if (!paper.getTestState().equals(3)) {
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

                    Integer value = 1;
                    String seqCode = "EmployeeCertificate";
                    String date = DateFormatUtils.format(paper.getSubmitTime(), "yyyy");
                    String md = DateFormatUtils.format(paper.getSubmitTime(), "MMdd");

                    String code = (seqCode + "_" + date).toUpperCase();
                    SysSequence sequence = sysSequenceService.getSequenceValue(code);
                    if (null == sequence) {
                        sequence = new SysSequence();
                        sequence.setSeqCode(code);
                        sequence.setSeqName(seqCode);
                        sequence.setSeqValue(value);
                        sysSequenceService.insert(sequence);
                    } else {
                        value = sequence.getSeqValue() + 1;
                        sequence.setSeqValue(value);
                        sysSequenceService.update(sequence);
                    }

                    Course course =courseService.getById(paper.getCourseId());

                    String rnd1 = RandomStringUtils.randomNumeric(5);
                    String certificateCode = date + rnd1 + sysSequenceService.fillZero(value.toString(), 7) + md;
                    EmployeeCertificate certificate = new EmployeeCertificate();
                    certificate.setCertificateCode(certificateCode);
                    certificate.setCourseCode(course.getCode());
                    certificate.setCertificateName(course.getChineseName());
                    certificate.setCertificateDate(paper.getSubmitTime());
                    certificate.setCertificateState(1);
                    certificate.setEnglishName(course.getEnglishName());
                    certificate.setEnglishContent(course.getEnglishContent());
                    certificate.setChineseContent(course.getChineseContent());
                    certificate.setEmployeeId(account.getId());
                    certificate.setEmployeeName(account.getFullName());
                    certificate.setIdentityCode(account.getIdentityCode());
                    certificate.setEmployeeBorn(account.getBirthday());
                    employeeCertificateService.insert(certificate);

                } else {
                    paper.setPassState(false);
                }
                paper.setTestState(3);
                employeeExaminationPaperService.update(paper);

                return resultSuccess("本次考试成绩为：" + testScore + "，考试为：" + (paper.getPassState() ? "及格" : "不及格"));
            } else {
                return resultError("请不要重复交卷！");
            }
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
