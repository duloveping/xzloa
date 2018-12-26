package cn.com.enjoystudy.oa.dao.sys;

import cn.com.enjoystudy.oa.bean.sys.SysMenu;
import cn.com.enjoystudy.oa.bean.sys.SysMenuSO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 菜单DAO
 * @author 广州新咨力科技有限公司-杜永生
 */
@Repository
public interface SysMenuDao {
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
    SysMenu getById(@Param("id") String id);

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
    List<SysMenu> list(SysMenuSO so);

    long count(SysMenuSO so);

    List<SysMenu> findByParentId(String parentId);

    List<SysMenu> findEmployeeMenuList(SysMenuSO so);

    List<SysMenu> findMenu(@Param("parentId") String parentId, @Param("employeeId") String employeeId);
}
