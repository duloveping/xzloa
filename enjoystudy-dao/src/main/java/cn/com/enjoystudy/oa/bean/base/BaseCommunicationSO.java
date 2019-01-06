package cn.com.enjoystudy.oa.bean.base;

import cn.com.enjoystudy.oa.bean.SOSupport;

/**
 * 通讯信息
 * @author 广州新咨力科技有限公司-杜永生
 */
public abstract class BaseCommunicationSO extends SOSupport {
    /** 类型 */
    private Integer category;
    /** 省ID */
    private String provinceId;
    /** 省编号 */
    private String provinceCode;
    /** 省名称 */
    private String provinceName;
    /** 市ID */
    private String cityId;
    /** 市编号 */
    private String cityCode;
    /** 市名称 */
    private String cityName;
    /** 镇ID */
    private String townId;
    /** 镇编号 */
    private String townCode;
    /** 镇名称 */
    private String townName;
    /** 详细地址 */
    private String address;
    /** 邮政编号 */
    private String postCode;
    /** 手机号码 */
    private String mobile;
    /** 固定电话 */
    private String phone;
    /** 传真 */
    private String fax;
    /** 邮箱 */
    private String email;

    public BaseCommunicationSO() {
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getTownId() {
        return townId;
    }

    public void setTownId(String townId) {
        this.townId = townId;
    }

    public String getTownCode() {
        return townCode;
    }

    public void setTownCode(String townCode) {
        this.townCode = townCode;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
