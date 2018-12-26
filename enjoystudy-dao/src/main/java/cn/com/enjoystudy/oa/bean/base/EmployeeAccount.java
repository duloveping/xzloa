package cn.com.enjoystudy.oa.bean.base;

import cn.com.enjoystudy.oa.bean.EntitySupport;

/**
 * 员工账号
 * @author 广州新咨力科技有限公司-杜永生
 */
public class EmployeeAccount extends EntitySupport {
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
    /** 登录密码 */
    private String loginPassword;
    /** 锁定状态 */
    private Boolean lockState;

    public EmployeeAccount() {
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
}
