package cn.com.enjoystudy.oa.bean.base;

/**
 * 学员
 * @author 广州新咨力科技有限公司-杜永生
 */
public class Student extends EmployeeAccount {
    private EmployeeCommunication communication;

    public Student() {
    }

    public EmployeeCommunication getCommunication() {
        return communication;
    }

    public void setCommunication(EmployeeCommunication communication) {
        this.communication = communication;
    }
}
