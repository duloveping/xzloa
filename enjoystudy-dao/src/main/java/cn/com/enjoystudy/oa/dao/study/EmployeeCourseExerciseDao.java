package cn.com.enjoystudy.oa.dao.study;

import cn.com.enjoystudy.oa.bean.study.EmployeeCourseExercise;
import cn.com.enjoystudy.oa.bean.study.EmployeeCourseExerciseItem;
import cn.com.enjoystudy.oa.bean.study.EmployeeCourseExerciseSO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeCourseExerciseDao {
    int insert(EmployeeCourseExercise entity);

    int update(EmployeeCourseExercise entity);

    EmployeeCourseExercise getById(String id);

    int deleteById(String id);

    List<EmployeeCourseExercise> list(EmployeeCourseExerciseSO so);

    List<EmployeeCourseExerciseItem> findItemsByExerciseId(String exerciseId);

    int deleteByExerciseId(String exerciseId);

    String getAnalysis(String exerciseId);
}
