package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.ExaminationConfig;
import cn.com.enjoystudy.oa.bean.study.ExaminationConfigSO;
import cn.com.enjoystudy.oa.dao.study.ExaminationConfigDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ExaminationConfigServiceImpl implements ExaminationConfigService {
    @Autowired
    private ExaminationConfigDao examinationConfigDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(ExaminationConfig entity) {
        entity.preInsert();
        return examinationConfigDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(ExaminationConfig entity) {
        entity.preUpdate();
        return examinationConfigDao.update(entity);
    }

    @Override
    public ExaminationConfig getById(String id) {
        return examinationConfigDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return examinationConfigDao.deleteById(id);
    }

    @Override
    public List<ExaminationConfig> list(ExaminationConfigSO so) {
        return examinationConfigDao.list(so);
    }
}
