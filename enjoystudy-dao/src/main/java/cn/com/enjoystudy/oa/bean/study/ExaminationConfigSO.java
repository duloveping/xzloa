package cn.com.enjoystudy.oa.bean.study;

import cn.com.enjoystudy.oa.bean.SOSupport;

/**
 * 考试设置
 * @author 广州新咨力科技有限公司-杜永生
 */
public class ExaminationConfigSO extends SOSupport {
    /** 是否需要通过学习完课程后方可考试 */
    private Boolean studyToExamState;
    /** 考试时长（单位：分钟） */
    private Integer duration;
    /** 考试类型：1课程学习完成后自动考试，2由教师统计安排统计 */
    private Integer testType;
    /** 考卷类型：1系统随机出卷，2由教师自行出卷 */
    private Integer paperType;
    /** 总成绩 */
    private Integer totalScore;
    /** 合格成绩 */
    private Integer passScore;
    /** 考试次数（补考次数）,默认2次机会 */
    private Integer testAmount;
    /** 考题数量 */
    private Integer questionAmount;
    /** 考题分配情况：1自动分配，2自行分配 */
    private Integer questionType;
    /** 单选题类型出题类型：1随机数量，2固定数量 */
    private Integer singleType;
    /** 单选题数量 */
    private Integer singleAmount;
    /** 多选题类型出题类型：1随机数量，2固定数量 */
    private Integer multiType;
    /** 多选题数量 */
    private Integer multiAmount;
    /** 判断题类型出题类型：1随机数量，2固定数量 */
    private Integer judgeType;
    /** 判断题数量 */
    private Integer judgeAmount;
    /** 不定项题类型出题类型：1随机数量，2固定数量 */
    private Integer checkType;
    /** 不定项题数量 */
    private Integer checkAmount;
    /** 填空题类型出题类型：1随机数量，2固定数量 */
    private Integer fillType;
    /** 填空题数量 */
    private Integer fillAmount;

    public ExaminationConfigSO() {
    }

    public Boolean getStudyToExamState() {
        return studyToExamState;
    }

    public void setStudyToExamState(Boolean studyToExamState) {
        this.studyToExamState = studyToExamState;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getTestType() {
        return testType;
    }

    public void setTestType(Integer testType) {
        this.testType = testType;
    }

    public Integer getPaperType() {
        return paperType;
    }

    public void setPaperType(Integer paperType) {
        this.paperType = paperType;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getPassScore() {
        return passScore;
    }

    public void setPassScore(Integer passScore) {
        this.passScore = passScore;
    }

    public Integer getTestAmount() {
        return testAmount;
    }

    public void setTestAmount(Integer testAmount) {
        this.testAmount = testAmount;
    }

    public Integer getQuestionAmount() {
        return questionAmount;
    }

    public void setQuestionAmount(Integer questionAmount) {
        this.questionAmount = questionAmount;
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    public Integer getSingleType() {
        return singleType;
    }

    public void setSingleType(Integer singleType) {
        this.singleType = singleType;
    }

    public Integer getSingleAmount() {
        return singleAmount;
    }

    public void setSingleAmount(Integer singleAmount) {
        this.singleAmount = singleAmount;
    }

    public Integer getMultiType() {
        return multiType;
    }

    public void setMultiType(Integer multiType) {
        this.multiType = multiType;
    }

    public Integer getMultiAmount() {
        return multiAmount;
    }

    public void setMultiAmount(Integer multiAmount) {
        this.multiAmount = multiAmount;
    }

    public Integer getJudgeType() {
        return judgeType;
    }

    public void setJudgeType(Integer judgeType) {
        this.judgeType = judgeType;
    }

    public Integer getJudgeAmount() {
        return judgeAmount;
    }

    public void setJudgeAmount(Integer judgeAmount) {
        this.judgeAmount = judgeAmount;
    }

    public Integer getCheckType() {
        return checkType;
    }

    public void setCheckType(Integer checkType) {
        this.checkType = checkType;
    }

    public Integer getCheckAmount() {
        return checkAmount;
    }

    public void setCheckAmount(Integer checkAmount) {
        this.checkAmount = checkAmount;
    }

    public Integer getFillType() {
        return fillType;
    }

    public void setFillType(Integer fillType) {
        this.fillType = fillType;
    }

    public Integer getFillAmount() {
        return fillAmount;
    }

    public void setFillAmount(Integer fillAmount) {
        this.fillAmount = fillAmount;
    }
}
