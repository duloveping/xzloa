package cn.com.enjoystudy.oa.test;

import cn.com.enjoystudy.oa.common.Constants;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class HttpclientTester {
    public static void main(String[] args) {
        String nonce_str = RandomStringUtils.randomNumeric(32);
        String body = "内审员证";
        String out_trade_no = "2019100600001";
        String spbill_create_ip = "123.12.12.123";
        String total_fee = "1.0";
        String trade_type = "JSAPI";

        Calendar calendar = Calendar.getInstance();
        String pattern = "yyyyMMddHHmmss";
        String time_start = DateFormatUtils.format(calendar.getTime(), pattern);
        calendar.add(Calendar.MINUTE, 10);
        String time_expire = DateFormatUtils.format(calendar.getTime(), pattern);
        String notify_url = "http://www.enjoystudy.com.cn/web/pay/wei-xin-pay/notifyUrl";

        List<String> params = new ArrayList<String>();
        params.add("appid=" + Constants.WX_APPID);
        params.add("mch_id=" + Constants.WX_MCH_ID);
        params.add("nonce_str=" + nonce_str);
        params.add("body=" + body);
        params.add("spbill_create_ip=" + spbill_create_ip);
        params.add("time_start=" + time_start);
        params.add("time_expire=" + time_expire);
        params.add("total_fee=" + total_fee);
        params.add("notify_url=" + notify_url);
        params.add("trade_type=" + trade_type);

        String[] strs = params.toArray(new String[params.size()]);
        Arrays.sort(strs);
        String sign = DigestUtils.md5Hex(StringUtils.join(strs, "&"));

        StringBuilder xml = new StringBuilder();
        xml.append("<xml>");
        xml.append("<appid>" + Constants.WX_APPID + "</appid>");
        xml.append("<mch_id>" + Constants.WX_MCH_ID + "</mch_id>");
//        xml.append("<device_info></device_info>");
        xml.append("<nonce_str>" + nonce_str + "</nonce_str>");
        xml.append("<sign>" + sign + "</sign>");
//        xml.append("<sign_type>MD5</sign_type>");
        xml.append("<body>" + body + "</body>");
//        xml.append("<detail></detail>");
//        xml.append("<attach></attach>");
        xml.append("<out_trade_no>" + out_trade_no + "</out_trade_no>");
        xml.append("<spbill_create_ip>" + spbill_create_ip + "</spbill_create_ip>");



        xml.append("<time_start>" + time_start + "</time_start>");
        xml.append("<time_expire>" + time_expire + "</time_expire>");
//        xml.append("<fee_type>CNY<fee_type>");
        xml.append("<total_fee>" + total_fee + "</total_fee>");
//        xml.append("<goods_tag></goods_tag>");
        xml.append("<notify_url>" + notify_url + "</notify_url>");
        xml.append("<trade_type>" + trade_type + "</trade_type>");
//        xml.append("<limit_pay></limit_pay>");
//        xml.append("<receipt></receipt>");
        xml.append("</xml>");

//        List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
//        parameters.add(new BasicNameValuePair("xml", xml.toString()));

        String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
        HttpClient hc = HttpClientBuilder.create().build();
        HttpPost hp = new HttpPost(url);
        hp.addHeader("Content-Type","text/html;charset=UTF-8");
        StringEntity stringEntity = new StringEntity(xml.toString(),"UTF-8");
        stringEntity.setContentEncoding("UTF-8");
        hp.setEntity(stringEntity);

        try {
//            hp.setEntity(new UrlEncodedFormEntity(parameters,"UTF-8"));
            HttpResponse response = hc.execute(hp);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, "UTF-8");
            System.out.println(result);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


//        String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
//
//        HttpPost hp = new HttpPost(url);
//
//
//
//
//        HttpClient hc = HttpClientBuilder.create().build();
//        try {
//            HttpResponse response = hc.execute(hp);
//            response.getEntity();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
