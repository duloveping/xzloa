package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.EmployeeExaminationQuestionItem;
import cn.com.enjoystudy.oa.bean.study.EmployeeExaminationQuestionItemSO;
import cn.com.enjoystudy.oa.dao.study.EmployeeExaminationQuestionItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class EmployeeExaminationQuestionItemServiceImpl implements EmployeeExaminationQuestionItemService {
    @Autowired
    private EmployeeExaminationQuestionItemDao employeeExaminationQuestionItemDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(EmployeeExaminationQuestionItem entity) {
        entity.preInsert();
        return employeeExaminationQuestionItemDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(EmployeeExaminationQuestionItem entity) {
        entity.preUpdate();
        return employeeExaminationQuestionItemDao.update(entity);
    }

    @Override
    public EmployeeExaminationQuestionItem getById(String id) {
        return employeeExaminationQuestionItemDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return employeeExaminationQuestionItemDao.deleteById(id);
    }

    @Override
    public List<EmployeeExaminationQuestionItem> list(EmployeeExaminationQuestionItemSO so) {
        return employeeExaminationQuestionItemDao.list(so);
    }

}
