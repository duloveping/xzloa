package cn.com.enjoystudy.oa.test;

import allinpay.utils.SybUtils;
import cn.com.enjoystudy.oa.common.Constants;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
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

public class TreeMapTester {
    public static void main(String[] args) {
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("cusid", Constants.ALLINPAY_SYB_CUSID);
        params.put("appid", Constants.ALLINPAY_SYB_APPID);
        params.put("version", "11");
        params.put("trxamt", "100");
        params.put("reqsn", "2019102400005");
        params.put("body", StringEscapeUtils.escapeJava("内审员"));
        params.put("paytype", "W01");
        params.put("notify_url", "http://www.enjoystudy.com.cn/web/allinpay/allinpay-notify.jhtml");
        params.put("randomstr", RandomStringUtils.randomNumeric(10));
        try {
            params.put("sign", SybUtils.sign(params, Constants.ALLINPAY_SYB_APPKEY));
        } catch (Exception e) {
            e.printStackTrace();
        }

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
