package cn.com.enjoystudy.oa.webapps.web.allinpay;

import cn.com.enjoystudy.oa.common.Constants;

public class Allinpay {
    private String cusid = Constants.ALLINPAY_SYB_CUSID;
    private String appid = Constants.ALLINPAY_SYB_APPID;
    private String trxamt = "0.0";
    private String randomstr = "";
    private String sign = "";
    private String appkey = Constants.ALLINPAY_SYB_APPKEY;

    public Allinpay() {
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

    public String getTrxamt() {
        return trxamt;
    }

    public void setTrxamt(String trxamt) {
        this.trxamt = trxamt;
    }

    public String getRandomstr() {
        return randomstr;
    }

    public void setRandomstr(String randomstr) {
        this.randomstr = randomstr;
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
