package cn.com.enjoystudy.oa.bean.base;

/**
 * 员工通讯录
 * @author 广州新咨力科技有限公司-杜永生
 */
public class EmployeeCommunicationSO extends BaseCommunicationSO {
    /** 员工ID */
    private String employeeId;

    public EmployeeCommunicationSO() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
