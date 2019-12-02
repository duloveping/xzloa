package cn.com.enjoystudy.oa.webapps.web.allinpay;

import allinpay.utils.SybUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.TreeMap;

public class AllinpayH5unionpayUnionorder extends Allinpay {
    private String version = "12";
    private String reqsn = "12";
    private String charset = "UTF-8";
    private String returl = "http://www.enjoystudy.com.cn/web/allinpay/allinpay-notify/result.jhtml";
    private String notifyUrl = "http://www.enjoystudy.com.cn/web/allinpay/allinpay-notify/ajax.jhtml";
    private String body = "";
    private String remark = "";
    private String validtime = "";
    private String limitPay = "";
    private String asinfo = "";

    public AllinpayH5unionpayUnionorder() {
    }

    public TreeMap<String, String> beanToTreeMap(AllinpayH5unionpayUnionorder api) {
        if (null == api) {
            throw new NullPointerException("api is null.");
        }
        TreeMap<String, String> map = new TreeMap<String, String>();
        map.put("cusid", api.getCusid());
        map.put("appid", api.getAppid());
        map.put("version", this.version);
        map.put("trxamt", getTrxamt());
        map.put("reqsn", this.reqsn);
        map.put("randomstr", getRandomstr());
        if (StringUtils.isNotBlank(this.body)) { map.put("body", StringUtils.trim(this.body)); }
        if (StringUtils.isNotBlank(this.charset)) { map.put("charset", StringUtils.trim(this.charset)); }
        if (StringUtils.isNotBlank(this.validtime)) { map.put("validtime", StringUtils.trim(this.validtime)); }
        if (StringUtils.isNotBlank(this.returl)) { map.put("returl", StringUtils.trim(this.returl)); }
        if (StringUtils.isNotBlank(this.notifyUrl)) { map.put("notify_url", StringUtils.trim(this.notifyUrl)); }
        if (StringUtils.isNotBlank(this.remark)) { map.put("remark", StringUtils.trim(this.remark)); }
        if (StringUtils.isNotBlank(this.limitPay)) { map.put("limit_pay", StringUtils.trim(this.limitPay)); }
        if (StringUtils.isNotBlank(this.asinfo)) { map.put("asinfo", StringUtils.trim(this.asinfo)); }

        try {
            map.put("sign", SybUtils.sign(map, api.getAppkey()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        setSign(map.get("sign"));
        return map;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getReqsn() {
        return reqsn;
    }

    public void setReqsn(String reqsn) {
        this.reqsn = reqsn;
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

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getValidtime() {
        return validtime;
    }

    public void setValidtime(String validtime) {
        this.validtime = validtime;
    }

    public String getLimitPay() {
        return limitPay;
    }

    public void setLimitPay(String limitPay) {
        this.limitPay = limitPay;
    }

    public String getAsinfo() {
        return asinfo;
    }

    public void setAsinfo(String asinfo) {
        this.asinfo = asinfo;
    }
}
