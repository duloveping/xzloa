package cn.com.enjoystudy.oa.dao.study;

import cn.com.enjoystudy.oa.bean.study.CourseAttachment;
import cn.com.enjoystudy.oa.bean.study.CourseAttachmentSO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseAttachmentDao {
    int insert(CourseAttachment entity);

    int update(CourseAttachment entity);

    CourseAttachment getById(@Param("id") String id);

    int deleteById(@Param("id") String id);

    List<CourseAttachment> list(CourseAttachmentSO so);

    int delete(CourseAttachmentSO so);

    int deleteByVideoId(String videoId);

    int deleteByCourseId(String courseId);
}
