package cn.com.enjoystudy.oa.webapps.web.allinpay;

import cn.com.enjoystudy.oa.webapps.BaseController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.TreeMap;

public class AllinpayController extends BaseController {
    /** 微信扫码支付 */
    public final String ALLINPAY_PAYTYPE_W01 = "W01";
    /** 微信JS支付 */
    public final String ALLINPAY_PAYTYPE_W02 = "W02";
    /** 微信APP支付 */
    public final String ALLINPAY_PAYTYPE_W03 = "W03";
    /** 微信小程序支付 */
    public final String ALLINPAY_PAYTYPE_W06 = "W06";
    /** 支付宝扫码支付 */
    public final String ALLINPAY_PAYTYPE_A01 = "A01";
    /** 支付宝JS支付 */
    public final String ALLINPAY_PAYTYPE_A02 = "A02";
    /** 支付宝APP支付 */
    public final String ALLINPAY_PAYTYPE_A03 = "A03";
    /** 手机QQ扫码支付 */
    public final String ALLINPAY_PAYTYPE_Q01 = "Q01";
    /** 手机QQ JS支付 */
    public final String ALLINPAY_PAYTYPE_Q02 = "Q02";
    /** 银联扫码支付(CSB)  */
    public final String ALLINPAY_PAYTYPE_U01 = "U01";
    /** 银联JS支付 */
    public final String ALLINPAY_PAYTYPE_U02 = "U02 ";

    /** 微信支付 */
    public final String ALLINPAY_TRXCODE_VSP501 = "VSP501";
    /** 微信支付撤销 */
    public final String ALLINPAY_TRXCODE_VSP502 = "VSP502";
    /** 微信支付退款 */
    public final String ALLINPAY_TRXCODE_VSP503 = "VSP503";
    /** 手机QQ 支付 */
    public final String ALLINPAY_TRXCODE_VSP505 = "VSP505";
    /** 手机QQ支付撤销 */
    public final String ALLINPAY_TRXCODE_VSP506 = "VSP506";
    /** 手机QQ支付退款 */
    public final String ALLINPAY_TRXCODE_VSP507 = "VSP507";
    /** 支付宝支付 */
    public final String ALLINPAY_TRXCODE_VSP511 = "VSP511";
    /** 支付宝支付撤销 */
    public final String ALLINPAY_TRXCODE_VSP512 = "VSP512";
    /** 支付宝支付退款 */
    public final String ALLINPAY_TRXCODE_VSP513 = "VSP513";
    /** 银联扫码支付  */
    public final String ALLINPAY_TRXCODE_VSP551 = "VSP551";
    /** 银联扫码撤销 */
    public final String ALLINPAY_TRXCODE_VSP552 = "VSP552";
    /** 银联扫码退货 */
    public final String ALLINPAY_TRXCODE_VSP553 = "VSP553";
    /** 差错借记调整  */
    public final String ALLINPAY_TRXCODE_VSP907 = "VSP907";
    /** 差错贷记调整  */
    public final String ALLINPAY_TRXCODE_VSP908 = "VSP908";

    public String ALLINPAY_RETCODE_SUCCESS = "SUCCESS";
    public String ALLINPAY_RETCODE_FAIL = "FAIL";

    public TreeMap<String, String> getParameters(HttpServletRequest request) {
        TreeMap<String, String> map = new TreeMap<String, String>();
        Map reqMap = request.getParameterMap();
        for (Object key : reqMap.keySet()) {
            String value = ((String[]) reqMap.get(key))[0];
            map.put(key.toString(), value);
        }
        return map;
    }
}
