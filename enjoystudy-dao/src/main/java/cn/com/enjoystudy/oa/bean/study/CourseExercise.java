package cn.com.enjoystudy.oa.bean.study;

import java.util.List;

/**
 * 课程视频练习题
 * @author 广州新咨力科技有限公司-杜永生
 */
public class CourseExercise extends Question {
    /** 课程 */
    private Course course;
    /** 课程ID */
    private String courseId;
    /** 课程名称 */
    private String courseName;
    /** 课程视频 */
    private CourseVideo video;
    /** 课程视频ID */
    private String videoId;
    /** 课程视频名称 */
    private String videoName;
    /** 解析 */
    private String analysis;
    /** 解题选项 */
    private List<CourseExerciseItem> itemList;

    public CourseExercise() {
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

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public List<CourseExerciseItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<CourseExerciseItem> itemList) {
        this.itemList = itemList;
    }
}
