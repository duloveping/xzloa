package cn.com.enjoystudy.oa.dao.study;

import cn.com.enjoystudy.oa.bean.study.CourseCertificateTemplet;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseCertificateTempletDao {
    int insert(CourseCertificateTemplet entity);

    int update(CourseCertificateTemplet entity);

    CourseCertificateTemplet getById(@Param("id") String id);

    CourseCertificateTemplet getByCourseId(@Param("courseId") String courseId);

    int deleteById(@Param("id") String id);

    int deleteByCourseId(@Param("courseId") String courseId);



}
