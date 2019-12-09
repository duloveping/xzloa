package cn.com.enjoystudy.oa.dao.shop;

import cn.com.enjoystudy.oa.bean.shop.ShoppingOrder;
import cn.com.enjoystudy.oa.bean.shop.ShoppingOrderSO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 购物订单DAO
 * @author 广州新咨力科技有限公司-杜永生
 */
@Repository
public interface ShoppingOrderDao {
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

    ShoppingOrder getByOrderCode(@Param("orderCode") String orderCode);


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
     * 更新支付状态
     * @param orderId
     * @param payState
     * @param payTime
     * @param payType
     * @param orderState
     * @return
     */
    int updatePayState(@Param("orderId") String orderId, @Param("payState") Integer payState, @Param("payTime")Date payTime,
             @Param("payType") Integer payType, @Param("orderState") Integer orderState);

    /**
     * 更新订单状态
     * @param orderId
     * @param orderState
     * @return
     */
    int updateOrderState(@Param("orderId") String orderId, @Param("orderState") Integer orderState);
}
