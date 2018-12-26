package cn.com.enjoystudy.oa.service.sys;

import cn.com.enjoystudy.oa.bean.sys.SysRoleMenu;
import cn.com.enjoystudy.oa.bean.sys.SysRoleMenuSO;
import cn.com.enjoystudy.oa.dao.sys.SysRoleMenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 角色菜单Service实现
 * @author 广州新咨力科技有限公司-杜永生
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SysRoleMenuServiceImpl implements SysRoleMenuService {
    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(SysRoleMenu roleMenu) {
        roleMenu.preInsert();
        return sysRoleMenuDao.insert(roleMenu);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(SysRoleMenu roleMenu) {
        roleMenu.preUpdate();
        return sysRoleMenuDao.update(roleMenu);
    }

    @Override
    public SysRoleMenu getById(String id) {
        return sysRoleMenuDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return sysRoleMenuDao.deleteById(id);
    }

    @Override
    public List<SysRoleMenu> list(SysRoleMenuSO roleMenuSO) {
        return sysRoleMenuDao.list(roleMenuSO);
    }

    @Override
    public List<SysRoleMenu> findByRoleId(String roleId) {
        return sysRoleMenuDao.findByRoleId(roleId);
    }

    @Override
    public List<SysRoleMenu> findByMenuId(String menuId) {
        return sysRoleMenuDao.findByMenuId(menuId);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteByRoleId(String roleId) {
        return sysRoleMenuDao.deleteByRoleId(roleId);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteByMenuId(String menuId) {
        return sysRoleMenuDao.deleteByMenuId(menuId);
    }
}
