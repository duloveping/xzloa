package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.EmployeeExaminationQuestion;
import cn.com.enjoystudy.oa.bean.study.EmployeeExaminationQuestionItem;
import cn.com.enjoystudy.oa.bean.study.EmployeeExaminationQuestionSO;

import java.util.List;

public interface EmployeeExaminationQuestionService {
    int insert(EmployeeExaminationQuestion entity);

    int update(EmployeeExaminationQuestion entity);

    EmployeeExaminationQuestion getById(String id);

    int deleteById(String id);

    List<EmployeeExaminationQuestion> list(EmployeeExaminationQuestionSO so);

    List<EmployeeExaminationQuestionItem> findItemByQuestionId(String questionId);
}
