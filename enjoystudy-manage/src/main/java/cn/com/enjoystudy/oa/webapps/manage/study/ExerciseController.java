package cn.com.enjoystudy.oa.webapps.manage.study;

import cn.com.enjoystudy.oa.bean.study.*;
import cn.com.enjoystudy.oa.service.study.*;
import cn.com.enjoystudy.oa.validation.manage.study.CourseExerciseValidator;
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
@RequestMapping("/manage/study/exercise")
public class ExerciseController extends UploadController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseExerciseService courseExerciseService;
    @Autowired
    private CourseExerciseAnalysisService courseExerciseAnalysisService;
    @Autowired
    private CourseExerciseItemService courseExerciseItemService;
    @Autowired
    private EmployeeCourseExerciseService employeeCourseExerciseService;
    @Autowired
    private EmployeeCourseExerciseItemService employeeCourseExerciseItemService;
    @Autowired
    private EmployeeCourseExerciseAnalysisService employeeCourseExerciseAnalysisService;

    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("manage/study/exercise/index");
        return mv;
    }

    @RequestMapping("list")
    @ResponseBody
    public JSONObject list(CourseExerciseSO so) {
        PageInfo<CourseExercise> pageInfo = courseExerciseService.findPag(so);
        JSONObject json = resultSuccess();
        json.put("datas", pageInfo.getList());
        json.put("total", pageInfo.getTotal());
        json.put("pages", pageInfo.getPages());
        return json;
    }

    @RequestMapping("edit")
    public ModelAndView edit(@RequestParam(value = "id", required = false) String id) {
        ModelAndView mv = new ModelAndView("manage/study/exercise/edit");
        mv.getModel().put("id", id);
        mv.getModel().put("so", new CourseExercise());
        return mv;
    }

    @RequestMapping("save")
    @ResponseBody
    public JSONObject save(@RequestBody CourseExerciseSO so, BindingResult result) {

        CourseExerciseValidator validator = new CourseExerciseValidator();
        validator.validate(so, result);

        if (result.hasErrors()) {
            return resultError(result.getFieldError().getDefaultMessage());
        } else {
            CourseExercise exercise = null;
            CourseExerciseAnalysis analysis = null;
            if (StringUtils.isNotBlank(so.getId())) {
                exercise = courseExerciseService.getById(so.getId());
            } else {
                exercise = new CourseExercise();
                exercise.setCourseId(so.getCourseId());
            }
            exercise.setTitle(so.getTitle());
            exercise.setCategory(so.getCategory());
            exercise.setScore(so.getScore());
            exercise.setCourseId(so.getCourseId());
            exercise.setVideoId(so.getVideoId());
            if (StringUtils.isNotBlank(so.getId())) {
                courseExerciseService.update(exercise);

                analysis = courseExerciseAnalysisService.getAnalysisExerciseId(exercise.getId());
                analysis.setContent(so.getAnalysis());
                courseExerciseAnalysisService.update(analysis);

                courseExerciseItemService.deleteByExerciseId(exercise.getId());
            } else {
                courseExerciseService.insert(exercise);
                analysis = new CourseExerciseAnalysis();
                analysis.setCourseId(so.getCourseId());
                analysis.setVideoId(so.getVideoId());
                analysis.setExerciseId(exercise.getId());
                analysis.setContent(StringUtils.trimToNull(so.getAnalysis()));
                courseExerciseAnalysisService.insert(analysis);
            }

            if (null != so.getItemList() && so.getItemList().size() > 0) {
                for (CourseExerciseItem item : so.getItemList()) {
                    item.setCourseId(exercise.getCourseId());
                    item.setVideoId(exercise.getVideoId());
                    item.setExerciseId(exercise.getId());
                    courseExerciseItemService.insert(item);
                }
            }

            return resultSuccess();
        }
    }

    @RequestMapping("view")
    @ResponseBody
    public JSONObject view(@RequestParam("id") String id) {
        CourseExercise data = courseExerciseService.getById(id);
        JSONObject json = resultSuccess();
        json.put("data", data);
        return json;
    }

    @RequestMapping("delete")
    @ResponseBody
    public JSONObject delete(@RequestParam String id) {
        courseExerciseService.deleteById(id);
        return resultSuccess();
    }

    @RequestMapping("course-list")
    @ResponseBody
    public JSONObject courseList() {
        List<Course> datas = courseExerciseService.findAllCourse();
        JSONObject json = resultSuccess();
        json.put("datas", datas);
        return json;
    }

    @RequestMapping("test")
    public ModelAndView test(@RequestParam("courseId") String courseId) {
        List<Question> questionList = courseExerciseService.findQuestionByCourseId(courseId);
        ModelAndView mv = new ModelAndView("manage/study/exercise/test");
        mv.getModel().put("questionList", questionList);
        return mv;
    }
}
