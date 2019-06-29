package cn.com.enjoystudy.oa.webapps.manage.study;

import cn.com.enjoystudy.oa.bean.base.EmployeeAccount;
import cn.com.enjoystudy.oa.bean.study.*;
import cn.com.enjoystudy.oa.common.Constants;
import cn.com.enjoystudy.oa.filter.ManageSessionFilter;
import cn.com.enjoystudy.oa.service.study.CourseService;
import cn.com.enjoystudy.oa.service.study.CourseVideoService;
import cn.com.enjoystudy.oa.service.study.EmployeeAccountCourseService;
import cn.com.enjoystudy.oa.service.study.EmployeeCourseStudyService;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/manage/study/course-study")
public class CourseStudyController extends BaseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private EmployeeCourseStudyService employeeCourseStudyService;
    @Autowired
    private CourseVideoService courseVideoService;
    @Autowired
    private EmployeeAccountCourseService employeeAccountCourseService;

    @RequestMapping("index")
    public ModelAndView index() {
        List<Course> courseList;

        EmployeeAccount account = getCurrentUser();
        if (account.getCategory().equals(Constants.ACCOUNT_CATEGORY_STUDENT)) {
            EmployeeAccountCourseSO courseSO = new EmployeeAccountCourseSO();
            courseSO.setEmployeeId(account.getId());
            courseList = employeeAccountCourseService.findCourseByEmployeeId(account.getId());
        } else {
            courseList = courseService.list(new CourseSO());
        }

        ModelAndView mv = new ModelAndView("manage/study/course-study/index");
        mv.getModel().put("courseList", courseList);
        return mv;
    }

    @RequestMapping("list")
    @ResponseBody
    public JSONObject list(EmployeeCourseStudySO so) {
        EmployeeAccount account = getCurrentUser();
        so.setEmployeeId(account.getId());
        so.setVideoState(true);

        if (account.getCategory().equals(Constants.ACCOUNT_CATEGORY_STUDENT)) {
            if (StringUtils.isBlank(so.getCourseId())) {
                EmployeeAccountCourseSO courseSO = new EmployeeAccountCourseSO();
                courseSO.setEmployeeId(account.getId());
                List<Course> courseList = employeeAccountCourseService.findCourseByEmployeeId(account.getId());
                String[] courseIds = new String[courseList.size()];
                int i = 0;
                for (Course course : courseList) {
                    courseIds[i++] = course.getId();
                }
                so.setCourseIds(courseIds);
            }

        }


        PageInfo<EmployeeCourseStudy> pageInfo = employeeCourseStudyService.findPag(so);
        List<EmployeeCourseStudy> datas = pageInfo.getList();

        JSONObject json = resultSuccess();
        json.put("datas", datas);
        json.put("total", pageInfo.getTotal());
        json.put("pages", pageInfo.getPages());
        return json;
    }

    @RequestMapping("study")
    public ModelAndView study(@RequestParam("videoId") String videoId) {
        CourseVideo video = courseVideoService.getById(videoId);

        Subject subject = SecurityUtils.getSubject();
        Object object = subject.getSession().getAttribute(ManageSessionFilter.DEFAULT_LOGIN_USER);
        if (null != object) {
            EmployeeAccount account = (EmployeeAccount) object;

            EmployeeCourseStudy study = new EmployeeCourseStudy();
            study.setCourseId(video.getCourseId());
            study.setVideoId(video.getId());
            study.setEmployeeId(account.getId());
            study.setStudyTime(new Date());
            employeeCourseStudyService.insert(study);
        }

        ModelAndView mv = new ModelAndView("manage/study/course-study/study");
        mv.getModel().put("video", video);
        return mv;
    }

    @RequestMapping("course-index")
    public ModelAndView courseIndex() {
        ModelAndView mv = new ModelAndView("manage/study/course-study/course-index");
        return mv;
    }

    @RequestMapping("course-list")
    @ResponseBody
    public JSONObject courseList(CourseSO so) {
        PageInfo<Course> pageInfo;

        Subject subject = SecurityUtils.getSubject();
        Object object = subject.getSession().getAttribute(ManageSessionFilter.DEFAULT_LOGIN_USER);
        EmployeeAccount account = (EmployeeAccount) object;

        if (account.getCategory().equals(Constants.ACCOUNT_CATEGORY_STUDENT)) {
            EmployeeAccountCourseSO courseSO = new EmployeeAccountCourseSO();
            courseSO.setEmployeeId(account.getId());
            pageInfo = employeeAccountCourseService.findCoursePageByEmployeeId(courseSO);
        } else {
            pageInfo = courseService.findPag(so);
        }

        List<Course> datas = pageInfo.getList();

        JSONObject json = resultSuccess();
        json.put("datas", datas);
        json.put("total", pageInfo.getTotal());
        json.put("pages", pageInfo.getPages());
        return json;
    }
}
