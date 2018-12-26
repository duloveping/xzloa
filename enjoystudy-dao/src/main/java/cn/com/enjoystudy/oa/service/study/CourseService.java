package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.Course;
import cn.com.enjoystudy.oa.bean.study.CourseSO;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseService {
    int insert(Course entity);

    int update(Course entity);

    Course getById(String id);

    int deleteById(String id);

    List<Course> list(CourseSO so);

    long count(CourseSO so);

    PageInfo<Course> findPag(CourseSO so);

    int updateTestState(String id, Integer testState);
}
