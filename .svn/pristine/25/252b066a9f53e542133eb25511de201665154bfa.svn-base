package cn.com.enjoystudy.oa.service.sys;

import cn.com.enjoystudy.oa.bean.sys.SysRole;
import cn.com.enjoystudy.oa.bean.sys.SysRoleSO;
import cn.com.enjoystudy.oa.dao.sys.SysRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 角色Service
 * @author 广州新咨力科技有限公司-杜永生
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(SysRole entity) {
        entity.preInsert();
        return sysRoleDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(SysRole entity) {
        entity.preUpdate();
        return sysRoleDao.update(entity);
    }

    @Override
    public SysRole getById(String id) {
        return sysRoleDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void deleteById(String id) {
        sysRoleDao.deleteById(id);
    }

    @Override
    public List<SysRole> list(SysRoleSO so) {
        return sysRoleDao.list(so);
    }

    @Override
    public long count(SysRoleSO so) {
        return sysRoleDao.count(so);
    }
}
