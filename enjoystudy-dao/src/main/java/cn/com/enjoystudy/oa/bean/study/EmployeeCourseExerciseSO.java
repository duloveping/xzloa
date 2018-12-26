package cn.com.enjoystudy.oa.bean.study;

import java.util.List;

/**
 * 员工课程练习题
 * @author 广州新咨力科技有限公司-杜永生
 */
public class EmployeeCourseExerciseSO extends QuestionSO {
    /** 员工ID */
    private String employeeId;
    /** 课程ID */
    private String courseId;
    /** 课程视频ID */
    private String videoId;
    /** 练习题ID */
    private String exerciseId;
    /** 答对状态 */
    private Boolean rightState;
    /** 答题选项列表 */
    private List<EmployeeCourseExerciseItem> itemList;

    public EmployeeCourseExerciseSO() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(String exerciseId) {
        this.exerciseId = exerciseId;
    }

    public Boolean getRightState() {
        return rightState;
    }

    public void setRightState(Boolean rightState) {
        this.rightState = rightState;
    }

    public List<EmployeeCourseExerciseItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<EmployeeCourseExerciseItem> itemList) {
        this.itemList = itemList;
    }
}
