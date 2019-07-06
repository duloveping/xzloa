package cn.com.enjoystudy.oa.bean.base;

import cn.com.enjoystudy.oa.bean.SOSupport;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 员工账号
 * @author 广州新咨力科技有限公司-杜永生
 */
public class EmployeeAccountSO extends SOSupport {
    /** 用户类型 */
    private Integer category;
    /** 所属单位 */
    private Company company;
    /** 所属单位ID */
    private String companyId;
    /** 所属单位名称 */
    private String companyName;
    /** 所属部门 */
    private Department department;
    /** 所属部门ID */
    private String departmentId;
    /** 所属部门名称 */
    private String departmentName;
    /** 所属职务 */
    private BasePosition position;
    /** 职务ID */
    private String positionId;
    /** 职务名称 */
    private String positionName;
    /** 员工编号 */
    private String code;
    /** 员工姓名 */
    private String fullName;
    /** 性别 */
    private Integer sex;
    /** 出生日期 */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    /** 登录密码 */
    private String loginPassword;
    /** 锁定状态 */
    private Boolean lockState;
    /** 证件类型：
     * 99.其他
     * 1.居民身份证
     * 2.军官证
     * 3.香港特区护照/身份证明
     * 4.澳门特区护照/身份证明
     * 5.台湾居民来往大陆通行证
     * 6.境外永久居住证
     */
    private Integer identityType;
    /** 证件号码 */
    private String identityCode;
    /** 密码找回问题 */
    private String question;
    /** 密码找回答案 */
    private String answer;
    /** 学历 */
    private String education;
    /** 毕业学院 */
    private String school;
    /** 主修专业 */
    private String major;
    /** 籍贯 */
    private String nativePlace;
    /** 婚姻状况 */
    private Integer maritalStatus;
    private Boolean firstLoginState;

    private String[] employeeIds;
    private String[] employeeNames;
    private String[] departmentIds;
    private String[] departmentNames;
    private String[] positionIds;
    private String[] positionNames;
    private String[] companyIds;
    private String[] companyNames;

    public EmployeeAccountSO() {
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public BasePosition getPosition() {
        return position;
    }

    public void setPosition(BasePosition position) {
        this.position = position;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public Boolean getLockState() {
        return lockState;
    }

    public void setLockState(Boolean lockState) {
        this.lockState = lockState;
    }

    public Integer getIdentityType() {
        return identityType;
    }

    public void setIdentityType(Integer identityType) {
        this.identityType = identityType;
    }

    public String getIdentityCode() {
        return identityCode;
    }

    public void setIdentityCode(String identityCode) {
        this.identityCode = identityCode;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public Integer getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Integer maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String[] getEmployeeIds() {
        return employeeIds;
    }

    public void setEmployeeIds(String[] employeeIds) {
        this.employeeIds = employeeIds;
    }

    public String[] getEmployeeNames() {
        return employeeNames;
    }

    public void setEmployeeNames(String[] employeeNames) {
        this.employeeNames = employeeNames;
    }

    public String[] getDepartmentIds() {
        return departmentIds;
    }

    public void setDepartmentIds(String[] departmentIds) {
        this.departmentIds = departmentIds;
    }

    public String[] getDepartmentNames() {
        return departmentNames;
    }

    public void setDepartmentNames(String[] departmentNames) {
        this.departmentNames = departmentNames;
    }

    public String[] getPositionIds() {
        return positionIds;
    }

    public void setPositionIds(String[] positionIds) {
        this.positionIds = positionIds;
    }

    public String[] getPositionNames() {
        return positionNames;
    }

    public void setPositionNames(String[] positionNames) {
        this.positionNames = positionNames;
    }

    public String[] getCompanyIds() {
        return companyIds;
    }

    public void setCompanyIds(String[] companyIds) {
        this.companyIds = companyIds;
    }

    public String[] getCompanyNames() {
        return companyNames;
    }

    public void setCompanyNames(String[] companyNames) {
        this.companyNames = companyNames;
    }

    public Boolean getFirstLoginState() {
        return firstLoginState;
    }

    public void setFirstLoginState(Boolean firstLoginState) {
        this.firstLoginState = firstLoginState;
    }
}
