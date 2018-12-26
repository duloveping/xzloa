package cn.com.enjoystudy.oa.webapps.manage.study;

import cn.com.enjoystudy.oa.bean.study.Course;
import cn.com.enjoystudy.oa.bean.study.CourseSO;
import cn.com.enjoystudy.oa.bean.study.ExaminationPaper;
import cn.com.enjoystudy.oa.bean.study.ExaminationPaperSO;
import cn.com.enjoystudy.oa.service.study.CourseService;
import cn.com.enjoystudy.oa.service.study.ExaminationPaperService;
import cn.com.enjoystudy.oa.validation.manage.study.ExaminationPaperValidator;
import cn.com.enjoystudy.oa.webapps.BaseController;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/manage/study/examination-paper")
public class ExaminationPaperController extends BaseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private ExaminationPaperService examinationPaperService;

    @RequestMapping("index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        List<Course> courseList = courseService.list(new CourseSO());

        ModelAndView mv = new ModelAndView("manage/study/examination-paper/index");
        mv.getModel().put("courseList", courseList);
        return mv;
    }

    @RequestMapping("list")
    @ResponseBody
    public JSONObject list(ExaminationPaperSO so) {
        PageInfo<ExaminationPaper> pageInfo = examinationPaperService.findPag(so);
        List<ExaminationPaper> datas = pageInfo.getList();
        JSONObject json = resultSuccess();
        json.put("datas", datas);
        json.put("total", pageInfo.getTotal());
        json.put("pages", pageInfo.getPages());
        return json;
    }

    @RequestMapping("edit")
    public ModelAndView edit(@RequestParam(value = "id", required = false) String id) {
        List<Course> courseList = courseService.list(new CourseSO());

        ExaminationPaper paper = null;
        if (StringUtils.isNotBlank(id)) {
            paper = examinationPaperService.getById(id);
        } else {
            paper = new ExaminationPaper();
        }

        ModelAndView mv = new ModelAndView("manage/study/examination-paper/edit");
        mv.getModel().put("so", paper);
        mv.getModel().put("courseList", courseList);
        return mv;
    }

    @RequestMapping("save")
    @ResponseBody
    public JSONObject save(ExaminationPaperSO so, BindingResult result) {
        ExaminationPaperValidator validator = new ExaminationPaperValidator();
        validator.validate(so, result);

        if (result.hasErrors()) {
            return resultError(result.getFieldError().getDefaultMessage());
        } else {
            ExaminationPaper paper = null;
            if (StringUtils.isNotBlank(so.getId())) {
                paper = examinationPaperService.getById(so.getId());
            } else {
                paper = new ExaminationPaper();
                paper.setFillAmount(0);
                paper.setCheckAmount(0);
            }
            paper.setTitle(StringUtils.trim(so.getTitle()));
            paper.setCourseId(so.getCourseId());
            paper.setTestState(so.getTestState());
            paper.setTestType(so.getTestType());
            paper.setDuration(so.getDuration());
            paper.setTestType(so.getTestType());
            paper.setTotalScore(so.getTotalScore());
            paper.setPassScore(so.getPassScore());
            paper.setTestAmount(so.getTestAmount());
            paper.setQuestionAmount(so.getQuestionAmount());
            paper.setQuestionType(so.getQuestionType());
            paper.setSingleAmount(so.getSingleAmount());
            paper.setMultiAmount(so.getMultiAmount());
            paper.setCheckAmount(so.getCheckAmount());
            paper.setFillAmount(so.getFillAmount());
            paper.setJudgeAmount(so.getJudgeAmount());
            if (StringUtils.isNotBlank(so.getId())) {
                examinationPaperService.update(paper);
            } else {
                examinationPaperService.insert(paper);
            }
            return resultSuccess();
        }
    }

    @RequestMapping("delete")
    @ResponseBody
    public JSONObject delete(@RequestParam String id) {
        examinationPaperService.deleteById(id);
        return resultSuccess();
    }
}
