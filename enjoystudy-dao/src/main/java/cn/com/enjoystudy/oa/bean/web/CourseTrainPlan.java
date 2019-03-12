package cn.com.enjoystudy.oa.bean.web;

import cn.com.enjoystudy.oa.bean.EntitySupport;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 课程培训计划
 * @author 广州新咨力科技有限公司-杜永生
 */
public class CourseTrainPlan extends EntitySupport {
    /** 显示状态 */
    private Boolean showState;
    /** 培训状态 */
    private Integer trainState;
    /** 培训课程名称 */
    private String courseName;
    /** 报名开始时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registerStartTime;
    /** 报名结束时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registerEndTime;
    /** 培训开始时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date trainStartTime;
    /** 培训结束时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date trainEndTime;
    /** 打印准考证时间开始时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date admissionStartTime;
    /** 打印准考证时间结束时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date admissionEndTime;
    /** 考试证时间开始时间 */
    private Date examStartTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    /** 考试证时间结束时间 */
    private Date examEndTime;
    /** 成绩查询证时间开始时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date scoreStartTime;
    /** 成绩查询证时间结束时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date scoreEndTime;
    /** 证书颁发证时间开始时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date issueStartTime;
    /** 证书颁发证时间结束时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date issueEndTime;
    /** 报名人数 */
    private Integer registerAmount;
    /** 报名方式 */
    private Integer registerType;
    /** 报名地点 */
    private String registerAddress;
    /** 培训地点 */
    private String trainAddress;
    /** 考试地点 */
    private String examAddress;
    /** 颁发证书地点 */
    private String issueAddress;
    /** 培训单位名称 */
    private String companyName;
    /** 培训单位电话 */
    private String companyPhone;
    /** 培训单位传真 */
    private String companyFax;
    /** 培训单位邮箱 */
    private String companyEmail;
    /** 培训师名称 */
    private String trainTeacherName;
    /** 培训师电话 */
    private String trainTeacherPhone;
    /** 培训师手机 */
    private String trainTeacherMobile;
    /** 培训师QQ号 */
    private String trainTeacherQq;
    /** 培训师邮箱 */
    private String trainTeacherEmail;
    /** 联系人名称 */
    private String linkManName;
    /** 联系人电话 */
    private String linkManPhone;
    /** 联系人手机 */
    private String linkManMobile;
    /** 联系人QQ号 */
    private String linkManQq;
    /** 联系人邮箱 */
    private String linkManEmail;
    /** 班主任名称 */
    private String classTeacherName;
    /** 班主任电话 */
    private String classTeacherPhone;
    /** 班主任手机 */
    private String classTeacherMobile;
    /** 班主任QQ号 */
    private String classTeacherQq;
    /** 班主任邮箱 */
    private String classTeacherEmail;

    public CourseTrainPlan() {
    }

    public Boolean getShowState() {
        return showState;
    }

    public void setShowState(Boolean showState) {
        this.showState = showState;
    }

    public Integer getTrainState() {
        return trainState;
    }

    public void setTrainState(Integer trainState) {
        this.trainState = trainState;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getRegisterStartTime() {
        return registerStartTime;
    }

    public void setRegisterStartTime(Date registerStartTime) {
        this.registerStartTime = registerStartTime;
    }

    public Date getRegisterEndTime() {
        return registerEndTime;
    }

    public void setRegisterEndTime(Date registerEndTime) {
        this.registerEndTime = registerEndTime;
    }

    public Date getTrainStartTime() {
        return trainStartTime;
    }

    public void setTrainStartTime(Date trainStartTime) {
        this.trainStartTime = trainStartTime;
    }

    public Date getTrainEndTime() {
        return trainEndTime;
    }

    public void setTrainEndTime(Date trainEndTime) {
        this.trainEndTime = trainEndTime;
    }

    public Date getAdmissionStartTime() {
        return admissionStartTime;
    }

    public void setAdmissionStartTime(Date admissionStartTime) {
        this.admissionStartTime = admissionStartTime;
    }

    public Date getAdmissionEndTime() {
        return admissionEndTime;
    }

    public void setAdmissionEndTime(Date admissionEndTime) {
        this.admissionEndTime = admissionEndTime;
    }

    public Date getExamStartTime() {
        return examStartTime;
    }

    public void setExamStartTime(Date examStartTime) {
        this.examStartTime = examStartTime;
    }

    public Date getExamEndTime() {
        return examEndTime;
    }

    public void setExamEndTime(Date examEndTime) {
        this.examEndTime = examEndTime;
    }

    public Date getScoreStartTime() {
        return scoreStartTime;
    }

    public void setScoreStartTime(Date scoreStartTime) {
        this.scoreStartTime = scoreStartTime;
    }

    public Date getScoreEndTime() {
        return scoreEndTime;
    }

    public void setScoreEndTime(Date scoreEndTime) {
        this.scoreEndTime = scoreEndTime;
    }

    public Date getIssueStartTime() {
        return issueStartTime;
    }

    public void setIssueStartTime(Date issueStartTime) {
        this.issueStartTime = issueStartTime;
    }

    public Date getIssueEndTime() {
        return issueEndTime;
    }

    public void setIssueEndTime(Date issueEndTime) {
        this.issueEndTime = issueEndTime;
    }

    public Integer getRegisterAmount() {
        return registerAmount;
    }

    public void setRegisterAmount(Integer registerAmount) {
        this.registerAmount = registerAmount;
    }

    public Integer getRegisterType() {
        return registerType;
    }

    public void setRegisterType(Integer registerType) {
        this.registerType = registerType;
    }

    public String getRegisterAddress() {
        return registerAddress;
    }

    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress;
    }

