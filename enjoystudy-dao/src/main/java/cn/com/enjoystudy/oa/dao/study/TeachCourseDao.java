package cn.com.enjoystudy.oa.dao.study;

import cn.com.enjoystudy.oa.bean.study.TeachCourse;
import cn.com.enjoystudy.oa.bean.study.TeachCourseSO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeachCourseDao {
    List<TeachCourse> teachCourseList(TeachCourseSO so);

    List<TeachCourse> learnCourseList(TeachCourseSO so);
}
