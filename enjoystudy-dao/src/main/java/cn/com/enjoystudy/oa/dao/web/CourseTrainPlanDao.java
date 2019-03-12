package cn.com.enjoystudy.oa.dao.web;

import cn.com.enjoystudy.oa.bean.web.CourseTrainPlan;
import cn.com.enjoystudy.oa.bean.web.CourseTrainPlanSO;

import java.util.List;

/**
 * 课程培训计划DAO
 * @author 广州新咨力科技有限公司-杜永生
 */
public interface CourseTrainPlanDao {
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
}
