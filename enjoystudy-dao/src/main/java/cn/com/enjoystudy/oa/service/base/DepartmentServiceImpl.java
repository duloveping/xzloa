package cn.com.enjoystudy.oa.service.base;

import cn.com.enjoystudy.oa.bean.base.Department;
import cn.com.enjoystudy.oa.bean.base.DepartmentSO;
import cn.com.enjoystudy.oa.dao.base.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 部门Service实现
 * @author 广州新咨力科技有限公司-杜永生
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(Department entity) {
        entity.preInsert();
        return departmentDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(Department entity) {
        entity.preUpdate();
        return departmentDao.update(entity);
    }

    @Override
    public Department getById(String id) {
        return departmentDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return departmentDao.deleteById(id);
    }

    @Override
    public List<Department> list(DepartmentSO so) {
        return departmentDao.list(so);
    }

    @Override
    public List<Department> tree(DepartmentSO so, List<Department> departments) {
        List<Department> list = departmentDao.list(so);
        if (null != list && list.size() > 0) {
            for (Department department : list) {
                departments.add(department);
                DepartmentSO departmentSO = new DepartmentSO();
                departmentSO.setParentId(department.getId());
                tree(departmentSO, departments);
            }
        }
        return departments;
    }

    @Override
    public long count(DepartmentSO so) {
        return departmentDao.count(so);
    }
}
