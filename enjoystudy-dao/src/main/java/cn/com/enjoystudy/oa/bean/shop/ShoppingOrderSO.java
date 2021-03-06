package cn.com.enjoystudy.oa.bean.shop;

import cn.com.enjoystudy.oa.bean.SOSupport;

import java.util.Date;
import java.util.List;

/**
 * 购物订单
 * @author 广州新咨力科技有限公司-杜永生
 */
public class ShoppingOrderSO extends SOSupport {
    /** 订单标识 */
    private String orderSign;
    /** 订单编号 */
    private String orderCode;
    /** 用户ID */
    private String accountId;
    /** 用户姓名 */
    private String fullName;
    /** 下单时间 */
    private Date orderTime;
    /** 过期时间 */
    private Date expireTime;
    /** 支付时间 */
    private Date payTime;
    /** 订单总数 */
    private Integer totalAmount;
    /** 订单总额 */
    private Double totalPrice;
    /** 支付状态：0待支付，1已支付 */
    private Integer payState;
    /** 支付类型 */
    private String payType;
    /** 订单状态：0待付款，1待发货，2待收货，3待评价，4完成，5关闭，6无效，7删除 */
    private Integer orderState;
    private List<ShoppingOrderItem> orderItemList;
    private List<ShoppingCart> cartList;

    public ShoppingOrderSO() {
    }

    public String getOrderSign() {
        return orderSign;
    }

    public void setOrderSign(String orderSign) {
        this.orderSign = orderSign;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getPayState() {
        return payState;
    }

    public void setPayState(Integer payState) {
        this.payState = payState;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public List<ShoppingOrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<ShoppingOrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public List<ShoppingCart> getCartList() {
        return cartList;
    }

    public void setCartList(List<ShoppingCart> cartList) {
        this.cartList = cartList;
    }
}
