package cn.com.enjoystudy.oa.dao.study;

import cn.com.enjoystudy.oa.bean.study.StoreQuestion;
import cn.com.enjoystudy.oa.bean.study.StoreQuestionItem;
import cn.com.enjoystudy.oa.bean.study.StoreQuestionSO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreQuestionDao {
    int insert(StoreQuestion entity);

    int update(StoreQuestion entity);

    StoreQuestion getById(String id);

    int deleteById(String id);

    List<StoreQuestion> list(StoreQuestionSO so);

    List<StoreQuestionItem> findItemsByQuestionId(String questionId);

    int deleteByQuestionId(String questionId);

    String getAnalysis(String questionId);
}
