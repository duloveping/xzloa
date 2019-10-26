package cn.com.enjoystudy.oa.webapps.web.shop;

import cn.com.enjoystudy.oa.bean.base.EmployeeAccount;
import cn.com.enjoystudy.oa.bean.shop.ShoppingCart;
import cn.com.enjoystudy.oa.bean.shop.ShoppingCartSO;
import cn.com.enjoystudy.oa.bean.shop.ShoppingOrder;
import cn.com.enjoystudy.oa.bean.shop.ShoppingOrderSO;
import cn.com.enjoystudy.oa.bean.study.Course;
import cn.com.enjoystudy.oa.bean.study.CourseVideoSO;
import cn.com.enjoystudy.oa.filter.ManageSessionFilter;
import cn.com.enjoystudy.oa.service.shop.ShoppingCartService;
import cn.com.enjoystudy.oa.service.study.CourseService;
import cn.com.enjoystudy.oa.service.study.CourseVideoService;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.alibaba.fastjson.JSONObject;
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
}
