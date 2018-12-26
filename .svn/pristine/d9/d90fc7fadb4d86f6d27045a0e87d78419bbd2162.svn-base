package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.StoreQuestionAnalysis;
import cn.com.enjoystudy.oa.dao.study.StoreQuestionAnalysisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class StoreQuestionAnalysisServiceImpl implements StoreQuestionAnalysisService {
    @Autowired
    private StoreQuestionAnalysisDao storeQuestionAnalysisDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(StoreQuestionAnalysis entity) {
        entity.preInsert();
        return storeQuestionAnalysisDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(StoreQuestionAnalysis entity) {
        entity.preUpdate();
        return storeQuestionAnalysisDao.update(entity);
    }

    @Override
    public StoreQuestionAnalysis getById(String id) {
        return storeQuestionAnalysisDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return storeQuestionAnalysisDao.deleteById(id);
    }

    @Override
    public StoreQuestionAnalysis getAnalysisQuestionId(String questionId) {
        return storeQuestionAnalysisDao.getAnalysisQuestionId(questionId);
    }
}
