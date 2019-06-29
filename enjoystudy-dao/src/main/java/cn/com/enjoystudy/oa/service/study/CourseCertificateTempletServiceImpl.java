package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.CourseCertificateTemplet;
import cn.com.enjoystudy.oa.dao.study.CourseCertificateTempletDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CourseCertificateTempletServiceImpl implements CourseCertificateTempletService {
    @Autowired
    private CourseCertificateTempletDao courseCertificateTempletDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(CourseCertificateTemplet entity) {
        entity.preInsert();
        return courseCertificateTempletDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(CourseCertificateTemplet entity) {
        entity.preUpdate();
        return courseCertificateTempletDao.update(entity);
    }

    @Override
    public CourseCertificateTemplet getById(String id) {
        return courseCertificateTempletDao.getById(id);
    }

    @Override
    public CourseCertificateTemplet getByCourseId(String courseId) {
        return courseCertificateTempletDao.getByCourseId(courseId);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return courseCertificateTempletDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteByCourseId(String courseId) {
        return courseCertificateTempletDao.deleteByCourseId(courseId);
    }
}
