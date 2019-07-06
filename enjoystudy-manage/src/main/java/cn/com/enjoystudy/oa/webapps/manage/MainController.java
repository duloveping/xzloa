package cn.com.enjoystudy.oa.webapps.manage;

import cn.com.enjoystudy.oa.bean.base.EmployeeAccount;
import cn.com.enjoystudy.oa.bean.study.*;
import cn.com.enjoystudy.oa.bean.sys.SysMenu;
import cn.com.enjoystudy.oa.bean.sys.SysMenuSO;
import cn.com.enjoystudy.oa.common.Constants;
import cn.com.enjoystudy.oa.filter.ManageSessionFilter;
import cn.com.enjoystudy.oa.service.study.CourseService;
import cn.com.enjoystudy.oa.service.study.CourseVideoService;
import cn.com.enjoystudy.oa.service.study.EmployeeAccountCourseService;
import cn.com.enjoystudy.oa.service.sys.SysMenuService;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/manage/main")
public class MainController extends BaseController {
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseVideoService courseVideoService;
    @Autowired
    private EmployeeAccountCourseService employeeAccountCourseService;

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
    public ModelAndView welcome() {
        ModelAndView mv = new ModelAndView("manage/main/welcome");
        EmployeeAccount account = getCurrentUser();
        if (account.getCategory().equals(Constants.ACCOUNT_CATEGORY_STUDENT)) {
            if (account.getFirstLoginState()) {
                mv = new ModelAndView("redirect:/manage/employee/account/edit-data.jhtml");
            }
        }
        return mv;
    }

    @RequestMapping("course-list")
    @ResponseBody
    public JSONObject courseList() {
        CourseVideoSO videoSO = new CourseVideoSO();

        EmployeeAccount account = getCurrentUser();
        if (account.getCategory().equals(Constants.ACCOUNT_CATEGORY_STUDENT)) {
            EmployeeAccountCourseSO courseSO = new EmployeeAccountCourseSO();
            courseSO.setEmployeeId(account.getId());
            List<Course> courseList = employeeAccountCourseService.findCourseByEmployeeId(account.getId());
            String[] courseIds = new String[courseList.size()];
            int i = 0;
            for (Course course : courseList) {
                courseIds[i++] = course.getId();
            }
            videoSO.setCourseIds(courseIds);
        }

        videoSO.setShowState(true);
        videoSO.setPageNum(1);
        videoSO.setPageSize(10);

        List<CourseVideo> videoList = courseVideoService.findVideoPage(videoSO).getList();
        JSONObject json = resultSuccess();
        json.put("videoList", videoList);
        return json;
    }

    @RequestMapping("examination-list")
    @ResponseBody
    public JSONObject examinationList() {
        CourseSO so  = new CourseSO();
        so.setTestState(2);
        so.setPageNum(1);
        so.setPageSize(10);

        EmployeeAccount account = getCurrentUser();
        if (account.getCategory().equals(Constants.ACCOUNT_CATEGORY_STUDENT)) {
            EmployeeAccountCourseSO courseSO = new EmployeeAccountCourseSO();
            courseSO.setEmployeeId(account.getId());
            List<Course> courseList = employeeAccountCourseService.findCourseByEmployeeId(account.getId());
            String[] courseIds = new String[courseList.size()];
            int i = 0;
            for (Course course : courseList) {
                courseIds[i++] = course.getId();
            }
            so.setIds(courseIds);
        }

        List<Course> examinationList = courseService.findPag(so).getList();
        JSONObject json = resultSuccess();
        json.put("examinationList", examinationList);
        return json;
    }

}

