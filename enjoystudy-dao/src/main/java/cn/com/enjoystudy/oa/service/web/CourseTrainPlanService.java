package cn.com.enjoystudy.oa.service.web;

import cn.com.enjoystudy.oa.bean.web.CourseTrainPlan;
import cn.com.enjoystudy.oa.bean.web.CourseTrainPlanSO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CourseTrainPlanService {
    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(CourseTrainPlan entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(CourseTrainPlan entity);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    CourseTrainPlan getById(String id);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    int deleteById(String id);

    /**
     * 列表查询
     * @param so
     * @return
     */
    List<CourseTrainPlan> list(CourseTrainPlanSO so);

    PageInfo findPage(CourseTrainPlanSO so);
}
