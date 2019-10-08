package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.EmployeeExaminationPaper;
import cn.com.enjoystudy.oa.bean.study.EmployeeExaminationPaperSO;
import cn.com.enjoystudy.oa.bean.study.EmployeeExaminationScore;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeExaminationPaperService {
    int insert(EmployeeExaminationPaper entity);

    int update(EmployeeExaminationPaper entity);

    EmployeeExaminationPaper getById(String id);

    int deleteById(String id);

    List<EmployeeExaminationPaper> list(EmployeeExaminationPaperSO so);

    PageInfo<EmployeeExaminationPaper> findPage(EmployeeExaminationPaperSO so);

    long count(EmployeeExaminationPaperSO so);

    long getTestAmount(String employeeId, String courseId);

    List<EmployeeExaminationScore> findScoreList(EmployeeExaminationPaperSO so);

    void deleteQuestionByPaperId(String paperId);

    void deleteQuestionItemByPaperId(String paperId);

    void deleteQuestionAnalysisByPaperId(String paperId);
}
