package cn.com.enjoystudy.oa.bean.register.examination;

import cn.com.enjoystudy.oa.bean.EntitySupport;

import java.util.List;

/**
 * 考试计划
 * @author 广州新咨力科技有限公司-杜永生
 */
public class ExaminationPlanRegister extends EntitySupport {
    /** 标题 */
    private String title;
    /** 显示状态 */
    private Boolean showState;
    /** 报告描述 */
    private String content;
    private List<ExaminationPlanList> planList;

    public ExaminationPlanRegister() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getShowState() {
        return showState;
    }

    public void setShowState(Boolean showState) {
        this.showState = showState;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<ExaminationPlanList> getPlanList() {
        return planList;
    }

    public void setPlanList(List<ExaminationPlanList> planList) {
        this.planList = planList;
    }
}
