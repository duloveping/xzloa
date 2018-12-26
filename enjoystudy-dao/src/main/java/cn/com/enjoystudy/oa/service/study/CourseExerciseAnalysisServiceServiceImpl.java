package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.CourseExerciseAnalysis;
import cn.com.enjoystudy.oa.dao.study.CourseExerciseAnalysisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CourseExerciseAnalysisServiceServiceImpl implements CourseExerciseAnalysisService {
    @Autowired
    private CourseExerciseAnalysisDao courseExerciseAnalysisDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(CourseExerciseAnalysis entity) {
        entity.preInsert();
        return courseExerciseAnalysisDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(CourseExerciseAnalysis entity) {
        entity.preUpdate();
        return courseExerciseAnalysisDao.update(entity);
    }

    @Override
    public CourseExerciseAnalysis getById(String id) {
        return courseExerciseAnalysisDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return courseExerciseAnalysisDao.deleteById(id);
    }

    @Override
    public CourseExerciseAnalysis getAnalysisExerciseId(String exerciseId) {
        return courseExerciseAnalysisDao.getAnalysisExerciseId(exerciseId);
    }
}
