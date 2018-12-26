package cn.com.enjoystudy.oa.bean.study;

import cn.com.enjoystudy.oa.bean.EntitySupport;
import cn.com.enjoystudy.oa.bean.SOSupport;

public class QuestionAnalysisSO extends SOSupport {
    /** 考题ID */
    private String questionId;
    /** 解析内容 */
    private String content;

    public QuestionAnalysisSO() {
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