    public String getTrainAddress() {
        return trainAddress;
    }

    public void setTrainAddress(String trainAddress) {
        this.trainAddress = trainAddress;
    }

    public String getExamAddress() {
        return examAddress;
    }

    public void setExamAddress(String examAddress) {
        this.examAddress = examAddress;
    }

    public String getIssueAddress() {
        return issueAddress;
    }

    public void setIssueAddress(String issueAddress) {
        this.issueAddress = issueAddress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyFax() {
        return companyFax;
    }

    public void setCompanyFax(String companyFax) {
        this.companyFax = companyFax;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getTrainTeacherName() {
        return trainTeacherName;
    }

    public void setTrainTeacherName(String trainTeacherName) {
        this.trainTeacherName = trainTeacherName;
    }

    public String getTrainTeacherPhone() {
        return trainTeacherPhone;
    }

    public void setTrainTeacherPhone(String trainTeacherPhone) {
        this.trainTeacherPhone = trainTeacherPhone;
    }

    public String getTrainTeacherMobile() {
        return trainTeacherMobile;
    }

    public void setTrainTeacherMobile(String trainTeacherMobile) {
        this.trainTeacherMobile = trainTeacherMobile;
    }

    public String getTrainTeacherQq() {
        return trainTeacherQq;
    }

    public void setTrainTeacherQq(String trainTeacherQq) {
        this.trainTeacherQq = trainTeacherQq;
    }

    public String getTrainTeacherEmail() {
        return trainTeacherEmail;
    }

    public void setTrainTeacherEmail(String trainTeacherEmail) {
        this.trainTeacherEmail = trainTeacherEmail;
    }

    public String getLinkManName() {
        return linkManName;
    }

    public void setLinkManName(String linkManName) {
        this.linkManName = linkManName;
    }

    public String getLinkManPhone() {
        return linkManPhone;
    }

    public void setLinkManPhone(String linkManPhone) {
        this.linkManPhone = linkManPhone;
    }

    public String getLinkManMobile() {
        return linkManMobile;
    }

    public void setLinkManMobile(String linkManMobile) {
        this.linkManMobile = linkManMobile;
    }

    public String getLinkManQq() {
        return linkManQq;
    }

    public void setLinkManQq(String linkManQq) {
        this.linkManQq = linkManQq;
    }

    public String getLinkManEmail() {
        return linkManEmail;
    }

    public void setLinkManEmail(String linkManEmail) {
        this.linkManEmail = linkManEmail;
    }

    public String getClassTeacherName() {
        return classTeacherName;
    }

    public void setClassTeacherName(String classTeacherName) {
        this.classTeacherName = classTeacherName;
    }

    public String getClassTeacherPhone() {
        return classTeacherPhone;
    }

    public void setClassTeacherPhone(String classTeacherPhone) {
        this.classTeacherPhone = classTeacherPhone;
    }

    public String getClassTeacherMobile() {
        return classTeacherMobile;
    }

    public void setClassTeacherMobile(String classTeacherMobile) {
        this.classTeacherMobile = classTeacherMobile;
    }

    public String getClassTeacherQq() {
        return classTeacherQq;
    }

    public void setClassTeacherQq(String classTeacherQq) {
        this.classTeacherQq = classTeacherQq;
    }

    public String getClassTeacherEmail() {
        return classTeacherEmail;
    }

    public void setClassTeacherEmail(String classTeacherEmail) {
        this.classTeacherEmail = classTeacherEmail;
    }
}
