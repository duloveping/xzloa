package cn.com.enjoystudy.oa.service.sys;

import cn.com.enjoystudy.oa.bean.sys.SysRole;
import cn.com.enjoystudy.oa.bean.sys.SysRoleSO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色Service
 * @author 广州新咨力科技有限公司-杜永生
 */
public interface SysRoleService {
    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(SysRole entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(SysRole entity);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    SysRole getById(@Param("id") String id);

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
    List<SysRole> list(SysRoleSO so);

    long count(SysRoleSO so);
}
