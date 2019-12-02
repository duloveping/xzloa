package cn.com.enjoystudy.oa.webapps.web.pay;

import allinpay.utils.SybUtils;
import cn.com.enjoystudy.oa.bean.web.CourseTrainPlan;
import cn.com.enjoystudy.oa.bean.web.CourseTrainPlanSO;
import cn.com.enjoystudy.oa.common.Constants;
import cn.com.enjoystudy.oa.util.QRCodeUtils;
import cn.com.enjoystudy.oa.webapps.BaseController;
import cn.com.enjoystudy.oa.webapps.web.allinpay.AllinpayApi;
import cn.com.enjoystudy.oa.webapps.web.allinpay.AllinpayH5unionpayUnionorder;
import com.github.pagehelper.PageInfo;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

@Controller
@RequestMapping("/web/pay/payment")
public class PaymentController extends BaseController {

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

        ModelAndView mv = new ModelAndView("/web/pay/payment/index");
        return mv;
    }

    @RequestMapping("gateway")
    public ModelAndView gateway() {
        ModelAndView mv = new ModelAndView("/web/pay/payment/gateway");
        return mv;
    }



    @RequestMapping(value = "wxQRCode", method = RequestMethod.GET)
    @ResponseBody
    public void wxQRCode(HttpServletRequest request, HttpServletResponse response) {
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

        TreeMap<String, String> params = api.beanToTreeMap(api);

        StringBuilder sb = new StringBuilder();
        sb.append("https://syb.allinpay.com/apiweb/h5unionpay/unionorder?");
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getValue() != null && entry.getValue().length() > 0) {
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }

        try {
            // 生成二维码
            BitMatrix qRcodeImg = QRCodeUtils.generateQRCodeStream(sb.toString(), response);
            // 将二维码输出到页面中
            MatrixToImageWriter.writeToStream(qRcodeImg, "png", response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
