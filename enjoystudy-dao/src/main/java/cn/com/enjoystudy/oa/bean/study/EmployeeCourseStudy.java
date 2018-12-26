package cn.com.enjoystudy.oa.bean.study;

import cn.com.enjoystudy.oa.bean.EntitySupport;
import cn.com.enjoystudy.oa.bean.base.EmployeeAccount;

import java.util.Date;

/**
 * 员工课程学习
 * @author 广州新咨力科技有限公司-杜永生
 */
public class EmployeeCourseStudy extends EntitySupport {
    /** 员工*/
    private EmployeeAccount employee;
    /** 员工ID */
    private String employeeId;
    /** 员工名称 */
    private String employeeName;
    /** 课程*/
    private Course course;
    /** 课程ID */
    private String courseId;
    /** 课程名称 */
    private String courseName;
    /** 课程视频*/
    private CourseVideo video;
    /** 课程视频ID */
    private String videoId;
    /** 课程视频名称 */
    private String videoName;
    /** 学习时间 */
    private Date studyTime;
    /** 学习次数 */
    private Integer studyAmount;
    /** 人数 */
    private Long employeeAmount;
    /** 章节数 */
    private Long lessonAmount;

    public EmployeeCourseStudy() {
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

    public Long getEmployeeAmount() {
        return employeeAmount;
    }

    public void setEmployeeAmount(Long employeeAmount) {
        this.employeeAmount = employeeAmount;
    }

    public Long getLessonAmount() {
        return lessonAmount;
    }

    public void setLessonAmount(Long lessonAmount) {
        this.lessonAmount = lessonAmount;
    }
}
