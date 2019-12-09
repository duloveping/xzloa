package cn.com.enjoystudy.oa.webapps.web.allinpay;

import allinpay.utils.SybUtils;
import cn.com.enjoystudy.oa.bean.base.EmployeeAccount;
import cn.com.enjoystudy.oa.bean.shop.ShoppingOrder;
import cn.com.enjoystudy.oa.bean.shop.ShoppingOrderItem;
import cn.com.enjoystudy.oa.bean.shop.ShoppingOrderItemSO;
import cn.com.enjoystudy.oa.common.Constants;
import cn.com.enjoystudy.oa.service.shop.ShoppingOrderItemService;
import cn.com.enjoystudy.oa.service.shop.ShoppingOrderService;
import cn.com.enjoystudy.oa.util.QRCodeUtils;
import com.alibaba.fastjson.JSONObject;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/web/allinpay/unitorder-pay")
public class AllinpayUnitorderPayController extends AllinpayController {
    @Autowired
    private ShoppingOrderService shoppingOrderService;
    @Autowired
    private ShoppingOrderItemService shoppingOrderItemService;

    @RequestMapping(value = "notify")
    @ResponseBody
    public ModelAndView notify(HttpServletRequest request, HttpServletResponse response) {
        try {
            //通知传输的编码为GBK
            request.setCharacterEncoding("gbk");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //动态遍历获取所有收到的参数,此步非常关键,因为收银宝以后可能会加字段,动态获取可以兼容
        response.setCharacterEncoding("gbk");
        TreeMap<String, String> params = getParameters(request);
        try {
//            // 收银宝APPID
//            String appid = MapUtils.getString(params, "appid");
//            // 第三方交易号
//            String outtrxid = MapUtils.getString(params, "outtrxid");
//            // 交易类型
//            String trxcode = MapUtils.getString(params, "trxcode");
//            // 收银宝交易单号
//            String trxid = MapUtils.getString(params, "trxid");
//            // 	交易金额,单位：分
//            String trxamt = MapUtils.getString(params, "trxamt");
//            // 交易请求日期，格式：yyyymmdd
//            String trxdate = MapUtils.getString(params, "trxdate");
//            // 交易完成时间，格式：yyyymmddhhmmss
//            String paytime = MapUtils.getString(params, "paytime");
//            // 	渠道流水号
//            String chnltrxid = MapUtils.getString(params, "chnltrxid");
//            // 交易结果码
//            String trxstatus = MapUtils.getString(params, "trxstatus");
//            // 	终端编号
//            String cusid = MapUtils.getString(params, "cusid");
//            // 终端批次号
//            String termno = MapUtils.getString(params, "termno");
//            // 终端流水号
//            String termbatchid = MapUtils.getString(params, "termbatchid");
//            // 终端授权码
//            String termtraceno = MapUtils.getString(params, "termtraceno");
//            // 终端参考号
//            String termauthno = MapUtils.getString(params, "termauthno");
//            // 业务关联内容
//            String termrefnum = MapUtils.getString(params, "termrefnum");
//            // 原交易流水，通联原交易流水，冲正撤销交易本字段不为空
//            String trxreserved = MapUtils.getString(params, "trxreserved");
//            // 业务流水，统一下单对应的reqsn订单号
//            String cusorderid = MapUtils.getString(params, "cusorderid");
//            // 交易账号
//            String acct = MapUtils.getString(params, "acct");
//            // 手续费
//            String fee = MapUtils.getString(params, "fee");
//            // 签名类型
//            String signtype = MapUtils.getString(params, "signtype");
//            // 渠道子商户号
//            String cmid = MapUtils.getString(params, "cmid");
//            // 	渠道号
//            String chnlid = MapUtils.getString(params, "chnlid");
//            // sign校验码
//            String sign = MapUtils.getString(params, "sign");

            // 接受到推送通知,首先验签
            boolean isSign = SybUtils.validSign(params, Constants.ALLINPAY_SYB_APPKEY);
            if (isSign) {
                String cusorderid = MapUtils.getString(params, "cusorderid");

                ShoppingOrder order = shoppingOrderService.getByOrderCode(cusorderid);
                if (null != order && order.getPayState().equals(Constants.PAY_STATE_NO)) {
                    String paytime = MapUtils.getString(params, "paytime");
                    String trxcode = MapUtils.getString(params, "trxcode");
                    String pattern = "yyyyMMddHHmmss";
                    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                    Date payTime = sdf.parse(paytime);
                    order.setPayTime(payTime);
                    order.setPayType(trxcode);
                    order.setPayState(Constants.PAY_STATE_YES);
                    shoppingOrderService.update(order);
                }
            }
        } catch (Exception e) {
            //处理异常
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            //收到通知,返回success
            try {
                response.getOutputStream().write("success".getBytes());
                response.flushBuffer();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return new ModelAndView("web/allinpay/unitorder-pay/notify");
    }

    @RequestMapping(value = "weixin-pay")
    @ResponseBody
    public void weixinPay(@RequestParam String orderId, HttpServletRequest request, HttpServletResponse response) {
        qrcode(orderId, ALLINPAY_PAYTYPE_W01, request, response);
    }

    @RequestMapping(value = "alipay")
    @ResponseBody
    public void alipay(@RequestParam String orderId, HttpServletRequest request, HttpServletResponse response) {
        qrcode(orderId, ALLINPAY_PAYTYPE_A01, request, response);
    }

    @RequestMapping(value = "unionpay")
    @ResponseBody
    public void unionpay(@RequestParam String orderId, HttpServletRequest request, HttpServletResponse response) {
        qrcode(orderId, ALLINPAY_PAYTYPE_U01, request, response);
    }

    @RequestMapping(value = "qqpay")
    @ResponseBody
    public void qqpay(@RequestParam String orderId, HttpServletRequest request, HttpServletResponse response) {
        qrcode(orderId, ALLINPAY_PAYTYPE_Q01, request, response);
    }

    @RequestMapping(value = "qrcode", method = RequestMethod.GET)
    @ResponseBody
    public void qrcode(@RequestParam String orderId, @RequestParam String paytype, HttpServletRequest request, HttpServletResponse response) {
        ShoppingOrder order = shoppingOrderService.getById(orderId);
        if (null != order && order.getPayState().equals(Constants.PAY_STATE_NO)) {
            EmployeeAccount account = getCurrentUser();
            if (order.getAccountId().equals(account.getId())) {
                ShoppingOrderItemSO itemSO = new ShoppingOrderItemSO();
                itemSO.setOrderId(order.getId());
                List<ShoppingOrderItem> orderItemList =shoppingOrderItemService.list(itemSO);
                if (CollectionUtils.isNotEmpty(orderItemList)) {
                    ShoppingOrderItem item = orderItemList.get(0);

                    String valRnd = RandomStringUtils.randomNumeric(10);

                    Double trxamt = order.getTotalPrice() * 100;

                    AllinpayUnitorderPay api = new AllinpayUnitorderPay();
                    api.setReqsn(order.getOrderCode());
                    api.setRandomstr(valRnd);
                    api.setBody(item.getCourseName());
                    api.setTrxamt(trxamt.intValue() + "");
                    api.setValidtime("10");
                    api.setPaytype(paytype);
                    api.setNotifyUrl("http://www.enjoystudy.com.cn/web/allinpay/unitorder-pay/notify.jhtml");

                    TreeMap<String, String> params = api.toTreeMap();

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
                                .setPath("/apiweb/unitorder/pay").build();
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                    HttpPost hp = new HttpPost(uri);
                    try {
                        hp.setEntity(new UrlEncodedFormEntity(list, "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }

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
                        CloseableHttpResponse chr = httpClient.execute(hp);
                        // 从响应模型中获取响应实体
                        HttpEntity responseEntity = chr.getEntity();
                        if (responseEntity != null) {
                            String resTxt = EntityUtils.toString(responseEntity);
                            JSONObject json = JSONObject.parseObject(resTxt);
                            String retcode = json.getString("retcode");
                            String sign = json.getString("sign");

                            if (retcode.equals(ALLINPAY_RETCODE_SUCCESS)) {
                                TreeMap<String, String> resMap = new TreeMap<String, String>();
                                resMap.put("cusid", json.getString("cusid"));
                                resMap.put("appid", json.getString("appid"));
                                resMap.put("trxid", json.getString("trxid"));
                                if (StringUtils.isNotBlank(json.getString("chnltrxid"))) {
                                    resMap.put("chnltrxid", json.getString("chnltrxid"));
                                }
                                resMap.put("reqsn", json.getString("reqsn"));
                                resMap.put("randomstr", json.getString("randomstr"));
                                resMap.put("trxstatus", json.getString("trxstatus"));

                                try {
                                    String newSign = SybUtils.sign(resMap, Constants.ALLINPAY_SYB_APPKEY);
                                    System.out.println(newSign.equals(sign));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }


                                try {
                                    // 生成二维码
                                    BitMatrix qRcodeImg = QRCodeUtils.generateQRCodeStream(json.getString("payinfo"), response);
                                    // 将二维码输出到页面中
                                    MatrixToImageWriter.writeToStream(qRcodeImg, "png", response.getOutputStream());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }
}