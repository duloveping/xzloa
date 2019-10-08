package cn.com.enjoystudy.oa.common;

public class Constants {
    public static final String SECURITY_QUESTION_1 = "我就读的第一所学校的名称？";
    public static final String SECURITY_QUESTION_2 = "我最喜欢的运动是什么？";
    public static final String SECURITY_QUESTION_3 = "我最喜欢的运动员是谁？";
    public static final String SECURITY_QUESTION_4 = "我最喜欢的物品名称？";
    public static final String SECURITY_QUESTION_5 = "我最喜欢的歌曲？";
    public static final String SECURITY_QUESTION_6 = "妈妈的生日是？";
    public static final String SECURITY_QUESTION_7 = "我最喜欢的食物是？";
    public static final String SECURITY_QUESTION_8 = "我最爱的人的名字？";
    public static final String SECURITY_QUESTION_9 = "我最爱的电影？";
    public static final String SECURITY_QUESTION_10 = "爸爸的生日是？";
    public static final String[] SECURITY_QUESTION_LIST = {SECURITY_QUESTION_1, SECURITY_QUESTION_2, SECURITY_QUESTION_3,
            SECURITY_QUESTION_4, SECURITY_QUESTION_5, SECURITY_QUESTION_6, SECURITY_QUESTION_7, SECURITY_QUESTION_8,
            SECURITY_QUESTION_9, SECURITY_QUESTION_10};

    public static final Integer COMMUNICATION_CATEGORY_MYSELF = 1;

    /** 用户类型 - 系统用户 */
    public static final Integer ACCOUNT_CATEGORY_SYSTEM = 1;
    /** 用户类型 - 政府单位 */
    public static final Integer ACCOUNT_CATEGORY_GOVERNMENT = 2;
    /** 用户类型 - 企业单位 */
    public static final Integer ACCOUNT_CATEGORY_COMPANY = 3;
    /** 用户类型 - 学校单位 */
    public static final Integer ACCOUNT_CATEGORY_SCHOOL = 4;
    /** 用户类型 - 协会单位 */
    public static final Integer ACCOUNT_CATEGORY_INSTITUTE = 5;
    /** 用户类型 - 员工用户 */
    public static final Integer ACCOUNT_CATEGORY_EMPLOYEE = 6;
    /** 用户类型 - 老师 */
    public static final Integer ACCOUNT_CATEGORY_TEACHER = 7;
    /** 用户类型 - 学生（考生） */
    public static final Integer ACCOUNT_CATEGORY_STUDENT = 8;
    /** 用户类型 - 个人 */
    public static final Integer ACCOUNT_CATEGORY_PERSONAL = 9;

    /** 考试状态 - 等待考试 */
    public static final Integer TEST_STATE_WAIT = 1;
    /** 考试状态 - 开始考试 */
    public static final Integer TEST_STATE_START = 2;
    /** 考试状态 - 结束考试 */
    public static final Integer TEST_STATE_END = 3;

    /** 购物订单支付状态 - 待支付 */
    public static final Integer PAY_STATE_NO = 0;
    /** 购物订单支付状态 - 已支付 */
    public static final Integer PAY_STATE_YES = 1;

    /** 购物订单支付类型 - 其他 */
    public static final Integer PAY_STATE_OTHER = 0;
    /** 购物订单支付类型 - 微信 */
    public static final Integer PAY_STATE_WECHAT = 1;
    /** 购物订单支付类型 - 支付宝 */
    public static final Integer PAY_STATE_ALIPAY = 2;
    /** 购物订单支付类型 - 银联 */
    public static final Integer PAY_STATE_UNIONPAY = 3;


    /** 购物订单状态 - 待付款 */
    public static final Integer ORDER_STATE_PAY = 0;
    /** 购物订单状态 - 待发货 */
    public static final Integer ORDER_STATE_SEND = 1;
    /** 购物订单状态 - 待收货 */
    public static final Integer ORDER_STATE_RECEIVE = 2;
    /** 购物订单状态 - 待评价 */
    public static final Integer ORDER_STATE_REMARK = 3;
    /** 购物订单状态 - 完成 */
    public static final Integer ORDER_STATE_FINISH= 4;
    /** 购物订单状态 - 关闭 */
    public static final Integer ORDER_STATE_CLOSE = 5;
    /** 购物订单状态 - 无效 */
    public static final Integer ORDER_STATE_DISABLED = 6;
    /** 购物订单状态 - 删除 */
    public static final Integer ORDER_STATE_DELETE = 7;

    public static final String POSITION_SYS_STUDENT = "sys-student";

    /** 微信开放平台审核通过的应用APPID */
    public static final String WX_APPID = "wx9989a18bc4714287";
    /** 微信支付分配的商户号 */
    public static final String WX_MCH_ID = "1553413341";
    public static final String WX_MCH_KEY = "zsxzl0760b4c09247ec02duys69f1985";
    public static final String WX_MCH_PWD = "xzl0760dys1985++";
}