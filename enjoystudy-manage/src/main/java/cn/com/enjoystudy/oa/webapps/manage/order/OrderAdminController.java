package cn.com.enjoystudy.oa.webapps.manage.order;

import cn.com.enjoystudy.oa.bean.shop.ShoppingOrder;
import cn.com.enjoystudy.oa.bean.shop.ShoppingOrderItemSO;
import cn.com.enjoystudy.oa.bean.shop.ShoppingOrderSO;
import cn.com.enjoystudy.oa.service.shop.ShoppingOrderItemService;
import cn.com.enjoystudy.oa.service.shop.ShoppingOrderService;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/manage/order/order-admin")
public class OrderAdminController extends BaseController {
    @Autowired
    private ShoppingOrderService shoppingOrderService;
    @Autowired
    private ShoppingOrderItemService shoppingOrderItemService;

    @RequestMapping("index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("manage/order/order/index");
        return mv;
    }

    @RequestMapping("list")
    @ResponseBody
    public JSONObject list(ShoppingOrderSO so) {
        PageInfo<ShoppingOrder> pageInfo = shoppingOrderService.findPage(so);
        if (CollectionUtils.isNotEmpty(pageInfo.getList())) {
            for (ShoppingOrder order : pageInfo.getList()) {
                ShoppingOrderItemSO itemSO = new ShoppingOrderItemSO();
                itemSO.setOrderId(order.getId());
                order.setOrderItemList(shoppingOrderItemService.list(itemSO));
            }
        }
        return resultSuccess(pageInfo);
    }

    @RequestMapping("item-index")
    public ModelAndView itemIndex(@RequestParam String orderId) {
        ModelAndView mv = new ModelAndView("manage/order/order/item-index");
        return mv;
    }

    @RequestMapping("item-list")
    @ResponseBody
    public JSONObject itemList(@RequestParam String orderId) {
        ShoppingOrderItemSO itemSO = new ShoppingOrderItemSO();
        itemSO.setOrderId(orderId);
        return resultSuccess(shoppingOrderItemService.list(itemSO));
    }
}
