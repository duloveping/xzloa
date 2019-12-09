package cn.com.enjoystudy.oa.webapps.manage.study;

import cn.com.enjoystudy.oa.bean.study.CourseVideoSO;
import cn.com.enjoystudy.oa.bean.study.TeachCourseSO;
import cn.com.enjoystudy.oa.service.study.CourseService;
import cn.com.enjoystudy.oa.service.study.CourseVideoService;
import cn.com.enjoystudy.oa.service.study.TeachCourseService;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage/study/teach-course")
public class TeachCourseController extends BaseController {
    @Autowired
    private TeachCourseService teachCourseService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseVideoService courseVideoService;

    @RequestMapping("teach-index")
    public ModelAndView teachIndex() {
        ModelAndView mv = new ModelAndView("manage/study/teach-course/teach-index");
        return mv;
    }

    @RequestMapping("teach-list")
    @ResponseBody
    public JSONObject teachList(TeachCourseSO so) {
        return resultSuccess(teachCourseService.teachCoursePage(so));
    }

    @RequestMapping("learn-index")
    public ModelAndView learnIndex() {
        ModelAndView mv = new ModelAndView("manage/study/teach-course/learn-index");
        return mv;
    }

    @RequestMapping("learn-list")
    @ResponseBody
    public JSONObject learnList(TeachCourseSO so) {
        so.setEmployeeId(getCurrentUser().getId());
        return resultSuccess(teachCourseService.learnCoursePage(so));
    }

    @RequestMapping("course-video-index")
    public ModelAndView courseVideoIndex(@RequestParam String courseId) {
        ModelAndView mv = new ModelAndView("manage/study/teach-course/course-video-index");
        mv.getModel().put("course", courseService.getById(courseId));
        return mv;
    }

    @RequestMapping("course-video-list")
    @ResponseBody
    public JSONObject courseVideoList(@RequestParam String courseId) {
        CourseVideoSO so = new CourseVideoSO();
        so.setCourseId(courseId);
        so.setShowState(true);
        return resultSuccess(courseVideoService.findVideoPage(so));
    }
}
