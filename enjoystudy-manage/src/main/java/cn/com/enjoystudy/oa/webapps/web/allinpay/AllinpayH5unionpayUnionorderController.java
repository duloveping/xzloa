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
@RequestMapping("/web/allinpay/h5unionpay-unionorder")
public class AllinpayH5unionpayUnionorderController extends AllinpayController {
    @RequestMapping("index")
    public ModelAndView index() {
        Date date = new Date();
        String ymd = DateFormatUtils.format(date, "yyyyMMdd");
        String hms = DateFormatUtils.format(date, "HHmmss");
        String orderRnd = RandomStringUtils.randomNumeric(6);
        String valRnd = RandomStringUtils.randomNumeric(10);

        AllinpayH5unionpayUnionorder api = new AllinpayH5unionpayUnionorder();
        api.setReqsn(ymd + hms + orderRnd);
        api.setRandomstr(valRnd);
        api.setBody("内审员");
        api.setRemark("内审员证书");
        api.setTrxamt("100");
        api.setValidtime("10");
        api.beanToTreeMap(api);
        ModelAndView mv = new ModelAndView("/web/pay/payment/h5unionpay");
        mv.getModel().put("so", api);
        return mv;
    }
}
