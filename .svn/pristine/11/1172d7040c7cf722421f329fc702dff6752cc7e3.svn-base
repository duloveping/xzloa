package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.EmployeeCourseExercise;
import cn.com.enjoystudy.oa.bean.study.EmployeeCourseExerciseItem;
import cn.com.enjoystudy.oa.bean.study.EmployeeCourseExerciseSO;
import cn.com.enjoystudy.oa.dao.study.EmployeeCourseExerciseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class EmployeeCourseExerciseServiceImpl implements EmployeeCourseExerciseService {
    @Autowired
    private EmployeeCourseExerciseDao employeeCourseExerciseDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(EmployeeCourseExercise entity) {
        entity.preInsert();
        return employeeCourseExerciseDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(EmployeeCourseExercise entity) {
        entity.preUpdate();
        return employeeCourseExerciseDao.update(entity);
    }

    @Override
    public EmployeeCourseExercise getById(String id) {
        return employeeCourseExerciseDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return employeeCourseExerciseDao.deleteById(id);
    }

    @Override
    public List<EmployeeCourseExercise> list(EmployeeCourseExerciseSO so) {
        return employeeCourseExerciseDao.list(so);
    }

    @Override
    public List<EmployeeCourseExerciseItem> findItemsByExerciseId(String exerciseId) {
        return employeeCourseExerciseDao.findItemsByExerciseId(exerciseId);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteByExerciseId(String exerciseId) {
        return employeeCourseExerciseDao.deleteByExerciseId(exerciseId);
    }

    @Override
    public String getAnalysis(String exerciseId) {
        return employeeCourseExerciseDao.getAnalysis(exerciseId);
    }
}
