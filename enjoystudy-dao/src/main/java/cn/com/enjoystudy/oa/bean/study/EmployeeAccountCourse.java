package cn.com.enjoystudy.oa.bean.study;

import cn.com.enjoystudy.oa.bean.EntitySupport;
import cn.com.enjoystudy.oa.bean.base.EmployeeAccount;

/**
 * 学员课程
 * @author 广州新咨力科技有限公司-杜永生
 */
public class EmployeeAccountCourse extends EntitySupport {
    /** 所属学员ID */
    private String employeeId;
    private EmployeeAccount account;
    /** 所属课程ID */
    private String courseId;
    private Course course;

    public EmployeeAccountCourse() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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
}
