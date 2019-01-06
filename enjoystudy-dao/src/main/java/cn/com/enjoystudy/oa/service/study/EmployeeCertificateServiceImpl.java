package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.EmployeeCertificate;
import cn.com.enjoystudy.oa.bean.study.EmployeeCertificateSO;
import cn.com.enjoystudy.oa.dao.study.EmployeeCertificateDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeCertificateServiceImpl implements EmployeeCertificateService {
    @Autowired
    private EmployeeCertificateDao employeeCertificateDao;

    @Override
    public int insert(EmployeeCertificate entity) {
        entity.preInsert();
        return employeeCertificateDao.insert(entity);
    }

    @Override
    public int update(EmployeeCertificate entity) {
        entity.preUpdate();
        return employeeCertificateDao.update(entity);
    }

    @Override
    public EmployeeCertificate getById(String id) {
        if (StringUtils.isBlank(id)) {
            throw new NullPointerException("id is null");
        }
        return employeeCertificateDao.getById(id);
    }

    @Override
    public int deleteById(String id) {
        if (StringUtils.isBlank(id)) {
            throw new NullPointerException("id is null");
        }
        return employeeCertificateDao.deleteById(id);
    }

    @Override
    public List<EmployeeCertificate> list(EmployeeCertificateSO so) {
        return employeeCertificateDao.list(so);
    }

    @Override
    public PageInfo<EmployeeCertificate> findPag(EmployeeCertificateSO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo<EmployeeCertificate> pageInfo = new PageInfo(employeeCertificateDao.list(so));
        return pageInfo;
    }
}
