package cn.com.enjoystudy.oa.tag.study;

import cn.com.enjoystudy.oa.bean.study.Course;
import cn.com.enjoystudy.oa.bean.study.CourseSO;
import cn.com.enjoystudy.oa.service.study.CourseService;
import cn.com.enjoystudy.oa.tag.BaseTagSupport;

import java.util.List;

public class CourseListTag extends BaseTagSupport {
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


    @Override
    protected int doStartTagInternal() throws Exception {
        CourseSO so = new CourseSO();
        so.setCode(code);
        so.setName(name);
        so.setTypeId(typeId);
        so.setTypeName(typeName);
        so.setTeacherId(teacherId);
        so.setTeacherName(teacherName);

        CourseService service = (CourseService) getBean(CourseService.class);
        List<Course> list = service.list(so);

        pageContext.setAttribute(getVarid(), list);
        return SKIP_PAGE;
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
}
