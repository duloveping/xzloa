<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/views/common/meta.jsp" %>
    <%@ include file="/WEB-INF/views/common/javascript.jsp" %>
    <script type="text/javascript" src="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/jquery.validation/1.14.0/jquery.validate.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/jquery.validation/1.14.0/validate-methods.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/jquery.validation/1.14.0/messages_zh.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/js/common/My97DatePicker/WdatePicker.js'/>"></script>
    <title>课程培训管理</title>
</head>
<body>
<article class="page-container">
    <form:form id="inputForm" modelAttribute="so" method="post" action="#" cssClass="form form-horizontal">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>课程名称：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="courseName" path="courseName" placeholder="课程名称" maxlength="200" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>培训单位名称：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="companyName" path="companyName" placeholder="培训单位名称" maxlength="200" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>培训地址：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="trainAddress" path="trainAddress" placeholder="培训地址" maxlength="100" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>联系人姓名：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="linkManName" path="linkManName" placeholder="联系人姓名" maxlength="50" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>联系人手机：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="linkManMobile" path="linkManMobile" placeholder="联系人手机" maxlength="11" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>培训师姓名：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="trainTeacherName" path="trainTeacherName" placeholder="培训师姓名" maxlength="50" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>培训师手机：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="trainTeacherMobile" path="trainTeacherMobile" placeholder="培训师手机" maxlength="11" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>培训开始时间：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="trainStartTime" path="trainStartTime" placeholder="培训开始时间" maxlength="19" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" cssClass="required input-text Wdate"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>培训结束时间：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="trainEndTime" path="trainEndTime" placeholder="培训结束时间" maxlength="19" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" cssClass="required input-text Wdate"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>显示状态：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:radiobutton id="showState-1" path="showState" value="true" label="显示" cssClass="required"/>
                <form:radiobutton id="showState-2" path="showState" value="false" label="隐藏"/>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-10 col-xs-offset-4 col-sm-offset-2">
                <input class="btn btn-primary radius" type="submit" value="提交">
                <form:hidden id="id" path="id" />
            </div>
        </div>
    </form:form>
</article>
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/web/course-train-plan/plan-edit.js' />"></script>
</body>
</html>