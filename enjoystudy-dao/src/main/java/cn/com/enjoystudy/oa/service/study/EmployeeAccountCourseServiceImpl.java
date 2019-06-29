package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.Course;
import cn.com.enjoystudy.oa.bean.study.EmployeeAccountCourse;
import cn.com.enjoystudy.oa.bean.study.EmployeeAccountCourseSO;
import cn.com.enjoystudy.oa.dao.study.EmployeeAccountCourseDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class EmployeeAccountCourseServiceImpl implements EmployeeAccountCourseService {
    @Autowired
    private EmployeeAccountCourseDao employeeAccountCourseDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(EmployeeAccountCourse entity) {
        entity.preInsert();
        return employeeAccountCourseDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(EmployeeAccountCourse entity) {
        entity.preUpdate();
        return employeeAccountCourseDao.update(entity);
    }

    @Override
    public EmployeeAccountCourse getById(String id) {
        return employeeAccountCourseDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return employeeAccountCourseDao.deleteById(id);
    }

    @Override
    public List<EmployeeAccountCourse> list(EmployeeAccountCourseSO so) {
        return employeeAccountCourseDao.list(so);
    }

    @Override
    public long count(EmployeeAccountCourseSO so) {
        return employeeAccountCourseDao.count(so);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int delete(EmployeeAccountCourseSO so) {
        return employeeAccountCourseDao.delete(so);
    }

    @Override
    public List<Course> findCourseByEmployeeId(String employeeId) {
        if (StringUtils.isBlank(employeeId)) {
            throw new NullPointerException("employeeId is null.");
        }
        return employeeAccountCourseDao.findCourseByEmployeeId(employeeId);
    }

    @Override
    public PageInfo<Course> findCoursePageByEmployeeId(EmployeeAccountCourseSO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo<Course> pageInfo = new PageInfo(employeeAccountCourseDao.findCourseByEmployeeId(so.getEmployeeId()));
        return pageInfo;
    }
}
