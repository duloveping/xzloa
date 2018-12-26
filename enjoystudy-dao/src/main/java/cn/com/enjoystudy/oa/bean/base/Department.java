package cn.com.enjoystudy.oa.bean.base;

import cn.com.enjoystudy.oa.bean.EntitySupport;

/**
 * 部门
 * @author 广州新咨力科技有限公司-杜永生
 */
public class Department extends BaseOrganization {
    /** 部门联系电话 */
    private String phone;
    /** 负责人ID */
    private String bossId;
    /** 负责人姓名 */
    private String bossName;

    public Department() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBossId() {
        return bossId;
    }

    public void setBossId(String bossId) {
        this.bossId = bossId;
    }

    public String getBossName() {
        return bossName;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName;
    }
}
