package cn.com.enjoystudy.oa.security.shiro;

import cn.com.enjoystudy.oa.bean.base.EmployeeAccount;
import cn.com.enjoystudy.oa.bean.base.EmployeeAccountSO;
import cn.com.enjoystudy.oa.bean.base.EmployeeRole;
import cn.com.enjoystudy.oa.bean.sys.SysMenu;
import cn.com.enjoystudy.oa.bean.sys.SysMenuSO;
import cn.com.enjoystudy.oa.bean.sys.SysRoleMenu;
import cn.com.enjoystudy.oa.bean.sys.SysRoleMenuSO;
import cn.com.enjoystudy.oa.service.base.EmployeeAccountService;
import cn.com.enjoystudy.oa.service.base.EmployeeRoleService;
import cn.com.enjoystudy.oa.service.sys.SysMenuService;
import cn.com.enjoystudy.oa.service.sys.SysRoleMenuService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public class SysEmployeeShiroDbRealm extends AuthorizingRealm {
    @Autowired
    private EmployeeAccountService employeeAccountService;
    @Autowired
    private EmployeeRoleService employeeRoleService;
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        String username = (String) arg0.getPrimaryPrincipal();

        EmployeeAccountSO accountSO = new EmployeeAccountSO();
        accountSO.setCode(username);

        List<EmployeeAccount> list = employeeAccountService.list(accountSO);

        EmployeeAccount account = null;
        if (null != list && list.size() > 0) {
            account = list.get(0);
        }

        if (null != account) {
            if ("admin".equals(account.getCode())) {
                SysMenuSO so = new SysMenuSO();
                so.setCategory(2);
                so.setShowState(true);

                List<SysMenu> menus = sysMenuService.list(so);
                if (null != menus && menus.size() > 0) {
                    List<String> permissions = new ArrayList<String>();
                    for (SysMenu data : menus) {
                        permissions.add(data.getCode());
                    }

                    info.addRole("admin");
                    info.addStringPermissions(permissions);
                }
            } else {
                List<EmployeeRole> employeeRoleList = employeeRoleService.findByEmployeeId(account.getId());
                if (null !=  employeeRoleList && employeeRoleList.size() > 0) {
                    for (EmployeeRole er : employeeRoleList) {
                        SysMenu menu = new SysMenu();
                        menu.setShowState(true);
                        menu.setCategory(2);

                        SysRoleMenuSO so = new SysRoleMenuSO();
                        so.setMenu(menu);
                        so.setRole(er.getRole());

                        List<SysRoleMenu> menus = sysRoleMenuService.findByRoleId(er.getRole().getId());
                        if (null != menus && menus.size() > 0) {
                            List<String> permissions = new ArrayList<String>();
                            for (SysRoleMenu data : menus) {
                                if (StringUtils.isNotBlank(data.getMenu().getCode())) {
                                    permissions.add(data.getMenu().getCode());
                                }
                            }
                            info.addRole(er.getRole().getCode());
                            info.addStringPermissions(permissions);
                        }
                    }
                }
            }
        }
        return info;
    }


    /**
     * 认证回调函数,登录时调用.
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) arg0;

        if (StringUtils.isBlank(token.getUsername())) {
            throw new AccountException("Null usernames are not allowed by this realm.");
        }

        EmployeeAccountSO accountSO = new EmployeeAccountSO();
        accountSO.setCode(token.getUsername());

        List<EmployeeAccount> list = employeeAccountService.list(accountSO);

        EmployeeAccount account = null;
        if (null != list && list.size() > 0) {
            account = list.get(0);
        }

        if (null == account) {
            throw new UnknownAccountException("No account found for user [" + token.getUsername() + "]");
        }

        SimpleAuthenticationInfo sai = new SimpleAuthenticationInfo(account.getCode(), account.getLoginPassword(), getName());
        return sai;
    }

}

