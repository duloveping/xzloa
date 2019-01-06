package cn.com.enjoystudy.oa.dao.register.examination;

import cn.com.enjoystudy.oa.bean.register.examination.ExaminationPlan;
import cn.com.enjoystudy.oa.bean.register.examination.ExaminationPlanSO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExaminationPlanDao {
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

    void updateShowState(@Param("showState") Boolean showState, @Param("id") String id);

}
