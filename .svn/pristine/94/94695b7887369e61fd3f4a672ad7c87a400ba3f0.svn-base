package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.EmployeeCourseExerciseItem;
import cn.com.enjoystudy.oa.bean.study.EmployeeCourseExerciseItemSO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class EmployeeCourseExerciseItemServiceImpl implements EmployeeCourseExerciseItemService{
    @Autowired
    private EmployeeCourseExerciseItemService employeeCourseExerciseItemService;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(EmployeeCourseExerciseItem entity) {
        entity.preInsert();
        return employeeCourseExerciseItemService.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(EmployeeCourseExerciseItem entity) {
        entity.preUpdate();
        return employeeCourseExerciseItemService.update(entity);
    }

    @Override
    public EmployeeCourseExerciseItem getById(String id) {
        return employeeCourseExerciseItemService.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return employeeCourseExerciseItemService.deleteById(id);
    }

    @Override
    public List<EmployeeCourseExerciseItem> list(EmployeeCourseExerciseItemSO so) {
        return employeeCourseExerciseItemService.list(so);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteByExerciseId(String exerciseId) {
        return employeeCourseExerciseItemService.deleteByExerciseId(exerciseId);
    }
}
