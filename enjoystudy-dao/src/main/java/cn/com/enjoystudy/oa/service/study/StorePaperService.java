package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.Course;
import cn.com.enjoystudy.oa.bean.study.CourseSO;
import cn.com.enjoystudy.oa.bean.study.StorePaper;
import cn.com.enjoystudy.oa.bean.study.StorePaperSO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface StorePaperService {
    int insert(StorePaper entity);

    int update(StorePaper entity);

    StorePaper getById(String id);

    int deleteById(String id);

    List<StorePaper> list(StorePaperSO so);

    long count(StorePaperSO so);

    PageInfo<StorePaper> findPag(StorePaperSO so);
}
