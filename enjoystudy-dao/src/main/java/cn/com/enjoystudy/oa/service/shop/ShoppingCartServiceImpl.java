package cn.com.enjoystudy.oa.service.shop;

import cn.com.enjoystudy.oa.bean.shop.ShoppingCart;
import cn.com.enjoystudy.oa.bean.shop.ShoppingCartSO;
import cn.com.enjoystudy.oa.dao.shop.ShoppingCartDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 购物车Service实现类
 * @author 广州新咨力科技有限公司-杜永生
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartDao shoppingCartDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(ShoppingCart entity) {
        entity.preInsert();
        return shoppingCartDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(ShoppingCart entity) {
        entity.preUpdate();
        return shoppingCartDao.update(entity);
    }

    @Override
    public ShoppingCart getById(String id) {
        return shoppingCartDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return shoppingCartDao.deleteById(id);
    }

    @Override
    public List<ShoppingCart> list(ShoppingCartSO so) {
        return shoppingCartDao.list(so);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int remove(String accountId, String courseId) {
        if (StringUtils.isBlank(accountId)) {
            throw new NullPointerException("accountId is null");
        }

        if (StringUtils.isBlank(courseId)) {
            throw new NullPointerException("courseId is null");
        }
        return shoppingCartDao.remove(accountId, courseId);
    }
}
