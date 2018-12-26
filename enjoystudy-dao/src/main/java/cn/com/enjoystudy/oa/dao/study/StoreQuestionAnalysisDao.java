package cn.com.enjoystudy.oa.dao.study;

import cn.com.enjoystudy.oa.bean.study.StoreQuestionAnalysis;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreQuestionAnalysisDao {
    int insert(StoreQuestionAnalysis entity);

    int update(StoreQuestionAnalysis entity);

    StoreQuestionAnalysis getById(String id);

    int deleteById(String id);

    StoreQuestionAnalysis getAnalysisQuestionId(String questionId);
}
