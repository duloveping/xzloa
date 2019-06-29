package cn.com.enjoystudy.oa.bean.study;

import cn.com.enjoystudy.oa.bean.SOSupport;
import cn.com.enjoystudy.oa.bean.base.EmployeeAccount;

/**
 * 学员课程
 * @author 广州新咨力科技有限公司-杜永生
 */
public class EmployeeAccountCourseSO extends SOSupport {
    /** 所属学员ID */
    private String employeeId;
    private String[] employeeIds;
    private EmployeeAccount account;
    /** 所属课程ID */
    private String courseId;
    private String[] courseIds;
    private Course course;

    public EmployeeAccountCourseSO() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String[] getEmployeeIds() {
        return employeeIds;
    }

    public void setEmployeeIds(String[] employeeIds) {
        this.employeeIds = employeeIds;
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

    public String[] getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(String[] courseIds) {
        this.courseIds = courseIds;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
