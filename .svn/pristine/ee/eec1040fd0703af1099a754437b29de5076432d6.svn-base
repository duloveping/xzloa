package cn.com.enjoystudy.oa.service.sys;

import cn.com.enjoystudy.oa.bean.sys.SysRolePosition;
import cn.com.enjoystudy.oa.bean.sys.SysRolePositionSO;
import cn.com.enjoystudy.oa.dao.sys.SysRolePositionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SysRolePositionServiceImpl implements SysRolePositionService {
    @Autowired
    private SysRolePositionDao sysRolePositionDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(SysRolePosition entity) {
        entity.preInsert();
        return sysRolePositionDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(SysRolePosition entity) {
        entity.preUpdate();
        return sysRolePositionDao.update(entity);
    }

    @Override
    public List<SysRolePosition> list(SysRolePositionSO so) {
        return sysRolePositionDao.list(so);
    }

    @Override
    public SysRolePosition getById(String id) {
        return sysRolePositionDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return sysRolePositionDao.deleteById(id);
    }

    @Override
    public List<SysRolePosition> findByRoleId(String roleId) {
        return sysRolePositionDao.findByRoleId(roleId);
    }

    @Override
    public List<SysRolePosition> findByPositionId(String positionId) {
        return sysRolePositionDao.findByPositionId(positionId);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteByRoleId(String roleId) {
        return sysRolePositionDao.deleteByRoleId(roleId);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteByPositionId(String positionId) {
        return sysRolePositionDao.deleteByPositionId(positionId);
    }

    @Override
    public SysRolePosition getRole(String roleId) {
        return sysRolePositionDao.getRole(roleId);
    }

    @Override
    public SysRolePosition getPosition(String positionId) {
        return sysRolePositionDao.getPosition(positionId);
    }
}
