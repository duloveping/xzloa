package cn.com.enjoystudy.oa.dao.sys;

import cn.com.enjoystudy.oa.bean.sys.SysBaseConfig;
import cn.com.enjoystudy.oa.bean.sys.SysBaseConfigSO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysBaseConfigDao {
    /**
     * 插入SysBaseConfigDao
     * @param entity
     * @return
     */
    int insert(SysBaseConfig entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(SysBaseConfig entity);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    SysBaseConfig getById(@Param("id") String id);

    /**
     * 根据ID删除
     * @param id
     */
    void deleteById(@Param("id") String id);

    /**
     * 列表查询
     * @param so
     * @return
     */
    List<SysBaseConfig> list(SysBaseConfigSO so);
}
