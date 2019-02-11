package cn.com.enjoystudy.oa.webapps.manage.study;

import cn.com.enjoystudy.oa.bean.study.*;
import cn.com.enjoystudy.oa.service.study.CourseService;
import cn.com.enjoystudy.oa.service.study.CourseTypeService;
import cn.com.enjoystudy.oa.service.study.ExaminationConfigService;
import cn.com.enjoystudy.oa.service.study.TeacherService;
import cn.com.enjoystudy.oa.util.JsUtils;
import cn.com.enjoystudy.oa.validation.manage.study.CourseValidator;
import cn.com.enjoystudy.oa.webapps.UploadController;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/manage/study/course")
public class CourseController extends UploadController {
    @Autowired
    private CourseTypeService courseTypeService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ExaminationConfigService examinationConfigService;

    @RequestMapping("index")
    public ModelAndView index() {
        List<Teacher> teachers = teacherService.list(new TeacherSO());

        ModelAndView mv = new ModelAndView("manage/study/course/index");
        mv.getModel().put("teachers", teachers);
        return mv;
    }

    @RequestMapping("list")
    @ResponseBody
    public JSONObject list(CourseSO so) {
        PageInfo<Course> pageInfo = courseService.findPag(so);
        JSONObject json = resultSuccess();
        json.put("datas", pageInfo.getList());
        json.put("total", pageInfo.getTotal());
        json.put("pages", pageInfo.getPages());
        return json;
    }

    @RequestMapping("edit")
    public ModelAndView edit(@RequestParam(value = "id", required = false) String id) {
        List<Teacher> teachers = teacherService.list(new TeacherSO());

        Course course = null;
        if (StringUtils.isNotBlank(id)) {
            course = courseService.getById(id);
            CourseType courseType = courseTypeService.getById(course.getTypeId());
            course.setTypeName(courseType.getName());
        } else {
            course = new Course();
            course.setShowState(false);
            course.setRecommendState(false);
            course.setHotState(false);
        }

        ModelAndView mv = new ModelAndView("manage/study/course/edit");
        mv.getModel().put("so", course);
        mv.getModel().put("teachers", teachers);
        return mv;
    }

    @RequestMapping("save")
    @ResponseBody
    public JSONObject save(CourseSO so, BindingResult result) {
        CourseValidator validator = new CourseValidator();
        validator.validate(so, result);

        if (result.hasErrors()) {
            return resultError(result.getFieldError().getDefaultMessage());
        } else {
            Course course = null;
            if (StringUtils.isNotBlank(so.getId())) {
                course = courseService.getById(so.getId());
            } else {
                ExaminationConfig config = null;
                List<ExaminationConfig> configList = examinationConfigService.list(new ExaminationConfigSO());
                if (null != configList && configList.size() > 0) {
                    config = configList.get(0);
                } else {
                    config = new ExaminationConfig();
                    config.setStudyToExamState(false);
                    config.setDuration(100);
                    config.setTestType(1);
                    config.setPaperType(1);
                    config.setTotalScore(100);
                    config.setPassScore(60);
                    config.setTestAmount(1);
                    config.setQuestionAmount(100);
                    config.setQuestionType(1);
                    config.setSingleAmount(0);
                    config.setMultiAmount(0);
                    config.setCheckAmount(0);
                    config.setJudgeAmount(0);
                    config.setFillAmount(0);
                    examinationConfigService.insert(config);
                }

                course = new Course();
                course.setStudyToExamState(config.getStudyToExamState());
                course.setTotalScore(config.getTotalScore());
                course.setPassScore(config.getPassScore());
                course.setTestAmount(config.getTestAmount());
                course.setDuration(config.getDuration());
                course.setTestType(config.getTestType());
                course.setQuestionType(config.getQuestionType());
                course.setQuestionAmount(config.getQuestionAmount());
                course.setSingleAmount(config.getSingleAmount());
                course.setMultiAmount(config.getMultiAmount());
                course.setJudgeAmount(config.getJudgeAmount());
                course.setCheckAmount(config.getCheckAmount());
                course.setFillAmount(config.getFillAmount());
                course.setTestState(1);
            }
            course.setShowState(so.getShowState());
            course.setHotState(so.getHotState());
            course.setRecommendState(so.getRecommendState());
            course.setCode(StringUtils.trim(so.getCode()));
            course.setName(StringUtils.trim(so.getName()));
            course.setTeacherId(StringUtils.trimToNull(so.getTeacherId()));
            course.setTypeId(StringUtils.trimToNull(so.getTypeId()));
            course.setIntroduction(StringUtils.trimToNull(so.getIntroduction()));
            course.setDescription(StringUtils.trimToNull(so.getDescription()));
            course.setImage(StringUtils.trimToNull(so.getImage()));
            if (StringUtils.isNotBlank(so.getId())) {
                courseService.update(course);
            } else {
                courseService.insert(course);
            }
            return resultSuccess();
        }
    }

    @RequestMapping("check")
    public void check(
            @RequestParam(value = "code", required = false) String code,
            @RequestParam(value = "id", required = false) String id,
            HttpServletResponse response) {
        String flag = "true";

        CourseSO so = new CourseSO();
        so.setCode(code);
        so.setExceptId(id);

        JsUtils.writeText(response, flag);
    }

    @RequestMapping("delete")
    @ResponseBody
    public JSONObject delete(@RequestParam String id) {
        courseService.deleteById(id);
        return resultSuccess();
    }

    @RequestMapping("examination")
    public ModelAndView examinationIndex() {
        ModelAndView mv = new ModelAndView("manage/study/course/examination");
        return mv;
    }

    @RequestMapping("examination-edit")
    public ModelAndView examinationEdit(@RequestParam() String id) {
        Course course = courseService.getById(id);;
        ModelAndView mv = new ModelAndView("manage/study/course/examination-edit");
        mv.getModel().put("so", course);
        return mv;
    }

    @RequestMapping("examinationSave")
    @ResponseBody
    public JSONObject examinationS(CourseSO so) {
        Course course = courseService.getById(so.getId());
        course.setStudyToExamState(so.getStudyToExamState());
        course.setTotalScore(so.getTotalScore());
        course.setPassScore(so.getPassScore());
        course.setTestAmount(so.getTestAmount());
        course.setDuration(so.getDuration());
        course.setTestType(so.getTestType());
        course.setQuestionType(so.getQuestionType());
        course.setQuestionAmount(so.getQuestionAmount());
        course.setSingleAmount(so.getSingleAmount());
        course.setMultiAmount(so.getMultiAmount());
        course.setJudgeAmount(so.getJudgeAmount());
        course.setCheckAmount(so.getCheckAmount());
        course.setFillAmount(so.getFillAmount());
        courseService.update(course);
        return resultSuccess();
    }

    @RequestMapping("test-state")
    @ResponseBody
    public JSONObject updateTestState(@RequestParam("id") String id, @RequestParam("testState") Integer testState) {
        courseService.updateTestState(id, testState);
        return resultSuccess();
    }


}
