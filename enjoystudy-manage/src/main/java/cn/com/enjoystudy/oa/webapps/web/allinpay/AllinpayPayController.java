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
import java.util.TreeMap;

@Controller
@RequestMapping("/web/allinpay/allinpay-pay")
public class AllinpayPayController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AllinpayPayController.class);

    @RequestMapping("result")
    public ModelAndView result(HttpServletRequest request, HttpServletResponse response){
        



        return null;
    }
}