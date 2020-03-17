package cn.com.enjoystudy.oa.webapps.web;

import cn.com.enjoystudy.oa.bean.base.EmployeeAccount;
import cn.com.enjoystudy.oa.bean.shop.StudentCourseList;
import cn.com.enjoystudy.oa.bean.shop.StudentCourseListSO;
import cn.com.enjoystudy.oa.bean.study.*;
import cn.com.enjoystudy.oa.service.shop.StudentCourseListService;
import cn.com.enjoystudy.oa.service.study.*;
import cn.com.enjoystudy.oa.webapps.UploadController;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/web/course")
public class WebCourseController extends UploadController {
    private static final Logger LOG = LoggerFactory.getLogger(WebCourseController.class);
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseVideoService courseVideoService;
    @Autowired
    private CourseTypeService courseTypeService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CourseAttachmentService courseAttachmentService;
    @Autowired
    private StudentCourseListService studentCourseListService;
    @Autowired
    private EmployeeAccountCourseService employeeAccountCourseService;
    @Autowired
    private TeachCourseService teachCourseService;

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
            EmployeeAccount account = getCurrentUser();
            boolean buyState = false;
            if (null != account) {
                TeachCourseSO teachCourseSO = new TeachCourseSO();
                teachCourseSO.setEmployeeId(account.getId());
                teachCourseSO.setCourseId(course.getId());
                List<TeachCourse> teachCourseList = teachCourseService.learnCourseList(teachCourseSO);
                if (CollectionUtils.isNotEmpty(teachCourseList)) {
                    buyState = true;
                }
            }


            CourseType courseType = courseTypeService.getById(course.getTypeId());
            Teacher teacher = teacherService.getById(course.getTeacherId());

            CourseVideoSO videoSO = new CourseVideoSO();
            videoSO.setCourseShowState(true);
            videoSO.setShowState(true);
            videoSO.setCourseId(course.getId());

            List<CourseVideo> videoList = courseVideoService.list(videoSO);

            CourseAttachmentSO attachmentSO = new CourseAttachmentSO();
            attachmentSO.setCourseId(course.getId());
            List<CourseAttachment> attachmentList = courseAttachmentService.list(attachmentSO);

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
            mv.getModel().put("attachmentList", attachmentList);
            mv.getModel().put("student", account);
            mv.getModel().put("buyState", buyState);
        }
        return mv;
    }

    @RequestMapping("attachment-download")
    public ModelAndView attachmentDownload(@RequestParam String id, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = null;

        EmployeeAccount account = getCurrentUser();

        if (null != account) {
            boolean flag = false;

            CourseAttachment attachment = courseAttachmentService.getById(id);
            Course course = courseService.getById(attachment.getCourseId());

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
                        flag = true;
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
                                flag = true;
                                break;
                            }
                        }
                    }
                }
            }

            if (flag) {
                download(attachment.getFileName(), attachment.getFilePath(), request, response);
            } else {
                mv = new ModelAndView("redirect:/web/course/list.jhtml");
            }
        } else {
            mv = new ModelAndView("redirect:/manage/login/index.jhtml");
        }
        return mv;
    }
}
