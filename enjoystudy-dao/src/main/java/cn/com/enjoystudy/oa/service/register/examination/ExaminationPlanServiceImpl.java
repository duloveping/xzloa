package cn.com.enjoystudy.oa.service.register.examination;

import cn.com.enjoystudy.oa.bean.register.examination.ExaminationPlan;
import cn.com.enjoystudy.oa.bean.register.examination.ExaminationPlanSO;
import cn.com.enjoystudy.oa.dao.register.examination.ExaminationPlanDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ExaminationPlanServiceImpl implements ExaminationPlanService {
    @Autowired
    private ExaminationPlanDao examinationPlanDao;

    @Override
    public int insert(ExaminationPlan entity) {
        entity.preInsert();
        return examinationPlanDao.insert(entity);
    }

    @Override
    public int update(ExaminationPlan entity) {
        entity.preUpdate();
        return examinationPlanDao.update(entity);
    }

    @Override
    public ExaminationPlan getById(String id) {
        return examinationPlanDao.getById(id);
    }

    @Override
    public void deleteById(String id) {
        examinationPlanDao.deleteById(id);

    }

    @Override
    public List<ExaminationPlan> list(ExaminationPlanSO so) {
        return examinationPlanDao.list(so);
    }

    @Override
    public PageInfo<ExaminationPlan> findPage(ExaminationPlanSO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo pageInfo = new PageInfo(examinationPlanDao.list(so));
        return pageInfo;
    }

    @Override
    public void updateShowState(Boolean showState, String id) {
        if (null == showState) {
            throw new NullPointerException("showState is null.");
        }
        if (StringUtils.isBlank(id)) {
            throw new NullPointerException("id is null.");
        }
        examinationPlanDao.updateShowState(showState, id);
    }
}
