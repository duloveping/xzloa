package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.*;
import cn.com.enjoystudy.oa.dao.study.CourseExaminationDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CourseExaminationServiceImpl implements CourseExaminationService {
    @Autowired
    private CourseExaminationDao courseExaminationDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(CourseExamination entity) {
        entity.preInsert();
        return courseExaminationDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(CourseExamination entity) {
        entity.preUpdate();
        return courseExaminationDao.update(entity);
    }

    @Override
    public CourseExamination getById(String id) {
        return courseExaminationDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return courseExaminationDao.deleteById(id);
    }

    @Override
    public List<CourseExamination> list(CourseExaminationSO so) {
        return courseExaminationDao.list(so);
    }

    @Override
    public PageInfo<CourseExamination> findPag(CourseExaminationSO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo<CourseExamination> pageInfo = new PageInfo(courseExaminationDao.list(so));
        return pageInfo;
    }

    @Override
    public List<CourseExaminationItem> findItemsByExaminationId(String examinationId) {
        return courseExaminationDao.findItemsByExaminationId(examinationId);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteByExaminationId(String examinationId) {
        return courseExaminationDao.deleteByExaminationId(examinationId);
    }

    @Override
    public List<Course> findAllCourse() {
        return courseExaminationDao.findAllCourse();
    }

    @Override
    public String getAnalysis(String examinationId) {
        return courseExaminationDao.getAnalysis(examinationId);
    }
}
