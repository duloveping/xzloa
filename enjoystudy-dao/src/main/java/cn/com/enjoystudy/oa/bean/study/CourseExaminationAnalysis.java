package cn.com.enjoystudy.oa.bean.study;

import cn.com.enjoystudy.oa.bean.EntitySupport;

/**
 * 课程考试题作答解析
 * @author 广州新咨力科技有限公司-杜永生
 */
public class CourseExaminationAnalysis extends EntitySupport {
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
    /** 考试题ID */
    private String examinationId;
    /** 考试题题目 */
    private String examinationTitle;
    /** 考试题 */
    private CourseExamination examination;
    /** 解析内容 */
    private String content;

    public CourseExaminationAnalysis() {
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

    public String getExaminationId() {
        return examinationId;
    }

    public void setExaminationId(String examinationId) {
        this.examinationId = examinationId;
    }

    public String getExaminationTitle() {
        return examinationTitle;
    }

    public void setExaminationTitle(String examinationTitle) {
        this.examinationTitle = examinationTitle;
    }

    public CourseExamination getExamination() {
        return examination;
    }

    public void setExamination(CourseExamination examination) {
        this.examination = examination;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
