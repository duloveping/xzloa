package cn.com.enjoystudy.oa.webapps.web.allinpay;

import cn.com.enjoystudy.oa.common.Constants;

public class AllinpayApi {
    private String cusid = Constants.ALLINPAY_SYB_CUSID;
    private String appid = Constants.ALLINPAY_SYB_APPID;
    private String charset = "UTF-8";
    private String returl = "http://www.enjoystudy.com.cn/web/allinpay/allinpay-notify/result.jhtml";
    private String notifyurl = "http://www.enjoystudy.com.cn/web/allinpay/allinpay-notify/ajax.jhtml";
    private String goodsid = "";
    private String goodsinf = "";
    private String trxamt = "0.0";
    private String orderid = "";
    private String randomstr = "";
    private String gateid = "";
    private String paytype = "B2C";
    private String validtime = "720";
    private String limitpay = "";
    private String sign = "";
    private String appkey = Constants.ALLINPAY_SYB_APPKEY;

    public AllinpayApi() {
    }

    public String getCusid() {
        return cusid;
    }

    public void setCusid(String cusid) {
        this.cusid = cusid;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getReturl() {
        return returl;
    }

    public void setReturl(String returl) {
        this.returl = returl;
    }

    public String getNotifyurl() {
        return notifyurl;
    }

    public void setNotifyurl(String notifyurl) {
        this.notifyurl = notifyurl;
    }

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsinf() {
        return goodsinf;
    }

    public void setGoodsinf(String goodsinf) {
        this.goodsinf = goodsinf;
    }

    public String getTrxamt() {
        return trxamt;
    }

    public void setTrxamt(String trxamt) {
        this.trxamt = trxamt;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getRandomstr() {
        return randomstr;
    }

    public void setRandomstr(String randomstr) {
        this.randomstr = randomstr;
    }

    public String getGateid() {
        return gateid;
    }

    public void setGateid(String gateid) {
        this.gateid = gateid;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public String getValidtime() {
        return validtime;
    }

    public void setValidtime(String validtime) {
        this.validtime = validtime;
    }

    public String getLimitpay() {
        return limitpay;
    }

    public void setLimitpay(String limitpay) {
        this.limitpay = limitpay;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }
}
