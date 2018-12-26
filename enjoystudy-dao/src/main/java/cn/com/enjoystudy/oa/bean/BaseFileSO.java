package cn.com.enjoystudy.oa.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class BaseFileSO extends SOSupport {
    /** 显示状态 */
    private Boolean showState;
    /** 文件名称（原始名称） */
    private String fileName;
    /** 文件类型（扩展名） */
    private String fileType;
    /** 文件大小 */
    private Long fileSize;
    /** 文件路径 */
    private String filePath;
    /** 上传时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date uploadTime;

    public BaseFileSO() {
    }

    public Boolean getShowState() {
        return showState;
    }

    public void setShowState(Boolean showState) {
        this.showState = showState;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }
}
