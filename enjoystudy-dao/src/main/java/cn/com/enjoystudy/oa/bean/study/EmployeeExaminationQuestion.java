package cn.com.enjoystudy.oa.bean.study;

import java.util.List;

public class EmployeeExaminationQuestion extends Question {
    /** 员工考卷ID */
    private String paperId;
    /** 考题ID */
    private String questionId;
    /** 作答状态：1未作答，2作答标记，3已作答 */
    private Integer answerState;
    /** 回答正确状态 */
    private Boolean rightState;
    private List<EmployeeExaminationQuestionItem> itemList;
    private EmployeeExaminationQuestionAnalysis analysis;

    public EmployeeExaminationQuestion() {
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public Integer getAnswerState() {
        return answerState;
    }

    public void setAnswerState(Integer answerState) {
        this.answerState = answerState;
    }

    public Boolean getRightState() {
        return rightState;
    }

    public void setRightState(Boolean rightState) {
        this.rightState = rightState;
    }

    public List<EmployeeExaminationQuestionItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<EmployeeExaminationQuestionItem> itemList) {
        this.itemList = itemList;
    }

    public EmployeeExaminationQuestionAnalysis getAnalysis() {
        return analysis;
    }

    public void setAnalysis(EmployeeExaminationQuestionAnalysis analysis) {
        this.analysis = analysis;
    }
}
