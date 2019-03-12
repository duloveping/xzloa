<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <title>首页</title>
    <link href="<c:url value='/static/js/templates/web/index/Style2018.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/static/js/templates/web/index/css.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/static/js/templates/web/index/lrtk.css'/>" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="/WEB-INF/views/web/index/header-top.jsp" %>
<%@ include file="/WEB-INF/views/web/index/header-navigation.jsp" %>
<div class="FouseArea">
    <div id="solid">
        <div class="solid0"></div>
        <div class="solid1"></div>
        <ul>
            <xzlTag:advertisementListTag varid="bannerList" placeCode="index-header-banner" pageSize="10"/>
            <c:forEach var="banner" items="${bannerList}">
                <li><img style="cursor: pointer;" onclick="window.open('<c:url value='${banner.url}'/>')" src="<c:url value='${banner.large}'/>" width="1200" height="300"/></li>
            </c:forEach>
        </ul>
        <div id="btt">
            <c:forEach var="banner" items="${bannerList}">
                <span></span>
            </c:forEach>
        </div>
    </div>
</div>

<div class="LmBg" style="margin-top: 20px;">
    <div class="LmArea">
        <div class="LmAreaHalf">
            <div class="LmIcon"><img src="<c:url value='/static/js/templates/web/index/IconGonggao.png'/>"></div>
            <div class="LmTitle"><span>新闻资讯</span></div>
            <div class="LmMore"><a href="http://pxpt.ccaa.org.cn/Web/Index/4/">更多</a></div>
        </div>
        <div class="LmAreaHalf">
            <div class="LmIcon"><img src="<c:url value='/static/js/templates/web/index/IconPeixun.png'/>"></div>
            <div class="LmTitle"><span>培训资讯</span></div>
            <div class="LmMore"><a href="http://pxpt.ccaa.org.cn/OffTrain/Total/">更多</a></div>
        </div>
    </div>
</div>

<div class="ContentArea" style="height: 290px;">
    <div class="ContentHalf">
        <div style="width: 590px; height: 260px; margin-top: 30px;">
            <xzlTag:newsListTag varid="newsList" typeState="true" showState="true" pageSize="6" typeCode="xwzx"/>
            <c:forEach var="news" items="${ newsList }">
                <div class="PXItem">
                    <div style="width: 460px; height: 40px; float: left;">
                        <a href="" target="_blank">·&nbsp;&nbsp;${news.title}</a>
                    </div>
                    <div style="width: 100px; height: 40px; float: left;">
                        <span style="color: rgb(168, 168, 168);">[<fmt:formatDate value="${news.publishTime}" pattern="yyyy-MM-dd"/>]</span>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="ContentHalf">
        <div style="width: 590px; height: 260px; margin-top: 30px;">
            <xzlTag:newsListTag varid="trainList" typeState="true" showState="true" pageSize="6" typeCode="pxzx"/>
            <c:forEach var="edu" items="${trainList}">
                <div class="PXItem">
                    <div style="width: 460px; height: 40px; float: left;">
                        <a href="" target="_blank">·&nbsp;&nbsp;${edu.title}</a>
                    </div>
                    <div style="width: 100px; height: 40px; float: left;">
                        <span style="color: rgb(168, 168, 168);">[<fmt:formatDate value="${edu.publishTime}" pattern="yyyy-MM-dd"/>]</span>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<xzlTag:advertisementPlaceListTag varid="courseFloorList" showState="true" category="index-course-floor"/>
<c:forEach var="courseFloor" items="${courseFloorList}" varStatus="status">
    <div class="LmBg" style="margin-top: 20px;">
        <div class="LmArea">
            <div class="LmAreaLong">
                <div class="LmIcon"><img src="<c:url value='/static/js/templates/web/index/IconKecheng.png'/>"/></div>
                <div class="LmTitle"><span>${courseFloor.name}</span></div>
                <div class="LmMore"><a href="<c:url value='${courseFloor.moreUrl}'/>" target="_blank">更多</a></div>
            </div>
        </div>
    </div>


    <div class="ContentArea">
        <div class="ContentAreaLeft">
            <xzlTag:advertisementListTag varid="courseLeftList" placeCode="${courseFloor.code}" showState="true" pageSize="8"/>
            <c:forEach var="courseLeft" items="${courseLeftList}">
                <div class="LeItemBoxNoTop">
                    <div class="LeItemImg" style='background-image: url("<c:url value='${courseLeft.large}'/>"); background-repeat: repeat-x; background-size: contain;' onclick="window.open('<c:url value='${courseLeft.url}'/>')">
                        <div style="width: 90%; height: 50px; text-align: center; color: rgb(255, 255, 255); font-size: 17px; font-weight: bold; margin-top: 45px; margin-left: 10px; float: left;">${courseLeft.title}</div>
                    </div>
                    <div class="LeITemTitle">
                        <a href="<c:url value='${courseLeft.url}'/>" target="_blank">${courseLeft.title}</a>
                    </div>
                    <div class="LeItemPrice">
                        <span>￥<fmt:formatNumber value="${courseLeft.currentPrice}" pattern="###0.00"/></span>
                        <span style="color: rgb(234, 81, 30); font-size: 15px; margin-left: 30px;">学时：${courseLeft.lessonAmount}</span>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="ContentAreaRight">
            <xzlTag:advertisementPlaceDetailsTag varid="courseHotRight" placeCode="index-course-floor-hot-${status.count}"/>
            <div class="ContentAreaRightUp" style="${courseHotRight.cssStyle}">
                <div class="ContentAreaLeftTitle">
                    <div class="ContentAreaLeftTitleIcon">
                        <img src="<c:url value='/static/js/templates/web/index/IconHot.png'/>">
                    </div>
                    <div class="ContentAreaLeftTitleTxt">
                        <span>${courseHotRight.name}</span>
                    </div>
                </div>
                <xzlTag:advertisementListTag varid="courseRightList" placeId="${courseFloor.id}" pageSize="5"/>
                <c:forEach var="courseRight" items="${courseRightList}" varStatus="rightStatus">
                    <div class="ContentAreaLeftList">
                        <a href="<c:url value='${courseRight.url}'/>" target="_blank">
                            ${rightStatus.count}<span>.</span>${courseRight.title}
                        </a>
                    </div>
                </c:forEach>
            </div>
            <div class="ContentAreaRightDown">
                <img src="<c:url value='${courseHotRight.icon}'/>">
            </div>
        </div>
    </div>
</c:forEach>
<%@ include file="/WEB-INF/views/web/index/fooder.jsp" %>
<script type="text/javascript" src="<c:url value='/static/js/common/jquery/jquery-1.11.3.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/js/templates/web/index/function.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/js/templates/web/index/fordboy.js'/>"></script>
</body>
</html>