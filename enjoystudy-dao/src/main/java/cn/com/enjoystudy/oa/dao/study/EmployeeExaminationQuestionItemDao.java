package cn.com.enjoystudy.oa.dao.study;

import cn.com.enjoystudy.oa.bean.study.EmployeeExaminationQuestionItem;
import cn.com.enjoystudy.oa.bean.study.EmployeeExaminationQuestionItemSO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeExaminationQuestionItemDao {
    int insert(EmployeeExaminationQuestionItem entity);

    int update(EmployeeExaminationQuestionItem entity);

    EmployeeExaminationQuestionItem getById(String id);

    int deleteById(String id);

    List<EmployeeExaminationQuestionItem> list(EmployeeExaminationQuestionItemSO so);
}
