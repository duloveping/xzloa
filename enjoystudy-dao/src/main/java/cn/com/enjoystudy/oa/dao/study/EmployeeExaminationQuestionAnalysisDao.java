package cn.com.enjoystudy.oa.dao.study;

import cn.com.enjoystudy.oa.bean.study.EmployeeExaminationQuestionAnalysis;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeExaminationQuestionAnalysisDao {
    int insert(EmployeeExaminationQuestionAnalysis entity);

    int update(EmployeeExaminationQuestionAnalysis entity);

    EmployeeExaminationQuestionAnalysis getById(String id);

    int deleteById(String id);

    EmployeeExaminationQuestionAnalysis getAnalysisQuestionId(String questionId);
}
