package cn.com.enjoystudy.oa.dao.study;

import cn.com.enjoystudy.oa.bean.study.Certificate;
import cn.com.enjoystudy.oa.bean.study.CertificateSO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificateDao {
    int insert(Certificate entity);

    int update(Certificate entity);

    Certificate getById(String id);

    int deleteById(String id);

    List<Certificate> list(CertificateSO so);

    long count(CertificateSO so);
}
