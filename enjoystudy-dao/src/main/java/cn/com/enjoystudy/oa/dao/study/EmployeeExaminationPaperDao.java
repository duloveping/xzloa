package cn.com.enjoystudy.oa.dao.study;

import cn.com.enjoystudy.oa.bean.study.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeExaminationPaperDao {
    int insert(EmployeeExaminationPaper entity);

    int update(EmployeeExaminationPaper entity);

    EmployeeExaminationPaper getById(String id);

    int deleteById(String id);

    List<EmployeeExaminationPaper> list(EmployeeExaminationPaperSO so);

    long count(EmployeeExaminationPaperSO so);

    long getTestAmount(@Param("employeeId") String employeeId, @Param("courseId") String courseId);

    List<EmployeeExaminationQuestion> findQuestionByPaperId(@Param("paperId") String paperId);

    List<EmployeeExaminationQuestionItem> findQuestionItemByQuestionId(@Param("questionId") String questionId);

    EmployeeExaminationQuestionAnalysis findQuestionAnalysisByQuestionId(@Param("questionId") String questionId);

    List<EmployeeExaminationScore> findScoreList(EmployeeExaminationPaperSO so);
}
