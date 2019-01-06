package cn.com.enjoystudy.oa.bean.register.examination;

import cn.com.enjoystudy.oa.bean.EntitySupport;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 账号注册
 * @author 广州新咨力科技有限公司-杜永生
 */
public class AccountRegister extends EntitySupport {
    /** 用户名 */
    private String username;
    /** 姓名 */
    private String realname;
    /** 昵称 */
    private String nickname;
    /** 登录密码 */
    private String loginPassword;
    /** 确认密码 */
    private String confirmPassword;
    /** 性别 */
    private Integer sex;
    /** 出生日期 */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    /** 验证码 */
    private String checkCode;
    /** 证件类型：
     * 99.其他
     * 1.居民身份证
     * 2.军官证
     * 3.香港特区护照/身份证明
     * 4.澳门特区护照/身份证明
     * 5.台湾居民来往大陆通行证
     * 6.境外永久居住证
     */
    private Integer identityType;
    /** 证件号码 */
    private String identityCode;
    /** 密码找回问题 */
    private String question;
    /** 密码找回答案 */
    private String answer;
    /** 省ID */
    private String provinceId;
    /** 省名称 */
    private String provinceName;
    /** 市ID */
    private String cityId;
    /** 市名称 */
    private String cityName;
    /** 镇ID */
    private String townId;
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

    public AccountRegister() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public Integer getIdentityType() {
        return identityType;
    }

    public void setIdentityType(Integer identityType) {
        this.identityType = identityType;
    }

    public String getIdentityCode() {
        return identityCode;
    }

    public void setIdentityCode(String identityCode) {
        this.identityCode = identityCode;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
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
