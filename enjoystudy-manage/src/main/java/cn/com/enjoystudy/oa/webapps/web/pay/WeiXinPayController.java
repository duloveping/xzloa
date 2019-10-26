package cn.com.enjoystudy.oa.webapps.web.pay;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * 微信支付
 */
@Controller
@RequestMapping("/web/pay/wei-xin-pay")
public class WeiXinPayController extends PaymentController {
    private static final String INVALID_REQUEST = "INVALID_REQUEST";
    private static final String NOAUTH = "NOAUTH";
    private static final String NOTENOUGH = "NOTENOUGH";
    private static final String ORDERPAID = "ORDERPAID";
    private static final String ORDERCLOSED = "ORDERCLOSED";
    private static final String SYSTEMERROR = "SYSTEMERROR";
    private static final String APPID_NOT_EXIST = "APPID_NOT_EXIST";
    private static final String MCHID_NOT_EXIST = "MCHID_NOT_EXIST";
    private static final String APPID_MCHID_NOT_MATCH = "APPID_MCHID_NOT_MATCH";
    private static final String LACK_PARAMS = "LACK_PARAMS";
    private static final String OUT_TRADE_NO_USED = "OUT_TRADE_NO_USED";
    private static final String SIGNERROR = "SIGNERROR";
    private static final String XML_FORMAT_ERROR = "XML_FORMAT_ERROR";
    private static final String REQUIRE_POST_METHOD = "REQUIRE_POST_METHOD";
    private static final String POST_DATA_EMPTY = "POST_DATA_EMPTY";
    private static final String NOT_UTF8 = "NOT_UTF8";
    private static final String DOMAIN = "http://www.enjoystudy.com.cn";

    public JSONObject getErrorCode(String code) {
        String name = "";
        String desc = "";
        String reason = "";
        String scheme = "";
        if (INVALID_REQUEST.equalsIgnoreCase(code)) {
            name = INVALID_REQUEST;
            desc = "参数错误";
            reason = "参数格式有误或者未按规则上传";
            scheme = "订单重入时，要求参数值与原请求一致，请确认参数问题";
        } else if (NOAUTH.equalsIgnoreCase(code)) {
            name = NOAUTH;
            desc = "商户无此接口权限";
            reason = "商户未开通此接口权限";
            scheme = "请商户前往申请此接口权限";
        } else if (NOTENOUGH.equalsIgnoreCase(code)) {
            name = NOTENOUGH;
            desc = "余额不足";
            reason = "用户帐号余额不足";
            scheme = "用户帐号余额不足，请用户充值或更换支付卡后再支付";
        } else if (ORDERPAID.equalsIgnoreCase(code)) {
            name = ORDERPAID;
            desc = "商户订单已支付";
            reason = "商户订单已支付，无需重复操作";
            scheme = "商户订单已支付，无需更多操作";
        } else if (ORDERCLOSED.equalsIgnoreCase(code)) {
            name = ORDERCLOSED;
            desc = "订单已关闭";
            reason = "当前订单已关闭，无法支付";
            scheme = "当前订单已关闭，请重新下单";
        } else if (SYSTEMERROR.equalsIgnoreCase(code)) {
            name = SYSTEMERROR;
            desc = "系统错误";
            reason = "系统超时";
            scheme = "系统异常，请用相同参数重新调用";
        } else if (APPID_NOT_EXIST.equalsIgnoreCase(code)) {
            name = APPID_NOT_EXIST;
            desc = "APPID不存在";
            reason = "参数中缺少APPID";
            scheme = "请检查APPID是否正确";
        } else if (MCHID_NOT_EXIST.equalsIgnoreCase(code)) {
            name = MCHID_NOT_EXIST;
            desc = "MCHID不存在";
            reason = "参数中缺少MCHID";
            scheme = "请检查MCHID是否正确";
        } else if (APPID_MCHID_NOT_MATCH.equalsIgnoreCase(code)) {
            name = APPID_MCHID_NOT_MATCH;
            desc = "appid和mch_id不匹配";
            reason = "appid和mch_id不匹配";
            scheme = "请确认appid和mch_id是否匹配";
        } else if (LACK_PARAMS.equalsIgnoreCase(code)) {
            name = LACK_PARAMS;
            desc = "缺少参数";
            reason = "缺少必要的请求参数";
            scheme = "请检查参数是否齐全";
        } else if (OUT_TRADE_NO_USED.equalsIgnoreCase(code)) {
            name = OUT_TRADE_NO_USED;
            desc = "商户订单号重复";
            reason = "同一笔交易不能多次提交";
            scheme = "请核实商户订单号是否重复提交";
        } else if (SIGNERROR.equalsIgnoreCase(code)) {
            name = SIGNERROR;
            desc = "签名错误";
            reason = "参数签名结果不正确";
            scheme = "请检查签名参数和方法是否都符合签名算法要求";
        } else if (XML_FORMAT_ERROR.equalsIgnoreCase(code)) {
            name = XML_FORMAT_ERROR;
            desc = "XML格式错误";
            reason = "XML格式错误";
            scheme = "请检查XML参数格式是否正确";
        } else if (REQUIRE_POST_METHOD.equalsIgnoreCase(code)) {
            name = REQUIRE_POST_METHOD;
            desc = "请使用post方法";
            reason = "未使用post传递参数";
            scheme = "请检查请求参数是否通过post方法提交";
        } else if (POST_DATA_EMPTY.equalsIgnoreCase(code)) {
            name = POST_DATA_EMPTY;
            desc = "post数据为空";
            reason = "post数据不能为空";
            scheme = "请检查post数据是否为空";
        } else if (NOT_UTF8.equalsIgnoreCase(code)) {
            name = NOT_UTF8;
            desc = "编码格式错误";
            reason = "未使用指定编码格式";
            scheme = "请使用NOT_UTF8编码格式";
        }

        JSONObject result = new JSONObject();
        result.put("name", name);
        result.put("desc", desc);
        result.put("reason", reason);
        result.put("scheme", scheme);
        return result;
    }

