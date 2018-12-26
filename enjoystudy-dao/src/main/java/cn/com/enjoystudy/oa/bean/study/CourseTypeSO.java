package cn.com.enjoystudy.oa.bean.study;

import cn.com.enjoystudy.oa.bean.SOSupport;

/**
 * 课程类型
 * @author 广州新咨力科技有限公司-杜永生
 */
public class CourseTypeSO extends SOSupport {
    /** 课程编号 */
    private String code;
    /** 课程名称 */
    private String name;
    /** 备注 */
    private String caption;
    /** 所属父级ID */
    private String parentId;
    private String[] parentIds;
    /** 所属父级名称 */
    private String parentName;
    private String[] parentNames;

    public CourseTypeSO() {
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

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String[] getParentIds() {
        return parentIds;
    }

    public void setParentIds(String[] parentIds) {
        this.parentIds = parentIds;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String[] getParentNames() {
        return parentNames;
    }

    public void setParentNames(String[] parentNames) {
        this.parentNames = parentNames;
    }
}
