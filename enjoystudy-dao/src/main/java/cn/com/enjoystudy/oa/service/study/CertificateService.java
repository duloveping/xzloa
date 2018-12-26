package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.Certificate;
import cn.com.enjoystudy.oa.bean.study.CertificateSO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CertificateService {
    int insert(Certificate entity);

    int update(Certificate entity);

    Certificate getById(String id);

    int deleteById(String id);

    List<Certificate> list(CertificateSO so);

    long count(CertificateSO so);

    PageInfo<Certificate> findPag(CertificateSO so);

    void print(String id);
}
