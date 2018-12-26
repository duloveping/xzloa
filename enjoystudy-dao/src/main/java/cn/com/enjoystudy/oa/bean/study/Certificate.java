package cn.com.enjoystudy.oa.bean.study;

import cn.com.enjoystudy.oa.bean.EntitySupport;

/**
 * 证书
 * @author 广州新咨力科技有限公司-杜永生
 */
public class Certificate extends EntitySupport {
    /** 证书名称 */
    private String name;
    /** 发证机构 */
    private String department;
    /** 机构公章 */
    private String officialSeal;
    /** 证书等级 */
    private Integer grade;
    /** 证书模板 */
    private String templet;
    private String[] courseIds;

    public Certificate() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getOfficialSeal() {
        return officialSeal;
    }

    public void setOfficialSeal(String officialSeal) {
        this.officialSeal = officialSeal;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getTemplet() {
        return templet;
    }

    public void setTemplet(String templet) {
        this.templet = templet;
    }

    public String[] getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(String[] courseIds) {
        this.courseIds = courseIds;
    }
}
