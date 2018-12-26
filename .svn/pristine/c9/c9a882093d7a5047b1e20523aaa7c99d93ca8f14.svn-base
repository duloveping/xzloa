package cn.com.enjoystudy.oa.webapps.manage.study;

import cn.com.enjoystudy.oa.bean.study.Teacher;
import cn.com.enjoystudy.oa.bean.study.TeacherSO;
import cn.com.enjoystudy.oa.service.study.TeacherService;
import cn.com.enjoystudy.oa.validation.manage.study.TeacherValidator;
import cn.com.enjoystudy.oa.webapps.UploadController;
import com.alibaba.fastjson.JSONArray;
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
@RequestMapping("/manage/study/teacher")
public class TeacherController extends UploadController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("manage/study/teacher/index");
        return mv;
    }

    @RequestMapping("list")
    @ResponseBody
    public JSONObject list(TeacherSO so) {
        PageInfo<Teacher> pageInfo = teacherService.findPag(so);
        List<Teacher> datas = pageInfo.getList();
        JSONArray array = new JSONArray();
        if (null != datas && datas.size() > 0) {
            for (Teacher teacher : datas) {
                array.add(beanToJson(teacher));
            }
        }

        JSONObject json = resultSuccess();
        json.put("datas", array);
        json.put("total", pageInfo.getTotal());
        json.put("pages", pageInfo.getPages());
        return json;
    }

    @RequestMapping("edit")
    public ModelAndView edit(@RequestParam(value = "id", required = false) String id) {

        Teacher teacher = null;
        if (StringUtils.isNotBlank(id)) {
            teacher = teacherService.getById(id);
        } else {
            teacher = new Teacher();
        }

        ModelAndView mv = new ModelAndView("manage/study/teacher/edit");
        mv.getModel().put("so", teacher);
        return mv;
    }

    @RequestMapping("save")
    @ResponseBody
    public JSONObject save(TeacherSO so, BindingResult result) {

        TeacherValidator validator = new TeacherValidator();
        validator.validate(so, result);

        if (result.hasErrors()) {
            return resultError(result.getFieldError().getDefaultMessage());
        } else {
            Teacher teacher = null;
            if (StringUtils.isNotBlank(so.getId())) {
                teacher = teacherService.getById(so.getId());
            } else {
                teacher = new Teacher();
            }
            teacher.setCode(StringUtils.trim(so.getCode()));
            teacher.setFullName(StringUtils.trim(so.getFullName()));
            teacher.setImage(StringUtils.trimToNull(so.getImage()));
            teacher.setIntroduction(StringUtils.trimToNull(so.getIntroduction()));
            teacher.setDescription(StringUtils.trimToNull(so.getDescription()));
            if (StringUtils.isNotBlank(so.getId())) {
                teacherService.update(teacher);
            } else {
                teacherService.insert(teacher);
            }
            return resultSuccess();
        }
    }

    @RequestMapping("delete")
    @ResponseBody
    public JSONObject delete(@RequestParam String id) {
        teacherService.deleteById(id);
        return resultSuccess();
    }

    private JSONObject beanToJson(Teacher bean) {
        JSONObject obj = new JSONObject();
        obj.put("id", bean.getId());
        obj.put("image", StringUtils.trimToEmpty(bean.getImage()));
        obj.put("fullName", bean.getFullName());
        obj.put("introduction", StringUtils.trimToEmpty(bean.getIntroduction()));
        obj.put("description", StringUtils.trimToEmpty(bean.getDescription()));
        return obj;
    }
}
