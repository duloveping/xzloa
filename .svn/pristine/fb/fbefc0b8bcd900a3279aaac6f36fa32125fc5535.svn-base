package cn.com.enjoystudy.oa.dao.study;

import cn.com.enjoystudy.oa.bean.study.Course;
import cn.com.enjoystudy.oa.bean.study.CourseSO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDao {
    int insert(Course entity);

    int update(Course entity);

    Course getById(@Param("id") String id);

    int deleteById(@Param("id") String id);

    List<Course> list(CourseSO so);

    long count(CourseSO so);

    int updateTestState(@Param("id") String id, @Param("testState") Integer testState);
}
