package cn.com.enjoystudy.oa.test;

import cn.com.enjoystudy.oa.webapps.web.allinpay.AllinpayUnitorderPay;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

public class AllinpayUnitorderPayTester {
    public static void main(String[] args) {
        Date date = new Date();
        String ymd = DateFormatUtils.format(date, "yyyyMMdd");
        String hms = DateFormatUtils.format(date, "HHmmss");
        String orderRnd = RandomStringUtils.randomNumeric(6);
        String valRnd = RandomStringUtils.randomNumeric(10);

        AllinpayUnitorderPay pay = new AllinpayUnitorderPay();
        pay.setRandomstr(valRnd);
        pay.setReqsn(ymd + hms + orderRnd);
        pay.setTrxamt("100");
        pay.setPaytype("W01");

        TreeMap<String, String> params = pay.toTreeMap();

        List<NameValuePair> list = new ArrayList<NameValuePair>();
        Set<String> keys = params.keySet();
        Iterator<String> iterator =keys.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String val = params.get(key);
            list.add(new BasicNameValuePair(key, val));
        }

        URI uri = null;
        try {
            uri = new URIBuilder().setScheme("https")
                    .setHost("vsp.allinpay.com")
                    .setPath("/apiweb/unitorder/pay")
                    .setParameters(list).build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        HttpPost hp = new HttpPost(uri);

        RequestConfig config = RequestConfig.custom()
                // 设置连接超时时间(单位毫秒)
                .setConnectTimeout(5000)
                // 设置请求超时时间(单位毫秒)
                .setConnectionRequestTimeout(5000)
                // socket读写超时时间(单位毫秒)
                .setSocketTimeout(5000)
                // 设置是否允许重定向(默认为true)
                .setRedirectsEnabled(true).build();

        hp.setConfig(config);
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        try {
            CloseableHttpResponse response = httpClient.execute(hp);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
