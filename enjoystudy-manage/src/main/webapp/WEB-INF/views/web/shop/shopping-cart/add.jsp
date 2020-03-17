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
    <title>成功添加到购物车</title>
    <link href="<c:url value='/static/js/templates/web/index/Style2018.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/static/js/templates/web/index/css.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/static/js/templates/web/index/lrtk.css'/>" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="/WEB-INF/views/web/index/header-top.jsp" %>
<%@ include file="/WEB-INF/views/web/index/header-navigation.jsp" %>
<table border="0" cellpadding="0" cellspacing="0" style="width:1200px; margin:0px auto; margin-top:10px;">
    <tbody>
        <tr>
            <td colspan="2" style="height:60px;">
                <img src="<c:url value="/static/js/images/BuyIcon.png"/>" style="vertical-align:top; margin-left:10px;">
                <span style="color:#7b9a6e; font-size:19px; margin-left:4px;">成功添加到购物车</span>
            </td>
        </tr>
        <tr>
            <td style="width:855px;">
                <table border="0" cellpadding="0" cellspacing="0" style="width:99%; border:1px dashed #c8c8c8;">
                    <tbody>
                        <tr>
                            <td rowspan="3" valign="top" style="width:200px; height:140px; text-align:center;">
                                <img src="<c:url value="${course.image}"/>" style="width:180px; height:120px; margin-top:10px;">
                            </td>
                            <td style="height:40px;"><span style="font-size:16px;">${course.name}</span></td>
                        </tr>
                        <tr>
                            <td valign="top" style="height:40px;">
                                <span>价格：<span style="color:#ff2832; font-size:20px; font-weight:bold; margin-right:3px;">￥<fmt:formatNumber value="${course.currentPrice}" pattern="###0.00"/></span>元</span>
                                <span style="margin-left:20px;">学时：${videoAmount}</span>
                            </td>
                        </tr>
                        <tr>
                            <td valign="top" style="height:60px;"><span>数量：</span><span>1</span></td>
                        </tr>
                    </tbody>
                </table>
            </td>
            <td style="width:345px;">
                <style type="text/css">
                    .viewProductDetails{width:168px; height:33px; line-height:33px; border:1px solid #ca2936; text-align:center; font-size:14px; color:#ca2936; cursor:pointer; margin-left:20px;}
                    .goToPayFor{width:170px; height:35px; line-height:35px; background-color:#e5383c; text-align:center; font-size:14px; color:#ffffff; margin-top:20px; margin-left:20px; cursor:pointer;}
                </style>
                <div class="viewProductDetails" onclick="location.href='<c:url value="/web/course/view.jhtml?id=${course.id}"/>'">查看商品详情 </div>
                <div class="goToPayFor" onclick="location.href='<c:url value="/web/shop/shopping-cart/index.jhtml"/>'">去购物车结算 </div>
            </td>
        </tr>
    </tbody>
</table>

<%@ include file="/WEB-INF/views/web/index/fooder.jsp" %>
<script type="text/javascript" src="<c:url value='/static/js/common/jquery/jquery-1.11.3.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/js/templates/web/index/function.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/js/templates/web/index/fordboy.js'/>"></script>
<script type="text/javascript">

</script>
</body>
</html>