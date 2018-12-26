package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.Teacher;
import cn.com.enjoystudy.oa.bean.study.TeacherSO;
import cn.com.enjoystudy.oa.dao.study.TeacherDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(Teacher entity) {
        entity.preInsert();
        return teacherDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(Teacher entity) {
        entity.preUpdate();;
        return teacherDao.update(entity);
    }

    @Override
    public Teacher getById(String id) {
        return teacherDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return teacherDao.deleteById(id);
    }

    @Override
    public List<Teacher> list(TeacherSO so) {
        return teacherDao.list(so);
    }

    @Override
    public PageInfo<Teacher> findPag(TeacherSO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo<Teacher> pageInfo = new PageInfo(teacherDao.list(so));
        return pageInfo;
    }
}
