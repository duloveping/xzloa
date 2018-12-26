package cn.com.enjoystudy.oa.webapps.manage.study;

import cn.com.enjoystudy.oa.bean.study.*;
import cn.com.enjoystudy.oa.service.study.CourseExaminationAnalysisService;
import cn.com.enjoystudy.oa.service.study.CourseExaminationItemService;
import cn.com.enjoystudy.oa.service.study.CourseExaminationService;
import cn.com.enjoystudy.oa.validation.manage.study.CourseExaminationValidator;
import cn.com.enjoystudy.oa.webapps.UploadController;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/manage/study/examination")
public class ExaminationController extends UploadController {
    @Autowired
    private CourseExaminationService courseExaminationService;
    @Autowired
    private CourseExaminationAnalysisService courseExaminationAnalysisService;
    @Autowired
    private CourseExaminationItemService courseExaminationItemService;

    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("manage/study/examination/index");
        return mv;
    }

    @RequestMapping("list")
    @ResponseBody
    public JSONObject list(CourseExaminationSO so) {
        PageInfo<CourseExamination> pageInfo = courseExaminationService.findPag(so);
        JSONObject json = resultSuccess();
        json.put("datas", pageInfo.getList());
        json.put("total", pageInfo.getTotal());
        json.put("pages", pageInfo.getPages());
        return json;
    }

    @RequestMapping("edit")
    public ModelAndView edit(@RequestParam(value = "id", required = false) String id) {
        ModelAndView mv = new ModelAndView("manage/study/examination/edit");
        mv.getModel().put("id", id);
        mv.getModel().put("so", new CourseExamination());
        return mv;
    }

    @RequestMapping("save")
    @ResponseBody
    public JSONObject save(@RequestBody CourseExaminationSO so, BindingResult result) {

        CourseExaminationValidator validator = new CourseExaminationValidator();
        validator.validate(so, result);

        if (result.hasErrors()) {
            return resultError(result.getFieldError().getDefaultMessage());
        } else {
            CourseExamination examination = null;
            CourseExaminationAnalysis analysis = null;
            if (StringUtils.isNotBlank(so.getId())) {
                examination = courseExaminationService.getById(so.getId());
            } else {
                examination = new CourseExamination();
                examination.setCourseId(so.getCourseId());
            }
            examination.setTitle(so.getTitle());
            examination.setCategory(so.getCategory());
            examination.setScore(so.getScore());
            examination.setCourseId(so.getCourseId());
            examination.setVideoId(so.getVideoId());
            if (StringUtils.isNotBlank(so.getId())) {
                courseExaminationService.update(examination);

                analysis = courseExaminationAnalysisService.getAnalysisExaminationId(examination.getId());
                analysis.setContent(so.getAnalysis());
                courseExaminationAnalysisService.update(analysis);

                courseExaminationItemService.deleteByExaminationId(examination.getId());
            } else {
                courseExaminationService.insert(examination);
                analysis = new CourseExaminationAnalysis();
                analysis.setCourseId(so.getCourseId());
                analysis.setVideoId(so.getVideoId());
                analysis.setExaminationId(examination.getId());
                analysis.setContent(StringUtils.trimToNull(so.getAnalysis()));
                courseExaminationAnalysisService.insert(analysis);
            }

            if (null != so.getItemList() && so.getItemList().size() > 0) {
                for (CourseExaminationItem item : so.getItemList()) {
                    item.setCourseId(examination.getCourseId());
                    item.setVideoId(examination.getVideoId());
                    item.setExaminationId(examination.getId());
                    courseExaminationItemService.insert(item);
                }
            }

            return resultSuccess();
        }
    }

    @RequestMapping("view")
    @ResponseBody
    public JSONObject view(@RequestParam("id") String id) {
        CourseExamination data = courseExaminationService.getById(id);
        JSONObject json = resultSuccess();
        json.put("data", data);
        return json;
    }

    @RequestMapping("delete")
    @ResponseBody
    public JSONObject delete(@RequestParam String id) {
        courseExaminationService.deleteById(id);
        return resultSuccess();
    }

    @RequestMapping("course-list")
    @ResponseBody
    public JSONObject courseList() {
        List<Course> datas = courseExaminationService.findAllCourse();
        JSONObject json = resultSuccess();
        json.put("datas", datas);
        return json;
    }
}
