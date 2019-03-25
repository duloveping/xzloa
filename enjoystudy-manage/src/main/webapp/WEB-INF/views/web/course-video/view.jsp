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
    <title>${video.name}</title>
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
            <table border="0" cellpadding="3" cellspacing="0" class="KCDetailTable" style="margin-bottom:20px;">
                <tbody>
                    <tr>
                        <td rowspan="9" valign="middle" style="width:330px; text-align:center; border:1px solid #eeeeee;">
                            <img src="<c:url value='${video.image}'/>" style="width:310px; height:206px;">
                        </td>
                        <td class="KCListTableTdValue">
                            <a href="javascript:void(0)" target="_blank" style="color:#cc3300; font-size:20px; margin-left:20px;">${video.name}</a>
                        </td>
                    </tr>

                    <tr>
                        <td class="KCListTableTdValue">
                            <%-- <span style="margin-left:20px;">年度：<a href="javascript:void(0)">2017年度课程</a></span> --%>
                            <span>上传日期：<fmt:formatDate value="${course.createTime}" pattern="yyyy-MM-dd"/> </span>
                        </td>
                    </tr>
                </tbody>
            </table>
        </td>
    </tr>
    <tr>
        <td valign="top" style="width:180px;">
            <div class="LeRecommendBox">
                <div class="LeRecommendTitleBox">
                    <div class="LeRecommendTitle">
                        <span>课程视频</span>
                    </div>
                </div>
                <c:forEach var="hotCourse" items="${hotCourseList}">
                    <div class="LeIItemBox">
                        <div class="LeIItemImg">
                            <a href="<c:url value='/web/course/view.jhtml?id=${hotCourse.id}'/>" target="_blank" title="${hotCourse.name}">
                                <img src="<c:url value='${hotCourse.image}'/>" alt="${hotCourse.name}">
                            </a>
                        </div>
                        <div class="LeIITemTitle">
                            <a href="<c:url value='/web/course/view.jhtml?id=${hotCourse.id}'/>" target="_blank" title="${hotCourse.name}">${hotCourse.name}</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </td>
        <td valign="top">
            <div style="width:96%; height:50px; line-height:50px; margin-left:25px; margin-top:20px;">
                <div style="width:120px; height:50px; line-height:50px; float:left;" id="gkAra"><span onclick="LessonTagChange('gk')" style="font-size:16px; font-weight:bold; color:#2ba485;">课程介绍</span></div>
            </div>
            <div id="gkDetailArea" style="width: 96%; min-height: 100px; height: auto; margin-left: 25px; margin-top: 20px; display: block;">
                <table border="0" cellpadding="3" cellspacing="0" class="KCDetailTable">
                    <tbody>
                    <tr>
                        <td class="KCListTableTdValue"><span style="color:#333333; font-size:16px; font-weight:bold;">视频介绍</span></td>
                    </tr>
                    <tr>
                        <td class="KCListTableTdValue" style="line-height:25px; border-bottom:2px dotted #c8c8c8;">${video.description}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
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