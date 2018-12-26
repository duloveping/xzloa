package cn.com.enjoystudy.oa.bean.sys;

import cn.com.enjoystudy.oa.bean.SOSupport;

import java.util.List;

/**
 * 角色
 * @author 广州新咨力科技有限公司-杜永生
 */
public class SysRoleSO extends SOSupport {
    /** 角色编号 */
    private String code;
    /** 角色名称 */
    private String name;
    /** 备注信息 */
    private String caption;
    /** 显示状态 */
    private Boolean showState;
    /** 排序序号 */
    private Integer serialNumber;
    private List<SysRoleMenu> sysRoleMenuList;

    public SysRoleSO() {
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

    public Boolean getShowState() {
        return showState;
    }

    public void setShowState(Boolean showState) {
        this.showState = showState;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public List<SysRoleMenu> getSysRoleMenuList() {
        return sysRoleMenuList;
    }

    public void setSysRoleMenuList(List<SysRoleMenu> sysRoleMenuList) {
        this.sysRoleMenuList = sysRoleMenuList;
    }
}
