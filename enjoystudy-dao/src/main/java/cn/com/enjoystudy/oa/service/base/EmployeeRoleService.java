package cn.com.enjoystudy.oa.service.base;

import cn.com.enjoystudy.oa.bean.base.EmployeeRole;
import cn.com.enjoystudy.oa.bean.base.EmployeeRoleSO;

import java.util.List;

/**
 * 员工角色Service
 *
 * @author 广州新咨力科技有限公司-杜永生
 */
public interface EmployeeRoleService {
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
    EmployeeRole getById(String id);

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
    List<EmployeeRole> list(EmployeeRoleSO so);

    /**
     * 根据员工ID查找
     * @param employeeId
     * @return
     */
    List<EmployeeRole> findByEmployeeId(String employeeId);

    /**
     * 根据角色ID查找
     * @param roleId
     * @return
     */
    List<EmployeeRole> findByRoleId(String roleId);

    /**
     * 根据员工ID删除
     * @param employeeId
     * @return
     */
    int deleteByEmployeeId(String employeeId);

    /**
     * 根据角色ID删除
     * @param roleId
     * @return
     */
    int deleteByRoleId(String roleId);
}
