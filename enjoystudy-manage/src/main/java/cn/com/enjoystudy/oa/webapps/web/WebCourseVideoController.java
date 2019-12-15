package cn.com.enjoystudy.oa.webapps.web;

import cn.com.enjoystudy.oa.bean.base.EmployeeAccount;
import cn.com.enjoystudy.oa.bean.shop.StudentCourseList;
import cn.com.enjoystudy.oa.bean.shop.StudentCourseListSO;
import cn.com.enjoystudy.oa.bean.study.Course;
import cn.com.enjoystudy.oa.bean.study.CourseVideo;
import cn.com.enjoystudy.oa.bean.study.CourseVideoSO;
import cn.com.enjoystudy.oa.bean.study.EmployeeAccountCourseSO;
import cn.com.enjoystudy.oa.service.shop.StudentCourseListService;
import cn.com.enjoystudy.oa.service.study.CourseService;
import cn.com.enjoystudy.oa.service.study.CourseVideoService;
import cn.com.enjoystudy.oa.service.study.EmployeeAccountCourseService;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/web/course-video")
public class WebCourseVideoController extends BaseController {
    @Autowired
    private CourseVideoService courseVideoService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private EmployeeAccountCourseService employeeAccountCourseService;
    @Autowired
    private StudentCourseListService studentCourseListService;

    @RequestMapping("list")
    public ModelAndView list(CourseVideoSO so) {
        ModelAndView mv = new ModelAndView("web/course-video/list");
        mv.getModel().put("so", so);
        return mv;
    }

    @RequestMapping("search")
    @ResponseBody
    public JSONObject search(CourseVideoSO so) {
        so.setCourseShowState(true);
        return resultSuccess(courseVideoService.findVideoPage(so));
    }

    @RequestMapping("details")
    public ModelAndView details(@RequestParam String id) {
        ModelAndView mv = new ModelAndView("web/course-video/details");
        mv.getModel().put("so", courseVideoService.getById(id));
        return mv;
    }

    @RequestMapping("view")
    public ModelAndView view(@RequestParam String id) {
        ModelAndView mv;

        EmployeeAccount account = getCurrentUser();

        if (null != account) {
            mv = new ModelAndView("web/course-video/video-buy-view");
            CourseVideo video = courseVideoService.getById(id);
            Course course = courseService.getById(video.getCourseId());
            mv.getModel().put("video", video);
            mv.getModel().put("course", course);

            // 判断课程是否免费
            if (null != course.getFreeState() && course.getFreeState().equals(Boolean.FALSE)) {
                StudentCourseListSO courseListSO = new StudentCourseListSO();
                courseListSO.setCourseId(course.getId());
                courseListSO.setAccountId(account.getId());
                List<StudentCourseList> studentCourseList = studentCourseListService.list(courseListSO);

                // 判断是否已经购买课程
                if (CollectionUtils.isNotEmpty(studentCourseList)) {
                    Date date = new Date();
                    StudentCourseList courseList = studentCourseList.get(0);

                    if (date.before(courseList.getExpireTime())) {
                        mv = new ModelAndView("web/course-video/view");
                        mv.getModel().put("video", video);
                        mv.getModel().put("course", course);
                    }
                } else {
                    // 判断是否已被授课
                    EmployeeAccountCourseSO courseSO = new EmployeeAccountCourseSO();
                    courseSO.setEmployeeId(account.getId());
                    courseSO.setCourseId(course.getId());
                    List<Course> courseList = employeeAccountCourseService.findCourseByEmployeeId(account.getId());
                    if (CollectionUtils.isNotEmpty(courseList)) {
                        for (Course po : courseList) {
                            if (po.getId().equals(course.getId())) {
                                mv = new ModelAndView("web/course-video/view");
                                mv.getModel().put("video", video);
                                mv.getModel().put("course", course);
                                break;
                            }
                        }
                    }
                }
            }
        } else {
            mv = new ModelAndView("redirect:/manage/login/index.jhtml");
        }
        return mv;
    }

    @RequestMapping("updateClickAmount")
    @ResponseBody
    public JSONObject updateClickAmount(@RequestParam String id) {
       courseVideoService.updateClickAmount(id);

        JSONObject json = resultSuccess();
        return json;
    }
}
