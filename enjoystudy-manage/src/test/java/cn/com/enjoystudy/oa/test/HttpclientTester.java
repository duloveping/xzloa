package cn.com.enjoystudy.oa.test;

import cn.com.enjoystudy.oa.common.Constants;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HttpclientTester {
    public static void main(String[] args) {
        String nonce_str = RandomStringUtils.randomNumeric(10);
        String body = "test";
        String out_trade_no = "2019100600001";
        String spbill_create_ip = "123.12.12.123";
        String total_fee = "1.0";
        String trade_type = "JSAPI";

        String notify_url = "http://www.enjoystudy.com.cn/web/pay/wei-xin-pay/notifyUrl";

        List<String> params = new ArrayList<String>();
        params.add("appid=" + Constants.WX_APPID);
        params.add("mch_id=" + Constants.WX_MCH_ID);
        params.add("nonce_str=" + nonce_str);
        params.add("body=" + body);
        params.add("out_trade_no=" + out_trade_no);
        params.add("total_fee=" + total_fee);
        params.add("spbill_create_ip=" + spbill_create_ip);
        params.add("notify_url=" + notify_url);
        params.add("trade_type=" + trade_type);

        String[] strs = params.toArray(new String[params.size()]);
        Arrays.sort(strs);
        String str = (StringUtils.join(strs, "&")) + "&key=" + Constants.WX_MCH_KEY;
        String sign = DigestUtils.md5Hex(str).toUpperCase();
        StringBuilder xml = new StringBuilder();
        xml.append("<xml>");
        xml.append("<appid>" + Constants.WX_APPID + "</appid>");
        xml.append("<mch_id>" + Constants.WX_MCH_ID + "</mch_id>");
        xml.append("<nonce_str>" + nonce_str + "</nonce_str>");
        xml.append("<sign>" + sign + "</sign>");
        xml.append("<body>" + body + "</body>");
        xml.append("<out_trade_no>" + out_trade_no + "</out_trade_no>");
        xml.append("<total_fee>" + total_fee + "</total_fee>");
        xml.append("<spbill_create_ip>" + spbill_create_ip + "</spbill_create_ip>");
        xml.append("<notify_url>" + notify_url + "</notify_url>");
        xml.append("<trade_type>" + trade_type + "</trade_type>");
        xml.append("</xml>");

        String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
        HttpClient hc = HttpClientBuilder.create().build();
        HttpPost hp = new HttpPost(url);
        hp.addHeader("Content-Type","text/xml;charset=utf-8");
        StringEntity stringEntity = new StringEntity(xml.toString(),"UTF-8");
        stringEntity.setContentEncoding("UTF-8");
        hp.setEntity(stringEntity);

        try {
            HttpResponse response = hc.execute(hp);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, "UTF-8");
            System.out.println(result);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
