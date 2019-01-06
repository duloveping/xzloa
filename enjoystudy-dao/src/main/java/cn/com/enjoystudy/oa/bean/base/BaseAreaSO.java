package cn.com.enjoystudy.oa.bean.base;

import cn.com.enjoystudy.oa.bean.SOSupport;

/**
 * 地区信息
 * @author 广州新咨力科技有限公司-杜永生
 */
public class BaseAreaSO extends SOSupport {
    /** 编号 */
    private String code;
    /** 名称 */
    private String name;
    /** 父级ID */
    private String parentId;

    public BaseAreaSO() {
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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
