package cn.com.enjoystudy.oa.tag.study;

import cn.com.enjoystudy.oa.bean.study.CourseVideo;
import cn.com.enjoystudy.oa.bean.study.CourseVideoSO;
import cn.com.enjoystudy.oa.service.study.CourseVideoService;
import cn.com.enjoystudy.oa.tag.BaseTagSupport;

import java.util.List;

public class CourseVideoListTag extends BaseTagSupport {
    private int pageSize = 20;
    /** 老师ID */
    private String teacherId;
    /** 老师名称 */
    private String teacherName;
    /** 课程ID */
    private String courseId;
    /** 课程名称 */
    private String courseName;
    /** 视频名称 */
    private String name;
    /** 课程显示状态 */
    private Boolean courseShowState;
    /** 课程推荐状态 */
    private Boolean courseRecommendState;
    /** 课程热门状态 */
    private Boolean courseHotState;
    /** 显示状态 */
    private Boolean showState;

    @Override
    protected int doStartTagInternal() throws Exception {
        CourseVideoSO so = new CourseVideoSO();
        so.setPageNum(1);
        so.setPageSize(pageSize);
        so.setName(name);
        so.setCourseId(courseId);
        so.setCourseName(courseName);
        so.setTeacherId(teacherId);
        so.setTeacherName(teacherName);
        so.setShowState(showState);
        so.setCourseShowState(courseShowState);
        so.setCourseRecommendState(courseRecommendState);
        so.setCourseHotState(courseHotState);

        CourseVideoService service = (CourseVideoService) getBean(CourseVideoService.class);
        List<CourseVideo> list = service.list(so);

        pageContext.setAttribute(getVarid(), list);
        return SKIP_PAGE;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
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

    public Boolean getCourseShowState() {
        return courseShowState;
    }

    public void setCourseShowState(Boolean courseShowState) {
        this.courseShowState = courseShowState;
    }

    public Boolean getCourseRecommendState() {
        return courseRecommendState;
    }

    public void setCourseRecommendState(Boolean courseRecommendState) {
        this.courseRecommendState = courseRecommendState;
    }

    public Boolean getCourseHotState() {
        return courseHotState;
    }

    public void setCourseHotState(Boolean courseHotState) {
        this.courseHotState = courseHotState;
    }

    public Boolean getShowState() {
        return showState;
    }

    public void setShowState(Boolean showState) {
        this.showState = showState;
    }
}
