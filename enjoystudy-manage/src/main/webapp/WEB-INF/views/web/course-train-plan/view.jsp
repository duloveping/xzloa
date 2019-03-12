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
</head>
<body>
<%@ include file="/WEB-INF/views/web/index/header-top.jsp" %>
<%@ include file="/WEB-INF/views/web/index/header-navigation.jsp" %>

<table border="0" cellpadding="0" cellspacing="0" style="width:1200px; margin:0px auto; margin-top:20px;">
    <tbody>
        <tr>
            <td valign="top" style="width:300px;">
                <div class="LmAreaShort" style="border-bottom:1px solid #eeeeee;">
                    <div class="LmIconC"></div>
                    <div class="LmTitle"><span style="font-size:16px;">课程培训计划</span></div>
                </div>
                <div class="ContentShort">
                    <div style="width:300px; min-height:300px; height:auto; margin-top:13px;">
                        <c:forEach var="plan" items="${planList}">
                            <div id="Div1" class="PXItem">
                                <div style="width:460px; height:40px; float:left;">
                                    <a href="<c:url value="/web/course-train-plan/view.jhtml?id=${plan.id}"/>" target="_blank">·&nbsp;&nbsp;${plan.courseName}</a>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </td>
            <td valign="top">
                <div style="border-bottom:1px solid #eeeeee; width:900px; height:45px; margin-left:20px;">
                    <div class="LmIcon"></div>
                    <div class="LmTitle" style="width:300px;">
                        <span>确认课程培训计划 — 详情</span>
                    </div>
                    <div class="LmMore"></div>
                </div>

                <table border="0" cellpadding="7" cellspacing="1" class="TrainInfoDetailTb">
                    <tbody>
                        <tr>
                            <td class="TrainInfoDetailTr">培训名称</td>
                            <td colspan="3" class="TrainInfoDetailTd">${courseTrainPlan.courseName}</td>
                        </tr>
                        <tr>
                            <td class="TrainInfoDetailTr">培训课程提供者</td>
                            <td colspan="3" class="TrainInfoDetailTd">${courseTrainPlan.companyName}</td>
                        </tr>
                        <tr>
                            <td class="TrainInfoDetailTr">开始时间</td>
                            <td colspan="3" class="TrainInfoDetailTd"><fmt:formatDate value="${courseTrainPlan.trainStartTime}" pattern="yyyy-MM-dd HH:mm"/></td>
                        </tr>
                        <tr>
                            <td class="TrainInfoDetailTr">结束时间</td>
                            <td colspan="3" class="TrainInfoDetailTd"><fmt:formatDate value="${courseTrainPlan.trainEndTime}" pattern="yyyy-MM-dd HH:mm"/></td>
                        </tr>
                        <tr>
                            <td class="TrainInfoDetailTr">培训地点</td>
                            <td colspan="3" class="TrainInfoDetailTd">${courseTrainPlan.trainAddress}</td>
                        </tr>
                        <tr>
                            <td class="TrainInfoDetailTr">培训教师</td>
                            <td colspan="3" class="TrainInfoDetailTd">${courseTrainPlan.trainTeacherName}</td>
                        </tr>
                        <tr>
                            <td class="TrainInfoDetailTr">培训地点联系人 </td>
                            <td colspan="3" class="TrainInfoDetailTd">${courseTrainPlan.linkManName}</td>
                        </tr>
                        <tr>
                            <td class="TrainInfoDetailTr">培训地点电话</td>
                            <td colspan="3" class="TrainInfoDetailTd">${courseTrainPlan.linkManMobile}</td>
                        </tr>
                        <tr>
                            <td class="TrainInfoDetailTr">班主任</td>
                            <td colspan="3" class="TrainInfoDetailTd">${courseTrainPlan.trainTeacherName}</td>
                        </tr>
                        <tr>
                            <td class="TrainInfoDetailTr">班主任电话</td>
                            <td colspan="3" class="TrainInfoDetailTd">${courseTrainPlan.trainTeacherMobile}</td>
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