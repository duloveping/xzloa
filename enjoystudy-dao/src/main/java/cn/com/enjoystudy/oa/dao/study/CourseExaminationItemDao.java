package cn.com.enjoystudy.oa.dao.study;

import cn.com.enjoystudy.oa.bean.study.CourseExaminationItem;
import cn.com.enjoystudy.oa.bean.study.CourseExaminationItemSO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseExaminationItemDao {
    int insert(CourseExaminationItem entity);

    int update(CourseExaminationItem entity);

    CourseExaminationItem getById(String id);

    int deleteById(String id);

    List<CourseExaminationItem> list(CourseExaminationItemSO so);

    int deleteByExaminationId(String examinationId);
}
