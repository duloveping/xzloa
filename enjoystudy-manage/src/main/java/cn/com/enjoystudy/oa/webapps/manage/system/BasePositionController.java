package cn.com.enjoystudy.oa.webapps.manage.system;

import cn.com.enjoystudy.oa.bean.base.BasePosition;
import cn.com.enjoystudy.oa.bean.base.BasePositionSO;
import cn.com.enjoystudy.oa.bean.sys.SysRole;
import cn.com.enjoystudy.oa.bean.sys.SysRolePosition;
import cn.com.enjoystudy.oa.bean.sys.SysRoleSO;
import cn.com.enjoystudy.oa.service.base.BasePositionService;
import cn.com.enjoystudy.oa.service.sys.SysRolePositionService;
import cn.com.enjoystudy.oa.service.sys.SysRoleService;
import cn.com.enjoystudy.oa.util.JsUtils;
import cn.com.enjoystudy.oa.validation.manage.system.BasePositionValidator;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import java.util.List;

@Controller
@RequestMapping("/manage/system/base-position")
public class BasePositionController extends BaseController{
    @Autowired
    private BasePositionService basePositionService;
    @Autowired
    private SysRolePositionService sysRolePositionService;
    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping("index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("manage/system/base-position/index");
        return mv;
    }

    @RequestMapping("list")
    @ResponseBody
    public JSONObject list(@ModelAttribute BasePositionSO so) {
        PageInfo<BasePosition> pageInfo = basePositionService.findPag(so);
        List<BasePosition> datas = pageInfo.getList();
        JSONArray array = new JSONArray();
        if (null != datas && datas.size() > 0) {
            for (BasePosition position : datas) {
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
        ModelAndView mv = new ModelAndView("manage/system/base-position/edit");

        BasePosition position = null;
        if (StringUtils.isNotBlank(id)) {
            position = basePositionService.getById(id);
        } else {
            position = new BasePosition();
            position.setShowState(false);
            position.setSerialNumber(0);
        }
        mv.getModel().put("so", position);

        return mv;
    }

    @RequestMapping("save")
    @ResponseBody
    public JSONObject save(
            @ModelAttribute BasePositionSO so, BindingResult result) {

        BasePositionValidator validator = new BasePositionValidator();
        validator.validate(so, result);

        if (result.hasErrors()) {
            return resultError(result.getFieldError().getDefaultMessage());
        } else {
            BasePosition position = null;
            if (StringUtils.isNotBlank(so.getId())) {
                position = basePositionService.getById(so.getId());
            } else {
                position = new BasePosition();
            }
            position.setCode(StringUtils.trim(so.getCode()));
            position.setName(StringUtils.trim(so.getName()));
            position.setCaption(StringUtils.trimToNull(so.getCaption()));
            position.setShowState(so.getShowState());
            position.setSerialNumber(so.getSerialNumber());
            if (StringUtils.isNotBlank(so.getId())) {
                basePositionService.update(position);
                sysRolePositionService.deleteByPositionId(position.getId());
            } else {
                basePositionService.insert(position);
            }

            int i = 0;
            if (null != so.getSysRolePositionList() && so.getSysRolePositionList().size() > 0) {
                for (SysRolePosition rp : so.getSysRolePositionList()) {
                    rp.setPositionId(position.getId());
                    sysRolePositionService.insert(rp);
                }
            }
            return resultSuccess();
        }
    }

    @RequestMapping("delete")
    @ResponseBody
    public JSONObject delete(@RequestParam String id) {
        basePositionService.deleteById(id);
        return resultSuccess();
    }

    @RequestMapping("check")
    public void check(
            @RequestParam("code") String code,
            @RequestParam(value = "id", required = false) String id,
            HttpServletResponse response) {
        String flag = "true";

        BasePositionSO so = new BasePositionSO();
        so.setCode(code);
        so.setExceptId(id);
        if (basePositionService.count(so) > 0) {
            flag = "false";
        }
        JsUtils.writeText(response, flag);
    }

    @RequestMapping("grantTo")
    public ModelAndView grantTo(@RequestParam("id") String id) {
        ModelAndView mv = new ModelAndView("manage/system/base-position/grantTo");

        BasePosition position = basePositionService.getById(id);
        if (null != position) {
            List<SysRolePosition> rolePositionList = sysRolePositionService.findByPositionId(position.getId());
            List<SysRole> roleList = sysRoleService.list(new SysRoleSO());

            position.setSysRoleList(roleList);
            position.setSysRolePositionList(rolePositionList);
        }

        mv.getModel().put("so", position);

        return mv;
    }

    @RequestMapping("grantSave")
    @ResponseBody
    public JSONObject grantSave(
            @RequestParam("positionId") String positionId,
            @RequestParam("roleIds") String[] roleIds) {
        BasePosition position = basePositionService.getById(positionId);
        if (null != position) {
            sysRolePositionService.deleteByPositionId(position.getId());
            for (String roleId : roleIds) {
                SysRolePosition po = new SysRolePosition();
                po.setPositionId(position.getId());
                po.setRoleId(roleId);
                sysRolePositionService.insert(po);
            }
            return resultSuccess("成功为该职务分配系统角色");
        } else {
            return resultError("该职务不存在或已被删除");
        }
    }

    private JSONObject beanToJson(BasePosition position) {
        JSONArray array = new JSONArray();

        if (null != position.getSysRoleList() && position.getSysRoleList().size() > 0) {
            for (SysRole role : position.getSysRoleList()) {
                JSONObject r = new JSONObject();
                r.put("id", role.getId());
                r.put("code", role.getCode());
                r.put("name", role.getName());
                r.put("caption", StringUtils.trimToEmpty(role.getCaption()));
                array.add(r);
            }
        }

        JSONObject obj = new JSONObject();
        obj.put("id", position.getId());
        obj.put("showState", position.getShowState());
        obj.put("code", position.getCode());
        obj.put("name", position.getName());
        obj.put("serialNumber", position.getSerialNumber());
        obj.put("caption", StringUtils.trimToEmpty(position.getCaption()));
        obj.put("items", array);
        return obj;
    }
}
