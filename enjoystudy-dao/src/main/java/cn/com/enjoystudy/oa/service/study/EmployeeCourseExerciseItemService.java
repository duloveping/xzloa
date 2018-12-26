package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.EmployeeCourseExerciseItem;
import cn.com.enjoystudy.oa.bean.study.EmployeeCourseExerciseItemSO;

import java.util.List;

public interface EmployeeCourseExerciseItemService {
    int insert(EmployeeCourseExerciseItem entity);

    int update(EmployeeCourseExerciseItem entity);

    EmployeeCourseExerciseItem getById(String id);

    int deleteById(String id);

    List<EmployeeCourseExerciseItem> list(EmployeeCourseExerciseItemSO so);

    int deleteByExerciseId(String exerciseId);
}
