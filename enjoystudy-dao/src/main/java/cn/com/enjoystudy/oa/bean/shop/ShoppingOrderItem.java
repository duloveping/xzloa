package cn.com.enjoystudy.oa.bean.shop;

import cn.com.enjoystudy.oa.bean.EntitySupport;

/**
 * 购物订单明细
 * @author 广州新咨力科技有限公司-杜永生
 */
public class ShoppingOrderItem extends EntitySupport {
    /** 订单ID */
    private String orderId;
    /** 会员ID */
    private String accountId;
    /** 课程ID */
    private String courseId;
    /** 课程编号 */
    private String courseCode;
    /** 课程名称 */
    private String courseName;
    /** 现价 */
    private Double currentPrice;
    /** 市价 */
    private Double marketPrice;
    /** 促销价 */
    private Double salePrice;
    /** 合计金额 */
    private Double totalPrice;
    /** 购买数量 */
    private Integer totalAmount;

    public ShoppingOrderItem() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
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

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }
}
