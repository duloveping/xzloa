package cn.com.enjoystudy.oa.bean.web;

import cn.com.enjoystudy.oa.bean.SOSupport;

import java.util.Date;

public class AdvertisementSO extends SOSupport {
    /** 显示状态 */
    private Boolean showState;
    /** 所属位置ID */
    private String placeId;
    /** 所属位置编号 */
    private String placeCode;
    /** 所属位置名称 */
    private String placeName;
    /** 所属位置显示状态 */
    private Boolean placeState;
    /** html的class属性值 */
    private String cssClass;
    /** html的style属性值 */
    private String cssStyle;
    /** 类型 */
    private String category;
    /** 大图（原始图） */
    private String large;
    /** 中图 */
    private String middle;
    /** 小图 */
    private String small;
    /** 缩略图 */
    private String icon;
    /** 标题 */
    private String title;
    /** 上传时间 */
    private Date uploadTime;
    /** url地址 */
    private String url;
    /** 宽度 */
    private Integer width;
    /** 高度 */
    private Integer height;
    /** 现价 */
    private Double currentPrice;
    /** 市价 */
    private Double marketPrice;
    /** 促销价 */
    private Double salePrice;
    /** 课时数 */
    private Integer lessonAmount;

    public AdvertisementSO() {
    }

    public Boolean getShowState() {
        return showState;
    }

    public void setShowState(Boolean showState) {
        this.showState = showState;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getPlaceCode() {
        return placeCode;
    }

    public void setPlaceCode(String placeCode) {
        this.placeCode = placeCode;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Boolean getPlaceState() {
        return placeState;
    }

    public void setPlaceState(Boolean placeState) {
        this.placeState = placeState;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getCssStyle() {
        return cssStyle;
    }

    public void setCssStyle(String cssStyle) {
        this.cssStyle = cssStyle;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getLessonAmount() {
        return lessonAmount;
    }

    public void setLessonAmount(Integer lessonAmount) {
        this.lessonAmount = lessonAmount;
    }
}
