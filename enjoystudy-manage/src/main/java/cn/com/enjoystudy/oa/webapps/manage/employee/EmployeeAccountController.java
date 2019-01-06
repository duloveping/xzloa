package cn.com.enjoystudy.oa.webapps.manage.employee;

import cn.com.enjoystudy.oa.bean.base.*;
import cn.com.enjoystudy.oa.common.Constants;
import cn.com.enjoystudy.oa.filter.ManageSessionFilter;
import cn.com.enjoystudy.oa.service.base.BasePositionService;
import cn.com.enjoystudy.oa.service.base.EmployeeAccountService;
import cn.com.enjoystudy.oa.service.base.EmployeeCommunicationService;
import cn.com.enjoystudy.oa.service.base.EmployeePositionService;
import cn.com.enjoystudy.oa.util.JsUtils;
import cn.com.enjoystudy.oa.validation.manage.employee.EmployeeAccountValidator;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/manage/employee/account")
public class EmployeeAccountController extends BaseController {
    @Autowired
    private EmployeeAccountService employeeAccountService;
    @Autowired
    private EmployeePositionService employeePositionService;
    @Autowired
    private BasePositionService basePositionService;
    @Autowired
    private EmployeeCommunicationService employeeCommunicationService;

    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("manage/employee/account/index");
        return mv;
    }

    @RequestMapping("list")
    @ResponseBody
    public JSONObject list(EmployeeAccountSO so) {
        so.setCategory(Constants.ACCOUNT_CATEGORY_SYSTEM);
        PageInfo<EmployeeAccount> pageInfo = employeeAccountService.findPage(so);
        List<EmployeeAccount> datas = pageInfo.getList();
        JSONArray array = new JSONArray();
        if (null != datas && datas.size() > 0) {
            for (EmployeeAccount position : datas) {
                array.add(beanToJson(position));
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
        List<BasePosition> positionList = basePositionService.list(new BasePositionSO());

        EmployeeAccount po = null;
        if (StringUtils.isNotBlank(id)) {
            po = employeeAccountService.getById(id);
        } else {
            po = new EmployeeAccount();
            po.setLockState(true);
        }

        ModelAndView mv = new ModelAndView("manage/employee/account/edit");
        mv.getModel().put("po", po);
        mv.getModel().put("positionList", positionList);
        return mv;
    }

    @RequestMapping("save")
    @ResponseBody
    public JSONObject save(EmployeeAccountSO so, BindingResult result) {
        EmployeeAccountValidator validator = new EmployeeAccountValidator();
        validator.validate(so, result);

        if (result.hasErrors()) {
            return resultError(result.getFieldError().getDefaultMessage());
        } else {
            EmployeeAccount account = null;
            if (StringUtils.isNotBlank(so.getId())) {
                account = employeeAccountService.getById(so.getId());
            } else {
                account = new EmployeeAccount();
                account.setCategory(Constants.ACCOUNT_CATEGORY_SYSTEM);
            }
            account.setDepartmentId(so.getDepartmentId());
            account.setPositionId(so.getPositionId());
            account.setCode(StringUtils.trim(so.getCode()));
            account.setFullName(StringUtils.trim(so.getFullName()));
            account.setLockState(so.getLockState());
            if (StringUtils.isNotBlank(so.getLoginPassword())) {
                account.setLoginPassword(DigestUtils.sha1Hex(so.getLoginPassword().trim()));
            }
            if (StringUtils.isNotBlank(so.getId())) {
                employeeAccountService.update(account);
                employeePositionService.deleteByEmployeeId(account.getId());
            } else {
                employeeAccountService.insert(account);
            }

            // 代码是方便日后有身兼多职的情况，目前仅考一人一职的情况
            EmployeePosition ep = new EmployeePosition();
            ep.setEmployeeId(account.getId());
            ep.setPositionId(account.getPositionId());
            employeePositionService.insert(ep);

            return resultSuccess();
        }
    }

    @RequestMapping("delete")
    @ResponseBody
    public JSONObject delete(@RequestParam String id) {
        EmployeeAccount account = employeeAccountService.getById(id);
        if (null != account && account.getCode().equals("admin")) {
            return resultError("系统管理员不能删除");
        } else {
            employeeAccountService.deleteById(id);
            return resultSuccess();
        }
    }

    @RequestMapping("check")
    public void check(
            @RequestParam("code") String code,
            @RequestParam(value = "id", required = false) String id,
            HttpServletResponse response) {
        String flag = "true";

        EmployeeAccountSO so = new EmployeeAccountSO();
        so.setCode(code);
        so.setExceptId(id);
        if (employeeAccountService.count(so) > 0) {
            flag = "false";
        }
        JsUtils.writeText(response, flag);
    }

    @RequestMapping("edit-password")
    public ModelAndView editPassword() {
        ModelAndView mv = new ModelAndView("manage/employee/account/edit-password");
        return mv;
    }

    @RequestMapping("save-password")
    @ResponseBody
    public JSONObject savePassword(
            @RequestParam("oldpwd") String oldpwd,
            @RequestParam("newpwd") String newpwd,
            @RequestParam("okpwd") String okpwd) {
        if (newpwd.equals(okpwd)) {
            Subject subject = SecurityUtils.getSubject();
            Object object = subject.getSession().getAttribute(ManageSessionFilter.DEFAULT_LOGIN_USER);
            EmployeeAccount account = (EmployeeAccount) object;
            account = employeeAccountService.getById(account.getId());
            if (account.getLoginPassword().equals(DigestUtils.sha1Hex(oldpwd))) {
                account.setLoginPassword(DigestUtils.sha1Hex(newpwd));
                employeeAccountService.updateLoginPassword(account.getLoginPassword(), account.getId());
                subject.getSession().setAttribute(ManageSessionFilter.DEFAULT_LOGIN_USER, account);

                return resultSuccess();
            } else {
                return resultError("您输入旧的密码不正确！");
            }
        } else {
            return resultError("您输入两次的密码不相同！");
        }
    }

    @RequestMapping("edit-data")
    public ModelAndView editDate() {
        Subject subject = SecurityUtils.getSubject();
        Object object = subject.getSession().getAttribute(ManageSessionFilter.DEFAULT_LOGIN_USER);
        EmployeeAccount account = (EmployeeAccount) object;
        account = employeeAccountService.getById(account.getId());

        EmployeeCommunicationSO communicationSO = new EmployeeCommunicationSO();
        communicationSO.setEmployeeId(account.getId());
        communicationSO.setCategory(Constants.COMMUNICATION_CATEGORY_MYSELF);

        List<EmployeeCommunication> communicationList = employeeCommunicationService.list(communicationSO);

        ModelAndView mv = new ModelAndView("manage/employee/account/edit-data");
        mv.getModel().put("so", account);
        if (null != communicationList && communicationList.size() > 0) {
            mv.getModel().put("communication", communicationList.get(0));
        }
        return mv;
    }

    @RequestMapping("save-data")
    @ResponseBody
    public JSONObject saveData(
            @RequestParam(value = "education", required = false) String education,
            @RequestParam(value = "school", required = false) String school,
            @RequestParam(value = "major", required = false) String major,
            @RequestParam(value = "nativePlace", required = false) String nativePlace,
            @RequestParam(value = "maritalStatus", required = false) Integer maritalStatus,
            @RequestParam(value = "provinceId", required = false) String provinceId,
            @RequestParam(value = "provinceCode", required = false) String provinceCode,
            @RequestParam(value = "provinceName", required = false) String provinceName,
            @RequestParam(value = "cityId", required = false) String cityId,
            @RequestParam(value = "cityCode", required = false) String cityCode,
            @RequestParam(value = "cityName", required = false) String cityName,
            @RequestParam(value = "townId", required = false) String townId,
            @RequestParam(value = "townCode", required = false) String townCode,
            @RequestParam(value = "townName", required = false) String townName,
            @RequestParam(value = "address", required = false) String address,
            @RequestParam(value = "postCode", required = false) String postCode,
            @RequestParam(value = "mobile", required = false) String mobile,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "fax", required = false) String fax,
            @RequestParam(value = "email", required = false) String email) {
        Subject subject = SecurityUtils.getSubject();
        Object object = subject.getSession().getAttribute(ManageSessionFilter.DEFAULT_LOGIN_USER);
        EmployeeAccount account = (EmployeeAccount) object;
        account = employeeAccountService.getById(account.getId());
        account.setEducation(StringUtils.trimToNull(education));
        account.setSchool(StringUtils.trimToNull(school));
        account.setMajor(StringUtils.trimToNull(major));
        account.setNativePlace(StringUtils.trimToNull(nativePlace));
        account.setMaritalStatus(maritalStatus);
        employeeAccountService.update(account);

        EmployeeCommunicationSO communicationSO = new EmployeeCommunicationSO();
        communicationSO.setEmployeeId(account.getId());
        communicationSO.setCategory(Constants.COMMUNICATION_CATEGORY_MYSELF);
        EmployeeCommunication communication = new EmployeeCommunication();
        List<EmployeeCommunication> communicationList = employeeCommunicationService.list(communicationSO);
        if (null != communicationList && communicationList.size() > 0) {
            communication = communicationList.get(0);
        }
        communication.setProvinceId(StringUtils.trimToNull(provinceId));
        communication.setProvinceCode(StringUtils.trimToNull(provinceCode));
        communication.setProvinceName(StringUtils.trimToNull(provinceName));
        communication.setCityId(StringUtils.trimToNull(cityId));
        communication.setCityCode(StringUtils.trimToNull(cityCode));
        communication.setCityName(StringUtils.trimToNull(cityName));
        communication.setTownId(StringUtils.trimToNull(townId));
        communication.setTownCode(StringUtils.trimToNull(townCode));
        communication.setTownName(StringUtils.trimToNull(townName));
        communication.setAddress(StringUtils.trimToNull(address));
        communication.setPostCode(StringUtils.trimToNull(postCode));
        communication.setMobile(StringUtils.trimToNull(mobile));
        communication.setFax(StringUtils.trimToNull(fax));
        communication.setEmail(StringUtils.trimToNull(email));
        communication.setPhone(StringUtils.trimToNull(phone));
        if (null != communicationList && communicationList.size() > 0) {
            employeeCommunicationService.update(communication);
        } else {
            communication.setEmployeeId(account.getId());
            communication.setCategory(Constants.COMMUNICATION_CATEGORY_MYSELF);
            employeeCommunicationService.insert(communication);
        }

        return resultSuccess();
    }

    private JSONObject beanToJson(EmployeeAccount bean) {
        if (null != bean) {
            JSONObject json = new JSONObject();
            json.put("id", bean.getId());
            json.put("departmentId", StringUtils.trimToEmpty(bean.getDepartmentId()));
            json.put("departmentName", StringUtils.trimToEmpty(bean.getDepartmentName()));
            json.put("positionId", StringUtils.trimToEmpty(bean.getPositionId()));
            json.put("positionName", StringUtils.trimToEmpty(bean.getPositionName()));
            json.put("code", StringUtils.trimToEmpty(bean.getCode()));
            json.put("fullName", StringUtils.trimToEmpty(bean.getFullName()));
            json.put("lockState", bean.getLockState());
            return json;
        }
        return null;
    }
}
