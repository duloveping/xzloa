package cn.com.enjoystudy.oa.service.base;

import cn.com.enjoystudy.oa.bean.base.EmployeePosition;
import cn.com.enjoystudy.oa.bean.base.EmployeePositionSO;
import cn.com.enjoystudy.oa.dao.base.EmployeePositionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 职务Service
 * @author 广州新咨力科技有限公司-杜永生
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class EmployeePositionServiceImpl implements EmployeePositionService {
    @Autowired
    private EmployeePositionDao employeePositionDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(EmployeePosition entity) {
        entity.preInsert();
        return employeePositionDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(EmployeePosition entity) {
        entity.preUpdate();
        return employeePositionDao.update(entity);
    }

    @Override
    public EmployeePosition getById(String id) {
        return employeePositionDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return employeePositionDao.deleteById(id);
    }

    @Override
    public List<EmployeePosition> list(EmployeePositionSO so) {
        return employeePositionDao.list(so);
    }

    @Override
    public List<EmployeePosition> findByEmployeeId(String employeeId) {
        return employeePositionDao.findByEmployeeId(employeeId);
    }

    @Override
    public List<EmployeePosition> finidByPositionId(String positionId) {
        return employeePositionDao.finidByPositionId(positionId);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteByEmployeeId(String employeeId) {
        return employeePositionDao.deleteByEmployeeId(employeeId);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteByPositionId(String positionId) {
        return employeePositionDao.deleteByPositionId(positionId);
    }
}
