package cn.com.enjoystudy.oa.bean.study;

/**
 * 课程
 * @author 广州新咨力科技有限公司-杜永生
 */
public class CourseSO extends PaperSO {
    /** 分类 */
    private CourseType type;
    /** 分类ID */
    private String typeId;
    /** 分类编号 */
    private String typeCode;
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
    /** 显示状态 */
    private Boolean showState;
    /** 推荐状态 */
    private Boolean recommendState;
    /** 热门状态 */
    private Boolean hotState;
    /** 图片 */
    private String image;
    /** 课程简介 */
    private String introduction;
    /** 课程描述 */
    private String description;
    /** 模板 */
    private String templet;
    /** 点击次数 */
    private Integer clickAmount;
    /** 收藏次数 */
    private Integer loveAmount;
    /** 点赞次数 */
    private Integer starAmount;
    /** 评论次数 */
    private Integer remarkAmount;

    public CourseSO() {
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

    public String getTemplet() {
        return templet;
    }

    public void setTemplet(String templet) {
        this.templet = templet;
    }

    public Integer getClickAmount() {
        return clickAmount;
    }

    public void setClickAmount(Integer clickAmount) {
        this.clickAmount = clickAmount;
    }

    public Integer getLoveAmount() {
        return loveAmount;
    }

    public void setLoveAmount(Integer loveAmount) {
        this.loveAmount = loveAmount;
    }

    public Integer getStarAmount() {
        return starAmount;
    }

    public void setStarAmount(Integer starAmount) {
        this.starAmount = starAmount;
    }

    public Integer getRemarkAmount() {
        return remarkAmount;
    }

    public void setRemarkAmount(Integer remarkAmount) {
        this.remarkAmount = remarkAmount;
    }
}
