package cn.com.enjoystudy.oa.bean.web;

import cn.com.enjoystudy.oa.bean.EntitySupport;

/**
 * 新闻类别
 * @author 广州新咨力科技有限公司-杜永生
 *
 */
public class NewsType extends EntitySupport {
    /** 编号 */
    private String code;
    /** 名称 */
    private String name;
    /** 显示状态 */
    private Boolean showState;
    /** 父级ID */
    private String parentId;

    public NewsType() {
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
