package cn.com.enjoystudy.oa.webapps.weixin;

import cn.com.enjoystudy.oa.webapps.BaseController;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Controller
@RequestMapping("/weixin/weixin")
public class WeixinController extends BaseController {
    @RequestMapping("visit-token")
    public void visitToken(
            @RequestParam(value = "signature", required = false) String signature,
            @RequestParam(value = "timestamp", required = false) String timestamp,
            @RequestParam(value = "nonce", required = false) String nonce,
            @RequestParam(value = "echostr", required = false) String echostr,
            HttpServletRequest request, HttpServletResponse response) {
        String token = "gzxzl138";
        String[] strs = {StringUtils.trim(token), StringUtils.trim(timestamp), StringUtils.trim(nonce)};
        Arrays.sort(strs);

        StringBuilder sb = new StringBuilder();
        sb.append(strs[0]);
        sb.append(strs[1]);
        sb.append(strs[2]);

        String sha1 = DigestUtils.sha1Hex(sb.toString());
        if (signature.equalsIgnoreCase(sha1)) {
            try {
                response.getWriter().print(echostr);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
