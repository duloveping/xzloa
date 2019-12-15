package cn.com.enjoystudy.oa.webapps.manage.order;

import cn.com.enjoystudy.oa.bean.shop.ShoppingCart;
import cn.com.enjoystudy.oa.bean.shop.ShoppingCartSO;
import cn.com.enjoystudy.oa.bean.shop.ShoppingOrder;
import cn.com.enjoystudy.oa.bean.shop.ShoppingOrderSO;
import cn.com.enjoystudy.oa.service.shop.ShoppingCartService;
import cn.com.enjoystudy.oa.service.shop.ShoppingOrderService;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/manage/order/shopping-cart")
public class ShoppingCartAdminController extends BaseController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping("index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("manage/order/shopping-cart/index");
        return mv;
    }

    @RequestMapping("list")
    @ResponseBody
    public JSONObject list(ShoppingCartSO so) {
        so.setAccountId(getCurrentUser().getId());
        List<ShoppingCart> list = shoppingCartService.list(so);
        JSONObject json = resultSuccess();
        json.put("datas", list);
        return json;
    }

    @RequestMapping("delete")
    @ResponseBody
    public JSONObject delete(@RequestParam String id) {
        shoppingCartService.deleteById(id);
        return resultSuccess();
    }

}
