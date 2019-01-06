package cn.com.enjoystudy.oa.webapps.manage.register.examination;

import cn.com.enjoystudy.oa.bean.register.examination.ExaminationPlan;
import cn.com.enjoystudy.oa.bean.register.examination.ExaminationPlanList;
import cn.com.enjoystudy.oa.bean.register.examination.ExaminationPlanListSO;
import cn.com.enjoystudy.oa.bean.register.examination.ExaminationPlanSO;
import cn.com.enjoystudy.oa.bean.study.*;
import cn.com.enjoystudy.oa.service.register.examination.ExaminationPlanListService;
import cn.com.enjoystudy.oa.service.register.examination.ExaminationPlanService;
import cn.com.enjoystudy.oa.service.study.CertificateService;
import cn.com.enjoystudy.oa.service.study.CourseService;
import cn.com.enjoystudy.oa.validation.manage.register.examination.ExaminationPlanValidator;
import cn.com.enjoystudy.oa.webapps.BaseController;
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
@RequestMapping("/manage/register/examination/examination-plan")
public class ExaminationPlanController extends BaseController {
    @Autowired
    private ExaminationPlanService examinationPlanService;
    @Autowired
    private ExaminationPlanListService examinationPlanListService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private CertificateService certificateService;

    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("manage/register/examination/examination-plan/index");
        return mv;
    }

    @RequestMapping("list")
    @ResponseBody
    public JSONObject list(ExaminationPlanSO so) {
        PageInfo<ExaminationPlan> pageInfo = examinationPlanService.findPage(so);
        JSONObject json = resultSuccess();
        json.put("datas", pageInfo.getList());
        json.put("total", pageInfo.getTotal());
        json.put("pages", pageInfo.getPages());
        return json;
    }

    @RequestMapping("edit")
    public ModelAndView edit(@RequestParam(value = "id", required = false) String id) {
        List<Course> courseList = courseService.list(new CourseSO());
        List<Certificate> certificateList = certificateService.list(new CertificateSO());

        ModelAndView mv = new ModelAndView("manage/register/examination/examination-plan/edit");
        mv.getModel().put("courseList", courseList);
        mv.getModel().put("certificateList", certificateList);

        ExaminationPlan plan = null;
        if (StringUtils.isNotBlank(id)) {
            plan = examinationPlanService.getById(id);

            ExaminationPlanListSO listSO = new ExaminationPlanListSO();
            listSO.setPlanId(plan.getId());
            List<ExaminationPlanList> planList = examinationPlanListService.list(listSO);

            mv.getModel().put("so", plan);
            mv.getModel().put("planList", planList);
        } else {
            plan = new ExaminationPlan();
            plan.setShowState(false);
            mv.getModel().put("so", plan);
        }
        return mv;
    }

    @RequestMapping("save")
    @ResponseBody
    public JSONObject save(@RequestBody ExaminationPlanSO so, BindingResult result) {

        ExaminationPlanValidator validator = new ExaminationPlanValidator();
        validator.validate(so, result);

        if (result.hasErrors()) {
            return resultError(result.getFieldError().getDefaultMessage());
        } else {
            ExaminationPlan plan = new ExaminationPlan();
            if (StringUtils.isNotBlank(so.getId())) {
                plan = examinationPlanService.getById(so.getId());
            }
            plan.setTitle(so.getTitle());
            plan.setShowState(so.getShowState());
            plan.setContent(StringUtils.trimToNull(so.getContent()));
            if (StringUtils.isNotBlank(so.getId())) {
                examinationPlanListService.deleteByPlanId(plan.getId());
                examinationPlanService.update(plan);
            } else {
                examinationPlanService.insert(plan);
            }

            if (null != so.getPlanList() && so.getPlanList().size() > 0) {
                for (ExaminationPlanList planList : so.getPlanList()) {
                    planList.setPlanId(plan.getId());
                    examinationPlanListService.insert(planList);
                }

            }

            return resultSuccess();
        }
    }

    @RequestMapping("view")
    @ResponseBody
    public JSONObject view(@RequestParam("id") String id) {
        ExaminationPlan data = examinationPlanService.getById(id);
        JSONObject json = resultSuccess();
        json.put("data", data);
        return json;
    }

    @RequestMapping("delete")
    @ResponseBody
    public JSONObject delete(@RequestParam String id) {
        examinationPlanService.deleteById(id);
        return resultSuccess();
    }

    @RequestMapping("change-show-state")
    @ResponseBody
    public JSONObject changeShowState(@RequestParam Boolean showState, @RequestParam String id) {
        examinationPlanService.updateShowState(showState, id);
        return resultSuccess();
    }

    @RequestMapping("course-list")
    @ResponseBody
    public JSONObject courseList() {
        List<Course> courseList = courseService.list(new CourseSO());
        JSONObject json = resultSuccess();
        json.put("datas", courseList);
        return json;
    }

    @RequestMapping("certificate-list")
    @ResponseBody
    public JSONObject certificateList() {
        List<Certificate> certificateList = certificateService.list(new CertificateSO());
        JSONObject json = resultSuccess();
        json.put("datas", certificateList);
        return json;
    }
}
