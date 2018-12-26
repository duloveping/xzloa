package cn.com.enjoystudy.oa.dao.study;

import cn.com.enjoystudy.oa.bean.study.CourseCertificate;
import cn.com.enjoystudy.oa.bean.study.CourseCertificateSO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseCertificateDao {
    int insert(CourseCertificate entity);

    int update(CourseCertificate entity);

    CourseCertificate getById(String id);

    int deleteById(String id);

    List<CourseCertificate> list(CourseCertificateSO so);

    int deleteByCertificateId(String certificateId);
}
