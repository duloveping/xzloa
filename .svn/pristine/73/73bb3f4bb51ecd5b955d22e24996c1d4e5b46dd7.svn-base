package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.EmployeeCourseStudy;
import cn.com.enjoystudy.oa.bean.study.EmployeeCourseStudySO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface EmployeeCourseStudyService {
    int insert(EmployeeCourseStudy entity);

    int update(EmployeeCourseStudy entity);

    EmployeeCourseStudy getById(String id);

    int deleteById(String id);

    List<EmployeeCourseStudy> list(EmployeeCourseStudySO so);

    PageInfo<EmployeeCourseStudy> findPag(EmployeeCourseStudySO so);

    List<EmployeeCourseStudy> getCourseStudyReportList(EmployeeCourseStudySO so);

    PageInfo<EmployeeCourseStudy> getCourseStudyReportPage(EmployeeCourseStudySO so);

    long getStudyAmount(String employeeId, String courseId);
}
