package cn.com.enjoystudy.oa.bean.web;

import cn.com.enjoystudy.oa.bean.EntitySupport;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 新闻
 * @author 广州新咨力科技有限公司-杜永生
 *
 */
public class News extends EntitySupport {
    /** 标题 */
    private String title;
    /** 作者 */
    private String author;
    /** 发布时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date publishTime;
    /** 发布人ID */
    private String publisherId;
    /** 发布人姓名 */
    private String publisherName;
    /** 显示状态 */
    private Boolean showState;
    /** 所属类别ID */
    private String typeId;
    /** 所属类别名称 */
    private String typeName;
    /** 点击次数 */
    private Integer clickAmount;
    /** 收藏次数 */
    private Integer loveAmount;
    /** 点赞次数 */
    private Integer starAmount;
    /** 评论次数 */
    private Integer remarkAmount;
    /** 图片 */
    private String image;
    /** 简介 */
    private String introduction;
    /** 描述 */
    private String description;

    public News() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public Boolean getShowState() {
        return showState;
    }

    public void setShowState(Boolean showState) {
        this.showState = showState;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getClickAmount() {
        return clickAmount;
    }

    public void setClickAmount(Integer clickAmount) {
        this.clickAmount = clickAmount;
    }

    public Integer getLoveAmount() {
        return loveAmount;
    }

    public void setLoveAmount(Integer loveAmount) {
        this.loveAmount = loveAmount;
    }

    public Integer getStarAmount() {
        return starAmount;
    }

    public void setStarAmount(Integer starAmount) {
        this.starAmount = starAmount;
    }

    public Integer getRemarkAmount() {
        return remarkAmount;
    }

    public void setRemarkAmount(Integer remarkAmount) {
        this.remarkAmount = remarkAmount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
