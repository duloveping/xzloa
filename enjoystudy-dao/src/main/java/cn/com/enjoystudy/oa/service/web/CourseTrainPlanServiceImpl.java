package cn.com.enjoystudy.oa.service.web;

import cn.com.enjoystudy.oa.bean.web.CourseTrainPlan;
import cn.com.enjoystudy.oa.bean.web.CourseTrainPlanSO;
import cn.com.enjoystudy.oa.dao.web.CourseTrainPlanDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CourseTrainPlanServiceImpl implements CourseTrainPlanService {
    @Autowired
    private CourseTrainPlanDao courseTrainPlanDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(CourseTrainPlan entity) {
        entity.preInsert();
        return courseTrainPlanDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(CourseTrainPlan entity) {
        entity.preUpdate();
        return courseTrainPlanDao.update(entity);
    }

    @Override
    public CourseTrainPlan getById(String id) {
        return courseTrainPlanDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return courseTrainPlanDao.deleteById(id);
    }

    @Override
    public List<CourseTrainPlan> list(CourseTrainPlanSO so) {
        return courseTrainPlanDao.list(so);
    }

    @Override
    public PageInfo findPage(CourseTrainPlanSO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo<CourseTrainPlan> pageInfo = new PageInfo(courseTrainPlanDao.list(so));
        return pageInfo;
    }
}
