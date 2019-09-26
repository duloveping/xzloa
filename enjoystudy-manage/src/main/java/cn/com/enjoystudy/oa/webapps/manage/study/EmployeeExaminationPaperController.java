package cn.com.enjoystudy.oa.webapps.manage.study;

import cn.com.enjoystudy.oa.service.study.EmployeeExaminationPaperService;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/manage/study/employeeExaminationPaper")
public class EmployeeExaminationPaperController extends BaseController {
    @Autowired
    private EmployeeExaminationPaperService employeeExaminationPaperService;

    @RequestMapping("delete")
    @ResponseBody
    public JSONObject delete(@RequestParam String id) {
        employeeExaminationPaperService.deleteById(id);
        return resultSuccess();
    }
}
