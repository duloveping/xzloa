package cn.com.enjoystudy.oa.dao.base;

import cn.com.enjoystudy.oa.bean.base.EmployeeRole;
import cn.com.enjoystudy.oa.bean.base.EmployeeRoleSO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 员工角色DAO
 *
 * @author 广州新咨力科技有限公司-杜永生
 */
@Repository
public interface EmployeeRoleDao {
    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(EmployeeRole entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(EmployeeRole entity);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    EmployeeRole getById(@Param("id") String id);

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
    List<EmployeeRole> list(EmployeeRoleSO so);

    /**
     * 根据员工ID查找
     * @param employeeId
     * @return
     */
    List<EmployeeRole> findByEmployeeId(@Param("employeeId") String employeeId);

    /**
     * 根据角色ID查找
     * @param roleId
     * @return
     */
    List<EmployeeRole> findByRoleId(@Param("roleId") String roleId);

    /**
     * 根据员工ID删除
     * @param employeeId
     * @return
     */
    int deleteByEmployeeId(@Param("employeeId") String employeeId);

    /**
     * 根据角色ID删除
     * @param roleId
     * @return
     */
    int deleteByRoleId(@Param("roleId") String roleId);
}
