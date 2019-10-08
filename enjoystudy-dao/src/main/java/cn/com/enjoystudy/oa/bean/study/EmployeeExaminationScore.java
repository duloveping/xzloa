package cn.com.enjoystudy.oa.bean.study;

import cn.com.enjoystudy.oa.bean.EntitySupport;

import java.util.Date;
import java.util.List;

/**
 * 员工考试试卷
 * @author 广州新咨力科技有限公司-杜永生
 */
public class EmployeeExaminationScore extends EntitySupport {
    /** 员工ID */
    private String employeeId;
    /** 员工账号 */
    private String employeeAccount;
    /** 员工姓名 */
    private String employeeName;
    /** 课程ID */
    private String courseId;
    /** 课程名称 */
    private String courseName;
    /** 合格状态 */
    private Boolean passState;
    /** 考试成绩 */
    private Integer testScore;
    /** 开始时间 */
    private Date startTime;
    /** 结束时间 */
    private Date endTime;
    /** 交卷时间 */
    private Date submitTime;

    public EmployeeExaminationScore() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeAccount() {
        return employeeAccount;
    }

    public void setEmployeeAccount(String employeeAccount) {
        this.employeeAccount = employeeAccount;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
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

    public Boolean getPassState() {
        return passState;
    }

    public void setPassState(Boolean passState) {
        this.passState = passState;
    }

    public Integer getTestScore() {
        return testScore;
    }

    public void setTestScore(Integer testScore) {
        this.testScore = testScore;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }
}
