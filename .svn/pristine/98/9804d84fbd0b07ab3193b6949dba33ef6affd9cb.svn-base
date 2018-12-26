package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.*;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CourseExerciseService {
    int insert(CourseExercise entity);

    int update(CourseExercise entity);

    CourseExercise getById(String id);

    int deleteById(String id);

    List<CourseExercise> list(CourseExerciseSO so);

    PageInfo<CourseExercise> findPag(CourseExerciseSO so);

    List<CourseExerciseItem> findItemsByExerciseId(String exerciseId);

    int deleteByExerciseId(String exerciseId);

    List<Course> findAllCourse();

    List<Question> findQuestionByCourseId(String courseId);
}
