package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.*;
import cn.com.enjoystudy.oa.dao.study.CourseExerciseDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CourseExerciseServiceImpl implements CourseExerciseService {
    @Autowired
    private CourseExerciseDao courseExerciseDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(CourseExercise entity) {
        entity.preInsert();
        return courseExerciseDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(CourseExercise entity) {
        entity.preUpdate();
        return courseExerciseDao.update(entity);
    }

    @Override
    public CourseExercise getById(String id) {
        return courseExerciseDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return courseExerciseDao.deleteById(id);
    }

    @Override
    public List<CourseExercise> list(CourseExerciseSO so) {
        return courseExerciseDao.list(so);
    }

    @Override
    public PageInfo<CourseExercise> findPag(CourseExerciseSO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo<CourseExercise> pageInfo = new PageInfo(courseExerciseDao.list(so));
        return pageInfo;
    }

    @Override
    public List<CourseExerciseItem> findItemsByExerciseId(String exerciseId) {
        return courseExerciseDao.findItemsByExerciseId(exerciseId);
    }

    @Override
    public List<Course> findAllCourse() {
        return courseExerciseDao.findAllCourse();
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteByExerciseId(String exerciseId) {
        return courseExerciseDao.deleteById(exerciseId);
    }

    @Override
    public List<Question> findQuestionByCourseId(String courseId) {
        if (StringUtils.isBlank(courseId)) {
            throw new NullPointerException("courseId is null");
        }
        return courseExerciseDao.findQuestionByCourseId(courseId);
    }
}
