package cn.com.enjoystudy.oa.webapps.web.allinpay;

import allinpay.utils.SybUtils;
import cn.com.enjoystudy.oa.common.Constants;
import cn.com.enjoystudy.oa.webapps.BaseController;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.TreeMap;

@Controller
@RequestMapping("/web/allinpay/allinpay-notify")
public class AllinpayNotifyController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AllinpayNotifyController.class);

    /**
     *
     * @param retcode：返回码
     * @param retmsg：返回码说明
     * @param cusid：商户号
     * @param appid：应用ID
     * @param trxid：交易单号
     * @param chnltrxid：渠道平台交易单号
     * @param reqsn：商户交易单号
     * @param randomstr：随机字符串
     * @param trxstatus：交易状态
     * @param fintime：交易完成时间（格式：yyyyMMddHHmmss）
     * @param errmsg：错误原因
     * @param payinfo：微信支付串
     * @param sign：签名
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("result")
    public ModelAndView result(
            @RequestParam(value = "retcode", required = false) String retcode,
            @RequestParam(value = "retmsg", required = false) String retmsg,
            @RequestParam(value = "cusid", required = false) String cusid,
            @RequestParam(value = "appid", required = false) String appid,
            @RequestParam(value = "trxid", required = false) String trxid,
            @RequestParam(value = "chnltrxid", required = false) String chnltrxid,
            @RequestParam(value = "reqsn", required = false) String reqsn,
            @RequestParam(value = "randomstr", required = false) String randomstr,
            @RequestParam(value = "trxstatus", required = false) String trxstatus,
            @RequestParam(value = "fintime", required = false) String fintime,
            @RequestParam(value = "errmsg", required = false) String errmsg,
            @RequestParam(value = "payinfo", required = false) String payinfo,
            @RequestParam(value = "sign", required = false) String sign,
            HttpServletRequest request, HttpServletResponse response){
        TreeMap<String, String> params = new TreeMap<String, String>();
        if (StringUtils.isNotBlank(retcode)) { params.put("retcode", retcode); }
        if (StringUtils.isNotBlank(retmsg)) { params.put("retmsg", retmsg); }
        if (StringUtils.isNotBlank(cusid)) { params.put("cusid", cusid); }
        if (StringUtils.isNotBlank(appid)) { params.put("appid", appid); }
        if (StringUtils.isNotBlank(trxid)) { params.put("trxid", trxid); }
        if (StringUtils.isNotBlank(chnltrxid)) { params.put("chnltrxid", chnltrxid); }
        if (StringUtils.isNotBlank(reqsn)) { params.put("reqsn", reqsn); }
        if (StringUtils.isNotBlank(randomstr)) { params.put("randomstr", randomstr); }
        if (StringUtils.isNotBlank(trxstatus)) { params.put("trxstatus", trxstatus); }
        if (StringUtils.isNotBlank(fintime)) { params.put("fintime", fintime); }
        if (StringUtils.isNotBlank(errmsg)) { params.put("errmsg", errmsg); }
        if (StringUtils.isNotBlank(payinfo)) { params.put("payinfo", payinfo); }
        if (StringUtils.isNotBlank(sign)) { params.put("retcode", sign); }

        try {
            boolean flag = SybUtils.validSign(params, "");
            if (flag) {

            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return null;
    }
}
