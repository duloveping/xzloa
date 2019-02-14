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
    <title>考卷审核</title>
</head>
<body>
<article class="page-container">
    <form:form id="inputForm" modelAttribute="so" method="post" action="#" cssClass="form form-horizontal">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>审核人：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="auditorName" path="auditorName" readonly="true" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>审核状态：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:radiobutton path="auditState" label="通过" value="2"/>
                <form:radiobutton path="auditState" label="不通过" value="3" cssClass="required"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>审核日期：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="auditTime" path="auditTime" readonly="true" cssClass="required input-text Wdate" onclick="WdatePicker()"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>审核意见：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:textarea id="auditorMind" path="auditorMind" rows="5" cols="80" maxlength="100" cssClass="required textarea valid" onKeyUp="$.Huitextarealength(this, 100);" placeholder="审核意见"></form:textarea>
                <p class="textarea-numberbar"><em class="textarea-length">0</em>/500</p>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
                <input class="btn btn-primary radius" type="submit" value="提交">
                <form:hidden id="id" path="id" />
                <form:hidden id="auditorId" path="auditorId" />
            </div>
        </div>
    </form:form>
</article>
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/study/store-paper/audit-edit.js'/>"></script>
</body>
</html>