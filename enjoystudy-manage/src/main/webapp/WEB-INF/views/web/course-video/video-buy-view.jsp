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
    <title>${course.name}</title>
    <link href="/static/js/common/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
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
                <div class="LmTitle"><span style="font-size:16px;">课程详情</span></div>
            </div>
            <table id="courseTable" data-id="${course.id}" border="0" cellpadding="3" cellspacing="0" class="KCDetailTable" style="margin-bottom:20px;">
                <tbody>
                <tr>
                    <td rowspan="9" valign="middle" style="width:330px; text-align:center; border:1px solid #eeeeee;">
                        <img src="<c:url value='${course.image}'/>" style="width:310px; height:206px;">
                    </td>
                    <td class="KCListTableTdValue">
                        <a href="javascript:void(0)" target="_blank" style="color:#cc3300; font-size:20px; margin-left:20px;">${course.name}</a>
                    </td>
                </tr>
                <tr>
                    <td class="KCListTableTdValue">
                        <span style="margin-left:20px;">该课程需要购买后方可观看和学习！</span>
                    </td>
                </tr>
                <tr>
                    <td class="KCListTableTdValue">
                        <img src="<c:url value="/static/js/templates/web/index/shoppingCart.jpg"/>" style="margin-right:20px; cursor:pointer; margin-left:20px;" onclick="BuyIt('${course.id}')">
                        <img id="onceBuy" data-id="${course.id}" src="<c:url value="/static/js/templates/web/index/atOnceBuy.jpg"/>" style="margin-right:20px; cursor:pointer;">
                        <%--<img src="<c:url value="/static/js/templates/web/index/ShoucangButton.jpg"/>" style="margin-right:20px; cursor:pointer;">--%>
                        <img src="<c:url value="/static/js/templates/web/index/learn.jpg"/>" style="margin-right:20px; cursor:pointer;">

                        <span id="shoppingCart" style="margin-left:20px; color:#cc3300; font-size:16px; cursor:pointer;">
                            <i class="fa fa-shopping-cart" aria-hidden="true"></i>放入购物车
                        </span>
                        <span id="onceBuy" style="margin-left:20px; color:#cc3300; font-size:16px; cursor:pointer;">
                            <i class="fa fa-shopping-bag" aria-hidden="true"></i>立即购买
                        </span>
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
<script type="text/javascript" src="<c:url value='/static/js/templates/web/course-video/video-buy-view.js'/>"></script>
</body>
</html>