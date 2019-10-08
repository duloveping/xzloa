package cn.com.enjoystudy.oa.bean.study;

import cn.com.enjoystudy.oa.bean.EntitySupport;

import java.util.Date;

/**
 * 员工考试获取的证书
 */
public class EmployeeCertificate extends EntitySupport {
    /** 员工ID */
    private String employeeId;
    /** 员工姓名 */
    private String employeeName;
    /** 员工编号 */
    private String employeeCode;
    /** 员工性别 */
    private String employeeSex;
    /** 员工出生日期 */
    private Date employeeBorn;
    /** 员工身份证号 */
    private String identityCode;
    /** 证书ID */
    private String certificateId;
    /** 证书编号 */
    private String certificateCode;
    /** 证书名称 */
    private String certificateName;
    private String englishName;
    /** 证书日期 */
    private Date certificateDate;
    /** 证书状态：1正常，2过期，3作废 */
    private Integer certificateState;
    /** 公章图片地址 */
    private String sealPhoto;
    /** 机构编号 */
    private String organizationCode;
    /** 机构名称 */
    private String organizationName;
    /** 发证人ID */
    private String teacherId;
    /** 发证人姓名 */
    private String teacherName;
    private String englishContent;
    private String chineseContent;

    public EmployeeCertificate() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeSex() {
        return employeeSex;
    }

    public void setEmployeeSex(String employeeSex) {
        this.employeeSex = employeeSex;
    }

    public Date getEmployeeBorn() {
        return employeeBorn;
    }

    public void setEmployeeBorn(Date employeeBorn) {
        this.employeeBorn = employeeBorn;
    }

    public String getIdentityCode() {
        return identityCode;
    }

    public void setIdentityCode(String identityCode) {
        this.identityCode = identityCode;
    }

    public String getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }

    public String getCertificateCode() {
        return certificateCode;
    }

    public void setCertificateCode(String certificateCode) {
        this.certificateCode = certificateCode;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public Date getCertificateDate() {
        return certificateDate;
    }

    public void setCertificateDate(Date certificateDate) {
        this.certificateDate = certificateDate;
    }

    public Integer getCertificateState() {
        return certificateState;
    }

    public void setCertificateState(Integer certificateState) {
        this.certificateState = certificateState;
    }

    public String getSealPhoto() {
        return sealPhoto;
    }

    public void setSealPhoto(String sealPhoto) {
        this.sealPhoto = sealPhoto;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getEnglishContent() {
        return englishContent;
    }

    public void setEnglishContent(String englishContent) {
        this.englishContent = englishContent;
    }

    public String getChineseContent() {
        return chineseContent;
    }

    public void setChineseContent(String chineseContent) {
        this.chineseContent = chineseContent;
    }
}
