package cn.com.enjoystudy.oa.webapps.manage.employee;

import cn.com.enjoystudy.oa.bean.base.Department;
import cn.com.enjoystudy.oa.bean.base.DepartmentSO;
import cn.com.enjoystudy.oa.service.base.DepartmentService;
import cn.com.enjoystudy.oa.util.JsUtils;
import cn.com.enjoystudy.oa.validation.manage.employee.DepartmentValidator;
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
@RequestMapping("/manage/employee/department")
public class DepartmentController extends BaseController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("/manage/employee/department/index");
        return mv;
    }

    @RequestMapping("list")
    @ResponseBody
    public JSONObject list() {
        List<Department> departments = new ArrayList<Department>();
        DepartmentSO so = new DepartmentSO();
        so.setParentId("0");

        departments = departmentService.tree(so,departments);

        JSONArray array = new JSONArray();
        if (null != departments && departments.size() > 0) {
            for (Department department : departments) {
                array.add(beanToJson(department));
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
        ModelAndView mv = new ModelAndView("/manage/employee/department/edit");

        Department so = null;
        if  (StringUtils.isNotBlank(id)) {
            so = departmentService.getById(id);
        } else {
            so = new Department();
            so.setParentId(parentId);
            // 分类：1单位，2部门，3组
            so.setCategory(1);
        }

        if (StringUtils.isNotBlank(so.getParentId()) && !"0".equals(so.getParentId())) {
            mv.getModel().put("department", departmentService.getById(so.getParentId()));
    }
        mv.getModel().put("so", so);
        return mv;
    }

    @RequestMapping("save")
    @ResponseBody
    public JSONObject save(@ModelAttribute DepartmentSO so, BindingResult result) {
        DepartmentValidator validator = new DepartmentValidator();
        validator.validate(so, result);

        if (result.hasErrors()) {
            return resultError(result.getFieldError().getDefaultMessage());
        } else {
            Department department = null;
            if (StringUtils.isNotBlank(so.getId())) {
                department = departmentService.getById(so.getId());
            } else {
                department = new Department();
            }
            department.setCode(StringUtils.trim(so.getCode()));
            department.setName(StringUtils.trim(so.getName()));
            department.setCaption(StringUtils.trimToNull(so.getCaption()));
            department.setCategory(so.getCategory());
            department.setBossId(StringUtils.trimToNull(so.getBossId()));
            department.setPhone(StringUtils.trimToNull(so.getPhone()));
            if (StringUtils.isNotBlank(so.getParentId()) && !"0".equals(so.getParentId())) {
                department.setParentId(so.getParentId());
            }
            if (StringUtils.isNotBlank(so.getId())) {
                departmentService.update(department);
            } else {
                departmentService.insert(department);
            }
            return resultSuccess();
        }
    }

    @RequestMapping("check")
    public void check(
            @RequestParam(value = "code", required = false) String code,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "parentId", required = false) String parentId,
            @RequestParam(value = "category", required = false) Integer category,
            @RequestParam(value = "id", required = false) String id,
            HttpServletResponse response) {
        String flag = "true";

        DepartmentSO so = new DepartmentSO();
        so.setCode(code);
        so.setName(name);
        so.setCategory(category);
        so.setParentId(parentId);
        so.setExceptId(id);
        so.setLike(Boolean.FALSE);
        if (departmentService.count(so) > 0) {
            flag = "false";
        }
        JsUtils.writeText(response, flag);
    }

    @RequestMapping("delete")
    @ResponseBody
    public JSONObject delete(@RequestParam String id) {
        departmentService.deleteById(id);
        return resultSuccess();
    }

    @RequestMapping("single-select")
    @ResponseBody
    public ModelAndView singleSelect(@RequestParam(value = "ids", required = false) String[] ids) {
        DepartmentSO so = new DepartmentSO();
        so.setParentId("0");

        List<Department> departments = new ArrayList<Department>();
        departments = departmentService.tree(so, departments);

        JSONArray array = new JSONArray();
        if (null != departments && departments.size() > 0) {
            for (Department department : departments) {
                JSONObject json = new JSONObject();
                json.put("id", department.getId());
                json.put("name", department.getName());
                if (StringUtils.isNotBlank(department.getParentId())) {
                    json.put("pId", department.getParentId());
                } else {
                    json.put("pId", "0");
                }
                if (ArrayUtils.isNotEmpty(ids)) {
                    if (ArrayUtils.contains(ids, department.getId())) {
                        json.put("checked", true);
                    }
                }

                array.add(json);
            }
        }

        ModelAndView mv = new ModelAndView("/manage/employee/department/single-select");
        mv.getModel().put("departments", array.toJSONString());
        return mv;
    }

    private JSONObject beanToJson(Department department) {
        JSONObject obj = new JSONObject();
        obj.put("id", department.getId());
        obj.put("category", department.getCategory());
        obj.put("code", department.getCode());
        obj.put("name", department.getName());
        obj.put("phone", StringUtils.trimToEmpty(department.getPhone()));
        if (StringUtils.isNotBlank(department.getParentId())) {
            obj.put("parentId", department.getParentId());
        } else {
            obj.put("parentId", "0");
        }
        return obj;
    }
}
