package cn.com.enjoystudy.oa.bean.study;

/**
 * 考卷试题
 * @author 广州新咨力科技有限公司-杜永生
 */
public class ExaminationQuestionSO extends QuestionSO {
    //** 考卷 */
    private ExaminationPaper paper;
    /** 考卷ID */
    private String paperId;

    public ExaminationQuestionSO() {
    }

    public ExaminationPaper getPaper() {
        return paper;
    }

    public void setPaper(ExaminationPaper paper) {
        this.paper = paper;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

}
