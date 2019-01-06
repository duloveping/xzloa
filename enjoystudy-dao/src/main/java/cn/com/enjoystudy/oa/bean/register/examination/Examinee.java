package cn.com.enjoystudy.oa.bean.register.examination;

import cn.com.enjoystudy.oa.bean.base.BaseCommunication;
import cn.com.enjoystudy.oa.bean.base.BaseEducation;
import cn.com.enjoystudy.oa.bean.base.EmployeeAccount;

import java.util.List;

/**
 * 考试信息
 * @author 广州新咨力科技有限公司-杜永生
 */
public class Examinee extends EmployeeAccount {
    /** 联系方式 */
    private BaseCommunication baseCommunication;
    /** 教育方式 */
    private BaseEducation baseEducation;
    /** 教育经历 */
    private List<ExamineeEducation> educationList;
    /** 工作经历 */
    private List<ExamineeCommunication> communicationList;

    public Examinee() {
    }

    public BaseCommunication getBaseCommunication() {
        return baseCommunication;
    }

    public void setBaseCommunication(BaseCommunication baseCommunication) {
        this.baseCommunication = baseCommunication;
    }

    public BaseEducation getBaseEducation() {
        return baseEducation;
    }

    public void setBaseEducation(BaseEducation baseEducation) {
        this.baseEducation = baseEducation;
    }

    public List<ExamineeEducation> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<ExamineeEducation> educationList) {
        this.educationList = educationList;
    }

    public List<ExamineeCommunication> getCommunicationList() {
        return communicationList;
    }

    public void setCommunicationList(List<ExamineeCommunication> communicationList) {
        this.communicationList = communicationList;
    }
}
