package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.EmployeeExaminationPaper;
import cn.com.enjoystudy.oa.bean.study.EmployeeExaminationPaperSO;
import cn.com.enjoystudy.oa.bean.study.EmployeeExaminationScore;
import cn.com.enjoystudy.oa.dao.study.EmployeeExaminationPaperDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class EmployeeExaminationPaperServiceImpl implements EmployeeExaminationPaperService {
    @Autowired
    private EmployeeExaminationPaperDao employeeExaminationPaperDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(EmployeeExaminationPaper entity) {
        entity.preInsert();
        return employeeExaminationPaperDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(EmployeeExaminationPaper entity) {
        entity.preUpdate();
        return employeeExaminationPaperDao.update(entity);
    }

    @Override
    public EmployeeExaminationPaper getById(String id) {
        if (StringUtils.isBlank(id)) {
            throw new NullPointerException("id is null.");
        }
        return employeeExaminationPaperDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return employeeExaminationPaperDao.deleteById(id);
    }

    @Override
    public List<EmployeeExaminationPaper> list(EmployeeExaminationPaperSO so) {
        return employeeExaminationPaperDao.list(so);
    }

    @Override
    public PageInfo<EmployeeExaminationPaper> findPage(EmployeeExaminationPaperSO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo pageInfo = new PageInfo(employeeExaminationPaperDao.list(so));
        return pageInfo;
    }

    @Override
    public long count(EmployeeExaminationPaperSO so) {
        return employeeExaminationPaperDao.count(so);
    }

    @Override
    public long getTestAmount(String employeeId, String courseId) {
        return employeeExaminationPaperDao.getTestAmount(employeeId, courseId);
    }

    @Override
    public List<EmployeeExaminationScore> findScoreList(EmployeeExaminationPaperSO so) {
        return employeeExaminationPaperDao.findScoreList(so);
    }
}
