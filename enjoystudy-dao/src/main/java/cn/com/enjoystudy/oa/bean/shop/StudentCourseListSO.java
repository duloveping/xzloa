package cn.com.enjoystudy.oa.bean.shop;

import cn.com.enjoystudy.oa.bean.SOSupport;
import cn.com.enjoystudy.oa.bean.base.EmployeeAccount;
import cn.com.enjoystudy.oa.bean.study.Course;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class StudentCourseListSO extends SOSupport {
    private String accountId;
    private EmployeeAccount account;
    private String courseId;
    private Course course;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date buyTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expireTime;
    private Boolean expireState;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startBuyTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endBuyTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startExpireTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endExpireTime;

    public StudentCourseListSO() {
    }

    public StudentCourseListSO(String accountId, String courseId, Date buyTime, Date expireTime, Boolean expireState) {
        this.accountId = accountId;
        this.courseId = courseId;
        this.buyTime = buyTime;
        this.expireTime = expireTime;
        this.expireState = expireState;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public EmployeeAccount getAccount() {
        return account;
    }

    public void setAccount(EmployeeAccount account) {
        this.account = account;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Boolean getExpireState() {
        return expireState;
    }

    public void setExpireState(Boolean expireState) {
        this.expireState = expireState;
    }

    public Date getStartBuyTime() {
        return startBuyTime;
    }

    public void setStartBuyTime(Date startBuyTime) {
        this.startBuyTime = startBuyTime;
    }

    public Date getEndBuyTime() {
        return endBuyTime;
    }

    public void setEndBuyTime(Date endBuyTime) {
        this.endBuyTime = endBuyTime;
    }

    public Date getStartExpireTime() {
        return startExpireTime;
    }

    public void setStartExpireTime(Date startExpireTime) {
        this.startExpireTime = startExpireTime;
    }

    public Date getEndExpireTime() {
        return endExpireTime;
    }

    public void setEndExpireTime(Date endExpireTime) {
        this.endExpireTime = endExpireTime;
    }
}
