package cn.com.enjoystudy.oa.dao.study;

import cn.com.enjoystudy.oa.bean.study.EmployeeCertificate;
import cn.com.enjoystudy.oa.bean.study.EmployeeCertificateSO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeCertificateDao {
    int insert(EmployeeCertificate entity);

    int update(EmployeeCertificate entity);

    EmployeeCertificate getById(String id);

    int deleteById(String id);

    List<EmployeeCertificate> list(EmployeeCertificateSO so);
}
