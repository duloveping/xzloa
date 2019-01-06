package cn.com.enjoystudy.oa.service.base;

import cn.com.enjoystudy.oa.bean.base.EmployeeCommunication;
import cn.com.enjoystudy.oa.bean.base.EmployeeCommunicationSO;
import cn.com.enjoystudy.oa.dao.base.EmployeeCommunicationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class EmployeeCommunicationServiceImpl implements EmployeeCommunicationService {
    @Autowired
    private EmployeeCommunicationDao employeeCommunicationDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(EmployeeCommunication entity) {
        entity.preInsert();
        return employeeCommunicationDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(EmployeeCommunication entity) {
        entity.preUpdate();
        return employeeCommunicationDao.update(entity);
    }

    @Override
    public EmployeeCommunication getById(String id) {
        return employeeCommunicationDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return employeeCommunicationDao.deleteById(id);
    }

    @Override
    public List<EmployeeCommunication> list(EmployeeCommunicationSO so) {
        return employeeCommunicationDao.list(so);
    }
}
