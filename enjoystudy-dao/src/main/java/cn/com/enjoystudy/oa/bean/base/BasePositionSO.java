package cn.com.enjoystudy.oa.bean.base;

import cn.com.enjoystudy.oa.bean.SOSupport;
import cn.com.enjoystudy.oa.bean.sys.SysRole;
import cn.com.enjoystudy.oa.bean.sys.SysRolePosition;

import java.util.List;

/**
 * 职务
 * @author 广州新咨力科技有限公司-杜永生
 */
public class BasePositionSO extends SOSupport {
    /** 职务编号 */
    private String code;
    /** 职务名称 */
    private String name;
    /** 备注信息 */
    private String caption;
    /** 显示状态 */
    private Boolean showState;
    /** 排序序号 */
    private Integer serialNumber;
    private List<SysRole> sysRoleList;
    private List<SysRolePosition> sysRolePositionList;

    public BasePositionSO() {
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

    public List<SysRole> getSysRoleList() {
        return sysRoleList;
    }

    public void setSysRoleList(List<SysRole> sysRoleList) {
        this.sysRoleList = sysRoleList;
    }

    public List<SysRolePosition> getSysRolePositionList() {
        return sysRolePositionList;
    }

    public void setSysRolePositionList(List<SysRolePosition> sysRolePositionList) {
        this.sysRolePositionList = sysRolePositionList;
    }
}
