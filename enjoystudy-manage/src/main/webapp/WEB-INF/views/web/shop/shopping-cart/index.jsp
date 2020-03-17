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
                    <td style="width:10px;"><input id="checkAll" name="checkAll" type="checkbox" value="true" checked="checked"></td>
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
        <div data-id="${cart.courseId}" style="width:1200px; height:100px; margin:0px auto; border:1px solid #f1f1f1; background-color:#fff4e8; border-top:2px solid #aaaaaa; margin-top:10px;">
            <table border="0" cellpadding="0" cellspacing="0" style="width:100%;">
                <tbody>
                <tr>
                    <td style="width:8px;"></td>
                    <td style="width:402px;">
                        <table border="0" cellpadding="0" cellspacing="0">
                            <tbody>
                            <tr>
                                <td><input name="shoppingCartIds" type="checkbox" value="${cart.id}" data-course-id="${cart.courseId}" checked="checked"></td>
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
                        ¥<span id="LePrice_${cart.courseId}">
                            <c:choose>
                                <c:when test="${cart.currentPrice ne cart.salePrice}">
                                    <c:set var="total" value="${total + cart.salePrice * cart.buyAmount}"/>
                                    <fmt:formatNumber value="${cart.salePrice}" pattern="###0.00"/>
                                </c:when>
                                <c:otherwise>
                                    <c:set var="total" value="${total + cart.currentPrice * cart.buyAmount}"/>
                                    <fmt:formatNumber value="${cart.currentPrice}" pattern="###0.00"/>
                                </c:otherwise>
                            </c:choose>

                        </span>
                    </span>
                    </td>
                    <td style="width:125px;">
                        <span style="color:#666666; margin-left:7px;">
                            ${cart.buyAmount}<input type="hidden" id="BuyCount_${cart.courseId}" name="BuyCount_${cart.courseId}" value="${cart.buyAmount}">
                        </span>
                    </td>
                    <td style="width:145px;">
                        <span style="color:#666666; margin-left:7px; font-size:14px; font-weight:bold;">
                            <c:choose>
                                <c:when test="${cart.currentPrice ne cart.salePrice}">
                                    ¥<span id="LeCostShow_${cart.courseId}"><fmt:formatNumber value="${cart.salePrice * cart.buyAmount}" pattern="###0.00"/></span>
                                    <input type="hidden" id="LeCost_${cart.courseId}" name="LeCost_${cart.courseId}" value="<fmt:formatNumber value="${cart.salePrice * cart.buyAmount}" pattern="###0.00"/>">
                                </c:when>
                                <c:otherwise>
                                    ¥<span id="LeCostShow_${cart.courseId}"><fmt:formatNumber value="${cart.currentPrice * cart.buyAmount}" pattern="###0.00"/></span>
                                    <input type="hidden" id="LeCost_${cart.courseId}" name="LeCost_${cart.courseId}" value="<fmt:formatNumber value="${cart.currentPrice * cart.buyAmount}" pattern="###0.00"/>">
                                </c:otherwise>
                            </c:choose>

                        </span>
                    </td>
                    <td style="width:100px;">
                        <span style="color:#666666; margin-left:7px;">
                            <a href="javascript:void(0)" onclick="deleteItem('${cart.courseId}')" style="color:#666666;">删除</a>
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
                        <a id="payment" href="javascript:void(0)" style="font-size:20px; font-weight:bold; color:#fff;">去结算</a>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</form>
<%@ include file="/WEB-INF/views/web/index/fooder.jsp" %>
<script type="text/javascript" src="<c:url value='/static/js/common/jquery/jquery-1.11.3.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/js/common/layer/layer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/js/templates/web/index/function.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/js/templates/web/index/fordboy.js'/>"></script>
<script type="text/javascript">

    $(function () {
        $("#checkAll").on("click", function () {
            let flag = this.checked;
            $.each($('input[name=shoppingCartIds][type=checkbox]'),function(){
                this.checked = flag;
            });
            autoComputer();
        });

        $('input[name=shoppingCartIds][type=checkbox]').on('click', function () {
            autoComputer();
        })

        $("#payment").on("click", function () {
            let shoppingCartIds = new Array();
            $.each($('input[name=shoppingCartIds][type=checkbox]'),function(){
                if (this.checked) {
                    shoppingCartIds.push(this.value);
                }
            });

            if (null != shoppingCartIds && shoppingCartIds.length > 0) {
                $.ajax({
                    type: "get",
                    url: "/web/shop/shopping-cart/createOrder.jhtml?shoppingCartIds=" + shoppingCartIds.join(",") + "&rnd=" + Math.random(),
                    dataType: "json",
                    success: function (res) {
                        if (res.status) {
                            document.location.href = "/web/shop/web-shopping-order/payment.jhtml?orderId=" + res.data.id;
                        } else {
                            layer.alert(res.info);
                        }
                    },
                    error : function(XmlHttpRequest, textStatus, errorThrown) {
                        layer.alert('生成系统订单时出错了。');
                    }
                });
            } else {
                layer.alert("请选择要结算的课程！");
            }
        });
    });

    function autoComputer() {
        let cartTotalPrice = 0.0;
        $.each($('input[name=shoppingCartIds][type=checkbox]'),function(){
            if (this.checked) {
                let courseId = this.getAttribute("data-course-id");
                cartTotalPrice += parseFloat($("#LeCostShow_" + courseId).text());
            }
        });
        $("#cartTotalPrice").text(cartTotalPrice.toFixed(2));
    }

    function deleteItem(id) {
        layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                type : "get",
                url : "/web/shop/shopping-cart/remove.jhtml?courseId=" + id + '&rnd=' + Math.random(),
                cache : false,
                dataType : "json",
                success : function(res){
                    if (res.status) {
                        $("div[data-id=" + id + "]").remove();
                        autoComputer();
                        layer.msg('删除成功',{icon:1,time:3000});
                    }
                }
            });
            layer.close(index);
        });
    }
</script>
</body>
</html>