package cn.com.enjoystudy.oa.webapps.web;

import cn.com.enjoystudy.oa.webapps.manage.LoginController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/web/login")
public class WebLoginController extends LoginController {
    @RequestMapping("index")
    @Override
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("web/login/index");
        return mv;
    }
}
