package cn.com.enjoystudy.oa.webapps.web;

import cn.com.enjoystudy.oa.bean.study.Course;
import cn.com.enjoystudy.oa.bean.study.CourseSO;
import cn.com.enjoystudy.oa.service.study.CourseService;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/web/course")
public class WebCourseController extends BaseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("list")
    public ModelAndView list(CourseSO so) {
        PageInfo<Course> pageInfo = courseService.findPag(so);

        ModelAndView mv = new ModelAndView("web/course/list");
        mv.getModel().put("so", so);
        mv.getModel().put("pageInfo", pageInfo);
        return mv;
    }

    @RequestMapping("search")
    @ResponseBody
    public JSONObject search(CourseSO so) {
        PageInfo<Course> pageInfo = courseService.findPag(so);

        JSONObject json = resultSuccess();
        json.put("datas", pageInfo.getList());
        json.put("total", pageInfo.getTotal());
        json.put("pages", pageInfo.getPages());
        return json;
    }
}
