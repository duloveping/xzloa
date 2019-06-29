package cn.com.enjoystudy.oa.dao.study;

import cn.com.enjoystudy.oa.bean.study.Course;
import cn.com.enjoystudy.oa.bean.study.EmployeeAccountCourse;
import cn.com.enjoystudy.oa.bean.study.EmployeeAccountCourseSO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 学员课程DAO
 * @author 广州新咨力科技有限公司-杜永生
 */
@Repository
public interface EmployeeAccountCourseDao {
    int insert(EmployeeAccountCourse entity);

    int update(EmployeeAccountCourse entity);

    EmployeeAccountCourse getById(String id);

    int deleteById(String id);

    List<EmployeeAccountCourse> list(EmployeeAccountCourseSO so);

    long count(EmployeeAccountCourseSO so);

    int delete(EmployeeAccountCourseSO so);

    List<Course> findCourseByEmployeeId(String employeeId);
}
