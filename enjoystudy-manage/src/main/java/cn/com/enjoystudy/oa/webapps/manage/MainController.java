package cn.com.enjoystudy.oa.webapps.manage;

import cn.com.enjoystudy.oa.bean.base.EmployeeAccount;
import cn.com.enjoystudy.oa.bean.sys.SysMenu;
import cn.com.enjoystudy.oa.bean.sys.SysMenuSO;
import cn.com.enjoystudy.oa.filter.ManageSessionFilter;
import cn.com.enjoystudy.oa.service.sys.SysMenuService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/manage/main")
public class MainController {
    @Autowired
    private SysMenuService sysMenuService;

    @RequestMapping("index")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("manage/main/index");

        Subject subject = SecurityUtils.getSubject();
        Object object = subject.getSession().getAttribute(ManageSessionFilter.DEFAULT_LOGIN_USER);
        if (null != object) {
            EmployeeAccount account = (EmployeeAccount) object;

            SysMenuSO menuSO = new SysMenuSO();


            List<SysMenu> menus1 = null;
            List<SysMenu> menus2 = null;
            List<SysMenu> menuList = null;
            if ("admin".equals(account.getCode())) {
                menuList = sysMenuService.list(menuSO);
            } else {
                menuSO.setCategory(1);
                menuSO.setEmployeeId(account.getId());
                menuList = sysMenuService.findEmployeeMenuList(menuSO);
            }

            if (null != menuList && menuList.size() > 0) {
                menus1 = new ArrayList<SysMenu>() ;
                menus2 = new ArrayList<SysMenu>() ;
                for (SysMenu menu : menuList) {
                    if (StringUtils.isBlank(menu.getParentId())) {
                        menus1.add(menu);
                    } else {
                        menus2.add(menu);
                    }
                }

                if (null != menus1 && menus1.size() > 0) {
                    for (SysMenu one : menus1) {
                        for (SysMenu two : menus2) {
                            if (one.getId().equals(two.getParentId())) {
                                if (null == one.getMenuList() || one.getMenuList().size() == 0) {
                                    one.setMenuList(new ArrayList<SysMenu>());
                                }
                                one.getMenuList().add(two);
                            }
                        }
                    }

                }
            }
            mv.getModel().put("menuList", menus1);
        }

        return mv;
    }

    @RequestMapping("welcome")
    public ModelAndView welcome(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("manage/main/welcome");
        return mv;
    }

}

