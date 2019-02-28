package cn.com.enjoystudy.oa.webapps.web.shop;

import cn.com.enjoystudy.oa.bean.base.EmployeeAccount;
import cn.com.enjoystudy.oa.bean.shop.ShoppingCart;
import cn.com.enjoystudy.oa.bean.shop.ShoppingCartSO;
import cn.com.enjoystudy.oa.filter.ManageSessionFilter;
import cn.com.enjoystudy.oa.service.shop.ShoppingCartService;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("web/shop/shopping-cart/index");
        return mv;
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

    @RequestMapping("add")
    @ResponseBody
    public JSONObject add(@RequestParam("courseId") String courseId) {
        Subject subject = SecurityUtils.getSubject();
        Object object = subject.getSession().getAttribute(ManageSessionFilter.DEFAULT_LOGIN_USER);
        if (null != object) {
            EmployeeAccount account = (EmployeeAccount) object;
            ShoppingCartSO cartSO = new ShoppingCartSO();
            cartSO.setAccountId(account.getId());
            cartSO.setCourseId(courseId);

            ShoppingCart cart = null;
            List<ShoppingCart> cartList = shoppingCartService.list(cartSO);
            if (null != cartList && cartList.size() > 0) {
                cart = cartList.get(0);
                cart.setBuyAmount(cart.getBuyAmount() + 1);
                shoppingCartService.update(cart);
            } else {
                cart = new ShoppingCart();
                cart.setBuyAmount(1);
                cart.setAccountId(account.getId());
                cart.setCourseId(courseId);
                shoppingCartService.insert(cart);
            }
            return resultSuccess("成功");
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
