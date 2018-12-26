package cn.com.enjoystudy.oa.service.sys;

import cn.com.enjoystudy.oa.bean.sys.SysBaseConfig;
import cn.com.enjoystudy.oa.bean.sys.SysBaseConfigSO;
import cn.com.enjoystudy.oa.dao.sys.SysBaseConfigDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SysBaseConfigServiceImpl implements SysBaseConfigService {
    @Autowired
    private SysBaseConfigDao sysBaseConfigDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(SysBaseConfig entity) {
        entity.preInsert();
        return sysBaseConfigDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(SysBaseConfig entity) {
        entity.preUpdate();
        return sysBaseConfigDao.update(entity);
    }

    @Override
    public SysBaseConfig getById(String id) {
        return sysBaseConfigDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void deleteById(String id) {
        sysBaseConfigDao.deleteById(id);
    }

    @Override
    public List<SysBaseConfig> list(SysBaseConfigSO so) {
        return sysBaseConfigDao.list(so);
    }
}
