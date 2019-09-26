package cn.com.enjoystudy.oa.dao.study;

import cn.com.enjoystudy.oa.bean.study.EmployeeExaminationQuestion;
import cn.com.enjoystudy.oa.bean.study.EmployeeExaminationQuestionItem;
import cn.com.enjoystudy.oa.bean.study.EmployeeExaminationQuestionSO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeExaminationQuestionDao {
    int insert(EmployeeExaminationQuestion entity);

    int update(EmployeeExaminationQuestion entity);

    EmployeeExaminationQuestion getById(String id);

    int deleteById(String id);

    List<EmployeeExaminationQuestion> list(EmployeeExaminationQuestionSO so);

    List<EmployeeExaminationQuestionItem> findItemByQuestionId(String questionId);

    void deleteByPaperId(String paperId);
}
