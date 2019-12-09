package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.TeachCourse;
import cn.com.enjoystudy.oa.bean.study.TeachCourseSO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TeachCourseService {
    List<TeachCourse> teachCourseList(TeachCourseSO so);

    PageInfo<TeachCourse> teachCoursePage(TeachCourseSO so);

    List<TeachCourse> learnCourseList(TeachCourseSO so);

    PageInfo<TeachCourse> learnCoursePage(TeachCourseSO so);
}
