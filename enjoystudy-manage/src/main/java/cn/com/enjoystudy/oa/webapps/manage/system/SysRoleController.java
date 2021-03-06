package cn.com.enjoystudy.oa.webapps.manage.system;

import cn.com.enjoystudy.oa.bean.sys.SysRole;
import cn.com.enjoystudy.oa.bean.sys.SysRoleMenu;
import cn.com.enjoystudy.oa.bean.sys.SysRoleMenuSO;
import cn.com.enjoystudy.oa.bean.sys.SysRoleSO;
import cn.com.enjoystudy.oa.service.sys.SysRoleMenuService;
import cn.com.enjoystudy.oa.service.sys.SysRoleService;
import cn.com.enjoystudy.oa.util.JsUtils;
import cn.com.enjoystudy.oa.validation.manage.system.SysRoleValidator;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/manage/system/sys-role")
public class SysRoleController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(SysRoleController.class);
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("manage/system/sys-role/index");
        return mv;
    }

    @RequestMapping("list")
    @ResponseBody
    public JSONObject list(@ModelAttribute SysRoleSO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo<SysRole> pageInfo = new PageInfo<SysRole>();
        pageInfo.setList(sysRoleService.list(so));

        JSONArray array = new JSONArray();
        List<SysRole> roles = pageInfo.getList();
        if (null != roles && roles.size() > 0) {
            for (SysRole role : roles) {
                array.add(beanToJson(role));
            }
        }

        JSONObject json = new JSONObject();
        json.put("datas", array);
        json.put("total", pageInfo.getTotal());
        json.put("pages", pageInfo.getPages());
        json.put("status", true);
        json.put("info", "成功");
        return json;
    }

    @RequestMapping("edit")
    public ModelAndView edit(
            @RequestParam(value = "id", required = false) String id,
            @RequestParam(value = "parentId", required = false, defaultValue = "0") String parentId) {
        ModelAndView mv = new ModelAndView("manage/system/sys-role/edit");
        SysRole SysRole = null;
        if (StringUtils.isNotBlank(id)) {
            SysRole = sysRoleService.getById(id);
        } else {
            SysRole = new SysRole();
            SysRole.setShowState(false);
            SysRole.setSerialNumber(0);
        }

        if (!"0".equals(parentId)) {
            SysRole parent = sysRoleService.getById(parentId);
            mv.getModel().put("menu", parent);
        }

        mv.getModel().put("vo", SysRole);
        return mv;
    }

    @RequestMapping("save")
    @ResponseBody
    public JSONObject save(
            @RequestParam(value = "menuIds", required = false) String[] menuIds,
            @ModelAttribute("vo") SysRoleSO vo, BindingResult result) {
        String info;
        boolean status;

        SysRoleValidator validator = new SysRoleValidator();
        validator.validate(vo, result);

        if (result.hasErrors()) {
            info = result.getFieldError().getDefaultMessage();
            status = false;
        } else {
            SysRole role = null;

            if (StringUtils.isNotBlank(vo.getId())) {
                role = sysRoleService.getById(vo.getId());
            } else {
                role = new SysRole();
            }
            role.setCode(StringUtils.trim(vo.getCode()));
            role.setName(StringUtils.trim(vo.getName()));
            role.setShowState(vo.getShowState());
            role.setCaption(StringUtils.trimToNull(vo.getCaption()));
            role.setSerialNumber(vo.getSerialNumber());
            if (StringUtils.isNotBlank(vo.getId())) {
                sysRoleService.update(role);
            } else {
                sysRoleService.insert(role);
            }

            sysRoleMenuService.deleteByRoleId(role.getId());
            if (null != menuIds && menuIds.length > 0) {
                for (String menuId : menuIds) {
                    SysRoleMenu po = new SysRoleMenu();
                    po.setRoleId(role.getId());
                    po.setMenuId(menuId);
                    sysRoleMenuService.insert(po);
                }
            }

            info = "数据保存成功";
            status = true;
        }

        JSONObject json = new JSONObject();
        json.put("status", status);
        json.put("info", info);
        return json;
    }

    @RequestMapping("delete")
    @ResponseBody
    public JSONObject delete(@RequestParam String id) {
        sysRoleService.deleteById(id);

        JSONObject json = new JSONObject();
        json.put("status", true);
        json.put("info", "成功");
        return json;
    }

    @RequestMapping("check")
    public void check(
            @RequestParam("code") String code,
            @RequestParam(value = "id", required = false) String id,
            HttpServletRequest request, HttpServletResponse response) {
        String flag = "true";

        SysRoleSO so = new SysRoleSO();
        so.setExceptId(id);
        so.setCode(code);

        long count = sysRoleService.count(so);
        if (count > 0) {
            flag = "false";
        }

        JsUtils.writeText(response, flag);
    }

    private JSONObject beanToJson(SysRole role){
        JSONObject json = new JSONObject();
        json.put("id", role.getId());
        json.put("showState", role.getShowState());
        json.put("code", StringUtils.trimToEmpty(role.getCode()));
        json.put("name", StringUtils.trimToEmpty(role.getName()));
        json.put("caption", StringUtils.trimToEmpty(role.getCaption()));
        json.put("serialNumber", role.getSerialNumber());
        return json;
    }
}
