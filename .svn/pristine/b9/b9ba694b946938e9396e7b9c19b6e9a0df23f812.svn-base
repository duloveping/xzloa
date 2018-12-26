package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.CourseCertificate;
import cn.com.enjoystudy.oa.bean.study.CourseCertificateSO;
import cn.com.enjoystudy.oa.dao.study.CourseCertificateDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CourseCertificateServiceImpl implements CourseCertificateService {
    @Autowired
    private CourseCertificateDao courseCertificateDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(CourseCertificate entity) {
        entity.preInsert();
        return courseCertificateDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(CourseCertificate entity) {
        entity.preUpdate();
        return courseCertificateDao.update(entity);
    }

    @Override
    public CourseCertificate getById(String id) {
        return courseCertificateDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return courseCertificateDao.deleteById(id);
    }

    @Override
    public List<CourseCertificate> list(CourseCertificateSO so) {
        return courseCertificateDao.list(so);
    }

    @Override
    public int deleteByCertificateId(String certificateId) {
        if (StringUtils.isBlank(certificateId)) {
            throw new NullPointerException("certificateId is null.");
        }
        return courseCertificateDao.deleteByCertificateId(certificateId);
    }
}
