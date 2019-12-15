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
import java.util.List;

@Controller
@RequestMapping("/manage/order/shopping-order")
public class ShoppingOrderAdminController extends BaseController {
    @Autowired
    private ShoppingOrderService shoppingOrderService;
    @Autowired
    private ShoppingOrderItemService shoppingOrderItemService;

    @RequestMapping("index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("manage/order/shopping-order/index");
        return mv;
    }

    @RequestMapping("list")
    @ResponseBody
    public JSONObject list(ShoppingOrderSO so) {
        so.setAccountId(getCurrentUser().getId());
        PageInfo<ShoppingOrder> pageInfo = shoppingOrderService.findPage(so);
        List<ShoppingOrder> orderList = pageInfo.getList();
        if (CollectionUtils.isNotEmpty(orderList)) {
            for (ShoppingOrder order : orderList) {
                ShoppingOrderItemSO itemSO = new ShoppingOrderItemSO();
                itemSO.setOrderId(order.getId());
                order.setOrderItemList(shoppingOrderItemService.list(itemSO));
            }
            pageInfo.setList(orderList);
        }
        return resultSuccess(pageInfo);
    }

    @RequestMapping("delete")
    @ResponseBody
    public JSONObject delete(@RequestParam String id) {
        shoppingOrderService.deleteById(id);
        return resultSuccess();
    }
}
