package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.CourseExaminationItem;
import cn.com.enjoystudy.oa.bean.study.CourseExaminationItemSO;
import cn.com.enjoystudy.oa.dao.study.CourseExaminationItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CourseExaminationItemServiceImpl implements CourseExaminationItemService {
    @Autowired
    private CourseExaminationItemDao courseExaminationItemDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(CourseExaminationItem entity) {
        entity.preInsert();
        return courseExaminationItemDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(CourseExaminationItem entity) {
        entity.preUpdate();
        return courseExaminationItemDao.update(entity);
    }

    @Override
    public CourseExaminationItem getById(String id) {
        return courseExaminationItemDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return courseExaminationItemDao.deleteById(id);
    }

    @Override
    public List<CourseExaminationItem> list(CourseExaminationItemSO so) {
        return courseExaminationItemDao.list(so);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteByExaminationId(String examinationId) {
        return courseExaminationItemDao.deleteByExaminationId(examinationId);
    }
}
