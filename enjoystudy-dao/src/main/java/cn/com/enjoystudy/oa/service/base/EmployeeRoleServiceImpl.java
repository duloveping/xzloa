package cn.com.enjoystudy.oa.service.base;

import cn.com.enjoystudy.oa.bean.base.EmployeeRole;
import cn.com.enjoystudy.oa.bean.base.EmployeeRoleSO;
import cn.com.enjoystudy.oa.dao.base.EmployeeRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 员工角色Service实现
 *
 * @author 广州新咨力科技有限公司-杜永生
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class EmployeeRoleServiceImpl implements EmployeeRoleService {
    @Autowired
    private EmployeeRoleDao employeeRoleDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(EmployeeRole entity) {
        return employeeRoleDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(EmployeeRole entity) {
        return employeeRoleDao.update(entity);
    }

    @Override
    public EmployeeRole getById(String id) {
        return employeeRoleDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void deleteById(String id) {
        employeeRoleDao.deleteById(id);

    }

    @Override
    public List<EmployeeRole> list(EmployeeRoleSO so) {
        return employeeRoleDao.list(so);
    }

    @Override
    public List<EmployeeRole> findByEmployeeId(String employeeId) {
        return employeeRoleDao.findByEmployeeId(employeeId);
    }

    @Override
    public List<EmployeeRole> findByRoleId(String roleId) {
        return employeeRoleDao.findByRoleId(roleId);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteByEmployeeId(String employeeId) {
        return employeeRoleDao.deleteByEmployeeId(employeeId);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteByRoleId(String roleId) {
        return employeeRoleDao.deleteByRoleId(roleId);
    }
}
