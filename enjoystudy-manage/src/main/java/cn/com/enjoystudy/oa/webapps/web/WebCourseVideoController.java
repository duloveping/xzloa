package cn.com.enjoystudy.oa.webapps.web;

import cn.com.enjoystudy.oa.bean.base.EmployeeAccount;
import cn.com.enjoystudy.oa.bean.study.*;
import cn.com.enjoystudy.oa.common.Constants;
import cn.com.enjoystudy.oa.service.study.CourseService;
import cn.com.enjoystudy.oa.service.study.CourseVideoService;
import cn.com.enjoystudy.oa.service.study.EmployeeAccountCourseService;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
        CourseVideo video = courseVideoService.getById(id);
        Course course = courseService.getById(video.getCourseId());

        boolean freeState = true;
        boolean loginState = false;

        if (null != course.getFreeState() && course.getFreeState().equals(Boolean.FALSE)) {
            freeState = false;
            EmployeeAccount account = getCurrentUser();
            if (null != account) {
                loginState = true;
                if (account.getCategory().equals(Constants.ACCOUNT_CATEGORY_STUDENT)) {
                    EmployeeAccountCourseSO eacSo = new EmployeeAccountCourseSO();
                    eacSo.setEmployeeId(account.getId());
                    eacSo.setCourseId(video.getCourseId());

                    List<EmployeeAccountCourse> list = employeeAccountCourseService.list(eacSo);
                    if (CollectionUtils.isNotEmpty(list)) {
                        freeState = true;
                    }
                }
            }
        }

        ModelAndView mv;
        if (freeState) {
            mv = new ModelAndView("web/course-video/view");

            CourseVideoSO videoSO = new CourseVideoSO();
            videoSO.setShowState(true);
            videoSO.setCourseShowState(true);
            videoSO.setCourseId(video.getCourseId());
            videoSO.setPageNum(1);
            videoSO.setPageSize(5);
            PageInfo<CourseVideo> pageInfo = courseVideoService.findVideoPage(videoSO);
            mv.getModel().put("videoList", pageInfo.getList());
            mv.getModel().put("video", video);
        } else {
            if (loginState) {
                mv = new ModelAndView("web/course-video/video-buy-view");
                mv.getModel().put("course", course);
            } else {
                mv = new ModelAndView("redirect:/manage/login/index.jhtml");
            }

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
