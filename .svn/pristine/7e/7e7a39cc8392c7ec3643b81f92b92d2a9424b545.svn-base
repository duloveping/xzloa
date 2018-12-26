package cn.com.enjoystudy.oa.service.sys;

import cn.com.enjoystudy.oa.bean.sys.SysMenu;
import cn.com.enjoystudy.oa.bean.sys.SysMenuSO;
import cn.com.enjoystudy.oa.dao.sys.SysMenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 菜单Service实现
 * @author 广州新咨力科技有限公司-杜永生
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuDao sysMenuDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(SysMenu entity) {
        entity.preInsert();
        return sysMenuDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(SysMenu entity) {
        entity.preUpdate();
        return sysMenuDao.update(entity);
    }

    @Override
    public SysMenu getById(String id) {
        return sysMenuDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return sysMenuDao.deleteById(id);
    }

    @Override
    public List<SysMenu> list(SysMenuSO so) {
        return sysMenuDao.list(so);
    }

    @Override
    public List<SysMenu> findByParentId(String parentId) {
        return sysMenuDao.findByParentId(parentId);
    }

    @Override
    public long count(SysMenuSO so) {
        return sysMenuDao.count(so);
    }

    @Override
    public List<SysMenu> findEmployeeMenuList(SysMenuSO so) {
        return sysMenuDao.findEmployeeMenuList(so);
    }

    @Override
    public List<SysMenu> recursionFindMenu(SysMenuSO so, List<SysMenu> menus) {
        List<SysMenu> list = sysMenuDao.list(so);
        if (null != list && list.size() > 0) {
            for (SysMenu menu : list) {
                menus.add(menu);
                so.setParentId(menu.getId());
                recursionFindMenu(so, menus);
            }
        }
        return menus;
    }
}
