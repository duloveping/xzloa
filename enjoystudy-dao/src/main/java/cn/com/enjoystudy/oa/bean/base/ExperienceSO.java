package cn.com.enjoystudy.oa.bean.base;

import cn.com.enjoystudy.oa.bean.SOSupport;

import java.util.Date;

/**
 * 经验
 * @author 广州新咨力科技有限公司-杜永生
 */
public abstract class ExperienceSO extends SOSupport {
    /** 入职日期 */
    private Date startDate;
    /** 离职日期 */
    private Date endDate;
    /** 职称 */
    private String title;
    /** 工作职务 */
    private String duty;
    /** 工作单位名称 */
    private String company;
    /** 工作部门名称 */
    private String department;
    /** 直属上司姓名 */
    private String bossName;
    /** 直属上司联系方式 */
    private String bossPhone;
    /** 工作单位省ID */
    private String provinceId;
    /** 工作单位省编号 */
    private String provinceCode;
    /** 工作单位省名称 */
    private String provinceName;
    /** 工作单位市ID */
    private String cityId;
    /** 工作单位市编号 */
    private String cityCode;
    /** 工作单位市名称 */
    private String cityName;
    /** 工作单位镇ID */
    private String townId;
    /** 工作单位镇编号 */
    private String townCode;
    /** 工作单位镇名称 */
    private String townName;
    /** 工作单位详细地址 */
    private String address;
    /** 工作单位邮政编号 */
    private String postCode;
    /** 工作单位固定电话 */
    private String phone;
    /** 工作单位传真 */
    private String fax;
    /** 工作单位邮箱 */
    private String email;
    /** 工作描述 */
    private String work;
}
