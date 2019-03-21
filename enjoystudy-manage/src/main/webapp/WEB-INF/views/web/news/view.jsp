<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="keywords" content="${news.title}" />
    <meta name="description" content="${news.title}" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <title>${news.title}</title>
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
            <table border="0" cellpadding="0" cellspacing="0" style="width:97%; margin-left:20px; margin-top:10px;">
                <tbody>
                    <tr>
                        <td>
                            <div style="width:96%; height:40px; line-height:25px; text-align:center;">
                                <span style="font-size:22px; font-weight:bold; color:#333333;">${news.title}</span>
                            </div>
                            <div style="width:96%; height:25px; line-height:25px; text-align:center; border-bottom:1px solid #eeeeee;">
                                <span style="font-size:14px; color:#333333; margin-right:15px;">发布者：${news.author}</span>
                                <span style="font-size:14px; color:#333333; margin-right:15px;">上传时间：<fmt:formatDate value="${news.publishTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div style="width:96%; min-height:50px; height:auto; margin:0px auto; margin-top:20px; line-height:28px; font-size:16px; color:#3a3a3a;">${news.description}</div>
                        </td>
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
</body>
</html>