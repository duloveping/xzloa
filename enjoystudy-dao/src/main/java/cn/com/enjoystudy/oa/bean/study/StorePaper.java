package cn.com.enjoystudy.oa.bean.study;

import cn.com.enjoystudy.oa.bean.EntitySupport;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class StorePaper extends EntitySupport {
    /** 显示状态 */
    private Boolean showState;
    /** 课程ID */
    private String courseId;
    /** 标题 */
    private String title;
    /** 时长（单位：分钟） */
    private Integer duration;
    /** 题目总数 */
    private Integer questionAmount;
    /** 总分数 */
    private Integer totalScore;
    /** 合格分数 */
    private Integer passScore;
    /** 补考次数 */
    private Integer testAmount;
    /** 编辑人ID */
    private String editorId;
    /** 编辑人姓名 */
    private String editorName;
    /** 编辑状态：1草稿，2定稿 */
    private Integer editState;
    /** 编辑时间 */
    private Date editTime;
    /** 审核人ID */
    private String auditorId;
    /** 审核人名称 */
    private String auditorName;
    /** 审核状态，1待审核，2通过，3不通过  */
    private Integer auditState;
    /**  审核时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date auditTime;
    /** 审核意见 */
    private String auditorMind;

    public StorePaper() {
    }

    public Boolean getShowState() {
        return showState;
    }

    public void setShowState(Boolean showState) {
        this.showState = showState;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getQuestionAmount() {
        return questionAmount;
    }

    public void setQuestionAmount(Integer questionAmount) {
        this.questionAmount = questionAmount;
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

    public String getEditorId() {
        return editorId;
    }

    public void setEditorId(String editorId) {
        this.editorId = editorId;
    }

    public String getEditorName() {
        return editorName;
    }

    public void setEditorName(String editorName) {
        this.editorName = editorName;
    }

    public Integer getEditState() {
        return editState;
    }

    public void setEditState(Integer editState) {
        this.editState = editState;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    public String getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(String auditorId) {
        this.auditorId = auditorId;
    }

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
    }

    public Integer getAuditState() {
        return auditState;
    }

    public void setAuditState(Integer auditState) {
        this.auditState = auditState;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getAuditorMind() {
        return auditorMind;
    }

    public void setAuditorMind(String auditorMind) {
        this.auditorMind = auditorMind;
    }
}
