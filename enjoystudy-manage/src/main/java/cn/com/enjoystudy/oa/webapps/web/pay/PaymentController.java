package cn.com.enjoystudy.oa.webapps.web.pay;

import cn.com.enjoystudy.oa.util.QRCodeUtils;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Controller
@RequestMapping("/web/pay/payment")
public class PaymentController extends BaseController {



    @RequestMapping(value = "wxQRCode", method = RequestMethod.GET)
    @ResponseBody
    public void wxQRCode(@RequestParam String productId, HttpServletRequest request, HttpServletResponse response) {
        // 公众账号ID
        String appid = "wx9989a18bc4714287";
        // 商户号
        String mchId = "1488778382";
        // 时间戳
        String timeStamp = String.valueOf(System.currentTimeMillis() / 1000);
        // 随机字符串
        String nonceStr = RandomStringUtils.randomNumeric(32);
        productId = productId.replaceAll("-", "");

        String[] strs = {"appid=" + appid, "mch_id=" + mchId, "time_stamp=" + timeStamp, "product_id=" + productId, "nonce_str=" + nonceStr};
        Arrays.sort(strs);
        String params = StringUtils.join(strs, "&");
        String sign = DigestUtils.md5Hex(params);
        StringBuilder url = new StringBuilder();

        url.append("weixin://wxpay/bizpayurl?sign=");
        url.append(sign);
        url.append("&");
        url.append(params);

        try {
            // 生成二维码
            BitMatrix qRcodeImg = QRCodeUtils.generateQRCodeStream(url.toString(), response);
            // 将二维码输出到页面中
            MatrixToImageWriter.writeToStream(qRcodeImg, "png", response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
