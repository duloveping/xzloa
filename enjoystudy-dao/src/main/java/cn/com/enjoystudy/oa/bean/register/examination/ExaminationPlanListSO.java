package cn.com.enjoystudy.oa.bean.register.examination;

import cn.com.enjoystudy.oa.bean.EntitySupport;
import cn.com.enjoystudy.oa.bean.SOSupport;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 考试计划
 * @author 广州新咨力科技有限公司-杜永生
 */
public class ExaminationPlanListSO extends SOSupport {
    /** 显示状态 */
    private Boolean showState;
    /** 计划ID */
    private String planId;
    /** 证书ID */
    private String certificateId;
    /** 证书名称 */
    private String certificateName;
    /** 课程ID */
    private String courseId;
    /** 课程名称 */
    private String courseName;
    /** 报名状态 */
    private Integer entryState;
    /** 报名开始时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date entryStartTime;
    /** 报名截止时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date entryEndTime;
    /** 考试状态 */
    private Integer testState;
    /** 考试开始时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date testStartTime;
    /** 考试截止时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date testEndTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date entryStartTimeStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date entryStartTimeEnd;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date entryEndTimeStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date entryEndTimeEnd;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date testStartTimeStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date testStartTimeEnd;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date testEndTimeStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date testEndTimeEnd;

    public ExaminationPlanListSO() {
    }

    public Boolean getShowState() {
        return showState;
    }

    public void setShowState(Boolean showState) {
        this.showState = showState;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getEntryState() {
        return entryState;
    }

    public void setEntryState(Integer entryState) {
        this.entryState = entryState;
    }

    public Date getEntryStartTime() {
        return entryStartTime;
    }

    public void setEntryStartTime(Date entryStartTime) {
        this.entryStartTime = entryStartTime;
    }

    public Date getEntryEndTime() {
        return entryEndTime;
    }

    public void setEntryEndTime(Date entryEndTime) {
        this.entryEndTime = entryEndTime;
    }

    public Integer getTestState() {
        return testState;
    }

    public void setTestState(Integer testState) {
        this.testState = testState;
    }

    public Date getTestStartTime() {
        return testStartTime;
    }

    public void setTestStartTime(Date testStartTime) {
        this.testStartTime = testStartTime;
    }

    public Date getTestEndTime() {
        return testEndTime;
    }

    public void setTestEndTime(Date testEndTime) {
        this.testEndTime = testEndTime;
    }

    public Date getEntryStartTimeStart() {
        return entryStartTimeStart;
    }

    public void setEntryStartTimeStart(Date entryStartTimeStart) {
        this.entryStartTimeStart = entryStartTimeStart;
    }

    public Date getEntryStartTimeEnd() {
        return entryStartTimeEnd;
    }

    public void setEntryStartTimeEnd(Date entryStartTimeEnd) {
        this.entryStartTimeEnd = entryStartTimeEnd;
    }

    public Date getEntryEndTimeStart() {
        return entryEndTimeStart;
    }

    public void setEntryEndTimeStart(Date entryEndTimeStart) {
        this.entryEndTimeStart = entryEndTimeStart;
    }

    public Date getEntryEndTimeEnd() {
        return entryEndTimeEnd;
    }

    public void setEntryEndTimeEnd(Date entryEndTimeEnd) {
        this.entryEndTimeEnd = entryEndTimeEnd;
    }

    public Date getTestStartTimeStart() {
        return testStartTimeStart;
    }

    public void setTestStartTimeStart(Date testStartTimeStart) {
        this.testStartTimeStart = testStartTimeStart;
    }

    public Date getTestStartTimeEnd() {
        return testStartTimeEnd;
    }

    public void setTestStartTimeEnd(Date testStartTimeEnd) {
        this.testStartTimeEnd = testStartTimeEnd;
    }

    public Date getTestEndTimeStart() {
        return testEndTimeStart;
    }

    public void setTestEndTimeStart(Date testEndTimeStart) {
        this.testEndTimeStart = testEndTimeStart;
    }

    public Date getTestEndTimeEnd() {
        return testEndTimeEnd;
    }

    public void setTestEndTimeEnd(Date testEndTimeEnd) {
        this.testEndTimeEnd = testEndTimeEnd;
    }
}
