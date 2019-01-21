package cn.com.enjoystudy.oa.webapps.manage.study;

import cn.com.enjoystudy.oa.bean.study.ExaminationConfig;
import cn.com.enjoystudy.oa.bean.study.ExaminationConfigSO;
import cn.com.enjoystudy.oa.service.study.ExaminationConfigService;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/manage/study/examination-config")
public class ExaminationConfigController extends BaseController {
    @Autowired
    private ExaminationConfigService examinationConfigService;

    @RequestMapping("edit")
    public ModelAndView edit() {
        List<ExaminationConfig> list = examinationConfigService.list(new ExaminationConfigSO());
        ExaminationConfig config = null;
        if (null != list && list.size() > 0) {
            config = list.get(0);
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
            config.setSingleType(config.getQuestionType());
            config.setMultiType(config.getQuestionType());
            config.setCheckType(config.getQuestionType());
            config.setJudgeType(config.getQuestionType());
            config.setFillType(config.getQuestionType());
        }

        ModelAndView mv = new ModelAndView("manage/study/examination-config/edit");
        mv.getModel().put("so", config);
        return mv;
    }

    @RequestMapping("save")
    @ResponseBody
    public JSONObject save(ExaminationConfigSO so) {
        ExaminationConfig config = null;
        if (StringUtils.isNotBlank(so.getId())) {
            config = examinationConfigService.getById(so.getId());
        } else {
            config = new ExaminationConfig();
        }
        config.setStudyToExamState(so.getStudyToExamState());
        config.setDuration(so.getDuration());
        config.setTestType(so.getTestType());
        config.setPaperType(so.getPaperType());
        config.setTotalScore(so.getTotalScore());
        config.setPassScore(so.getPassScore());
        config.setTestAmount(so.getTestAmount());
        config.setQuestionAmount(so.getQuestionAmount());
        config.setQuestionType(so.getQuestionType());
        config.setSingleType(so.getSingleType());
        config.setSingleAmount(so.getSingleAmount());
        config.setMultiType(so.getMultiType());
        config.setMultiAmount(so.getMultiAmount());
        config.setCheckType(so.getCheckType());
        config.setCheckAmount(so.getCheckAmount());
        config.setJudgeType(so.getJudgeType());
        config.setFillType(so.getFillType());
        config.setFillAmount(so.getFillAmount());
        if (StringUtils.isNotBlank(so.getId())) {
            examinationConfigService.update(config);
        } else {
            examinationConfigService.insert(config);
        }
        JSONObject json = resultSuccess();
        json.put("id", config.getId());
        return json;
    }
}