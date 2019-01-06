package cn.com.enjoystudy.oa.service.register.examination;

import cn.com.enjoystudy.oa.bean.register.examination.ExaminationPlanList;
import cn.com.enjoystudy.oa.bean.register.examination.ExaminationPlanListSO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExaminationPlanListService {
    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(ExaminationPlanList entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(ExaminationPlanList entity);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    ExaminationPlanList getById(String id);

    /**
     * 根据ID删除
     * @param id
     */
    void deleteById(String id);

    void deleteByPlanId(String id);

    void updateShowState(@Param("showState") Boolean showState, @Param("id") String id);

    /**
     * 列表查询
     * @param so
     * @return
     */
    List<ExaminationPlanList> list(ExaminationPlanListSO so);
}
