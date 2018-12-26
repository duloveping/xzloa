package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.StoreQuestionItem;
import cn.com.enjoystudy.oa.bean.study.StoreQuestionItemSO;
import cn.com.enjoystudy.oa.dao.study.StoreQuestionItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class StoreQuestionItemServiceImpl implements StoreQuestionItemService {
    @Autowired
    private StoreQuestionItemDao storeQuestionItemDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(StoreQuestionItem entity) {
        entity.preInsert();
        return storeQuestionItemDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(StoreQuestionItem entity) {
        entity.preUpdate();
        return storeQuestionItemDao.update(entity);
    }

    @Override
    public StoreQuestionItem getById(String id) {
        return storeQuestionItemDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return storeQuestionItemDao.deleteById(id);
    }

    @Override
    public List<StoreQuestionItem> list(StoreQuestionItemSO so) {
        return storeQuestionItemDao.list(so);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteByQuestionId(String questionId) {
        return storeQuestionItemDao.deleteByQuestionId(questionId);
    }
}
