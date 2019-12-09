<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <title>订单支付</title>
    <link href="/static/js/common/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="/static/js/common/H-ui.admin_v3.0/lib/Hui-iconfont/1.0.8/iconfont.min.css" rel="stylesheet" type="text/css">
    <link href="<c:url value='/static/js/templates/web/index/Style2018.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/static/js/templates/web/index/css.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/static/js/templates/web/index/lrtk.css'/>" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="/WEB-INF/views/web/index/header-top.jsp" %>
<%@ include file="/WEB-INF/views/web/index/header-navigation.jsp" %>
<table border="0" cellpadding="0" cellspacing="0" style="width:1200px; margin:0px auto; margin-top:20px;">
    <tbody>
    <tr>
        <td colspan="2" valign="top" style="border-bottom:1px dashed #c8c8c8;">
            <div style="width:100%; height:45px; line-height:45px; border-bottom:2px solid #eeeeee;">
                <div class="LmIcon"></div>
                <div class="LmTitle"><span style="font-size:16px;">订单支付</span></div>
            </div>
            <table id="courseTable" border="0" cellpadding="3" cellspacing="0" class="KCDetailTable" style="margin-bottom:20px;">
                <tbody>
                <tr>
                    <td rowspan="9" valign="middle" style="width:330px; text-align:center; border:1px solid #eeeeee;">
                        <img id="payImg" src="/web/allinpay/unitorder-pay/weixin-pay.jhtml?orderId=${order.id}" style="width:300px; height:300px;">
                    </td>
                    <td class="KCListTableTdValue">
                        <a id="payDesc" href="javascript:void(0)" style="color:#cc3300; font-size:20px; margin-left:20px;">请用微信扫描左侧的二维码支付订单</a>
                    </td>
                </tr>
                <tr>
                    <td class="KCListTableTdValue">
                        <span style="margin-left:20px;">订单编号：${order.orderCode}</span>
                    </td>
                </tr>
                <tr>
                    <td class="KCListTableTdValue">
                        <span style="margin-left:20px;">订单金额：<fmt:formatNumber value="${order.totalPrice}" pattern="#0.00"/>元</span>
                    </td>
                </tr>
                <tr>
                    <td class="KCListTableTdValue">
                        <span style="margin-left:20px;">订单时间：<fmt:formatDate value="${order.orderTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
                    </td>
                </tr>
                <tr>
                    <td class="KCListTableTdValue">
                        <span id="weixin" style="margin-left:20px; color:#cc3300; font-size:16px; cursor:pointer;">
                            <i class="Hui-iconfont">&#xe719</i>微信支付
                        </span>
                        <span id="alipay" style="color:#cc3300; font-size:16px; cursor:pointer;">
                            <i class="Hui-iconfont">&#xe730;</i>支付宝支付
                        </span>
                       <%-- <span id="unionpay" style="color:#cc3300; font-size:16px; cursor:pointer;">
                            <i class="Hui-iconfont">&#xe71d;</i>银联支付
                        </span>
                        <span id="qqpay" style="color:#cc3300; font-size:16px; cursor:pointer;">
                            <i class="Hui-iconfont">&#xe67b;</i>QQ支付
                        </span>--%>
                    </td>
                </tr>
                <tr>
                    <td class="KCListTableTdValue">&nbsp;</td>
                </tr>
                <tr>
                    <td class="KCListTableTdValue">&nbsp;</td>
                </tr>
                <tr>
                    <td class="KCListTableTdValue">&nbsp;</td>
                </tr>
                </tbody>
            </table>
        </td>
    </tr>
    </tbody>
</table>
<%@ include file="/WEB-INF/views/web/index/fooder.jsp" %>
<script type="text/javascript" src="<c:url value='/static/js/common/jquery/jquery-1.11.3.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/js/templates/web/index/function.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/js/templates/web/index/fordboy.js'/>"></script>
<script type="text/javascript">
    $(function () {
        var payImg = $("#payImg");
        var payDesc = $("#payDesc");
        $("#weixin").on("click", function () {
            payImg.prop("src", "/web/allinpay/unitorder-pay/weixin-pay.jhtml?orderId=${order.id}") ;
            payDesc.text("请用微信扫描左侧的二维码支付订单");
        });
        $("#alipay").on("click", function () {
            payImg.prop("src", "/web/allinpay/unitorder-pay/alipay.jhtml?orderId=${order.id}");
            payDesc.text("请用支付宝扫描左侧的二维码支付订单");
        });
        $("#unionpay").on("click", function () {
            payImg.prop("src", "/web/allinpay/unitorder-pay/unionpay.jhtml?orderId=${order.id}");
            payDesc.text("请用银行APP扫描左侧的二维码支付订单");
        });
        $("#qqpay").on("click", function () {
            payImg.prop("src", "/web/allinpay/unitorder-pay/qqpay.jhtml?orderId=${order.id}");
            payDesc.text("请用QQ扫描左侧的二维码支付订单");
        });
    });
</script>
</body>
</html>