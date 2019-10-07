package cn.com.enjoystudy.oa.test;

import cn.com.enjoystudy.oa.util.IdGenerateUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;

public class Tester {
    public static void main(String[] args) {
        // 公众账号ID
        String appid = "wx9989a18bc4714287";
        // 商户号
        String mchId = "1488778382";
        // 时间戳
        String timeStamp = String.valueOf(System.currentTimeMillis() / 1000);
        // 随机字符串
        String nonceStr = RandomStringUtils.randomNumeric(32);

        String productId = IdGenerateUtils.getRandomUUID().replaceAll("-", "");


        String[] strs = {"appid=" + appid, "mch_id=" + mchId, "time_stamp=" + timeStamp, "product_id=" + productId, "nonce_str=" + nonceStr};
        Arrays.sort(strs);
        String params = StringUtils.join(strs, "&");
        String sign = DigestUtils.md5Hex(params);
        StringBuilder url = new StringBuilder();



        url.append("weixin://wxpay/bizpayurl?sign=");
        url.append(sign);
        url.append("&");
        url.append(params);
        System.out.println(params);
        System.out.println(sign);
        System.out.println(url.toString());

    }
}
