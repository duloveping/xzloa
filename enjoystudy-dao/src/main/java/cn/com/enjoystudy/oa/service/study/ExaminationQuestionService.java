package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.ExaminationQuestion;
import cn.com.enjoystudy.oa.bean.study.ExaminationQuestionItem;
import cn.com.enjoystudy.oa.bean.study.ExaminationQuestionSO;

import java.util.List;

public interface ExaminationQuestionService {
    int insert(ExaminationQuestion entity);

    int update(ExaminationQuestion entity);

    ExaminationQuestion getById(String id);

    int deleteById(String id);

    List<ExaminationQuestion> list(ExaminationQuestionSO so);

    List<ExaminationQuestionItem> findItemsByQuestionId(String questionId);

    int deleteByQuestionId(String questionId);

    String getAnalysis(String questionId);
}
