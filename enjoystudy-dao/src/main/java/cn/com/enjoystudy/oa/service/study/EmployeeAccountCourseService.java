package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.base.EmployeeAccount;
import cn.com.enjoystudy.oa.bean.study.Course;
import cn.com.enjoystudy.oa.bean.study.EmployeeAccountCourse;
import cn.com.enjoystudy.oa.bean.study.EmployeeAccountCourseSO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface EmployeeAccountCourseService {
    int insert(EmployeeAccountCourse entity);

    int update(EmployeeAccountCourse entity);

    EmployeeAccountCourse getById(String id);

    int deleteById(String id);

    List<EmployeeAccountCourse> list(EmployeeAccountCourseSO so);

    long count(EmployeeAccountCourseSO so);

    int delete(EmployeeAccountCourseSO so);

    List<Course> findCourseByEmployeeId(String employeeId);

    PageInfo<Course> findCoursePageByEmployeeId(EmployeeAccountCourseSO so);
}
