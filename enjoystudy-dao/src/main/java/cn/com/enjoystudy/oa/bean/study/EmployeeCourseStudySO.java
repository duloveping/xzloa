package cn.com.enjoystudy.oa.bean.study;

import cn.com.enjoystudy.oa.bean.SOSupport;
import cn.com.enjoystudy.oa.bean.base.EmployeeAccount;

import java.util.Date;

/**
 * 员工课程学习
 * @author 广州新咨力科技有限公司-杜永生
 */
public class EmployeeCourseStudySO extends SOSupport {
    /** 员工*/
    private EmployeeAccount employee;
    /** 员工ID */
    private String employeeId;
    /** 员工名称 */
    private String employeeName;
    /** 课程*/
    private Course course;
    /** 课程状态 */
    private Boolean courseState;
    /** 课程ID */
    private String courseId;
    /** 课程名称 */
    private String courseName;
    /** 课程视频*/
    private CourseVideo video;
    /** 视频状态 */
    private Boolean videoState;
    /** 课程视频ID */
    private String videoId;
    /** 课程视频名称 */
    private String videoName;
    /** 学习时间 */
    private Date studyTime;
    /** 学习次数 */
    private Integer studyAmount;
    private String[] courseIds;
    private String[] courseNames;

    public EmployeeCourseStudySO() {
    }

    public EmployeeAccount getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeAccount employee) {
        this.employee = employee;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Boolean getCourseState() {
        return courseState;
    }

    public void setCourseState(Boolean courseState) {
        this.courseState = courseState;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public CourseVideo getVideo() {
        return video;
    }

    public void setVideo(CourseVideo video) {
        this.video = video;
    }

    public Boolean getVideoState() {
        return videoState;
    }

    public void setVideoState(Boolean videoState) {
        this.videoState = videoState;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public Date getStudyTime() {
        return studyTime;
    }

    public void setStudyTime(Date studyTime) {
        this.studyTime = studyTime;
    }

    public Integer getStudyAmount() {
        return studyAmount;
    }

    public void setStudyAmount(Integer studyAmount) {
        this.studyAmount = studyAmount;
    }

    public String[] getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(String[] courseIds) {
        this.courseIds = courseIds;
    }

    public String[] getCourseNames() {
        return courseNames;
    }

    public void setCourseNames(String[] courseNames) {
        this.courseNames = courseNames;
    }
}
