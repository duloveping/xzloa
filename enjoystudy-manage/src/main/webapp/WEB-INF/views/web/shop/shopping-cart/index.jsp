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
    <title>到购物车列表</title>
    <link href="<c:url value='/static/js/templates/web/index/Style2018.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/static/js/templates/web/index/css.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/static/js/templates/web/index/lrtk.css'/>" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="/WEB-INF/views/web/index/header-top.jsp" %>
<%@ include file="/WEB-INF/views/web/index/header-navigation.jsp" %>
<form id="frmSet" name="frmSet" action="http://pxpt.ccaa.org.cn/User/ShopCart/" method="post">
    <div style="width:1200px; height:35px; line-height:35px; margin:0px auto; margin-top:10px;">
        <span style="font-size:16px; color:#e4393c; font-weight:bold; margin-left:7px;">全部课程</span>
    </div>
    <div style="width:1200px; height:40px; line-height:40px; margin:0px auto; background-color:#f3f3f3; border:1px solid #e9e9e9;">
        <table border="0" cellpadding="0" cellspacing="0" style="width:100%;">
            <tbody>
                <tr>
                    <td style="width:423px;"><span style="color:#666666; margin-left:7px;">课程</span></td>
                    <td style="width:125px;"><span style="color:#666666; margin-left:7px;">单价</span></td>
                    <td style="width:125px;"><span style="color:#666666; margin-left:7px;">数量</span></td>
                    <td style="width:145px;"><span style="color:#666666; margin-left:7px;">小计</span></td>
                    <td style="width:100px;"><span style="color:#666666; margin-left:7px;">操作</span></td>
                </tr>
            </tbody>
        </table>
    </div>

    <c:set var="total" value="0.00"/>
    <c:forEach var="cart" items="${cartList}">
        <div style="width:1200px; height:100px; margin:0px auto; border:1px solid #f1f1f1; background-color:#fff4e8; border-top:2px solid #aaaaaa; margin-top:10px;">
            <table border="0" cellpadding="0" cellspacing="0" style="width:100%;">
                <tbody>
                <tr>
                    <td style="width:8px;"></td>
                    <td style="width:402px;">
                        <table border="0" cellpadding="0" cellspacing="0">
                            <tbody>
                            <tr>
                                <td style="width:155px; height:100px;">
                                    <img src="<c:url value='${cart.image}'/>" style="width:135px; height:90px; margin-left:5px;">
                                </td>
                                <td style="width:247px; height:100px;">
                                    <a href="<c:url value='/web/course/view.jhtml?id=${cart.courseId}'/>" target="_blank" style="color:#333333; margin-left:5px; font-size:16px;">${cart.courseName}</a><br>
                                    <%--
                                    <span style="color:#666666; margin-left:5px;">学时：8</span>
                                    <span style="color:#666666; margin-left:20px;">讲师：</span>
                                    --%>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </td>
                    <td style="width:125px;">
                    <span style="color:#666666; margin-left:7px;">
                    ¥<span id="LePrice_190924"><c:set var="total" value="${total + cart.currentPrice * cart.buyAmount}"/><fmt:formatNumber value="${cart.currentPrice}" pattern="###0.00"/></span></span>
                    </td>
                    <td style="width:125px;">
                        <span style="color:#666666; margin-left:7px;">
                            ${cart.buyAmount}<input type="hidden" id="BuyCount_${cart.courseId}" name="BuyCount_${cart.courseId}" value="${cart.buyAmount}">
                        </span>


                    </td>
                    <td style="width:145px;">
                    <span style="color:#666666; margin-left:7px; font-size:14px; font-weight:bold;">
                        ¥<span id="LeCostShow_190924"><fmt:formatNumber value="${cart.currentPrice * cart.buyAmount}" pattern="###0.00"/></span>
                        <input type="hidden" id="LeCost_190924" name="LeCost_190924" value="100.00">
                    </span>
                    </td>
                    <td style="width:100px;">
                    <span style="color:#666666; margin-left:7px;">
                        <a href="javascript:void(0)" onclick="Del(&#39;190924&#39;)" style="color:#666666;">删除</a>
                    </span>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </c:forEach>
    <div style="width:1200px; height:45px; line-height:45px; border:1px solid #f0f0f0; margin:0px auto; margin-top:20px;">
        <table border="0" cellpadding="0" cellspacing="0">
            <tbody>
                <tr>
                    <td style="width:1000px; height:45px; text-align:right;">
                        <span style="color:#999999;">总价格：</span>
                        <span style="margin-right:10px; font-size:24px; font-weight:bold; color:#e4393c;">¥</span>
                        <span id="cartTotalPrice" style="margin-right:10px; font-size:24px; font-weight:bold; color:#e4393c;"><fmt:formatNumber value="${total}" pattern="###0.00"/></span>
                    </td>
                    <td style="width:200px; height:45px; background-color:#e64346; color:#fff; text-align:center;">
                        <a href="javascript:void(0)" onclick="Commit()" style="font-size:20px; font-weight:bold; color:#fff;">去结算</a>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</form>
<%@ include file="/WEB-INF/views/web/index/fooder.jsp" %>
<script type="text/javascript" src="<c:url value='/static/js/common/jquery/jquery-1.11.3.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/js/templates/web/index/function.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/js/templates/web/index/fordboy.js'/>"></script>
<script type="text/javascript">

</script>
</body>
</html>