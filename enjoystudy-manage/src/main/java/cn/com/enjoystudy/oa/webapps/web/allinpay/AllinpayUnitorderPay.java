package cn.com.enjoystudy.oa.webapps.web.allinpay;

import allinpay.utils.SybUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.TreeMap;

/**
 * 通联收银宝的统一支付接口
 */
public class AllinpayUnitorderPay extends Allinpay {
    private String version = "11";
    private String reqsn = "";
    private String paytype = "11";
    private String body = "";
    private String remark = "";
    private String validtime = "";
    private String acct = "";
    private String notifyUrl = "http://www.enjoystudy.com.cn/web/allinpay/allinpay-notify/ajax.jhtml";
    private String limitPay = "";
    private String subAppid = "";
    private String goodsTag = "";
    private String benefitdetail = "";
    private String chnlstoreid = "";
    private String subbranch = "";
    private String extendparams = "";
    private String cusip = "";
    private String idno = "";
    private String truename = "";
    private String asinfo = "";
    private String fqnum = "";
    private String signtype = "MD5";
    private String sign = "";
    private String authcode = "";

    public AllinpayUnitorderPay() {
    }

    public TreeMap<String, String> toTreeMap() {
        TreeMap<String, String> map = new TreeMap<String, String>();
        map.put("cusid", getCusid());
        map.put("appid", getAppid());
        map.put("version", this.version);
        map.put("trxamt", getTrxamt());
        map.put("reqsn", this.reqsn);
        map.put("paytype", this.paytype);
        map.put("randomstr", getRandomstr());
        if (StringUtils.isNotBlank(this.body)) { map.put("body", StringUtils.trim(this.body)); }
        if (StringUtils.isNotBlank(this.remark)) { map.put("remark", StringUtils.trim(this.remark)); }
        if (StringUtils.isNotBlank(this.validtime)) { map.put("validtime", StringUtils.trim(this.validtime)); }
        if (StringUtils.isNotBlank(this.acct)) { map.put("acct", StringUtils.trim(this.acct)); }
        if (StringUtils.isNotBlank(this.notifyUrl)) { map.put("notify_url", StringUtils.trim(this.notifyUrl)); }
        if (StringUtils.isNotBlank(this.limitPay)) { map.put("limit_pay", StringUtils.trim(this.limitPay)); }
        if (StringUtils.isNotBlank(this.subAppid)) { map.put("sub_appid", StringUtils.trim(this.subAppid)); }
        if (StringUtils.isNotBlank(this.goodsTag)) { map.put("goods_tag", StringUtils.trim(this.goodsTag)); }
        if (StringUtils.isNotBlank(this.benefitdetail)) { map.put("benefitdetail", StringUtils.trim(this.benefitdetail)); }
        if (StringUtils.isNotBlank(this.chnlstoreid)) { map.put("chnlstoreid", StringUtils.trim(this.chnlstoreid)); }
        if (StringUtils.isNotBlank(this.subbranch)) { map.put("subbranch", StringUtils.trim(this.subbranch)); }
        if (StringUtils.isNotBlank(this.extendparams)) { map.put("extendparams", StringUtils.trim(this.extendparams)); }
        if (StringUtils.isNotBlank(this.cusip)) { map.put("cusip", StringUtils.trim(this.cusip)); }
        if (StringUtils.isNotBlank(this.idno)) { map.put("idno", StringUtils.trim(this.idno)); }
        if (StringUtils.isNotBlank(this.asinfo)) { map.put("asinfo", StringUtils.trim(this.asinfo)); }
        if (StringUtils.isNotBlank(this.fqnum)) { map.put("fqnum", StringUtils.trim(this.fqnum)); }
        if (StringUtils.isNotBlank(this.signtype)) { map.put("signtype", StringUtils.trim(this.signtype)); }

        try {
            map.put("sign", SybUtils.sign(map, getAppkey()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.sign = map.get("sign");
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

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
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

    public String getAcct() {
        return acct;
    }

    public void setAcct(String acct) {
        this.acct = acct;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getLimitPay() {
        return limitPay;
    }

    public void setLimitPay(String limitPay) {
        this.limitPay = limitPay;
    }

    public String getSubAppid() {
        return subAppid;
    }

    public void setSubAppid(String subAppid) {
        this.subAppid = subAppid;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    public String getBenefitdetail() {
        return benefitdetail;
    }

    public void setBenefitdetail(String benefitdetail) {
        this.benefitdetail = benefitdetail;
    }

    public String getChnlstoreid() {
        return chnlstoreid;
    }

    public void setChnlstoreid(String chnlstoreid) {
        this.chnlstoreid = chnlstoreid;
    }

    public String getSubbranch() {
        return subbranch;
    }

    public void setSubbranch(String subbranch) {
        this.subbranch = subbranch;
    }

    public String getExtendparams() {
        return extendparams;
    }

    public void setExtendparams(String extendparams) {
        this.extendparams = extendparams;
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public String getAsinfo() {
        return asinfo;
    }

    public void setAsinfo(String asinfo) {
        this.asinfo = asinfo;
    }

    public String getFqnum() {
        return fqnum;
    }

    public void setFqnum(String fqnum) {
        this.fqnum = fqnum;
    }

    public String getSigntype() {
        return signtype;
    }

    public void setSigntype(String signtype) {
        this.signtype = signtype;
    }

    @Override
    public String getSign() {
        return sign;
    }

    @Override
    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getAuthcode() {
        return authcode;
    }

    public void setAuthcode(String authcode) {
        this.authcode = authcode;
    }
}
