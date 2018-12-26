package cn.com.enjoystudy.oa.tag.system;


import cn.com.enjoystudy.oa.bean.sys.SysMenu;
import cn.com.enjoystudy.oa.bean.sys.SysMenuSO;
import cn.com.enjoystudy.oa.service.sys.SysMenuService;
import cn.com.enjoystudy.oa.tag.BaseTagSupport;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class SysMenuListTag extends BaseTagSupport {
    /** 菜单编号 */
    private String code;
    /** 菜单名称 */
    private String name;
    /** 类型：1菜单，2权限 */
    private Integer category;
    /** 显示状态 */
    private Boolean showState;
    /** 所属父级ID */
    private String parentId;

    @Override
    protected int doStartTagInternal() throws Exception {
        List<SysMenu> list = null;
        SysMenuService service = (SysMenuService) getBean(SysMenuService.class);
        if (null != service) {
            SysMenuSO so = new SysMenuSO();
            so.setShowState(showState);
            so.setCategory(category);
            so.setName(name);
            so.setCode(code);

            if (StringUtils.isNotBlank(parentId)) {
                so.setParentId(parentId);
            }

            list = service.list(so);
        }
        pageContext.setAttribute(getVarid(), list);
        return SKIP_PAGE;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Boolean getShowState() {
        return showState;
    }

    public void setShowState(Boolean showState) {
        this.showState = showState;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}

