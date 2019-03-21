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

<table border="0" cellpadding="0" cellspacing="0" style="width:1200px; margin:0px auto; margin-top:20px;">
    <tbody><tr>
        <td valign="top" style="width:300px;">
            <div class="LmAreaShort" style="border-bottom:1px solid #eeeeee;">
                <div class="LmIconC"></div>
                <div class="LmTitle" style="width:200px;"><span style="font-size:16px;">继续教育课程面授班</span></div>
            </div>
            <div class="ContentShort">
                <div style="width:300px; height:256px; background-color:#eeeeee; margin-top:25px;">

                </div>
            </div>
            <div class="LmAreaShort" style="border-bottom:1px solid #eeeeee;">
                <div class="LmIconC"></div>
                <div class="LmTitle" style="width:200px;"><span style="font-size:16px;">确认课程面授班信息</span></div>
            </div>
            <div class="ContentShort">
                <div style="width:300px; height:256px; background-color:#eeeeee; margin-top:25px;">
                        <%--
                        <div class="PXItem"><a href="http://pxpt.ccaa.org.cn/OffTrain/TotalDetail/402/?serType=sur">·&nbsp;&nbsp;服务认证审查员通用知识培训课程</a></div>
                        <div class="PXItem"><a href="http://pxpt.ccaa.org.cn/OffTrain/TotalDetail/401/?serType=sur">·&nbsp;&nbsp;服务认证审查员通用知识培训课程</a></div>
                        <div class="PXItem"><a href="http://pxpt.ccaa.org.cn/OffTrain/TotalDetail/399/?serType=sur">·&nbsp;&nbsp;服务认证审查员通用知识培训课程</a></div>
                        --%>

                    </div>
                </div>
            </div>
        </td>
        <td valign="top">
            <div style="width:100%; height:5px;"></div>

            <c:forEach var="news" items="${pageInfo.list}">
                <div style="width:97%; height:30px; margin-left:20px; margin-top:10px; border-bottom:1px dotted #575757;">
                    <div style="width:720px; height:30px; line-height:30px; float:left;">
                        <a href="<c:url value="/web/news/view.jhtml?id=${news.id}"/>" title="${news.title}" target="_blank" style="color:#333333; font-size:16px; text-decoration:none;">·&nbsp;&nbsp;${news.title}</a>
                    </div>
                    <div style="width:120px; height:30px; line-height:30px; float:left; text-align:center;"><span style="color:#6d6d6d;">2019-01-14</span></div>
                </div>
            </c:forEach>

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