package cn.com.enjoystudy.oa.webapps.web.shop;

import cn.com.enjoystudy.oa.bean.base.EmployeeAccount;
import cn.com.enjoystudy.oa.bean.shop.*;
import cn.com.enjoystudy.oa.bean.study.Course;
import cn.com.enjoystudy.oa.bean.study.CourseVideoSO;
import cn.com.enjoystudy.oa.bean.sys.SysSequence;
import cn.com.enjoystudy.oa.common.Constants;
import cn.com.enjoystudy.oa.filter.ManageSessionFilter;
import cn.com.enjoystudy.oa.service.shop.ShoppingCartService;
import cn.com.enjoystudy.oa.service.shop.ShoppingOrderItemService;
import cn.com.enjoystudy.oa.service.shop.ShoppingOrderService;
import cn.com.enjoystudy.oa.service.study.CourseService;
import cn.com.enjoystudy.oa.service.study.CourseVideoService;
import cn.com.enjoystudy.oa.service.sys.SysSequenceService;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/web/shop/shopping-cart")
public class ShoppingCartController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingCartController.class);
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseVideoService courseVideoService;
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private ShoppingOrderService shoppingOrderService;
    @Autowired
    private ShoppingOrderItemService shoppingOrderItemService;
    @Autowired
    private SysSequenceService sysSequenceService;

    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("web/shop/shopping-cart/index");

        Subject subject = SecurityUtils.getSubject();
        Object object = null;
        try {
            object = subject.getSession().getAttribute(ManageSessionFilter.DEFAULT_LOGIN_USER);
            if (null != object) {
                EmployeeAccount account = (EmployeeAccount) object;

                ShoppingCartSO cartSO = new ShoppingCartSO();
                cartSO.setAccountId(account.getId());

                List<ShoppingCart> cartList = shoppingCartService.list(cartSO);
                mv.getModel().put("cartList", cartList);
            }
        } catch (IllegalArgumentException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (InvalidSessionException e) {
            LOGGER.error(e.getMessage(), e);
        }

        return mv;
    }

    @RequestMapping("add")
    public ModelAndView add(@RequestParam("courseId") String courseId) {
        ModelAndView mv = new ModelAndView("redirect:/web/login/index.jhtml");
        Subject subject = SecurityUtils.getSubject();
        Object object = null;
        try {
            object = subject.getSession().getAttribute(ManageSessionFilter.DEFAULT_LOGIN_USER);
            if (null != object) {
                Course course = courseService.getById(courseId);

                CourseVideoSO videoSO = new CourseVideoSO();
                videoSO.setCourseId(course.getId());
                Long amount = courseVideoService.getCount(videoSO);

                EmployeeAccount account = (EmployeeAccount) object;
                ShoppingCartSO cartSO = new ShoppingCartSO();
                cartSO.setAccountId(account.getId());
                cartSO.setCourseId(courseId);

                List<ShoppingCart> cartList = shoppingCartService.list(cartSO);
                if (null == cartList || cartList.size() == 0) {
                    ShoppingCart cart = new ShoppingCart();
                    cart.setBuyAmount(1);
                    cart.setAccountId(account.getId());
                    cart.setCourseId(courseId);
                    shoppingCartService.insert(cart);
                }
                mv = new ModelAndView("web/shop/shopping-cart/add");
                mv.getModel().put("course", course);
                mv.getModel().put("videoAmount", amount);
            }
        } catch (IllegalArgumentException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (InvalidSessionException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return mv;
    }

    @RequestMapping("append")
    @ResponseBody
    public JSONObject append(@RequestParam("courseId") String courseId) {
        JSONObject result;
        EmployeeAccount account = getCurrentUser();

        if (null != account) {
            Course course = courseService.getById(courseId);
            if (null != course && course.getShowState()) {
                CourseVideoSO videoSO = new CourseVideoSO();
                videoSO.setCourseId(course.getId());
                Long amount = courseVideoService.getCount(videoSO);

                ShoppingCartSO cartSO = new ShoppingCartSO();
                cartSO.setAccountId(account.getId());
                cartSO.setCourseId(courseId);

                List<ShoppingCart> cartList = shoppingCartService.list(cartSO);
                if (null == cartList || cartList.size() == 0) {
                    ShoppingCart cart = new ShoppingCart();
                    cart.setBuyAmount(1);
                    cart.setAccountId(account.getId());
                    cart.setCourseId(courseId);
                    shoppingCartService.insert(cart);
                }

                result = resultSuccess();
            } else {
                result = resultError("该课程已经关闭或已经删除！");
            }
        } else {
            result = resultError("请先登录系统");
        }
        return result;
    }

    @RequestMapping("list")
    @ResponseBody
    public JSONObject list() {
        Subject subject = SecurityUtils.getSubject();
        Object object = subject.getSession().getAttribute(ManageSessionFilter.DEFAULT_LOGIN_USER);
        if (null != object) {
            EmployeeAccount account = (EmployeeAccount) object;
            ShoppingCartSO cartSO = new ShoppingCartSO();
            cartSO.setAccountId(account.getId());

            List<ShoppingCart> cartList = shoppingCartService.list(cartSO);
            JSONObject result = resultSuccess();
            result.put("datas", cartList);
            return result;
        }
        return resultError("请先登录");
    }



    @RequestMapping("remove")
    @ResponseBody
    public JSONObject remove(@RequestParam("courseId") String courseId) {
        Subject subject = SecurityUtils.getSubject();
        Object object = subject.getSession().getAttribute(ManageSessionFilter.DEFAULT_LOGIN_USER);
        if (null != object) {
            EmployeeAccount account = (EmployeeAccount) object;
            shoppingCartService.remove(account.getId(), courseId);
            return resultSuccess("成功");
        }
        return resultError("请先登录");
    }

    @RequestMapping("createOrder")
    @ResponseBody
    public JSONObject createOrder(@RequestParam String[] shoppingCartIds) {
        EmployeeAccount account = getCurrentUser();
        if (null != account) {
            JSONObject json = resultError();
            if (ArrayUtils.isNotEmpty(shoppingCartIds)) {
                List<ShoppingOrderItem> orderItemList = new ArrayList<ShoppingOrderItem>();

                double totalPrice = 0.0;
                for (String cartId : shoppingCartIds) {
                    if (StringUtils.isNotBlank(cartId)) {
                        ShoppingCart cart = shoppingCartService.getById(cartId);
                        if (null != cart) {
                            Course course = courseService.getById(cart.getCourseId());
                            ShoppingOrderItem item = new ShoppingOrderItem();

                            item.setAccountId(account.getId());
                            item.setCourseId(course.getId());
                            item.setCourseCode(course.getCode());
                            item.setCourseName(course.getName());
                            item.setCurrentPrice(course.getCurrentPrice());
                            item.setMarketPrice(course.getMarketPrice());
                            item.setSalePrice(course.getSalePrice());
                            item.setTotalAmount(1);
                            item.setTotalPrice(course.getCurrentPrice());
                            orderItemList.add(item);

                            totalPrice += course.getCurrentPrice();

                            shoppingCartService.deleteById(cart.getId());
                        }
                    }
                }

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

                ShoppingOrder order = new ShoppingOrder();
                order.setAccountId(account.getId());
                order.setFullName(account.getFullName());
                order.setOrderCode(code.toString());
                order.setOrderTime(orderTime);
                order.setExpireTime(expireTime);
                order.setPayState(Constants.PAY_STATE_NO);
                order.setOrderState(Constants.ORDER_STATE_PAY);
                order.setTotalAmount(1);
                order.setTotalPrice(totalPrice);
                shoppingOrderService.insert(order);


                if (CollectionUtils.isNotEmpty(orderItemList)) {
                    for (ShoppingOrderItem item : orderItemList) {
                        item.setOrderId(order.getId());
                        shoppingOrderItemService.insert(item);
                    }
                }

                order.setOrderItemList(orderItemList);

                sequence.setSeqValue(sequence.getSeqValue() + 1);
                sysSequenceService.update(sequence);

                json = resultSuccess("成功");
                json.put("data", order);
            }
            return json;
        }
        return resultError("请先登录");
    }
}
