package cn.com.enjoystudy.oa.bean.study;

/**
 * 课程
 * @author 广州新咨力科技有限公司-杜永生
 */
public class Course extends Paper {
    /** 分类 */
    private CourseType type;
    /** 分类ID */
    private String typeId;
    /** 分类名称 */
    private String typeName;
    /** 教师 */
    private Teacher teacher;
    /** 教师ID */
    private String teacherId;
    /** 教师名称 */
    private String teacherName;
    /** 课程编号 */
    private String code;
    /** 课程名称 */
    private String name;
    /** 课程简介 */
    private String introduction;
    /** 课程描述 */
    private String description;

    public Course() {
    }

    public CourseType getType() {
        return type;
    }

    public void setType(CourseType type) {
        this.type = type;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
}
