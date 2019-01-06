package cn.com.enjoystudy.oa.service.register.examination;

import cn.com.enjoystudy.oa.bean.register.examination.ExaminationPlanList;
import cn.com.enjoystudy.oa.bean.register.examination.ExaminationPlanListSO;
import cn.com.enjoystudy.oa.dao.register.examination.ExaminationPlanListDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ExaminationPlanListServiceImpl implements ExaminationPlanListService {
    @Autowired
    private ExaminationPlanListDao examinationPlanListDao;


    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(ExaminationPlanList entity) {
        entity.preInsert();
        return examinationPlanListDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(ExaminationPlanList entity) {
        entity.preUpdate();
        return examinationPlanListDao.update(entity);
    }

    @Override
    public ExaminationPlanList getById(String id) {
        return examinationPlanListDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void deleteById(String id) {
        examinationPlanListDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void deleteByPlanId(String id) {
        examinationPlanListDao.deleteByPlanId(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void updateShowState(Boolean showState, String id) {
        examinationPlanListDao.updateShowState(showState, id);
    }

    @Override
    public List<ExaminationPlanList> list(ExaminationPlanListSO so) {
        return examinationPlanListDao.list(so);
    }
}
