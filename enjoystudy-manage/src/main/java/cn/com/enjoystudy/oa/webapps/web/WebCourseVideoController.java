package cn.com.enjoystudy.oa.webapps.web;

import cn.com.enjoystudy.oa.bean.study.CourseVideo;
import cn.com.enjoystudy.oa.bean.study.CourseVideoSO;
import cn.com.enjoystudy.oa.service.study.CourseVideoService;
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
@RequestMapping("/web/course-video")
public class WebCourseVideoController extends BaseController {
    @Autowired
    private CourseVideoService courseVideoService;

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
        PageInfo<CourseVideo> pageInfo = courseVideoService.findVideoPage(so);

        JSONObject json = resultSuccess();
        json.put("datas", pageInfo.getList());
        json.put("total", pageInfo.getTotal());
        json.put("pages", pageInfo.getPages());
        return json;
    }

    @RequestMapping("details")
    public ModelAndView details(@RequestParam String id) {
        ModelAndView mv = new ModelAndView("web/course-video/details");
        CourseVideo video = courseVideoService.getById(id);
        mv.getModel().put("so", video);
        return mv;
    }

    @RequestMapping("view")
    public ModelAndView view(@RequestParam String id) {
        ModelAndView mv = new ModelAndView("web/course-video/view");
        CourseVideo video = courseVideoService.getById(id);

        if (null != video) {
            CourseVideoSO videoSO = new CourseVideoSO();
            videoSO.setShowState(true);
            videoSO.setCourseShowState(true);
            videoSO.setCourseId(video.getCourseId());
            videoSO.setPageNum(1);
            videoSO.setPageSize(5);
            PageInfo<CourseVideo> pageInfo = courseVideoService.findVideoPage(videoSO);
            mv.getModel().put("videoList", pageInfo.getList());
        }

        mv.getModel().put("video", video);
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
