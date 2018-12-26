package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.EmployeeCourseStudy;
import cn.com.enjoystudy.oa.bean.study.EmployeeCourseStudySO;
import cn.com.enjoystudy.oa.dao.study.EmployeeCourseStudyDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class EmployeeCourseStudyServiceImpl implements EmployeeCourseStudyService {
    @Autowired
    private EmployeeCourseStudyDao employeeCourseStudyDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(EmployeeCourseStudy entity) {
        entity.preInsert();
        return employeeCourseStudyDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(EmployeeCourseStudy entity) {
        entity.preUpdate();
        return employeeCourseStudyDao.update(entity);
    }

    @Override
    public EmployeeCourseStudy getById(String id) {
        return employeeCourseStudyDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return employeeCourseStudyDao.deleteById(id);
    }

    @Override
    public List<EmployeeCourseStudy> list(EmployeeCourseStudySO so) {
        return employeeCourseStudyDao.list(so);
    }

    @Override
    public PageInfo<EmployeeCourseStudy> findPag(EmployeeCourseStudySO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo<EmployeeCourseStudy> pageInfo = new PageInfo(employeeCourseStudyDao.list(so));
        return pageInfo;
    }

    @Override
    public List<EmployeeCourseStudy> getCourseStudyReportList(EmployeeCourseStudySO so) {
        return employeeCourseStudyDao.getCourseStudyReportList(so);
    }

    @Override
    public PageInfo<EmployeeCourseStudy> getCourseStudyReportPage(EmployeeCourseStudySO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo<EmployeeCourseStudy> pageInfo = new PageInfo(employeeCourseStudyDao.getCourseStudyReportList(so));
        return pageInfo;
    }

    @Override
    public long getStudyAmount(String employeeId, String courseId) {
        return employeeCourseStudyDao.getStudyAmount(employeeId, courseId);
    }
}
