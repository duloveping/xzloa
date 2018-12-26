package cn.com.enjoystudy.oa.dao.study;

import cn.com.enjoystudy.oa.bean.study.StoreQuestionItem;
import cn.com.enjoystudy.oa.bean.study.StoreQuestionItemSO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreQuestionItemDao {
    int insert(StoreQuestionItem entity);

    int update(StoreQuestionItem entity);

    StoreQuestionItem getById(String id);

    int deleteById(String id);

    List<StoreQuestionItem> list(StoreQuestionItemSO so);

    int deleteByQuestionId(String questionId);
}
