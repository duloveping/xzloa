package cn.com.enjoystudy.oa.bean.base;

import cn.com.enjoystudy.oa.bean.EntitySupport;

/**
 * 组织架构
 * @author 广州新咨力科技有限公司-杜永生
 */
public class BaseOrganization extends EntitySupport {
    /** 分类：1单位，2部门，3组 */
    private Integer category;
    /** 部门编号 */
    private String code;
    /** 部门名称 */
    private String name;
    private BaseOrganization parent;
    /** 上级ID */
    private String parentId;
    /** 上级名称 */
    private String parentName;
    /** 备注信息 */
    private String caption;

    public BaseOrganization() {
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
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

    public BaseOrganization getParent() {
        return parent;
    }

    public void setParent(BaseOrganization parent) {
        this.parent = parent;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
