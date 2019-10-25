package cn.com.enjoystudy.oa.webapps.manage.study;

import cn.com.enjoystudy.oa.bean.study.*;
import cn.com.enjoystudy.oa.service.study.CourseAttachmentService;
import cn.com.enjoystudy.oa.service.study.CourseService;
import cn.com.enjoystudy.oa.webapps.UploadController;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/manage/study/course-attachment")
public class CourseAttachmentController extends UploadController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseAttachmentService courseAttachmentService;

    @RequestMapping("index")
    public ModelAndView index(CourseVideoSO so) {
        Course course = courseService.getById(so.getCourseId());

        ModelAndView mv = new ModelAndView("manage/study/course-attachment/index");
        mv.getModel().put("course", course);
        return mv;
    }

    @RequestMapping("list")
    @ResponseBody
    public JSONObject list(CourseAttachmentSO so) {
        List<CourseAttachment> datas = courseAttachmentService.list(so);
        JSONObject json = resultSuccess();
        json.put("datas", datas);
        return json;
    }

    @RequestMapping("edit")
    public ModelAndView edit(
            @RequestParam(value = "courseId", required = false) String courseId,
            @RequestParam(value = "id", required = false) String id) {
        CourseAttachment attachment = new CourseAttachment();
        if  (StringUtils.isNotBlank(id)) {
            attachment = courseAttachmentService.getById(StringUtils.trim(id));
        } else {
            Course course = courseService.getById(courseId);
            attachment.setCourse(course);
            attachment.setCourseId(course.getId());
        }
        ModelAndView mv = new ModelAndView("manage/study/course-attachment/edit");
        mv.getModel().put("so", attachment);
        return mv;
    }

    @RequestMapping("save")
    @ResponseBody
    public JSONObject save(@RequestBody CourseSO so) {
        if (null != so.getAttachmentList() && so.getAttachmentList().size() > 0) {
            for (CourseAttachment attachment : so.getAttachmentList()) {
                courseAttachmentService.insert(attachment);
            }
        }
        return resultSuccess();
    }

    @RequestMapping("delete")
    @ResponseBody
    public JSONObject delete(@RequestParam String id) {
        courseAttachmentService.deleteById(id);
        return resultSuccess();
    }
}