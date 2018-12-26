package cn.com.enjoystudy.oa.tag.system;

import cn.com.enjoystudy.oa.bean.sys.SysRoleMenu;
import cn.com.enjoystudy.oa.bean.sys.SysRoleMenuSO;
import cn.com.enjoystudy.oa.service.sys.SysRoleMenuService;
import cn.com.enjoystudy.oa.tag.BaseTagSupport;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class SysRoleMenuListTag extends BaseTagSupport {
    /** 角色ID */
    private String roleId;
    /** 菜单ID */
    private String menuId;

    @Override
    protected int doStartTagInternal() throws Exception {
        List<SysRoleMenu> list = null;

        if (StringUtils.isNotBlank(roleId) || StringUtils.isNotBlank(menuId)) {
            SysRoleMenuService service = (SysRoleMenuService) getBean(SysRoleMenuService.class);
            if (null != service) {
                SysRoleMenuSO so = new SysRoleMenuSO();
                so.setRoleId(roleId);
                so.setMenuId(menuId);

                list = service.list(so);
            }
        }
        pageContext.setAttribute(getVarid(), list);
        return SKIP_PAGE;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}
