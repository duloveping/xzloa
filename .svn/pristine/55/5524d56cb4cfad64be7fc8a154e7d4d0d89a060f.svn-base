package cn.com.enjoystudy.oa.dao.study;

import cn.com.enjoystudy.oa.bean.study.ExaminationQuestion;
import cn.com.enjoystudy.oa.bean.study.ExaminationQuestionItem;
import cn.com.enjoystudy.oa.bean.study.ExaminationQuestionSO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExaminationQuestionDao {
    int insert(ExaminationQuestion entity);

    int update(ExaminationQuestion entity);

    ExaminationQuestion getById(String id);

    int deleteById(String id);

    List<ExaminationQuestion> list(ExaminationQuestionSO so);

    List<ExaminationQuestionItem> findItemsByQuestionId(String questionId);

    int deleteByQuestionId(String questionId);

    String getAnalysis(String questionId);
}
