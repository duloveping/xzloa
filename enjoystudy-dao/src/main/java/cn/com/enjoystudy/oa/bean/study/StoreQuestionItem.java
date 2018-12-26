package cn.com.enjoystudy.oa.bean.study;

import cn.com.enjoystudy.oa.bean.EntitySupport;

public class StoreQuestionItem extends EntitySupport {
    /** 练习题ID */
    private String questionId;
    /** 标题 */
    private String title;
    /** 是否为参考答案 */
    private Boolean isAnswer;

    public StoreQuestionItem() {
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getAnswer() {
        return isAnswer;
    }

    public void setAnswer(Boolean answer) {
        isAnswer = answer;
    }
}
