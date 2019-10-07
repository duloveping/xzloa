package cn.com.enjoystudy.oa.webapps.web.shop;

import cn.com.enjoystudy.oa.service.shop.ShoppingCartService;
import cn.com.enjoystudy.oa.service.shop.ShoppingOrderItemService;
import cn.com.enjoystudy.oa.service.shop.ShoppingOrderService;
import com.egzosn.pay.wx.api.WxPayConfigStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/shop/web-shopping-order")
public class WebShoppingOrderController {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private ShoppingOrderService shoppingOrderService;
    @Autowired
    private ShoppingOrderItemService shoppingOrderItemService;

    public void test() {
        WxPayConfigStorage wxPayConfigStorage = new WxPayConfigStorage();
    }

}
