package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.EmployeeCourseExerciseAnalysis;

public interface EmployeeCourseExerciseAnalysisService {
    int insert(EmployeeCourseExerciseAnalysis entity);

    int update(EmployeeCourseExerciseAnalysis entity);

    EmployeeCourseExerciseAnalysis getById(String id);

    int deleteById(String id);

    EmployeeCourseExerciseAnalysis getAnalysisExerciseId(String exerciseId);
}
