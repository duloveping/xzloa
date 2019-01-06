package cn.com.enjoystudy.oa.bean.register.examination;

import cn.com.enjoystudy.oa.bean.base.BaseCommunication;
import cn.com.enjoystudy.oa.bean.base.BaseEducation;
import cn.com.enjoystudy.oa.bean.base.EmployeeAccountSO;

import java.util.List;

/**
 * 考试信息
 * @author 广州新咨力科技有限公司-杜永生
 */
public class ExamineeSO extends EmployeeAccountSO {
    /** 联系方式 */
    private BaseCommunication communication;
    /** 教育方式 */
    private BaseEducation education;
    /** 教育经历 */
    private List<ExamineeEducation> educationList;
    /** 工作经历 */
    private List<ExamineeCommunication> communicationList;

    public ExamineeSO() {
    }
}
