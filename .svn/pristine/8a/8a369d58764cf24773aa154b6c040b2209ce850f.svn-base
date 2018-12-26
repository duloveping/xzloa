package cn.com.enjoystudy.oa.dao.sys;

import cn.com.enjoystudy.oa.bean.sys.SysMenu;
import cn.com.enjoystudy.oa.bean.sys.SysRole;
import cn.com.enjoystudy.oa.bean.sys.SysRoleMenu;
import cn.com.enjoystudy.oa.bean.sys.SysRoleMenuSO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 角色菜单DAO
 * @author 广州新咨力科技有限公司-杜永生
 */
@Repository
public interface SysRoleMenuDao {
    /**
     * 插入
     * @param roleMenu
     * @return
     */
    int insert(SysRoleMenu roleMenu);

    /**
     * 更新
     * @param roleMenu
     * @return
     */
    int update(SysRoleMenu roleMenu);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    SysRoleMenu getById(@Param("id") String id);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    int deleteById(@Param("id") String id);

    /**
     * 列表查询
     * @param roleMenuSO
     * @return
     */
    List<SysRoleMenu> list(SysRoleMenuSO roleMenuSO);

    /**
     * 根据角色ID查找
     * @param roleId
     * @return
     */
    List<SysRoleMenu> findByRoleId(@Param("roleId") String roleId);

    /**
     * 根据菜单ID查找
     * @param menuId
     * @return
     */
    List<SysRoleMenu> findByMenuId(@Param("menuId") String menuId);

    /**
     * 根据菜色ID删除
     * @param roleId
     * @return
     */
    int deleteByRoleId(@Param("roleId") String roleId);

    /**
     * 根据菜单ID删除
     * @param menuId
     * @return
     */
    int deleteByMenuId(@Param("menuId") String menuId);

    SysRole getRole(@Param("roleId") String roleId);

    SysMenu getMenu(@Param("menuId") String menuId);
}
