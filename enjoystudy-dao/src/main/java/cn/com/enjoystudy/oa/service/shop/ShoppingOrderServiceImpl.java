package cn.com.enjoystudy.oa.service.shop;

import cn.com.enjoystudy.oa.bean.shop.ShoppingOrder;
import cn.com.enjoystudy.oa.bean.shop.ShoppingOrderSO;
import cn.com.enjoystudy.oa.dao.shop.ShoppingOrderDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ShoppingOrderServiceImpl implements ShoppingOrderService {
    @Autowired
    private ShoppingOrderDao shoppingOrderDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(ShoppingOrder entity) {
        entity.preInsert();
        return shoppingOrderDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(ShoppingOrder entity) {
        entity.preUpdate();
        return shoppingOrderDao.update(entity);
    }

    @Override
    public ShoppingOrder getById(String id) {
        return shoppingOrderDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return shoppingOrderDao.deleteById(id);
    }

    @Override
    public List<ShoppingOrder> list(ShoppingOrderSO so) {
        return shoppingOrderDao.list(so);
    }

    @Override
    public PageInfo<ShoppingOrder> findPage(ShoppingOrderSO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo pageInfo = new PageInfo(shoppingOrderDao.list(so));
        return pageInfo;
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int updatePayState(String orderId, Integer payState, Date payTime, Integer payType, Integer orderState) {
        if (StringUtils.isBlank(orderId)) {
            throw new NullPointerException("orderId is null");
        }
        if (null == payState) {
            throw new NullPointerException("payState is null");
        }
        if (null == payTime) {
            throw new NullPointerException("payTime is null");
        }
        if (null == payType) {
            throw new NullPointerException("payType is null");
        }
        if (null == orderState) {
            throw new NullPointerException("orderState is null");
        }
        return shoppingOrderDao.updatePayState(orderId, payState, payTime, payType, orderState);
    }

    @Override
    public int updateOrderState(String orderId, Integer orderState) {
        if (StringUtils.isBlank(orderId)) {
            throw new NullPointerException("orderId is null");
        }
        if (null == orderState) {
            throw new NullPointerException("orderState is null");
        }
        return shoppingOrderDao.updateOrderState(orderId, orderState);
    }
}
