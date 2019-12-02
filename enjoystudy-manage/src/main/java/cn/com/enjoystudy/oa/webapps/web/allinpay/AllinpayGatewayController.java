package cn.com.enjoystudy.oa.webapps.web.allinpay;

import allinpay.utils.SybUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.TreeMap;

@Controller
@RequestMapping("/web/allinpay/gateway")
public class AllinpayGatewayController extends AllinpayController {
    @RequestMapping("index")
    public ModelAndView index() {
        Date date = new Date();
        String ymd = DateFormatUtils.format(date, "yyyyMMdd");
        String hms = DateFormatUtils.format(date, "HHmmss");
        String orderRnd = RandomStringUtils.randomNumeric(6);
        String valRnd = RandomStringUtils.randomNumeric(10);

        AllinpayApi api = new AllinpayApi();
        api.setOrderid(ymd + hms + orderRnd);
        api.setRandomstr(valRnd);
        api.setGoodsid("123456");
        api.setGoodsinf("内审员证书");
        api.setTrxamt("100");
        api.setValidtime("10");

        TreeMap<String, String> treeMap = beanToTreeMap(api);
        api.setSign(treeMap.get("sign"));

        ModelAndView mv = new ModelAndView("/web/pay/payment/gateway");
        mv.getModel().put("so", api);
        return mv;
    }

    public TreeMap<String, String> beanToTreeMap(AllinpayApi api) {
        if (null == api) {
            throw new NullPointerException("api is null.");
        }
        TreeMap<String, String> map = new TreeMap<String, String>();
        map.put("cusid", api.getCusid());
        map.put("appid", api.getAppid());
        map.put("charset", api.getCharset());
        map.put("returl", api.getReturl());
        map.put("notifyurl", api.getNotifyurl());
        map.put("goodsid", api.getGoodsid());
        map.put("goodsinf", api.getGoodsinf());
        map.put("trxamt", api.getTrxamt());
        map.put("orderid", api.getOrderid());
        map.put("randomstr", api.getRandomstr());
        map.put("gateid", api.getGateid());
        map.put("paytype", api.getPaytype());
        map.put("validtime", api.getValidtime());
        map.put("limitpay", api.getLimitpay());
        try {
            map.put("sign", SybUtils.sign(map, api.getAppkey()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
