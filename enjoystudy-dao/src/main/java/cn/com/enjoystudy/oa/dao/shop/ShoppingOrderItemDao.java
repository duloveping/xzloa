package cn.com.enjoystudy.oa.dao.shop;

import cn.com.enjoystudy.oa.bean.shop.ShoppingOrderItem;
import cn.com.enjoystudy.oa.bean.shop.ShoppingOrderItemSO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 购物订单明细DAO
 * @author 广州新咨力科技有限公司-杜永生
 */
@Repository
public interface ShoppingOrderItemDao {
    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(ShoppingOrderItem entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(ShoppingOrderItem entity);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    ShoppingOrderItem getById(String id);

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
    List<ShoppingOrderItem> list(ShoppingOrderItemSO so);
}
