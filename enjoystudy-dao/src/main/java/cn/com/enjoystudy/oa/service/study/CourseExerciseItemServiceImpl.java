package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.CourseExerciseItem;
import cn.com.enjoystudy.oa.bean.study.CourseExerciseItemSO;
import cn.com.enjoystudy.oa.dao.study.CourseExerciseItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CourseExerciseItemServiceImpl implements CourseExerciseItemService {
    @Autowired
    private CourseExerciseItemDao courseExerciseItemDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(CourseExerciseItem entity) {
        entity.preInsert();
        return courseExerciseItemDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(CourseExerciseItem entity) {
        entity.preUpdate();
        return courseExerciseItemDao.update(entity);
    }

    @Override
    public CourseExerciseItem getById(String id) {
        return courseExerciseItemDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return courseExerciseItemDao.deleteById(id);
    }

    @Override
    public List<CourseExerciseItem> list(CourseExerciseItemSO so) {
        return courseExerciseItemDao.list(so);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteByExerciseId(String exerciseId) {
        return courseExerciseItemDao.deleteByExerciseId(exerciseId);
    }
}
