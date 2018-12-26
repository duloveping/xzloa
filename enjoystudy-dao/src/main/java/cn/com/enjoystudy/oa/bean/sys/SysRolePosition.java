package cn.com.enjoystudy.oa.bean.sys;

import cn.com.enjoystudy.oa.bean.EntitySupport;
import cn.com.enjoystudy.oa.bean.base.BasePosition;

public class SysRolePosition extends EntitySupport {
    /** 角色ID */
    private String roleId;
    /** 职位ID */
    private String positionId;
    /** 角色 */
    private SysRole role;
    /** 职位 */
    private BasePosition position;

    public SysRolePosition() {
    }

    public SysRolePosition(String roleId, String positionId) {
        this.roleId = roleId;
        this.positionId = positionId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public SysRole getRole() {
        return role;
    }

    public void setRole(SysRole role) {
        this.role = role;
    }

    public BasePosition getPosition() {
        return position;
    }

    public void setPosition(BasePosition position) {
        this.position = position;
    }
}
