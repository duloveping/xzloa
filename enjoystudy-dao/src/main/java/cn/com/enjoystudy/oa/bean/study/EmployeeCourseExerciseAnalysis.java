package cn.com.enjoystudy.oa.bean.study;

import cn.com.enjoystudy.oa.bean.EntitySupport;

/**
 * 员工课程练习题答题解析
 * @author 广州新咨力科技有限公司-杜永生
 */
public class EmployeeCourseExerciseAnalysis extends EntitySupport {
    /** 员工课程练习题练习题ID */
    private String exerciseId;
    /** 解析内容 */
    private String content;

    public EmployeeCourseExerciseAnalysis() {
    }

    public String getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(String exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
