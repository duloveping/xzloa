package cn.com.enjoystudy.oa.bean.sys;

import cn.com.enjoystudy.oa.bean.EntitySupport;

public class SysSequence extends EntitySupport {
    /** 序号编号 */
    private String seqCode;
    /** 序号名称 */
    private String seqName;
    /** 序号值 */
    private Integer seqValue;

    public SysSequence() {
    }

    public SysSequence(String seqCode, String seqName, Integer seqValue) {
        this.seqCode = seqCode;
        this.seqName = seqName;
        this.seqValue = seqValue;
    }

    public String getSeqCode() {
        return seqCode;
    }

    public void setSeqCode(String seqCode) {
        this.seqCode = seqCode;
    }

    public String getSeqName() {
        return seqName;
    }

    public void setSeqName(String seqName) {
        this.seqName = seqName;
    }

    public Integer getSeqValue() {
        return seqValue;
    }

    public void setSeqValue(Integer seqValue) {
        this.seqValue = seqValue;
    }
}