    @RequestMapping("notifyUrl")
    public ModelAndView notifyUrl(){
        return new ModelAndView("web/pay/wei-xin-pay/notifyUrl");
    }

    /**
     * 统一下单
     */
    public void unifiedorder() {
        String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
        HttpPost httpPost = new HttpPost(url);



        // 应用ID
        String appid = "";
        // 商户号
        String mch_id = "";
        // 设备号
        String device_info = "";
        // 随机字符串
        String nonce_str = "";
        // 签名
        String sign = "";
        // 签名类型
        String sign_type = "";
        // 商品描述
        String body = "";
        // 商品详情
        String detail = "";
        // 附加数据
        String attach = "";
        // 商户订单号
        String out_trade_no = "";
        // 货币类型
        String fee_type = "CNY";
        // 总金额
        String total_fee = "";
        // 终端IP
        String spbill_create_ip = "";
        // 交易起始时间
        String time_start = "";
        // 交易结束时间
        String time_expire = "";
        // 订单优惠标记
        String goods_tag = "";
        // 通知地址
        String notify_url = "";
        // 交易类型
        String trade_type = "";
        // 指定支付方式
        String limit_pay = "";
        // 开发票入口开放标识
        String receipt = "";

        List<String> params = new ArrayList<String>();
        if (StringUtils.isNotBlank(appid)) { params.add("appid=" + StringUtils.trim(appid)); }
        if (StringUtils.isNotBlank(mch_id)) { params.add("mch_id=" + StringUtils.trim(mch_id)); }
        if (StringUtils.isNotBlank(device_info)) { params.add("device_info=" + StringUtils.trim(device_info)); }
        if (StringUtils.isNotBlank(nonce_str)) { params.add("nonce_str=" + StringUtils.trim(nonce_str)); }
        if (StringUtils.isNotBlank(appid)) { params.add("appid=" + StringUtils.trim(appid)); }
        if (StringUtils.isNotBlank(appid)) { params.add("appid=" + StringUtils.trim(appid)); }
        if (StringUtils.isNotBlank(appid)) { params.add("appid=" + StringUtils.trim(appid)); }
        if (StringUtils.isNotBlank(appid)) { params.add("appid=" + StringUtils.trim(appid)); }
        if (StringUtils.isNotBlank(appid)) { params.add("appid=" + StringUtils.trim(appid)); }
        if (StringUtils.isNotBlank(appid)) { params.add("appid=" + StringUtils.trim(appid)); }
        if (StringUtils.isNotBlank(appid)) { params.add("appid=" + StringUtils.trim(appid)); }
        if (StringUtils.isNotBlank(appid)) { params.add("appid=" + StringUtils.trim(appid)); }
        if (StringUtils.isNotBlank(appid)) { params.add("appid=" + StringUtils.trim(appid)); }
        if (StringUtils.isNotBlank(appid)) { params.add("appid=" + StringUtils.trim(appid)); }
        if (StringUtils.isNotBlank(appid)) { params.add("appid=" + StringUtils.trim(appid)); }
        if (StringUtils.isNotBlank(appid)) { params.add("appid=" + StringUtils.trim(appid)); }
        if (StringUtils.isNotBlank(appid)) { params.add("appid=" + StringUtils.trim(appid)); }
        if (StringUtils.isNotBlank(appid)) { params.add("appid=" + StringUtils.trim(appid)); }
        if (StringUtils.isNotBlank(appid)) { params.add("appid=" + StringUtils.trim(appid)); }
        if (StringUtils.isNotBlank(appid)) { params.add("appid=" + StringUtils.trim(appid)); }
        if (StringUtils.isNotBlank(appid)) { params.add("appid=" + StringUtils.trim(appid)); }
        if (StringUtils.isNotBlank(appid)) { params.add("appid=" + StringUtils.trim(appid)); }
        if (StringUtils.isNotBlank(appid)) { params.add("appid=" + StringUtils.trim(appid)); }
        if (StringUtils.isNotBlank(appid)) { params.add("appid=" + StringUtils.trim(appid)); }
        if (StringUtils.isNotBlank(appid)) { params.add("appid=" + StringUtils.trim(appid)); }
        if (StringUtils.isNotBlank(appid)) { params.add("appid=" + StringUtils.trim(appid)); }
        if (StringUtils.isNotBlank(appid)) { params.add("appid=" + StringUtils.trim(appid)); }
        if (StringUtils.isNotBlank(appid)) { params.add("appid=" + StringUtils.trim(appid)); }
        if (StringUtils.isNotBlank(appid)) { params.add("appid=" + StringUtils.trim(appid)); }

    }
}
