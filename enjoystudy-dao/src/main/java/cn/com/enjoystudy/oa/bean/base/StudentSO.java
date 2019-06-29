package cn.com.enjoystudy.oa.bean.base;

/**
 * 学员
 * @author 广州新咨力科技有限公司-杜永生
 */
public class StudentSO extends EmployeeAccountSO {
    private EmployeeCommunication communication;
    private Integer amount;
    private String courseId;

    public StudentSO() {
    }

    public EmployeeCommunication getCommunication() {
        return communication;
    }

    public void setCommunication(EmployeeCommunication communication) {
        this.communication = communication;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}
