package cn.com.enjoystudy.oa.dao.shop;

import cn.com.enjoystudy.oa.bean.shop.ShoppingCart;
import cn.com.enjoystudy.oa.bean.shop.ShoppingCartSO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 购物车DAO
 * @author 广州新咨力科技有限公司-杜永生
 */
@Repository
public interface ShoppingCartDao {
    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(ShoppingCart entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(ShoppingCart entity);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    ShoppingCart getById(String id);

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
    List<ShoppingCart> list(ShoppingCartSO so);

    int remove(@Param("accountId") String accountId, @Param("courseId") String courseId);
}
