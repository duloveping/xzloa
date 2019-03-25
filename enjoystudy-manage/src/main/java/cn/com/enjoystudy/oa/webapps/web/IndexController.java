package cn.com.enjoystudy.oa.webapps.web;

import cn.com.enjoystudy.oa.bean.web.CourseTrainPlan;
import cn.com.enjoystudy.oa.bean.web.CourseTrainPlanSO;
import cn.com.enjoystudy.oa.service.web.CourseTrainPlanService;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/web/index")
public class IndexController extends BaseController {
    @Autowired
    private CourseTrainPlanService courseTrainPlanService;

    @RequestMapping("index")
    public ModelAndView index() {
        CourseTrainPlanSO planSO = new CourseTrainPlanSO();
        planSO.setShowState(true);
        planSO.setPageNum(1);
        planSO.setPrePage(6);
        PageInfo<CourseTrainPlan> planPageInfo = courseTrainPlanService.findPage(planSO);

        ModelAndView mv = new ModelAndView("web/index/index");
        mv.getModel().put("trainList", planPageInfo.getList());
        return mv;
    }

    @RequestMapping("login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("web/index/login");
        return mv;
    }
}
