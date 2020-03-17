package cn.com.enjoystudy.oa.webapps.manage.community;

import cn.com.enjoystudy.oa.bean.community.CommunityNavigation;
import cn.com.enjoystudy.oa.bean.community.CommunityNavigationSO;
import cn.com.enjoystudy.oa.service.community.CommunityNavigationService;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage/community/community-navigation")
public class CommunityNavigationAdminController extends BaseController {
    @Autowired
    private CommunityNavigationService communityNavigationService;

    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("manage/community/community-navigation/index");
        return mv;
    }

    @RequestMapping("list")
    @ResponseBody
    public JSONObject list(CommunityNavigationSO so) {
        PageInfo<CommunityNavigation> pageInfo = communityNavigationService.findPage(so);
        return resultSuccess(pageInfo);
    }

    @RequestMapping("edit")
    public ModelAndView edit(@RequestParam(required = false) String id) {
        ModelAndView mv = new ModelAndView("manage/community/community-navigation/edit");
        if (StringUtils.isNotBlank(id)) {
            mv.getModel().put("so", communityNavigationService.getById(id));
        } else {
            CommunityNavigation so = new CommunityNavigation();
            so.setShowState(false);
            so.setSerialNumber(0);
            mv.getModel().put("so", so);
        }
        return mv;
    }

    @RequestMapping("save")
    @ResponseBody
    public JSONObject save(CommunityNavigationSO so) {
        CommunityNavigation po;
        if (StringUtils.isNotBlank(so.getId())) {
            po = communityNavigationService.getById(so.getId());
        } else {
            po = new CommunityNavigation();
        }
        po.setCode(StringUtils.trim(so.getCode()));
        po.setName(StringUtils.trim(so.getName()));
        po.setShowState(so.getShowState());
        po.setHref(StringUtils.trimToNull(so.getHref()));
        po.setIcon(StringUtils.trimToNull(so.getIcon()));
        po.setCssClass(StringUtils.trimToNull(so.getCssClass()));
        po.setCssStyle(StringUtils.trimToNull(so.getCssStyle()));
        if (StringUtils.isNotBlank(so.getId())) {
            communityNavigationService.update(po);
        } else {
            communityNavigationService.insert(po);
        }
        return resultSuccess();
    }

    @RequestMapping("delete")
    @ResponseBody
    public JSONObject delete(@RequestParam String id) {
        communityNavigationService.deleteById(id);
        return resultSuccess();
    }
}
