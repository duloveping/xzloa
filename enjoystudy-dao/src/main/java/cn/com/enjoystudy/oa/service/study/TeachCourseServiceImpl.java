package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.TeachCourse;
import cn.com.enjoystudy.oa.bean.study.TeachCourseSO;
import cn.com.enjoystudy.oa.dao.study.TeachCourseDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class TeachCourseServiceImpl implements TeachCourseService {
    @Autowired
    private TeachCourseDao teachCourseDao;

    @Override
    public List<TeachCourse> teachCourseList(TeachCourseSO so) {
        return teachCourseDao.teachCourseList(so);
    }

    @Override
    public PageInfo<TeachCourse> teachCoursePage(TeachCourseSO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo<TeachCourse> pageInfo = new PageInfo(teachCourseDao.teachCourseList(so));
        return pageInfo;
    }

    @Override
    public List<TeachCourse> learnCourseList(TeachCourseSO so) {
        return teachCourseDao.learnCourseList(so);
    }

    @Override
    public PageInfo<TeachCourse> learnCoursePage(TeachCourseSO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo<TeachCourse> pageInfo = new PageInfo(teachCourseDao.learnCourseList(so));
        return pageInfo;
    }
}
