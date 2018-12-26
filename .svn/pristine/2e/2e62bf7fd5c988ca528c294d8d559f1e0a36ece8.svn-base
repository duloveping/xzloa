package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.ExaminationQuestionAnalysis;
import cn.com.enjoystudy.oa.dao.study.ExaminationQuestionAnalysisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ExaminationQuestionAnalysisServiceImpl implements ExaminationQuestionAnalysisService {
    @Autowired
    private ExaminationQuestionAnalysisDao examinationQuestionAnalysisDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(ExaminationQuestionAnalysis entity) {
        entity.preInsert();
        return examinationQuestionAnalysisDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(ExaminationQuestionAnalysis entity) {
        entity.preUpdate();
        return examinationQuestionAnalysisDao.update(entity);
    }

    @Override
    public ExaminationQuestionAnalysis getById(String id) {
        return examinationQuestionAnalysisDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return examinationQuestionAnalysisDao.deleteById(id);
    }

    @Override
    public ExaminationQuestionAnalysis getAnalysisQuestionId(String questionId) {
        return examinationQuestionAnalysisDao.getAnalysisQuestionId(questionId);
    }
}
