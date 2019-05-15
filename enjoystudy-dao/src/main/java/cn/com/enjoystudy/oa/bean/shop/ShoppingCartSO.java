package cn.com.enjoystudy.oa.bean.shop;

import cn.com.enjoystudy.oa.bean.SOSupport;

/**
 * 购物车
 * @author 广州新咨力科技有限公司-杜永生
 */
public class ShoppingCartSO extends SOSupport {
    /** 用户ID */
    private String accountId;
    /** 分类ID */
    private String typeId;
    /** 分类编号 */
    private String typeCode;
    /** 分类名称 */
    private String typeName;
    /** 教师ID */
    private String teacherId;
    /** 教师名称 */
    private String teacherName;
    /** 课程ID */
    private String courseId;
    /** 课程编号 */
    private String courseCode;
    /** 课程名称 */
    private String courseName;
    /** 图片 */
    private String image;
    /** 现价 */
    private Double currentPrice;
    /** 市价 */
    private Double marketPrice;
    /** 促销价 */
    private Double salePrice;
    /** 购买数量 */
    private Integer buyAmount;
    /** 合计金额 */
    private Double totalPrice;

    public ShoppingCartSO() {
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public Integer getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(Integer buyAmount) {
        this.buyAmount = buyAmount;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
