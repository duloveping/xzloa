package cn.com.enjoystudy.oa.webapps.web;

import cn.com.enjoystudy.oa.bean.study.*;
import cn.com.enjoystudy.oa.service.study.CourseService;
import cn.com.enjoystudy.oa.service.study.CourseTypeService;
import cn.com.enjoystudy.oa.service.study.CourseVideoService;
import cn.com.enjoystudy.oa.service.study.TeacherService;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/web/course")
public class WebCourseController extends BaseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseVideoService courseVideoService;
    @Autowired
    private CourseTypeService courseTypeService;
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("list")
    public ModelAndView list(CourseSO so) {
        so.setPageSize(20);
        so.setShowState(true);
        PageInfo<Course> pageInfo = courseService.findPag(so);

        ModelAndView mv = new ModelAndView("web/course/list");
        mv.getModel().put("so", so);
        mv.getModel().put("pageInfo", pageInfo);
        return mv;
    }

    @RequestMapping("search")
    @ResponseBody
    public JSONObject search(CourseSO so) {
        so.setShowState(true);
        PageInfo<Course> pageInfo = courseService.findPag(so);

        JSONObject json = resultSuccess();
        json.put("datas", pageInfo.getList());
        json.put("total", pageInfo.getTotal());
        json.put("pages", pageInfo.getPages());
        return json;
    }

    @RequestMapping("view")
    public ModelAndView view(@RequestParam String id) {
        ModelAndView mv = new ModelAndView("web/course/view");

        Course course =courseService.getById(id);
        if (null != course) {
            CourseType courseType = courseTypeService.getById(course.getTypeId());
            Teacher teacher = teacherService.getById(course.getTeacherId());

            CourseVideoSO videoSO = new CourseVideoSO();
            videoSO.setCourseShowState(true);
            videoSO.setShowState(true);
            videoSO.setCourseId(course.getId());

            List<CourseVideo> videoList = courseVideoService.list(videoSO);

            CourseSO courseSO = new CourseSO();
            courseSO.setPageNum(1);
            courseSO.setPageSize(5);
            courseSO.setHotState(true);
            courseSO.setShowState(true);

            PageInfo<Course> pageInfo = courseService.findPag(courseSO);
            List<Course> hotCourseList = pageInfo.getList();

            mv.getModel().put("course", course);
            mv.getModel().put("videoList", videoList);
            mv.getModel().put("courseType", courseType);
            mv.getModel().put("teacher", teacher);
            mv.getModel().put("hotCourseList", hotCourseList);
        }
        return mv;
    }
}
