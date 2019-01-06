package cn.com.enjoystudy.oa.bean.base;

import cn.com.enjoystudy.oa.bean.EntitySupport;

import java.util.Date;

/**
 * 教育（学历）信息
 * @author 广州新咨力科技有限公司-杜永生
 */
public abstract class BaseEducation extends EntitySupport {
    /** 入学日期 */
    private Date startDate;
    /** 毕业日期 */
    private Date endDate;
    /** 学历 */
    private String education;
    /** 毕业学院 */
    private String school;
    /** 主修专业 */
    private String major;

    public BaseEducation() {
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
