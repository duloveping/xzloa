package cn.com.enjoystudy.oa.bean.web;

import cn.com.enjoystudy.oa.bean.SOSupport;

/**
 * 广告位置
 * @author 广州新咨力科技有限公司-杜永生
 *
 */
public class AdvertisementPlaceSO extends SOSupport {
    /** 显示状态 */
    private Boolean showState;
    /** 编号 */
    private String code;
    /** 名称 */
    private String name;
    /** 所属位置 */
    private String placeId;
    /** 归类 */
    private String category;
    /** html的class属性值 */
    private String cssClass;
    /** html的style属性值 */
    private String cssStyle;
    /** 宽度 */
    private Integer width;
    /** 高度 */
    private Integer height;
    /** 描述 */
    private String description;
    /** 更多链接 */
    private String moreUrl;
    /** 图标 */
    private String icon;
    /** 排序号 */
    private Integer serialNumber;

    public AdvertisementPlaceSO() {
    }

    public Boolean getShowState() {
        return showState;
    }

    public void setShowState(Boolean showState) {
        this.showState = showState;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMoreUrl() {
        return moreUrl;
    }

    public void setMoreUrl(String moreUrl) {
        this.moreUrl = moreUrl;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }
}
