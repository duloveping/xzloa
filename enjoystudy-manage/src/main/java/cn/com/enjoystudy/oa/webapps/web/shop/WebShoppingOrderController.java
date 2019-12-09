package cn.com.enjoystudy.oa.webapps.web.shop;

import cn.com.enjoystudy.oa.bean.base.EmployeeAccount;
import cn.com.enjoystudy.oa.bean.shop.ShoppingOrder;
import cn.com.enjoystudy.oa.bean.shop.ShoppingOrderItem;
import cn.com.enjoystudy.oa.bean.study.Course;
import cn.com.enjoystudy.oa.bean.sys.SysSequence;
import cn.com.enjoystudy.oa.common.Constants;
import cn.com.enjoystudy.oa.service.shop.ShoppingCartService;
import cn.com.enjoystudy.oa.service.shop.ShoppingOrderItemService;
import cn.com.enjoystudy.oa.service.shop.ShoppingOrderService;
import cn.com.enjoystudy.oa.service.study.CourseService;
import cn.com.enjoystudy.oa.service.sys.SysSequenceService;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.alibaba.fastjson.JSONObject;
import com.egzosn.pay.wx.api.WxPayConfigStorage;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/web/shop/web-shopping-order")
public class WebShoppingOrderController extends BaseController {
    @Autowired
    private SysSequenceService sysSequenceService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private ShoppingOrderService shoppingOrderService;
    @Autowired
    private ShoppingOrderItemService shoppingOrderItemService;

    @RequestMapping("onceBuy")
    @ResponseBody
    public JSONObject onceBuy(@RequestParam String courseId) {
        Course course = courseService.getById(courseId);
        Calendar calendar = Calendar.getInstance();
        Date orderTime = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date expireTime = calendar.getTime();

        String ymd = DateFormatUtils.format(orderTime, "yyyyMMdd");
        String hms = DateFormatUtils.format(orderTime, "HHmmss");
        String name = "shopping-order-" + ymd;

        SysSequence sequence = sysSequenceService.getSequenceValue(name);
        if (null == sequence) {
            sequence = new SysSequence();
            sequence.setSeqValue(1);
            sequence.setSeqCode(name);
            sequence.setSeqName("课程订单流水号");
            sysSequenceService.insert(sequence);
        }
        StringBuilder code = new StringBuilder();
        code.append(ymd);
        code.append(hms);
        code.append(sysSequenceService.fillZero(sequence.getSeqValue().toString(), 4));

        EmployeeAccount account = getCurrentUser();
        ShoppingOrder order = new ShoppingOrder();
        order.setAccountId(account.getId());
        order.setFullName(account.getFullName());
        order.setOrderCode(code.toString());
        order.setOrderTime(orderTime);
        order.setExpireTime(expireTime);
        order.setPayState(Constants.PAY_STATE_NO);
        order.setOrderState(Constants.ORDER_STATE_PAY);
        order.setTotalAmount(1);
        order.setTotalPrice(course.getCurrentPrice());
        shoppingOrderService.insert(order);

        ShoppingOrderItem item = new ShoppingOrderItem();
        item.setAccountId(account.getId());
        item.setOrderId(order.getId());
        item.setCourseId(course.getId());
        item.setCourseCode(course.getCode());
        item.setCourseName(course.getName());
        item.setCurrentPrice(course.getCurrentPrice());
        item.setMarketPrice(course.getMarketPrice());
        item.setSalePrice(course.getSalePrice());
        item.setTotalAmount(1);
        item.setTotalPrice(course.getCurrentPrice());
        shoppingOrderItemService.insert(item);

        List<ShoppingOrderItem> itemList = new ArrayList<ShoppingOrderItem>();
        itemList.add(item);
        order.setOrderItemList(itemList);

        sequence.setSeqValue(sequence.getSeqValue() + 1);
        sysSequenceService.update(sequence);

        JSONObject json = resultSuccess();
        json.put("data", order);
        return json;
    }

    @RequestMapping("payment")
    public ModelAndView payment(@RequestParam String orderId) {
        ShoppingOrder order = shoppingOrderService.getById(orderId);

        ModelAndView mv = new ModelAndView("web/shop/web-shopping-order/pay-error");
        if (null != order && order.getPayState().equals(Constants.PAY_STATE_NO)) {
            EmployeeAccount account = getCurrentUser();
            if (null != account && order.getAccountId().equals(account.getId())) {
                mv = new ModelAndView("web/shop/web-shopping-order/payment");
                mv.getModel().put("order", order);
            } else {
                mv = new ModelAndView("redirect:/manage/login/index.jhtml");
            }
        }
        return mv;
    }
}
