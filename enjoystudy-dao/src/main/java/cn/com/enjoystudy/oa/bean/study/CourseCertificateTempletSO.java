package cn.com.enjoystudy.oa.bean.study;

import cn.com.enjoystudy.oa.bean.SOSupport;

public class CourseCertificateTempletSO extends SOSupport {
    private String courseId;
    private String content;

    public CourseCertificateTempletSO() {
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
