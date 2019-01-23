package cn.com.enjoystudy.oa.bean.study;

import cn.com.enjoystudy.oa.bean.BaseFile;

import java.util.List;

/**
 * 课程视频
 * @author 广州新咨力科技有限公司-杜永生
 */
public class CourseVideo extends BaseFile {
    /** 老师 */
    private Teacher teacher;
    /** 老师ID */
    private String teacherId;
    /** 老师名称 */
    private String teacherName;
    /** 课程*/
    private Course course;
    /** 课程ID */
    private String courseId;
    /** 课程名称 */
    private String courseName;
    /** 视频名称 */
    private String name;
    /** 视频图片 */
    private String image;
    /** 视频简介 */
    private String introduction;
    /** 视频描述 */
    private String description;
    /** 附件列表 */
    private List<CourseAttachment> attachmentList;

    public CourseVideo() {
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CourseAttachment> getAttachmentList() {
        return attachmentList;
    }

    public void setAttachmentList(List<CourseAttachment> attachmentList) {
        this.attachmentList = attachmentList;
    }
}
