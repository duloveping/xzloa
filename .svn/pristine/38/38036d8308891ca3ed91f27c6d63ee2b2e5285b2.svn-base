package cn.com.enjoystudy.oa.service.base;

import cn.com.enjoystudy.oa.bean.base.BasePosition;
import cn.com.enjoystudy.oa.bean.base.BasePositionSO;
import cn.com.enjoystudy.oa.dao.base.BasePositionDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 职务Service实现
 * @author 广州新咨力科技有限公司-杜永生
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class BasePositionServiceImpl implements BasePositionService {
    @Autowired
    private BasePositionDao basePositionDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(BasePosition entity) {
        entity.preInsert();
        return basePositionDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(BasePosition entity) {
        entity.preUpdate();
        return basePositionDao.update(entity);
    }

    @Override
    public BasePosition getById(String id) {
        return basePositionDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return basePositionDao.deleteById(id);
    }

    @Override
    public List<BasePosition> list(BasePositionSO so) {
        return basePositionDao.list(so);
    }

    @Override
    public PageInfo<BasePosition> findPag(BasePositionSO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo pageInfo = new PageInfo(basePositionDao.list(so));
        return pageInfo;
    }

    @Override
    public long count(BasePositionSO so) {
        return basePositionDao.count(so);
    }
}
