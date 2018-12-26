package cn.com.enjoystudy.oa.webapps.manage.study;

import cn.com.enjoystudy.oa.bean.study.CourseType;
import cn.com.enjoystudy.oa.bean.study.CourseTypeSO;
import cn.com.enjoystudy.oa.service.study.CourseTypeService;
import cn.com.enjoystudy.oa.util.JsUtils;
import cn.com.enjoystudy.oa.validation.manage.study.CourseTypeValidator;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/manage/study/course-type")
public class CourseTypeController extends BaseController {
    @Autowired
    private CourseTypeService courseTypeService;

    @RequestMapping("index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("manage/study/course-type/index");
        return mv;
    }

    @RequestMapping("list")
    @ResponseBody
    public JSONObject list() {
        List<CourseType> types = new ArrayList<CourseType>();
        CourseTypeSO so = new CourseTypeSO();
        so.setParentId("0");

        types = courseTypeService.tree(so,types);

        JSONArray array = new JSONArray();
        if (null != types && types.size() > 0) {
            for (CourseType po : types) {
                array.add(beanToJson(po));
            }
        }

        JSONObject json = resultSuccess();
        json.put("datas", array);
        return json;
    }

    @RequestMapping("edit")
    public ModelAndView edit(
            @RequestParam(value = "id", required = false) String id,
            @RequestParam(value = "parentId", required = false, defaultValue = "0") String parentId) {
        ModelAndView mv = new ModelAndView("manage/study/course-type/edit");

        CourseType so = null;
        if  (StringUtils.isNotBlank(id)) {
            so = courseTypeService.getById(id);
        } else {
            so = new CourseType();
            so.setParentId(parentId);
        }

        if (StringUtils.isNotBlank(so.getParentId()) && !"0".equals(so.getParentId())) {
            mv.getModel().put("type`", courseTypeService.getById(so.getParentId()));
        }
        mv.getModel().put("so", so);
        return mv;
    }

    @RequestMapping("save")
    @ResponseBody
    public JSONObject save(@ModelAttribute CourseTypeSO so, BindingResult result) {
        CourseTypeValidator validator = new CourseTypeValidator();
        validator.validate(so, result);

        if (result.hasErrors()) {
            return resultError(result.getFieldError().getDefaultMessage());
        } else {
            CourseType po = null;
            if (StringUtils.isNotBlank(so.getId())) {
                po = courseTypeService.getById(so.getId());
            } else {
                po = new CourseType();
            }
            po.setCode(StringUtils.trim(so.getCode()));
            po.setName(StringUtils.trim(so.getName()));
            po.setCaption(StringUtils.trimToNull(so.getCaption()));
            if (StringUtils.isNotBlank(so.getParentId()) && !"0".equals(so.getParentId())) {
                po.setParentId(so.getParentId());
            }
            if (StringUtils.isNotBlank(so.getId())) {
                courseTypeService.update(po);
            } else {
                courseTypeService.insert(po);
            }
            return resultSuccess();
        }
    }

    @RequestMapping("check")
    public void check(
            @RequestParam(value = "code", required = false) String code,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "parentId", required = false) String parentId,
            @RequestParam(value = "id", required = false) String id,
            HttpServletResponse response) {
        String flag = "true";

        CourseTypeSO so = new CourseTypeSO();
        so.setCode(code);
        so.setName(name);
        so.setParentId(parentId);
        so.setExceptId(id);
        so.setLike(Boolean.FALSE);
        if (courseTypeService.count(so) > 0) {
            flag = "false";
        }
        JsUtils.writeText(response, flag);
    }

    @RequestMapping("delete")
    @ResponseBody
    public JSONObject delete(@RequestParam String id) {
        courseTypeService.deleteById(id);
        return resultSuccess();
    }

    @RequestMapping("single-select")
    @ResponseBody
    public ModelAndView singleSelect(@RequestParam(value = "ids", required = false) String[] ids) {
        List<CourseType> types = new ArrayList<CourseType>();
        CourseTypeSO so = new CourseTypeSO();
        so.setParentId("0");

        types = courseTypeService.tree(so,types);

        JSONArray array = new JSONArray();
        if (null != types && types.size() > 0) {
            for (CourseType po : types) {
                JSONObject json = new JSONObject();
                json.put("id", po.getId());
                json.put("name", po.getName());
                if (StringUtils.isNotBlank(po.getParentId())) {
                    json.put("pId", po.getParentId());
                } else {
                    json.put("pId", "0");
                }
                if (ArrayUtils.isNotEmpty(ids)) {
                    if (ArrayUtils.contains(ids, po.getId())) {
                        json.put("checked", true);
                    }
                }
                array.add(json);
            }
        }

        ModelAndView mv = new ModelAndView("manage/study/course-type/single-select");
        mv.getModel().put("types", array.toJSONString());
        return mv;
    }

    private JSONObject beanToJson(CourseType bean) {
        JSONObject obj = new JSONObject();
        obj.put("id", bean.getId());
        obj.put("code", bean.getCode());
        obj.put("name", bean.getName());
        if (StringUtils.isNotBlank(bean.getParentId())) {
            obj.put("parentId", bean.getParentId());
        } else {
            obj.put("parentId", "0");
        }
        return obj;
    }
}
