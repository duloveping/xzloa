package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.CourseCertificateTemplet;

public interface CourseCertificateTempletService {
    int insert(CourseCertificateTemplet entity);

    int update(CourseCertificateTemplet entity);

    CourseCertificateTemplet getById(String id);

    CourseCertificateTemplet getByCourseId(String courseId);

    int deleteById(String id);

    int deleteByCourseId(String courseId);
}
