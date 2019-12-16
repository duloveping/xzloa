package cn.com.enjoystudy.oa.webapps.web;

import cn.com.enjoystudy.oa.bean.base.EmployeeAccount;
import cn.com.enjoystudy.oa.bean.study.*;
import cn.com.enjoystudy.oa.service.study.*;
import cn.com.enjoystudy.oa.webapps.BaseController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class PaperController extends BaseController {
    @Autowired
    private EmployeeExaminationPaperService employeeExaminationPaperService;
    @Autowired
    private StorePaperService storePaperService;
    @Autowired
    private StoreQuestionService storeQuestionService;
    @Autowired
    private EmployeeExaminationQuestionService employeeExaminationQuestionService;
    @Autowired
    private StoreQuestionItemService storeQuestionItemService;
    @Autowired
    private EmployeeExaminationQuestionItemService employeeExaminationQuestionItemService;
    @Autowired
    private StoreQuestionAnalysisService storeQuestionAnalysisService;
    @Autowired
    private EmployeeExaminationQuestionAnalysisService employeeExaminationQuestionAnalysisService;

    public String saveEmployeeExaminationPaper(EmployeeAccount account, Course course) {
        StorePaperSO paperSO = new StorePaperSO();
        paperSO.setCourseId(course.getId());
        paperSO.setAuditState(2);
        paperSO.setEditState(2);
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
}
