package cn.com.enjoystudy.oa.dao.study;

import cn.com.enjoystudy.oa.bean.study.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseExerciseDao {
    int insert(CourseExercise entity);

    int update(CourseExercise entity);

    CourseExercise getById(@Param("id") String id);

    int deleteById(@Param("id") String id);

    List<CourseExercise> list(CourseExerciseSO so);

    List<CourseExerciseItem> findItemsByExerciseId(String exerciseId);

    int deleteByExerciseId(String exerciseId);

    List<Course> findAllCourse();

    String getAnalysis(String exerciseId);

    List<Question> findQuestionByCourseId(String courseId);
}
