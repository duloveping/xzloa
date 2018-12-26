package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.StorePaper;
import cn.com.enjoystudy.oa.bean.study.StoreQuestion;
import cn.com.enjoystudy.oa.bean.study.StoreQuestionItem;
import cn.com.enjoystudy.oa.bean.study.StoreQuestionSO;
import cn.com.enjoystudy.oa.dao.study.StoreQuestionDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class StoreQuestionServiceImpl implements StoreQuestionService {
    @Autowired
    private StoreQuestionDao storeQuestionDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(StoreQuestion entity) {
        entity.preInsert();
        return storeQuestionDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(StoreQuestion entity) {
        entity.preUpdate();
        return storeQuestionDao.update(entity);
    }

    @Override
    public StoreQuestion getById(String id) {
        return storeQuestionDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return storeQuestionDao.deleteById(id);
    }

    @Override
    public List<StoreQuestion> list(StoreQuestionSO so) {
        return storeQuestionDao.list(so);
    }

    @Override
    public List<StoreQuestionItem> findItemsByQuestionId(String questionId) {
        return storeQuestionDao.findItemsByQuestionId(questionId);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteByQuestionId(String questionId) {
        return storeQuestionDao.deleteByQuestionId(questionId);
    }

    @Override
    public String getAnalysis(String questionId) {
        return storeQuestionDao.getAnalysis(questionId);
    }

    @Override
    public PageInfo<StoreQuestion> findPag(StoreQuestionSO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo<StoreQuestion> pageInfo = new PageInfo(storeQuestionDao.list(so));
        return pageInfo;
    }
}
