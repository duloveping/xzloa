package cn.com.enjoystudy.oa.webapps.manage.study;

import cn.com.enjoystudy.oa.bean.study.*;
import cn.com.enjoystudy.oa.service.study.StorePaperService;
import cn.com.enjoystudy.oa.service.study.StoreQuestionAnalysisService;
import cn.com.enjoystudy.oa.service.study.StoreQuestionItemService;
import cn.com.enjoystudy.oa.service.study.StoreQuestionService;
import cn.com.enjoystudy.oa.validation.manage.study.StoreQuestionValidator;
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
@RequestMapping("/manage/study/store-question")
public class StoreQuestionController extends BaseController {
    @Autowired
    private StorePaperService storePaperService;
    @Autowired
    private StoreQuestionService storeQuestionService;
    @Autowired
    private StoreQuestionAnalysisService storeQuestionAnalysisService;
    @Autowired
    private StoreQuestionItemService storeQuestionItemService;

    @RequestMapping("index")
    public ModelAndView index(@RequestParam("paperId") String paperId) {
        StorePaper paper = storePaperService.getById(paperId);

        ModelAndView mv = new ModelAndView("manage/study/store-question/index");
        mv.getModel().put("paper", paper);
        return mv;
    }

    @RequestMapping("list")
    @ResponseBody
    public JSONObject list(StoreQuestionSO so) {
        PageInfo<StoreQuestion> pageInfo = storeQuestionService.findPag(so);
        List<StoreQuestion> datas = storeQuestionService.list(so);

        JSONObject json = resultSuccess();
        json.put("datas", datas);
        json.put("total", pageInfo.getTotal());
        json.put("pages", pageInfo.getPages());
        return json;
    }

    @RequestMapping("edit")
    public ModelAndView edit(
            @RequestParam(value = "id", required = false) String id,
            @RequestParam(value = "paperId", required = false) String paperId) {
        ModelAndView mv = new ModelAndView("manage/study/store-question/edit");
        mv.getModel().put("id", id);
        mv.getModel().put("paperId", paperId);
        return mv;
    }

    @RequestMapping("save")
    @ResponseBody
    public JSONObject save(@RequestBody StoreQuestionSO so, BindingResult result) {
        StoreQuestionValidator validator = new StoreQuestionValidator();
        validator.validate(so, result);

        if (result.hasErrors()) {
            return resultError(result.getFieldError().getDefaultMessage());
        } else {
            StoreQuestion question = null;
            StoreQuestionAnalysis analysis = null;
            if (StringUtils.isNotBlank(so.getId())) {
                question = storeQuestionService.getById(so.getId());
            } else {
                question = new StoreQuestion();
                question.setPaperId(so.getPaperId());
            }
            question.setTitle(so.getTitle());
            question.setCategory(so.getCategory());
            question.setScore(so.getScore());
            if (StringUtils.isNotBlank(so.getId())) {
                storeQuestionService.update(question);

                analysis = storeQuestionAnalysisService.getAnalysisQuestionId(question.getId());
                analysis.setContent(so.getAnalysis());
                storeQuestionAnalysisService.update(analysis);

                storeQuestionItemService.deleteByQuestionId(question.getId());
            } else {
                storeQuestionService.insert(question);
                analysis = new StoreQuestionAnalysis();
                analysis.setQuestionId(question.getId());
                analysis.setContent(StringUtils.trimToNull(so.getAnalysis()));
                storeQuestionAnalysisService.insert(analysis);
            }

            if (null != so.getItemList() && so.getItemList().size() > 0) {
                for (StoreQuestionItem item : so.getItemList()) {
                    item.setQuestionId(question.getId());
                    storeQuestionItemService.insert(item);
                }
            }

            return resultSuccess();
        }
    }

    @RequestMapping("view")
    @ResponseBody
    public JSONObject view(@RequestParam("id") String id) {
        StoreQuestion data = storeQuestionService.getById(id);
        JSONObject json = resultSuccess();
        json.put("data", data);
        return json;
    }

    @RequestMapping("delete")
    @ResponseBody
    public JSONObject delete(@RequestParam String id) {
        storeQuestionService.deleteById(id);
        return resultSuccess();
    }
}
