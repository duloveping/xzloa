package cn.com.enjoystudy.oa.service.register.examination;

import cn.com.enjoystudy.oa.bean.register.examination.ExaminationPlan;
import cn.com.enjoystudy.oa.bean.register.examination.ExaminationPlanSO;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExaminationPlanService {
    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(ExaminationPlan entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(ExaminationPlan entity);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    ExaminationPlan getById(String id);

    /**
     * 根据ID删除
     * @param id
     */
    void deleteById(String id);

    /**
     * 列表查询
     * @param so
     * @return
     */
    List<ExaminationPlan> list(ExaminationPlanSO so);

    PageInfo<ExaminationPlan> findPage(ExaminationPlanSO so);

    void updateShowState(Boolean showState, String id);
}
