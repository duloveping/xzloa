package cn.com.enjoystudy.oa.service.shop;

import cn.com.enjoystudy.oa.bean.shop.ShoppingOrder;
import cn.com.enjoystudy.oa.bean.shop.ShoppingOrderSO;
import com.github.pagehelper.PageInfo;

import java.util.Date;
import java.util.List;

/**
 * 购物订单DAO
 * @author 广州新咨力科技有限公司-杜永生
 */
public interface ShoppingOrderService {
    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(ShoppingOrder entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(ShoppingOrder entity);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    ShoppingOrder getById(String id);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    int deleteById(String id);

    /**
     * 列表查询
     * @param so
     * @return
     */
    List<ShoppingOrder> list(ShoppingOrderSO so);

    /**
     * 分页查询
     * @param so
     * @return
     */
    PageInfo<ShoppingOrder> findPage(ShoppingOrderSO so);

    /**
     * 更新订单状态
     * @param orderId
     * @param payState
     * @param payTime
     * @param payType
     * @param orderState
     * @return
     */
    int updatePayState(String orderId, Integer payState, Date payTime, Integer payType,Integer orderState);

    /**
     * 更新订单状态
     * @param orderId
     * @param orderState
     * @return
     */
    int updateOrderState(String orderId, Integer orderState);
}
