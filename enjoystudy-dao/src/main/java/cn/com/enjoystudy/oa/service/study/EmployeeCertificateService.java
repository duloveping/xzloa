package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.EmployeeCertificate;
import cn.com.enjoystudy.oa.bean.study.EmployeeCertificateSO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface EmployeeCertificateService {
    int insert(EmployeeCertificate entity);

    int update(EmployeeCertificate entity);

    EmployeeCertificate getById(String id);

    int deleteById(String id);

    List<EmployeeCertificate> list(EmployeeCertificateSO so);

    PageInfo<EmployeeCertificate> findPag(EmployeeCertificateSO so);
}
