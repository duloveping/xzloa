package cn.com.enjoystudy.oa.service.shop;

import cn.com.enjoystudy.oa.bean.shop.StudentCourseList;
import cn.com.enjoystudy.oa.bean.shop.StudentCourseListSO;
import cn.com.enjoystudy.oa.dao.shop.StudentCourseListDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class StudentCourseListServiceImpl implements StudentCourseListService {
    @Autowired
    private StudentCourseListDao studentCourseListDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(StudentCourseList entity) {
        entity.preInsert();
        return studentCourseListDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(StudentCourseList entity) {
        entity.preUpdate();
        return studentCourseListDao.update(entity);
    }

    @Override
    public StudentCourseList getById(String id) {
        return studentCourseListDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return studentCourseListDao.deleteById(id);
    }

    @Override
    public List<StudentCourseList> list(StudentCourseListSO so) {
        return studentCourseListDao.list(so);
    }

    @Override
    public PageInfo<StudentCourseList> findPage(StudentCourseListSO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo pageInfo = new PageInfo(studentCourseListDao.list(so));
        return pageInfo;
    }
}
