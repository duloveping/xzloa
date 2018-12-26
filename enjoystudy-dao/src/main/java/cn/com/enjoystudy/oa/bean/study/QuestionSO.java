package cn.com.enjoystudy.oa.bean.study;

import cn.com.enjoystudy.oa.bean.SOSupport;

/**
 * 课程视频练习题作答解析
 * @author 广州新咨力科技有限公司-杜永生
 */
public class QuestionSO extends SOSupport {
    /** 题目 */
    private String title;
    /** 类型：1单选题，2多选题，3不定项选择题，4判断题，5填空题，6主观题 */
    private Integer category;
    /** 分数 */
    private Integer score;

    public QuestionSO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
