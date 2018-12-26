package cn.com.enjoystudy.oa.webapps.common;

import cn.com.enjoystudy.oa.bean.common.SearchCriteria;
import cn.com.enjoystudy.oa.service.common.SelectService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/common/select")
public class SelectController {
    @Autowired
    private SelectService selectService;

    /**
     *
     * @param target:select target, default 0, 0: person, 1: department, 2: company, 3: department or company
     * @param rootId:root id, default "-1", "0": whole company, "-1": current company, others: specified root id
     * @param multiple:multiple select or not, default false
     * @return
     */
    @RequestMapping(value = "index")
    public ModelAndView index(
            @RequestParam(value = "target", required = false, defaultValue = "0") Integer target,
            @RequestParam(value = "rootId", required = false, defaultValue = "-1") String rootId,
            @RequestParam(value = "multiple", required = false, defaultValue = "false") Boolean multiple){
        ModelAndView mv = null;

        if (target == 0 || target == 4) {
            if (multiple) {
                mv = new ModelAndView("common/select/select-multiple-person");
            } else {
                mv = new ModelAndView("common/select/select-single-person");
            }
        } else {
            if (multiple) {
                mv = new ModelAndView("common/select/select-multiple-organization");
            } else {
                mv = new ModelAndView("common/select/select-single-organization");
            }
        }

        mv.getModel().put("target", target);
        mv.getModel().put("rootId", rootId);
        mv.getModel().put("multiple", multiple);
        mv.getModel().put("criteria", new SearchCriteria());
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "getData")
    public Object getData(
            @RequestParam(value = "id", required = false) String id,
            @RequestParam(value = "target", required = false, defaultValue = "0") Integer target) {
        String[] ids = StringUtils.split(id, ",");
        return selectService.getData(ids, target);
    }

    @ResponseBody
    @RequestMapping(value = "organization")
    public Object organizationTree(@ModelAttribute("criteria") SearchCriteria criteria) {
        String orgid = criteria.getOrgid();
        if (orgid != null) {
            // orgid, level, psco, deptFlag
            return selectService.zTreefindSubOrgs(criteria);
        } else {
            String rootId = criteria.getRootId();
            if (rootId == null) {
                return new ArrayList();
            } else if (rootId.equals("0") || rootId.equals("-2")) {
                // rootId, deptFlag
                criteria.setOrgid("0");
                criteria.setPsco(0);
                return selectService.zTreefindSubOrgs(criteria, true);
            } else {
                // rootId == -1 or other
                return selectService.zTreefindThroughOrg(criteria);
                // 得到的结果 设置了 psco，没有level，level在这里忽略，s >> c
            }
        }
    }

    @ResponseBody
    @RequestMapping(value = "findOrg")
    public Object findOrg(SearchCriteria criteria) {
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "user")
    public List userTree(SearchCriteria criteria) {
        return null;
    }

    // 获取通讯组用户
    @ResponseBody
    @RequestMapping(value = "userGroupMember")
    public List getUserOfGroup(String groupid) {
        return null;
    }

    // 获取单位组成员
    @ResponseBody
    @RequestMapping(value = "orgGroupMember")
    public List orgGroupMember(String groupid) {
        return null;
    }
}
