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
    <title>职务管理</title>
</head>
<body>
<article class="page-container">
    <form:form id="inputForm" modelAttribute="so" method="post" action="#" cssClass="form form-horizontal">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">
                <span class="c-red">*</span>编号：
            </label>
            <div class="formControls col-xs-8 col-sm-9">
                <form:input id="code" path="code" placeholder="编号" maxlength="50" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">
                <span class="c-red">*</span>名称：
            </label>
            <div class="formControls col-xs-8 col-sm-9">
                <form:input id="name" path="name" placeholder="名称" maxlength="50" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">
                <span class="c-red">*</span>状态：
            </label>
            <div class="formControls col-xs-8 col-sm-9">
                <form:radiobutton id="showState-1" path="showState" value="true" label="显示" cssClass="required"/>
                <form:radiobutton id="showState-2" path="showState" value="false" label="隐藏"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">
                <span class="c-red">*</span>排序：
            </label>
            <div class="formControls col-xs-8 col-sm-9">
                <form:input id="serialNumber" path="serialNumber" placeholder="排序" maxlength="50" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">备注：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <form:textarea id="caption" path="caption" rows="5" cols="80" maxlength="255" cssClass="textarea valid" onKeyUp="$.Huitextarealength(this,255);" placeholder="备注"></form:textarea>
                <p class="textarea-numberbar"><em class="textarea-length">0</em>/255</p>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <input class="btn btn-primary radius" type="submit" value="提交">
                <form:hidden id="id" path="id" />
            </div>
        </div>
    </form:form>
</article>
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/system/position/position-edit.js' />"></script>
</body>
</html>