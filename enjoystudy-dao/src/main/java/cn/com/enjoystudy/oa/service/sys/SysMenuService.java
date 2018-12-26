package cn.com.enjoystudy.oa.service.sys;

import cn.com.enjoystudy.oa.bean.sys.SysMenu;
import cn.com.enjoystudy.oa.bean.sys.SysMenuSO;

import java.util.List;

/**
 * 菜单Service
 * @author 广州新咨力科技有限公司-杜永生
 */
public interface SysMenuService {
    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(SysMenu entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(SysMenu entity);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    SysMenu getById(String id);

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
    List<SysMenu> list(SysMenuSO so);

    long count(SysMenuSO so);

    List<SysMenu> findByParentId(String parentId);

    List<SysMenu> findEmployeeMenuList(SysMenuSO so);

    List<SysMenu> recursionFindMenu(SysMenuSO so, List<SysMenu> menus);
}
