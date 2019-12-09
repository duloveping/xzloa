package cn.com.enjoystudy.oa.bean.study;

import cn.com.enjoystudy.oa.bean.SOSupport;

public class TeachCourseSO extends SOSupport {
    private String courseId;
    private String courseCode;
    private String courseName;
    private String courseImage;
    private Double currentPrice;
    private Double marketPrice;
    private Double salePrice;
    private Boolean recommendState;
    private Boolean hotState;
    private Boolean freeState;
    private String typeId;
    private String typeCode;
    private String typeName;
    private String teacherId;
    private String teacherName;
    private String teacherImage;
    private String employeeId;
    private String employeeName;

    public TeachCourseSO() {
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
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

    public Boolean getFreeState() {
        return freeState;
    }

    public void setFreeState(Boolean freeState) {
        this.freeState = freeState;
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

    public String getTeacherImage() {
        return teacherImage;
    }

    public void setTeacherImage(String teacherImage) {
        this.teacherImage = teacherImage;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}
