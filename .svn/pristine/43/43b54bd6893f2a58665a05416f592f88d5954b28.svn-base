package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.Certificate;
import cn.com.enjoystudy.oa.bean.study.CertificateSO;
import cn.com.enjoystudy.oa.bean.study.Course;
import cn.com.enjoystudy.oa.dao.study.CertificateDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CertificateServiceImpl implements CertificateService {
    @Autowired
    private CertificateDao certificateDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(Certificate entity) {
        entity.preInsert();
        return certificateDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(Certificate entity) {
        entity.preUpdate();
        return certificateDao.update(entity);
    }

    @Override
    public Certificate getById(String id) {
        return certificateDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return certificateDao.deleteById(id);
    }

    @Override
    public List<Certificate> list(CertificateSO so) {
        return certificateDao.list(so);
    }

    @Override
    public long count(CertificateSO so) {
        return certificateDao.count(so);
    }

    @Override
    public PageInfo<Certificate> findPag(CertificateSO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo<Certificate> pageInfo = new PageInfo(certificateDao.list(so));
        return pageInfo;
    }

    @Override
    public void print(String id) {
        System.out.println("123123123123123-----------------------");
    }
}
