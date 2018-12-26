package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.ExaminationPaper;
import cn.com.enjoystudy.oa.bean.study.ExaminationPaperSO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ExaminationPaperService {
    int insert(ExaminationPaper entity);

    int update(ExaminationPaper entity);

    ExaminationPaper getById(String id);

    int deleteById(String id);

    List<ExaminationPaper> list(ExaminationPaperSO so);

    PageInfo<ExaminationPaper> findPag(ExaminationPaperSO so);
}
