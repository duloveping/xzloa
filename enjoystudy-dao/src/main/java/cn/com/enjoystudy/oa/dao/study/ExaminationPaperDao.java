package cn.com.enjoystudy.oa.dao.study;

import cn.com.enjoystudy.oa.bean.study.ExaminationPaper;
import cn.com.enjoystudy.oa.bean.study.ExaminationPaperSO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExaminationPaperDao {
    int insert(ExaminationPaper entity);

    int update(ExaminationPaper entity);

    ExaminationPaper getById(String id);

    int deleteById(String id);

    List<ExaminationPaper> list(ExaminationPaperSO so);

    long count(ExaminationPaperSO so);
}
