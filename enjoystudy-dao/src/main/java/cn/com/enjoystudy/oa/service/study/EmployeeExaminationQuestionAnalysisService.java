package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.EmployeeExaminationQuestionAnalysis;

public interface EmployeeExaminationQuestionAnalysisService {
    int insert(EmployeeExaminationQuestionAnalysis entity);

    int update(EmployeeExaminationQuestionAnalysis entity);

    EmployeeExaminationQuestionAnalysis getById(String id);

    int deleteById(String id);

    EmployeeExaminationQuestionAnalysis getAnalysisQuestionId(String questionId);
}
