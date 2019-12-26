package cn.com.enjoystudy.oa.webapps.web;

import cn.com.enjoystudy.oa.filter.ManageSessionFilter;
import cn.com.enjoystudy.oa.webapps.manage.LoginController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/web/login")
public class WebLoginController extends LoginController {
    @RequestMapping("index")
    @Override
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("web/login/index");
        return mv;
    }

    @Override
    @RequestMapping("logout")
    public ModelAndView logout(HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        if (null != subject) {
            Object object = subject.getSession().getAttribute(ManageSessionFilter.DEFAULT_LOGIN_USER);
            if (null != object) {
                subject.getSession().removeAttribute(ManageSessionFilter.DEFAULT_LOGIN_USER);
                subject.logout();
            }
        }
        ModelAndView mv = new ModelAndView("redirect:/web/login/index.jhtml");
        return mv;
    }
}
