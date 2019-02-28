package cn.com.enjoystudy.oa.service.shop;

import cn.com.enjoystudy.oa.bean.shop.ShoppingOrderItem;
import cn.com.enjoystudy.oa.bean.shop.ShoppingOrderItemSO;
import cn.com.enjoystudy.oa.dao.shop.ShoppingOrderItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 购物订单明细Service实现类
 * @author 广州新咨力科技有限公司-杜永生
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ShoppingOrderItemServiceImpl implements ShoppingOrderItemService {
    @Autowired
    private ShoppingOrderItemDao shoppingOrderItemDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(ShoppingOrderItem entity) {
        entity.preInsert();
        return shoppingOrderItemDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(ShoppingOrderItem entity) {
        entity.preUpdate();
        return shoppingOrderItemDao.update(entity);
    }

    @Override
    public ShoppingOrderItem getById(String id) {
        return shoppingOrderItemDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return shoppingOrderItemDao.deleteById(id);
    }

    @Override
    public List<ShoppingOrderItem> list(ShoppingOrderItemSO so) {
        return shoppingOrderItemDao.list(so);
    }
}
