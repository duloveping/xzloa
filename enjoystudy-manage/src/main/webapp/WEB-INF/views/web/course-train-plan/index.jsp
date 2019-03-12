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

<table border="0" cellpadding="0" cellspacing="0" style="width:1200px; margin:0px auto;">
    <tbody>
        <tr>
            <td valign="top">
                <div class="LmBg" style="margin-top:20px;">
                    <div class="LmArea">
                        <div class="LmIconC"></div>
                        <div class="LmTitle" style="width:200px;"><span>最新培训信息</span></div>
                        <%--
                        <div class="LmMore"><a href="/OffTrain/TotalList/?serType=sur">更多</a></div>
                        --%>
                    </div>
                </div>
                <div class="ContentArea">
                    <div class="ContentHalf" style="width:1200px; margin-top:5px;">
                        <table border="0" cellpadding="5" cellspacing="1" class="TrainInfoTb">
                            <thead>
                                <tr>
                                    <th class="TrainInfoTdTitle"><span>培训班名称</span></th>
                                    <th class="TrainInfoTdTitle" width="200"><span>培训课程提供者</span></th>
                                    <th class="TrainInfoTdTitle" width="150"><span>开始时间</span></th>
                                    <th class="TrainInfoTdTitle" width="200"><span>地点</span></th>
                                    <th class="TrainInfoTdTitle" width="150"><span>教师</span></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="plan" items="${pageInfo.list}">
                                    <tr>
                                        <td class="TrainInfoTdValue"><span><a href="<c:url value="/web/course-train-plan/view.jhtml?id=${plan.id}"/>" target="_blank">${plan.courseName}</a></span></td>
                                        <td class="TrainInfoTdValue"><span>${plan.companyName}</span></td>
                                        <td class="TrainInfoTdValue"><span><fmt:formatDate value="${plan.trainStartTime}" pattern="yyyy-MM-dd HH:mm"/></span></td>
                                        <td class="TrainInfoTdValue"><span>${plan.trainAddress}</span></td>
                                        <td class="TrainInfoTdValue"><span>${plan.trainTeacherName}</span></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
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