package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.CourseExerciseItem;
import cn.com.enjoystudy.oa.bean.study.CourseExerciseItemSO;

import java.util.List;

public interface CourseExerciseItemService {
    int insert(CourseExerciseItem entity);

    int update(CourseExerciseItem entity);

    CourseExerciseItem getById(String id);

    int deleteById(String id);

    List<CourseExerciseItem> list(CourseExerciseItemSO so);

    int deleteByExerciseId(String exerciseId);
}
