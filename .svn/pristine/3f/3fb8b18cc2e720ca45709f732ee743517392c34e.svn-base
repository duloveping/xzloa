package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.EmployeeCourseExerciseAnalysis;
import cn.com.enjoystudy.oa.dao.study.EmployeeCourseExerciseAnalysisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class EmployeeCourseExerciseAnalysisServiceImpl implements EmployeeCourseExerciseAnalysisService {
    @Autowired
    private EmployeeCourseExerciseAnalysisDao employeeCourseExerciseAnalysisDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(EmployeeCourseExerciseAnalysis entity) {
        entity.preInsert();
        return employeeCourseExerciseAnalysisDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(EmployeeCourseExerciseAnalysis entity) {
        entity.preUpdate();
        return employeeCourseExerciseAnalysisDao.update(entity);
    }

    @Override
    public EmployeeCourseExerciseAnalysis getById(String id) {
        return employeeCourseExerciseAnalysisDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return employeeCourseExerciseAnalysisDao.deleteById(id);
    }

    @Override
    public EmployeeCourseExerciseAnalysis getAnalysisExerciseId(String exerciseId) {
        return employeeCourseExerciseAnalysisDao.getAnalysisExerciseId(exerciseId);
    }
}
