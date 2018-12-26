package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.EmployeeExaminationQuestionAnalysis;
import cn.com.enjoystudy.oa.dao.study.EmployeeExaminationQuestionAnalysisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class EmployeeExaminationQuestionAnalysisServiceImpl implements EmployeeExaminationQuestionAnalysisService {
    @Autowired
    private EmployeeExaminationQuestionAnalysisDao employeeExaminationQuestionAnalysisDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(EmployeeExaminationQuestionAnalysis entity) {
        entity.preUpdate();
        return employeeExaminationQuestionAnalysisDao.update(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(EmployeeExaminationQuestionAnalysis entity) {
        entity.preInsert();
        return employeeExaminationQuestionAnalysisDao.insert(entity);
    }

    @Override
    public EmployeeExaminationQuestionAnalysis getById(String id) {
        return employeeExaminationQuestionAnalysisDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return employeeExaminationQuestionAnalysisDao.deleteById(id);
    }

    @Override
    public EmployeeExaminationQuestionAnalysis getAnalysisQuestionId(String questionId) {
        return employeeExaminationQuestionAnalysisDao.getAnalysisQuestionId(questionId);
    }
}
