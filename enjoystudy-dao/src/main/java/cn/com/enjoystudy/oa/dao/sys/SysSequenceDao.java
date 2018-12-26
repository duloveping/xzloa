package cn.com.enjoystudy.oa.dao.sys;

import cn.com.enjoystudy.oa.bean.sys.SysSequence;
import cn.com.enjoystudy.oa.bean.sys.SysSequenceSO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysSequenceDao {
    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(SysSequence entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(SysSequence entity);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    SysSequence getById(@Param("id") String id);

    SysSequence getByCode(@Param("code") String code);

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
    List<SysSequence> list(SysSequenceSO so);

    long count(SysSequenceSO so);
}
