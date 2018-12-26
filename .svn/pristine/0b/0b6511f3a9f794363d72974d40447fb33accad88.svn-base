package cn.com.enjoystudy.oa.dao.base;

import cn.com.enjoystudy.oa.bean.base.BasePosition;
import cn.com.enjoystudy.oa.bean.base.BasePositionSO;
import cn.com.enjoystudy.oa.bean.sys.SysRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 职务DAO
 * @author 广州新咨力科技有限公司-杜永生
 */
@Repository
public interface BasePositionDao {
    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(BasePosition entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(BasePosition entity);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    BasePosition getById(@Param("id") String id);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    int deleteById(@Param("id") String id);

    /**
     * 列表查询
     * @param so
     * @return
     */
    List<BasePosition> list(BasePositionSO so);

    long count(BasePositionSO so);

    List<SysRole> findRoleByPositionId(String positionId);
}
