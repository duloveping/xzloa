package cn.com.enjoystudy.oa.bean;

import cn.com.enjoystudy.oa.util.IdGenerateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class EntitySupport implements Serializable {
    private static final long serialVersionUID = -4529725793029080576L;
    /** 流水号 */
    private String id;
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
    /** 排序号 */
    private Integer serialNumber;

    public EntitySupport() {
    }

    /**
     * 插入之前执行方法，子类实现
     */
    public void preInsert() {
        this.id = IdGenerateUtils.getRandomUUID();
        this.createTime = new Date();
        this.updateTime = this.createTime;
        this.flag = Boolean.TRUE;
        this.status = this.flag;
        this.serialNumber = 0;
    }

    /**
     * 更新之前执行方法，子类实现
     */
    public void preUpdate() {
        this.updateTime = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }
}

