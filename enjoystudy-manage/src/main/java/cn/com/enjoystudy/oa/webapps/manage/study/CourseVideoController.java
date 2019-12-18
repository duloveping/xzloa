package cn.com.enjoystudy.oa.webapps.manage.study;

import cn.com.enjoystudy.oa.bean.study.*;
import cn.com.enjoystudy.oa.service.study.CourseAttachmentService;
import cn.com.enjoystudy.oa.service.study.CourseService;
import cn.com.enjoystudy.oa.service.study.CourseVideoService;
import cn.com.enjoystudy.oa.validation.manage.study.CourseVideoValidator;
import cn.com.enjoystudy.oa.webapps.UploadController;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/manage/study/course-video")
public class CourseVideoController extends UploadController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseVideoService courseVideoService;
    @Autowired
    private CourseAttachmentService courseAttachmentService;

    @RequestMapping("index")
    public ModelAndView index(CourseVideoSO so) {
        Course course = courseService.getById(so.getCourseId());

        ModelAndView mv = new ModelAndView("manage/study/course-video/index");
        mv.getModel().put("course", course);
        return mv;
    }

    @RequestMapping("list")
    @ResponseBody
    public JSONObject list(CourseVideoSO so) {
        List<CourseVideo> datas = courseVideoService.list(so);
        JSONArray array = new JSONArray();
        if (null != datas && datas.size() > 0) {
            for (CourseVideo video : datas) {
                array.add(beanToJson(video));
            }
        }

        JSONObject json = resultSuccess();
        json.put("datas", array);
        return json;
    }

    @RequestMapping("edit")
    public ModelAndView edit(
            @RequestParam(value = "courseId", required = false) String courseId,
            @RequestParam(value = "id", required = false) String id) {
        CourseVideo video = new CourseVideo();
        video.setId(id);
        video.setCourseId(courseId);

        ModelAndView mv = new ModelAndView("manage/study/course-video/edit");
        mv.getModel().put("so", video);
        return mv;
    }

    @RequestMapping("save")
    @ResponseBody
    public JSONObject save(@RequestBody CourseVideoSO so, BindingResult result) {

        CourseVideoValidator validator = new CourseVideoValidator();
        validator.validate(so, result);

        if (result.hasErrors()) {
            return resultError(result.getFieldError().getDefaultMessage());
        } else {
            CourseVideo video = null;
            if (StringUtils.isNotBlank(so.getId())) {
                video = courseVideoService.getById(so.getId());
            } else {
                video = new CourseVideo();
                video.setCourseId(so.getCourseId());
            }
            video.setName(StringUtils.trim(so.getName()));
            video.setImage(StringUtils.trimToNull(so.getImage()));
            video.setIntroduction(StringUtils.trimToNull(so.getIntroduction()));
            video.setDescription(StringUtils.trimToNull(so.getDescription()));
            video.setFileName(so.getFileName());
            video.setFileType(so.getFileType());
            video.setFileSize(so.getFileSize());
            video.setFilePath(so.getFilePath());
            video.setUploadTime(so.getUploadTime());
            video.setSerialNumber(so.getSerialNumber());
            if (StringUtils.isNotBlank(so.getId())) {
                courseAttachmentService.deleteByVideoId(so.getId());
                courseVideoService.update(video);
            } else {
                courseVideoService.insert(video);
            }
            if (null != so.getAttachmentList() && so.getAttachmentList().size() > 0) {
                for (CourseAttachment attachment : so.getAttachmentList()) {
                    attachment.setCourseId(video.getCourseId());
                    attachment.setVideoId(video.getId());
                    courseAttachmentService.insert(attachment);
                }
            }

            return resultSuccess();
        }
    }

    @RequestMapping("delete")
    @ResponseBody
    public JSONObject delete(@RequestParam String id) {
        courseVideoService.deleteById(id);
        return resultSuccess();
    }

    @RequestMapping("attachment-list")
    @ResponseBody
    public JSONObject attachmentList(@RequestParam String videoId) {
        CourseAttachmentSO attachmentSO = new CourseAttachmentSO();
        attachmentSO.setVideoId(videoId);
        List<CourseAttachment> attachmentList = courseAttachmentService.list(attachmentSO);
        JSONObject json = resultSuccess();
        json.put("attachmentList", attachmentList);
        return json;
    }

    @RequestMapping("update-video-state")
    @ResponseBody
    public JSONObject updateVideoState(@RequestParam Boolean showState, @RequestParam String videoId) {
        courseVideoService.changeShowState(showState, videoId);
        return resultSuccess();
    }

    @RequestMapping("video-view")
    @ResponseBody
    public JSONObject videoView(@RequestParam String videoId) {
        CourseVideo video = courseVideoService.getById(videoId);
        if (null != video) {
            JSONObject json = resultSuccess();
            json.put("video", video);
            return json;
        } else {
            return resultError();
        }
    }

    @RequestMapping("course-view")
    @ResponseBody
    public JSONObject courseView(@RequestParam String courseId) {
        Course course = courseService.getById(courseId);
        if (null != course) {
            JSONObject json = resultSuccess();
            json.put("course", course);
            return json;
        } else {
            return resultError();
        }
    }

    @RequestMapping("change-show-state")
    @ResponseBody
    public JSONObject changeShowState(@RequestParam Boolean showState, @RequestParam String videoId) {
        courseVideoService.changeShowState(showState, videoId);
        return resultSuccess();
    }

    private JSONObject beanToJson(CourseVideo bean) {
        JSONObject obj = new JSONObject();
        obj.put("id", bean.getId());
        obj.put("courseId", bean.getCourseId());
        obj.put("name", bean.getName());
        obj.put("image", StringUtils.trimToEmpty(bean.getImage()));
        obj.put("fileName", StringUtils.trimToEmpty(bean.getFileName()));
        obj.put("fileType", StringUtils.trimToEmpty(bean.getFileType()));
        obj.put("fileSize", null == bean.getFileSize() ? 0 : bean.getFileSize());
        obj.put("showState", bean.getShowState());
        obj.put("uploadTime", null == bean.getUploadTime() ? "" :
                DateFormatUtils.format(bean.getUploadTime(), "yyyy-MM-dd HH:mm:ss"));
        obj.put("introduction", StringUtils.trimToEmpty(bean.getIntroduction()));
        obj.put("description", StringUtils.trimToEmpty(bean.getDescription()));
        return obj;
    }

}
