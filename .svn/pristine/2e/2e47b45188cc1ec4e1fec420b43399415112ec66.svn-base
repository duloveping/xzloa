package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.CourseExaminationAnalysis;
import cn.com.enjoystudy.oa.dao.study.CourseExaminationAnalysisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CourseExaminationAnalysisServiceImpl implements CourseExaminationAnalysisService {
    @Autowired
    private CourseExaminationAnalysisDao courseExaminationAnalysisDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(CourseExaminationAnalysis entity) {
        entity.preInsert();
        return courseExaminationAnalysisDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(CourseExaminationAnalysis entity) {
        entity.preUpdate();
        return courseExaminationAnalysisDao.update(entity);
    }

    @Override
    public CourseExaminationAnalysis getById(String id) {
        return courseExaminationAnalysisDao.getById(id);
    }

    @Override
    public int deleteById(String id) {
        return courseExaminationAnalysisDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public CourseExaminationAnalysis getAnalysisExaminationId(String examinationId) {
        return courseExaminationAnalysisDao.getAnalysisExaminationId(examinationId);
    }
}
