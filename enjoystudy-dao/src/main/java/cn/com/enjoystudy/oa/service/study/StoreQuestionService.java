package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.*;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface StoreQuestionService {
    int insert(StoreQuestion entity);

    int update(StoreQuestion entity);

    StoreQuestion getById(String id);

    int deleteById(String id);

    List<StoreQuestion> list(StoreQuestionSO so);

    List<StoreQuestionItem> findItemsByQuestionId(String questionId);

    int deleteByQuestionId(String questionId);

    String getAnalysis(String questionId);

    PageInfo<StoreQuestion> findPag(StoreQuestionSO so);;
}
