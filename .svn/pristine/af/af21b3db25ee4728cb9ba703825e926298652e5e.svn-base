package cn.com.enjoystudy.oa.bean.common;

import java.util.List;

public class SearchCriteria {
    private String currentUserId;
    // 选择 organization 条件
    private String rootId;
    private String orgid;
    // 0: 包括部门, 1：不包括部门, 2：只包括当前单位下的部门
    private Integer deptFlag;
    private Integer level = -1;
    // parent, self, child, other
    private Integer psco = 0;
    // 选择 用户 条件
    private Boolean isParent;
    // 如果有多个orgid，就使用orgidList存储orgid
    private List<String> orgidList;
    private String name;
    private List<String> nameList;
    private List<String> invisibleOrgIdList;

    public SearchCriteria() {
    }

    public String getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(String currentUserId) {
        this.currentUserId = currentUserId;
    }

    public String getRootId() {
        return rootId;
    }

    public void setRootId(String rootId) {
        this.rootId = rootId;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public Integer getDeptFlag() {
        return deptFlag;
    }

    public void setDeptFlag(Integer deptFlag) {
        this.deptFlag = deptFlag;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getPsco() {
        return psco;
    }

    public void setPsco(Integer psco) {
        this.psco = psco;
    }

    public Boolean getParent() {
        return isParent;
    }

    public void setParent(Boolean parent) {
        isParent = parent;
    }

    public List<String> getOrgidList() {
        return orgidList;
    }

    public void setOrgidList(List<String> orgidList) {
        this.orgidList = orgidList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    public List<String> getInvisibleOrgIdList() {
        return invisibleOrgIdList;
    }

    public void setInvisibleOrgIdList(List<String> invisibleOrgIdList) {
        this.invisibleOrgIdList = invisibleOrgIdList;
    }
}
