package cn.com.enjoystudy.oa.dao.study;

import cn.com.enjoystudy.oa.bean.study.ExaminationQuestionItem;
import cn.com.enjoystudy.oa.bean.study.ExaminationQuestionItemSO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExaminationQuestionItemDao {
    int insert(ExaminationQuestionItem entity);

    int update(ExaminationQuestionItem entity);

    ExaminationQuestionItem getById(String id);

    int deleteById(String id);

    List<ExaminationQuestionItem> list(ExaminationQuestionItemSO so);

    int deleteByQuestionId(String questionId);
}
