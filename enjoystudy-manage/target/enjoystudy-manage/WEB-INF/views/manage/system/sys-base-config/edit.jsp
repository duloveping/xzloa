<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/views/common/meta.jsp" %>
    <%@ include file="/WEB-INF/views/common/javascript.jsp" %>
    <link rel="stylesheet" type="text/css" href="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/icheck/icheck.css'/>" />
    <script type="text/javascript" src="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/icheck/jquery.icheck.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/jquery.validation/1.14.0/jquery.validate.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/jquery.validation/1.14.0/validate-methods.js'/>"></script>
    <title>系统设置</title>
</head>
<body>
<article class="page-container">
    <form:form id="inputForm" modelAttribute="config" method="post" action="#" cssClass="form form-horizontal">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>系统名称：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="systemName" path="systemName" maxlength="200" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>版权所有：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="copyright" path="copyright" maxlength="200" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>系统网址：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="webSite" path="webSite" maxlength="200" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>允许上传的图片扩展名：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="allowUploadImage" path="allowUploadImage" maxlength="200" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>允许上传的文件扩展名：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="allowUploadFile" path="allowUploadFile" maxlength="200" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>允许上传的媒体扩展名：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="allowUploadMedia" path="allowUploadMedia" maxlength="200" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>允许上传的FLASH扩展名：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="allowUploadFlash" path="allowUploadFlash" maxlength="200" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>关键字：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:textarea id="keywords" path="keywords" rows="5" cols="80" maxlength="500" cssClass="textarea valid" onKeyUp="$.Huitextarealength(this, 500);" placeholder="关键字"></form:textarea>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>系统描述：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:textarea id="description" path="description" rows="5" cols="80" maxlength="500" cssClass="textarea valid" onKeyUp="$.Huitextarealength(this, 500);" placeholder="系统描述"></form:textarea>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
                <input class="btn btn-primary radius" type="submit" value="提交">
                <input id="id" name="id" type="hidden" value="${id}">
            </div>
        </div>
    </form:form>
</article>
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/system/sys-base-config/config-edit.js' />"></script>
</body>
</html>