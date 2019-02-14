package cn.com.enjoystudy.oa.tag.study;

import cn.com.enjoystudy.oa.bean.study.Course;
import cn.com.enjoystudy.oa.bean.study.CourseSO;
import cn.com.enjoystudy.oa.service.study.CourseService;
import cn.com.enjoystudy.oa.tag.BaseTagSupport;

import java.util.List;

public class CourseListTag extends BaseTagSupport {
    private Integer pageSize;
    /** 分类ID */
    private String typeId;
    /** 分类名称 */
    private String typeCode;
    /** 分类名称 */
    private String typeName;
    /** 教师ID */
    private String teacherId;
    /** 教师名称 */
    private String teacherName;
    /** 课程编号 */
    private String code;
    /** 课程名称 */
    private String name;
    /** 显示状态 */
    private Boolean showState;
    /** 推荐状态 */
    private Boolean recommendState;
    /** 热门状态 */
    private Boolean hotState;

    @Override
    protected int doStartTagInternal() throws Exception {
        CourseSO so = new CourseSO();
        so.setPageNum(1);
        so.setPageSize(pageSize);
        so.setCode(code);
        so.setName(name);
        so.setTypeId(typeId);
        so.setTypeName(typeName);
        so.setTeacherId(teacherId);
        so.setTeacherName(teacherName);
        so.setShowState(showState);

        CourseService service = (CourseService) getBean(CourseService.class);
        List<Course> list = service.findPag(so).getList();

        pageContext.setAttribute(getVarid(), list);
        return SKIP_PAGE;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getShowState() {
        return showState;
    }

    public void setShowState(Boolean showState) {
        this.showState = showState;
    }

    public Boolean getRecommendState() {
        return recommendState;
    }

    public void setRecommendState(Boolean recommendState) {
        this.recommendState = recommendState;
    }

    public Boolean getHotState() {
        return hotState;
    }

    public void setHotState(Boolean hotState) {
        this.hotState = hotState;
    }
}
