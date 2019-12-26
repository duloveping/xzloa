package cn.com.enjoystudy.oa.webapps.manage.system;

import cn.com.enjoystudy.oa.bean.sys.SysMenu;
import cn.com.enjoystudy.oa.bean.sys.SysMenuSO;
import cn.com.enjoystudy.oa.service.sys.SysMenuService;
import cn.com.enjoystudy.oa.service.sys.SysRoleMenuService;
import cn.com.enjoystudy.oa.validation.manage.system.SysMenuValidator;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/manage/system/sys-menu")
public class SysMenuController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(SysMenuController.class);
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("manage/system/sys-menu/index");
        return mv;
    }

    @RequestMapping("list")
    @ResponseBody
    public JSONObject list() {
        SysMenuSO so = new SysMenuSO();
        so.setParentId("0");
        so.setCategory(1);

        JSONArray array = new JSONArray();

        List<SysMenu> menus = new ArrayList<SysMenu>();
        menus = sysMenuService.recursionFindMenu(so, menus);
        if (null != menus && menus.size() > 0) {
            for (SysMenu menu : menus) {
                array.add(beanToJson(menu));
                if (StringUtils.isNotBlank(menu.getParentId())) {
                    List<SysMenu> permissions = sysMenuService.findByParentId(menu.getId());
                    if (null != permissions && permissions.size() > 0) {
                        for (SysMenu permission : permissions) {
                            array.add(beanToJson(permission));
                        }
                    }
                }
            }
        }

        JSONObject json = new JSONObject();
        json.put("datas", array);
        json.put("status", true);
        json.put("info", "成功");
        return json;
    }

    @RequestMapping("edit")
    public ModelAndView edit(
            @RequestParam(value = "id", required = false) String id,
            @RequestParam(value = "parentId", required = false, defaultValue = "0") String parentId) {
        ModelAndView mv = new ModelAndView("manage/system/sys-menu/edit");
        SysMenu sysMenu = null;
        if (StringUtils.isNotBlank(id)) {
            sysMenu = sysMenuService.getById(id);
        } else {
            sysMenu = new SysMenu();
            sysMenu.setCategory(1);
            sysMenu.setShowState(false);
            sysMenu.setParentId(parentId);
            sysMenu.setSerialNumber(0);
        }

        if (!"0".equals(parentId)) {
            SysMenu parent = sysMenuService.getById(parentId);
            mv.getModel().put("menu", parent);
        }

        mv.getModel().put("vo", sysMenu);
        return mv;
    }

    @RequestMapping("save")
    @ResponseBody
    public JSONObject save(@ModelAttribute("vo") SysMenuSO vo, BindingResult result) {
        String info;
        boolean status;

        SysMenuValidator validator = new SysMenuValidator();
        validator.validate(vo, result);

        if (result.hasErrors()) {
            info = result.getFieldError().getDefaultMessage();
            status = false;
        } else {
            SysMenu sysMenu = null;

            if (StringUtils.isNotBlank(vo.getId())) {
                sysMenu = sysMenuService.getById(vo.getId());
            } else {
                sysMenu = new SysMenu();
                if (!"0".equals(vo.getParentId())) {
                    sysMenu.setParentId(vo.getParentId());
                }
            }
            sysMenu.setCategory(vo.getCategory());
            sysMenu.setCode(StringUtils.trim(vo.getCode()));
            sysMenu.setName(StringUtils.trim(vo.getName()));
            sysMenu.setShowState(vo.getShowState());
            sysMenu.setCaption(StringUtils.trimToNull(vo.getCaption()));
            sysMenu.setCssClass(StringUtils.trimToNull(vo.getCssClass()));
            sysMenu.setCssStyle(StringUtils.trimToNull(vo.getCssStyle()));
            sysMenu.setIcon(StringUtils.trimToNull(vo.getIcon()));
            sysMenu.setHref(StringUtils.trimToNull(vo.getHref()));
            sysMenu.setSerialNumber(vo.getSerialNumber());
            if (StringUtils.isNotBlank(vo.getId())) {
                sysMenuService.update(sysMenu);
            } else {
                sysMenuService.insert(sysMenu);
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
        sysMenuService.deleteById(id);
        JSONObject json = resultSuccess();
        return json;
    }

    @RequestMapping("permission-edit")
    public ModelAndView permissionEdit(
            @RequestParam(value = "id", required = false) String id,
            @RequestParam("parentId") String parentId) {
        ModelAndView mv = new ModelAndView("manage/system/permission/edit");

        SysMenu parent = sysMenuService.getById(parentId);
        mv.getModel().put("menu", parent);

        SysMenu sysMenu = null;
        if (StringUtils.isNotBlank(id)) {
            sysMenu = sysMenuService.getById(id);
        } else {
            sysMenu = new SysMenu();
            sysMenu.setCategory(2);
            sysMenu.setShowState(false);
            sysMenu.setParentId(parent.getId());
            sysMenu.setSerialNumber(0);
        }

        mv.getModel().put("vo", sysMenu);
        return mv;
    }

    @RequestMapping("permission-save")
    @ResponseBody
    public JSONObject permissionave(@ModelAttribute("vo") SysMenuSO vo, BindingResult result) {
        String info;
        boolean status;

        SysMenuValidator validator = new SysMenuValidator();
        validator.validate(vo, result);

        if (result.hasErrors()) {
            info = result.getFieldError().getDefaultMessage();
            status = false;
        } else {
            SysMenu sysMenu = null;

            if (StringUtils.isNotBlank(vo.getId())) {
                sysMenu = sysMenuService.getById(vo.getId());
            } else {
                sysMenu = new SysMenu();
                sysMenu.setParentId(vo.getParentId());
            }
            sysMenu.setCategory(2);
            sysMenu.setCode(StringUtils.trim(vo.getCode()));
            sysMenu.setName(StringUtils.trim(vo.getName()));
            sysMenu.setShowState(vo.getShowState());
            sysMenu.setSerialNumber(vo.getSerialNumber());
            if (StringUtils.isNotBlank(vo.getId())) {
                sysMenuService.update(sysMenu);
            } else {
                sysMenuService.insert(sysMenu);
            }

            info = "数据保存成功";
            status = true;
        }

        JSONObject json = new JSONObject();
        json.put("status", status);
        json.put("info", info);
        return json;
    }

    private JSONObject beanToJson(SysMenu m){
        JSONObject json = new JSONObject();
        json.put("id", m.getId());
        if (StringUtils.isBlank(m.getParentId())) {
            json.put("parentId", "0");
        } else {
            json.put("parentId", m.getParentId());
        }
        json.put("showState", m.getShowState());
        json.put("category", m.getCategory());
        json.put("code", StringUtils.trimToEmpty(m.getCode()));
        json.put("name", StringUtils.trimToEmpty(m.getName()));
        json.put("href", StringUtils.trimToEmpty(m.getHref()));
        json.put("icon", StringUtils.trimToEmpty(m.getIcon()));
        json.put("cssClass", StringUtils.trimToEmpty(m.getCssClass()));
        json.put("cssStyle", StringUtils.trimToEmpty(m.getCssStyle()));
        return json;
    }
}
