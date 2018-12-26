package cn.com.enjoystudy.oa.dao.study;

import cn.com.enjoystudy.oa.bean.study.EmployeeCourseStudy;
import cn.com.enjoystudy.oa.bean.study.EmployeeCourseStudySO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeCourseStudyDao {
    int insert(EmployeeCourseStudy entity);

    int update(EmployeeCourseStudy entity);

    EmployeeCourseStudy getById(String id);

    int deleteById(String id);

    List<EmployeeCourseStudy> list(EmployeeCourseStudySO so);

    List<EmployeeCourseStudy> getCourseStudyReportList(EmployeeCourseStudySO so);

    long getStudyAmount(@Param("employeeId") String employeeId, @Param("courseId") String courseId);
}
