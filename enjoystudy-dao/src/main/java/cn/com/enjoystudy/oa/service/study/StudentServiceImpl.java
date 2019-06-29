package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.base.Student;
import cn.com.enjoystudy.oa.bean.base.StudentSO;
import cn.com.enjoystudy.oa.dao.base.StudentDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(Student entity) {
        entity.preInsert();
        return studentDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(Student entity) {
        entity.preUpdate();
        return studentDao.update(entity);
    }

    @Override
    public Student getById(String id) {
        return studentDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return studentDao.deleteById(id);
    }

    @Override
    public List<Student> list(StudentSO so) {
        return studentDao.list(so);
    }

    @Override
    public PageInfo<Student> findPage(StudentSO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo<Student> pageInfo = new PageInfo(studentDao.list(so));
        return pageInfo;
    }
}
