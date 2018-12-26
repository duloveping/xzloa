package cn.com.enjoystudy.oa.service.sys;

import cn.com.enjoystudy.oa.bean.sys.BaseDictionaryItem;
import cn.com.enjoystudy.oa.bean.sys.BaseDictionaryItemSO;
import cn.com.enjoystudy.oa.dao.sys.BaseDictionaryItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 数字字典Service实现
 * @author 广州新咨力科技有限公司-杜永生
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class BaseDictionaryItemServiceImpl implements BaseDictionaryItemService {
    @Autowired
    private BaseDictionaryItemDao baseDictionaryItemDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(BaseDictionaryItem entity) {
        entity.preInsert();
        return baseDictionaryItemDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(BaseDictionaryItem entity) {
        entity.preUpdate();
        return baseDictionaryItemDao.update(entity);
    }

    @Override
    public BaseDictionaryItem getById(String id) {
        return baseDictionaryItemDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void deleteById(String id) {
        baseDictionaryItemDao.deleteById(id);
    }

    @Override
    public List<BaseDictionaryItem> list(BaseDictionaryItemSO so) {
        return baseDictionaryItemDao.list(so);
    }

    @Override
    public int deleteByDictionaryId(String dictionaryId) {
        return baseDictionaryItemDao.deleteByDictionaryId(dictionaryId);
    }
}
