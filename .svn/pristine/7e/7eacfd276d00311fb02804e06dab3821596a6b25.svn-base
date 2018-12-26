package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.Course;
import cn.com.enjoystudy.oa.bean.study.CourseExamination;
import cn.com.enjoystudy.oa.bean.study.CourseExaminationItem;
import cn.com.enjoystudy.oa.bean.study.CourseExaminationSO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CourseExaminationService {
    int insert(CourseExamination entity);

    int update(CourseExamination entity);

    CourseExamination getById(String id);

    int deleteById(String id);

    List<CourseExamination> list(CourseExaminationSO so);

    PageInfo<CourseExamination> findPag(CourseExaminationSO so);

    List<CourseExaminationItem> findItemsByExaminationId(String examinationId);

    int deleteByExaminationId(String examinationId);

    List<Course> findAllCourse();

    String getAnalysis(String examinationId);
}
