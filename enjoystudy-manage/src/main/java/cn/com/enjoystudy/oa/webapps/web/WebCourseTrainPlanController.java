package cn.com.enjoystudy.oa.webapps.web;

import cn.com.enjoystudy.oa.bean.web.CourseTrainPlan;
import cn.com.enjoystudy.oa.bean.web.CourseTrainPlanSO;
import cn.com.enjoystudy.oa.service.web.CourseTrainPlanService;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/web/course-train-plan")
public class WebCourseTrainPlanController extends BaseController {
    @Autowired
    private CourseTrainPlanService courseTrainPlanService;

    @RequestMapping("index")
    public ModelAndView index(CourseTrainPlanSO so) {
        so.setShowState(true);
        PageInfo<CourseTrainPlan> pageInfo = courseTrainPlanService.findPage(so);

        ModelAndView mv = new ModelAndView("web/course-train-plan/index");
        mv.getModel().put("pageInfo", pageInfo);
        mv.getModel().put("planSO", so);
        return mv;
    }

    @RequestMapping("view")
    public ModelAndView index(@RequestParam("id") String id) {
        CourseTrainPlan courseTrainPlan = courseTrainPlanService.getById(id);

        CourseTrainPlanSO so = new CourseTrainPlanSO();
        so.setPageNum(1);
        so.setPageSize(10);
        so.setShowState(true);

        PageInfo<CourseTrainPlan> pageInfo = courseTrainPlanService.findPage(so);

        ModelAndView mv = new ModelAndView("web/course-train-plan/view");
        mv.getModel().put("planList", pageInfo.getList());
        mv.getModel().put("courseTrainPlan", courseTrainPlan);
        return mv;
    }
}
