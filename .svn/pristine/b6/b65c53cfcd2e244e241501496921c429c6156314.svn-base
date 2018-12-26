package cn.com.enjoystudy.oa.dao.study;

import cn.com.enjoystudy.oa.bean.study.CourseExerciseItem;
import cn.com.enjoystudy.oa.bean.study.CourseExerciseItemSO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseExerciseItemDao {
    int insert(CourseExerciseItem entity);

    int update(CourseExerciseItem entity);

    CourseExerciseItem getById(String id);

    int deleteById(String id);

    List<CourseExerciseItem> list(CourseExerciseItemSO so);

    int deleteByExerciseId(String exerciseId);
}
