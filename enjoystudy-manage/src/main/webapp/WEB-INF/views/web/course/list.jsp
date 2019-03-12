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
    <title>课程中心</title>
    <link href="<c:url value='/static/js/templates/web/index/Style2018.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/static/js/templates/web/index/css.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/static/js/templates/web/index/lrtk.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/static/js/templates/web/index/Pager.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/static/js/templates/web/index/listpage.css'/>" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="/WEB-INF/views/web/index/header-top.jsp" %>
<%@ include file="/WEB-INF/views/web/index/header-navigation.jsp" %>

<%--
<div style="width:1200px; min-height:30px; height:auto; margin:0px auto; margin-top:10px;">
    <table border="0" cellpadding="0" cellspacing="0" style="width:1200px; margin:0px auto; margin-top:10px; border-bottom:1px solid #dddddd; border-left:1px solid #dddddd; border-right:1px solid #dddddd;">
        <tbody>
            <tr>
                <td style="width:110px; height:38px; background-color:#f3f3f3; border-top:1px solid #dddddd;"><span style="color:#666666; font-weight:bold; margin-left:10px; margin-right:10px;">类型：</span></td>
                <td style="height:38px; background-color:#fff; border-top:1px solid #dddddd;">

                    <div class="LeSearchedBox" onclick="location.href='/Lesson/Index/'">全部</div>
                    <div class="LeSearchBox" onclick="location.href='/Lesson/Index/?1=1&amp;cg=1|1&amp;sort=&amp;key='"><span>通用课程</span></div>
                    <div class="LeSearchBox" onclick="location.href='/Lesson/Index/?1=1&amp;cg=2|2&amp;sort=&amp;key='"><span>专业课程</span></div>
                    <div class="LeSearchBox" onclick="location.href='/Lesson/Index/?1=1&amp;cg=3|3&amp;sort=&amp;key='"><span>免费课程</span></div>
                </td>
                <td style="width:80px; height:38px; border-top:1px solid #dddddd;"></td>
            </tr>
        </tbody>
    </table>
</div>
--%>

<table border="0" cellpadding="0" cellspacing="0" style="width:1200px; margin:0px auto; margin-top:10px;">
    <tbody>
        <tr>
            <td valign="top">
                <div style="width:98%; min-height:100px; height:auto; background-color:#fff; border:1px solid #dddddd;">
                    <div class="LeOrderBox">
                        <%--
                        <div class="LeOrderEmpty"></div>
                        <div class="LeOrderCur" onclick="SortGoto('0')">
                            <span>综合</span><img src="<c:url value='/static/js/templates/web/index/Jt-bai-xia.png'/>">
                        </div>
                        <div class="LeOrderNor" onclick="SortGoto('1')">
                            <span>销量</span><img src="<c:url value='/static/js/templates/web/index/Jt-hui-xia.png'/>">
                        </div>
                        <div class="LeOrderNor" onclick="SortGoto('2')">
                            <span>新课</span><img src="<c:url value='/static/js/templates/web/index/Jt-hui-xia.png'/>">
                        </div>
                        <div class="LeOrderNor" onclick="SortGoto('3')">
                            <span>评价</span><img src="<c:url value='/static/js/templates/web/index/Jt-hui-xia.png'/>">
                        </div>
                        --%>
                    </div>
                    <div class="LeBox">
                        <c:forEach var="course" items="${pageInfo.list}">
                            <div class="LeItemBox">
                                <div class="LeItemImg" onclick="window.open('<c:url value='/web/course/view.jhtml?id=${course.id}'/>')" style="background-image:url('<c:url value='${course.image}'/>'); background-repeat:repeat-x; background-size:100% 100%;">
                                    <div style="font-size:17px; font-weight:bold; color:#fff; margin-top:45px; float:left; text-align:center; width:90%; height:50px; margin-left:10px;">
                                    </div>
                                </div>
                                <div class="LeITemTitle">
                                    <a href="<c:url value='/web/course/view.jhtml?id=${course.id}'/>" target="_blank">${course.name}</a></div>
                                <div class="LeItemPrice">
                                    <span>￥<fmt:formatNumber value="${course.currentPrice}" pattern="###0.00"/></span>
                                    <span style="color:#ea511e; font-size:15px; margin-left:30px;">学时：8</span>
                                </div>
                                <div class="LeItemComment">
                                    <span>已有<span style="color:#075cbc; font-size:16px; font-weight:bold;">${course.buyAmount}</span>人评价</span>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <div style="width:100%; height:40px; margin-top:20px;">
                        <div id="pager" class="pager">
                            <ul class="pages">
                                <li class="pgNext <c:if test="${pageInfo.isFirstPage}">pgEmpty</c:if>">首页</li>
                                <li class="pgNext <c:if test="${pageInfo.isFirstPage}">pgEmpty</c:if>">上一页</li>
                                <c:forEach items="${pageInfo.navigatepageNums }" var="pageNum">
                                    <li class="page-number <c:if test="${pageNum eq pageInfo.pageNum}">pgCurrent</c:if>">${pageNum}</li>
                                </c:forEach>
                                <li class="pgNext <c:if test="${pageInfo.isLastPage}">pgEmpty</c:if>">下一页</li>
                                <li class="pgNext <c:if test="${pageInfo.isLastPage}">pgEmpty</c:if>">末页</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </td>
            <td valign="top" style="width:210px;">
                <div class="ShopCatBox" onclick="location.href='/User/ShopCart/'">
                    <div class="ShopcarImg"><img src="<c:url value='/static/js/templates/web/index/shopcar.png'/>"></div>
                    <div class="ShopcarTxt"><span>我的购物车</span></div>
                    <div class="ShopcarCount"><span>0</span></div>
                    <div class="ShopcarIcon"><img src="<c:url value='/static/js/templates/web/index/shopcarIcon.jpg'/>"></div>
                </div>

                <div class="LeRecommendBox">
                    <div class="LeRecommendTitleBox">
                        <div class="LeRecommendTitle">
                            <span>热门课程</span>
                        </div>
                    </div>
                    <xzlTag:courseListTag varid="hotCourseList" pageSize="5" showState="true" hotState="true"/>
                    <c:forEach var="hotCourse" items="${hotCourseList}">
                        <div class="LeIItemBox">
                            <div class="LeIItemImg"><a href="<c:url value='/web/course/view.jhtml?id=${hotCourse.id}'/>" target="_blank" title="${hotCourse.name}">
                                <img src="<c:url value='${hotCourse.image}'/>" alt="${hotCourse.name}"></a>
                            </div>
                            <div class="LeIITemTitle">
                                <a href="<c:url value='/web/course/view.jhtml?id=${hotCourse.id}'/>" target="_blank" title="${hotCourse.name}">${hotCourse.name}</a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </td>
        </tr>
    </tbody>
</table>

<%@ include file="/WEB-INF/views/web/index/fooder.jsp" %>
<script type="text/javascript" src="<c:url value='/static/js/common/jquery/jquery-1.11.3.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/js/templates/web/index/function.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/js/templates/web/index/fordboy.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/js/templates/web/index/jquery.pager-vsdoc.js'/>"></script>
<script type="text/javascript">
    $(function () {
        $("#pager").pager({
            pagenumber: ${pageInfo.pageNum},
            pagecount: ${pageInfo.pages},
            firstText: "首页",
            prevText: "上一页",
            nextText: "下一页",
            lastText: "末页"
        });
    });
</script>
</body>
</html>