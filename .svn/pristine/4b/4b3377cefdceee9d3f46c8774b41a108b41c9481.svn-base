package cn.com.enjoystudy.oa.bean;

import com.github.pagehelper.PageInfo;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class SOSupport extends PageInfo implements Serializable {
    private static final long serialVersionUID = 9046906931951512513L;
    /** 流水号 */
    private String id;
    private String[] ids;
    /** 创建时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /** 修改时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /** 标记 */
    private Boolean flag;
    /** 状态 */
    private Boolean status;
    private String exceptId;
    private String[] exceptIds;
    private Boolean like;

    public SOSupport() {
        this.like = Boolean.TRUE;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getExceptId() {
        return exceptId;
    }

    public void setExceptId(String exceptId) {
        this.exceptId = exceptId;
    }

    public Boolean getLike() {
        return like;
    }

    public void setLike(Boolean like) {
        this.like = like;
    }

    public String[] getExceptIds() {
        return exceptIds;
    }

    public void setExceptIds(String[] exceptIds) {
        this.exceptIds = exceptIds;
    }
}
