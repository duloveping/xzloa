package cn.com.enjoystudy.oa.webapps.manage.study;

import cn.com.enjoystudy.oa.bean.base.EmployeeAccount;
import cn.com.enjoystudy.oa.bean.study.*;
import cn.com.enjoystudy.oa.filter.ManageSessionFilter;
import cn.com.enjoystudy.oa.service.study.CourseService;
import cn.com.enjoystudy.oa.service.study.ExaminationConfigService;
import cn.com.enjoystudy.oa.service.study.StorePaperService;
import cn.com.enjoystudy.oa.service.study.StoreQuestionService;
import cn.com.enjoystudy.oa.validation.manage.study.StorePaperValidator;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/manage/study/store-paper")
public class StorePaperController extends BaseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private StorePaperService storePaperService;
    @Autowired
    private StoreQuestionService storeQuestionService;
    @Autowired
    private ExaminationConfigService examinationConfigService;

    @RequestMapping("paper-index")
    public ModelAndView paperIndex() {
        List<Course> courseList = courseService.list(new CourseSO());

        ModelAndView mv = new ModelAndView("manage/study/store-paper/paper-index");
        mv.getModel().put("courseList", courseList);
        return mv;
    }

    @RequestMapping("paper-list")
    @ResponseBody
    public JSONObject paperList(StorePaperSO so) {
        PageInfo<StorePaper> pageInfo = storePaperService.findPag(so);
        List<StorePaper> datas = pageInfo.getList();

        JSONObject json = resultSuccess();
        json.put("datas", datas);
        json.put("total", pageInfo.getTotal());
        json.put("pages", pageInfo.getPages());
        return json;
    }

    @RequestMapping("paper-edit")
    public ModelAndView paperEdit(@RequestParam(value = "id", required = false) String id) {
        List<Course> courseList = courseService.list(new CourseSO());

        StorePaper so = null;
        if (StringUtils.isNotBlank(id)) {
            so = storePaperService.getById(id);
        } else {
            so = new StorePaper();
            so.setShowState(false);

            List<ExaminationConfig> configList = examinationConfigService.list(new ExaminationConfigSO());
            if (null != configList && configList.size() > 0) {
                ExaminationConfig config = configList.get(0);
                so.setTestAmount(config.getTestAmount());
                so.setTotalScore(config.getTotalScore());
                so.setPassScore(config.getPassScore());
                so.setDuration(config.getDuration());
                so.setQuestionAmount(config.getQuestionAmount());
            } else {
                so.setTestAmount(1);
                so.setTotalScore(100);
                so.setPassScore(60);
                so.setDuration(120);
                so.setQuestionAmount(100);
            }
        }
        ModelAndView mv = new ModelAndView("manage/study/store-paper/paper-edit");
        mv.getModel().put("so", so);
        mv.getModel().put("courseList", courseList);
        return mv;
    }

    @RequestMapping("paper-view")
    @ResponseBody
    public ModelAndView paperView(@RequestParam("id") String id) {
        List<StoreQuestion> list4 = new ArrayList<StoreQuestion>();
        List<StoreQuestion> list1 = new ArrayList<StoreQuestion>();
        List<StoreQuestion> list2 = new ArrayList<StoreQuestion>();

        StorePaper paper = storePaperService.getById(id);
        StoreQuestionSO questionSO = new StoreQuestionSO();
        questionSO.setPaperId(paper.getId());
        List<StoreQuestion> questionList = storeQuestionService.list(questionSO);
        if (null != questionList && questionList.size() > 0) {
            for (StoreQuestion question : questionList) {
                question.setAnalysis(storeQuestionService.getAnalysis(question.getId()));
                question.setItemList(storeQuestionService.findItemsByQuestionId(question.getId()));
                if (question.getCategory().equals(1)) {
                    list1.add(question);
                } else if (question.getCategory().equals(2)) {
                    list2.add(question);
                } else if (question.getCategory().equals(4)) {
                    list4.add(question);
                }
            }
        }

        ModelAndView mv = new ModelAndView("manage/study/store-paper/paper-view");
        mv.getModel().put("list1", list1);
        mv.getModel().put("list2", list2);
        mv.getModel().put("list4", list4);
        mv.getModel().put("paper", paper);
        return mv;
    }

    @RequestMapping("paper-save")
    @ResponseBody
    public JSONObject paperSave(StorePaperSO so, BindingResult result) {
        StorePaperValidator validator = new StorePaperValidator();
        validator.validate(so, result);

        if (result.hasErrors()) {
            return resultError(result.getFieldError().getDefaultMessage());
        } else {
            Subject subject = SecurityUtils.getSubject();
            Object object = subject.getSession().getAttribute(ManageSessionFilter.DEFAULT_LOGIN_USER);
            EmployeeAccount account = (EmployeeAccount) object;

            StorePaper paper = null;
            if (StringUtils.isNotBlank(so.getId())) {
                paper = storePaperService.getById(so.getId());
            } else {
                paper = new StorePaper();
            }
            paper.setEditorId(account.getId());
            paper.setEditorName(account.getFullName());
            paper.setEditState(1);
            paper.setEditTime(new Date());
            paper.setShowState(so.getShowState());
            paper.setTitle(StringUtils.trim(so.getTitle()));
            paper.setCourseId(so.getCourseId());
            paper.setDuration(so.getDuration());
            paper.setTotalScore(so.getTotalScore());
            paper.setPassScore(so.getPassScore());
            paper.setTestAmount(so.getTestAmount());
            paper.setQuestionAmount(so.getQuestionAmount());
            if (StringUtils.isNotBlank(so.getId())) {
                storePaperService.update(paper);
            } else {
                storePaperService.insert(paper);
            }
            return resultSuccess();
        }
    }

    @RequestMapping("paper-delete")
    @ResponseBody
    public JSONObject paperDelete(@RequestParam("id") String id) {
        storePaperService.deleteById(id);
        return resultSuccess();
    }

    @RequestMapping("paper-submit")
    @ResponseBody
    public JSONObject paperSubmit(@RequestParam("id") String id) {
        StorePaper paper = storePaperService.getById(id);
        if (null != paper && paper.getEditState().equals(1)) {
            paper.setEditState(2);
            paper.setAuditState(1);
            storePaperService.update(paper);
            return resultSuccess();
        } else {
            return resultError("已提交审核");
        }
    }

    @RequestMapping("paper-audit")
    public ModelAndView paperAudit(@RequestParam("id") String id) {
        StorePaper so = storePaperService.getById(id);

        Subject subject = SecurityUtils.getSubject();
        Object object = subject.getSession().getAttribute(ManageSessionFilter.DEFAULT_LOGIN_USER);
        EmployeeAccount account = (EmployeeAccount) object;
        so.setAuditorId(account.getId());
        so.setAuditorName(account.getFullName());
        so.setAuditState(3);
        so.setAuditTime(new Date());

        ModelAndView mv = new ModelAndView("manage/study/store-paper/paper-audit");
        mv.getModel().put("so", so);
        return mv;
    }

    @RequestMapping("save-audit")
    @ResponseBody
    public JSONObject saveAudit(
            @RequestParam("id") String id,
            @RequestParam("auditState") Integer auditState,
            @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("auditTime") Date auditTime,
            @RequestParam("auditorMind") String auditorMind) {
        StorePaper paper = storePaperService.getById(id);
        if (null != paper && paper.getAuditState().equals(1)) {
            Subject subject = SecurityUtils.getSubject();
            Object object = subject.getSession().getAttribute(ManageSessionFilter.DEFAULT_LOGIN_USER);
            EmployeeAccount account = (EmployeeAccount) object;
            paper.setAuditorId(account.getId());
            paper.setAuditorName(account.getFullName());
            paper.setAuditorMind(auditorMind);
            paper.setAuditState(auditState);
            paper.setAuditTime(auditTime);
            if (auditState.equals(3)) {
                paper.setEditState(1);
            }
            storePaperService.update(paper);
            return resultSuccess();
        } else {
            return resultError("已提交审核");
        }
    }

    @RequestMapping("audit-index")
    public ModelAndView auditIndex() {
        ModelAndView mv = new ModelAndView("manage/study/store-paper/audit-index");
        return mv;
    }

    @RequestMapping("audit-list")
    @ResponseBody
    public JSONObject auditList(StorePaperSO so) {
        so.setAuditState(1);
        PageInfo<StorePaper> pageInfo = storePaperService.findPag(so);
        List<StorePaper> datas = pageInfo.getList();

        JSONObject json = resultSuccess();
        json.put("datas", datas);
        json.put("total", pageInfo.getTotal());
        json.put("pages", pageInfo.getPages());
        return json;
    }
}
