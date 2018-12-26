package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.CourseCertificate;
import cn.com.enjoystudy.oa.bean.study.CourseCertificateSO;

import java.util.List;

public interface CourseCertificateService {
    int insert(CourseCertificate entity);

    int update(CourseCertificate entity);

    CourseCertificate getById(String id);

    int deleteById(String id);

    List<CourseCertificate> list(CourseCertificateSO so);

    int deleteByCertificateId(String certificateId);
}
