package cn.com.enjoystudy.oa.webapps.manage.web;

import cn.com.enjoystudy.oa.bean.web.CourseTrainPlan;
import cn.com.enjoystudy.oa.bean.web.CourseTrainPlanSO;
import cn.com.enjoystudy.oa.service.web.CourseTrainPlanService;
import cn.com.enjoystudy.oa.validation.manage.web.CourseTrainPlanValidator;
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

@Controller
@RequestMapping("/manage/web/course-train-plan")
public class CourseTrainPlanController extends BaseController {
    @Autowired
    private CourseTrainPlanService courseTrainPlanService;


    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("manage/web/course-train-plan/index");
        return mv;
    }

    @RequestMapping("list")
    @ResponseBody
    public JSONObject list(CourseTrainPlanSO so) {
        PageInfo<CourseTrainPlan> pageInfo = courseTrainPlanService.findPage(so);
        JSONObject json = resultSuccess();
        json.put("datas", pageInfo.getList());
        json.put("total", pageInfo.getTotal());
        json.put("pages", pageInfo.getPages());
        return json;
    }

    @RequestMapping("edit")
    public ModelAndView edit(@RequestParam(value = "id", required = false) String id) {
        CourseTrainPlan so = null;
        if  (StringUtils.isNotBlank(id)) {
            so = courseTrainPlanService.getById(id);
        } else {
            so = new CourseTrainPlan();
            so.setShowState(false);
            so.setTrainState(0);
        }

        ModelAndView mv = new ModelAndView("manage/web/course-train-plan/edit");
        mv.getModel().put("so", so);
        return mv;
    }

    @RequestMapping("save")
    @ResponseBody
    public JSONObject save(CourseTrainPlanSO so, BindingResult result) {

        CourseTrainPlanValidator validator = new CourseTrainPlanValidator();
        validator.validate(so, result);

        if (result.hasErrors()) {
            return resultError(result.getFieldError().getDefaultMessage());
        } else {
            CourseTrainPlan entity = null;
            if (StringUtils.isNotBlank(so.getId())) {
                entity = courseTrainPlanService.getById(so.getId());
            } else {
                entity = new CourseTrainPlan();
            }
            entity.setShowState(so.getShowState());
            entity.setTrainState(so.getTrainState());
            entity.setCourseName(StringUtils.trim(so.getCourseName()));
            entity.setCompanyName(StringUtils.trim(so.getCompanyName()));
            entity.setCompanyPhone(StringUtils.trimToNull(so.getCompanyPhone()));
            entity.setCompanyFax(StringUtils.trimToNull(so.getCompanyFax()));
            entity.setTrainStartTime(so.getTrainStartTime());
            entity.setTrainEndTime(so.getTrainEndTime());
            entity.setRegisterStartTime(so.getRegisterStartTime());
            entity.setRegisterEndTime(so.getRegisterEndTime());
            entity.setAdmissionStartTime(so.getAdmissionStartTime());
            entity.setAdmissionEndTime(so.getAdmissionEndTime());
            entity.setExamStartTime(so.getExamStartTime());
            entity.setExamEndTime(so.getExamEndTime());
            entity.setScoreStartTime(so.getScoreStartTime());
            entity.setScoreEndTime(so.getScoreEndTime());
            entity.setIssueStartTime(so.getIssueStartTime());
            entity.setIssueEndTime(so.getIssueEndTime());
            entity.setRegisterAmount(so.getRegisterAmount());
            entity.setRegisterAddress(StringUtils.trimToNull(so.getRegisterAddress()));
            entity.setExamAddress(StringUtils.trimToNull(so.getExamAddress()));
            entity.setTrainAddress(StringUtils.trimToNull(so.getTrainAddress()));
            entity.setTrainTeacherName(StringUtils.trimToNull(so.getTrainTeacherName()));
            entity.setTrainTeacherMobile(StringUtils.trimToNull(so.getTrainTeacherMobile()));
            entity.setTrainTeacherPhone(StringUtils.trimToNull(so.getTrainTeacherPhone()));
            entity.setTrainTeacherQq(StringUtils.trimToNull(so.getTrainTeacherQq()));
            entity.setTrainTeacherEmail(StringUtils.trimToNull(so.getTrainTeacherEmail()));
            entity.setLinkManName(StringUtils.trimToNull(so.getLinkManName()));
            entity.setLinkManMobile(StringUtils.trimToNull(so.getLinkManMobile()));
            entity.setLinkManPhone(StringUtils.trimToNull(so.getLinkManPhone()));
            entity.setLinkManQq(StringUtils.trimToNull(so.getLinkManQq()));
            entity.setLinkManEmail(StringUtils.trimToNull(so.getLinkManEmail()));
            entity.setClassTeacherName(StringUtils.trimToNull(so.getClassTeacherName()));
            entity.setClassTeacherMobile(StringUtils.trimToNull(so.getClassTeacherMobile()));
            entity.setClassTeacherPhone(StringUtils.trimToNull(so.getClassTeacherPhone()));
            entity.setClassTeacherQq(StringUtils.trimToNull(so.getClassTeacherQq()));
            entity.setClassTeacherEmail(StringUtils.trimToNull(so.getClassTeacherEmail()));
            if (StringUtils.isNotBlank(so.getId())) {
                courseTrainPlanService.update(entity);
            } else {
                courseTrainPlanService.insert(entity);
            }

            return resultSuccess();
        }
    }

    @RequestMapping("delete")
    @ResponseBody
    public JSONObject delete(@RequestParam String id) {
        courseTrainPlanService.deleteById(id);
        return resultSuccess();
    }
}
