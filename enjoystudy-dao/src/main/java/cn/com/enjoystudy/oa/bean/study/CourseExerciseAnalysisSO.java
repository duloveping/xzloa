package cn.com.enjoystudy.oa.bean.study;

import cn.com.enjoystudy.oa.bean.SOSupport;

/**
 * 课程练习题作答解析
 * @author 广州新咨力科技有限公司-杜永生
 */
public class CourseExerciseAnalysisSO extends SOSupport {
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
    /** 练习题ID */
    private String exerciseId;
    /** 练习题题目 */
    private String exerciseTitle;
    /** 练习题 */
    private CourseExercise exercise;
    /** 解析内容 */
    private String content;

    public CourseExerciseAnalysisSO() {
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

    public String getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(String exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getExerciseTitle() {
        return exerciseTitle;
    }

    public void setExerciseTitle(String exerciseTitle) {
        this.exerciseTitle = exerciseTitle;
    }

    public CourseExercise getExercise() {
        return exercise;
    }

    public void setExercise(CourseExercise exercise) {
        this.exercise = exercise;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
