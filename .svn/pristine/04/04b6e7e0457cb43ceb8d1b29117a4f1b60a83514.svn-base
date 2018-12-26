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
    <title>菜单管理</title>
</head>
<body>
<article class="page-container">
    <form:form id="inputForm" modelAttribute="vo" method="post" action="#" cssClass="form form-horizontal">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">
                <span class="c-red">*</span>所属菜单：
            </label>
            <div class="formControls col-xs-8 col-sm-9">
                <c:choose>
                    <c:when test="${vo.parentId eq '0'}">一级菜单</c:when>
                    <c:otherwise>${menu.name}</c:otherwise>
                </c:choose>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">
                <span class="c-red">*</span>编号：
            </label>
            <div class="formControls col-xs-8 col-sm-9">
                <form:input id="code" path="code" cssClass="required input-text" maxlength="50" placeholder="编号"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">
                <span class="c-red">*</span>名称：
            </label>
            <div class="formControls col-xs-8 col-sm-9">
                <form:input id="name" path="name" cssClass="required input-text" maxlength="50" placeholder="名称"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">
                <span class="c-red">*</span>显示状态：
            </label>
            <div class="formControls col-xs-8 col-sm-9">
                <form:radiobutton path="showState" value="true" label="显示" cssClass="{required:true}"/>
                <form:radiobutton path="showState" value="false" label="隐藏" />
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">图标：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <form:input id="icon" path="icon" cssClass="input-text" maxlength="50" placeholder="图标"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">链接地址：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <form:input id="href" path="href" cssClass="input-text" maxlength="255" placeholder="链接地址"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">class属性：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <form:input id="cssClass" path="cssClass" cssClass="input-text" maxlength="255" placeholder="class属性"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">style属性：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <form:input id="cssStyle" path="cssStyle" cssClass="input-text" maxlength="255" placeholder="style属性"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">排序序号：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <form:input id="serialNumber" path="serialNumber" cssClass="input-text" maxlength="3" placeholder="排序序号"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">备注：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <form:textarea id="caption" path="caption" rows="5" cols="80" maxlength="255" placeholder="备注" onKeyUp="$.Huitextarealength(this,255);" cssClass="textarea valid"></form:textarea>
                <p class="textarea-numberbar"><em class="textarea-length">0</em>/255</p>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <input class="btn btn-primary radius" type="submit" value="提交">
                <form:hidden id="id" path="id"/>
                <form:hidden id="parentId" path="parentId" />
                <form:hidden id="category" path="category" />
            </div>
        </div>
    </form:form>
</article>
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/system/sys-menu/menu-edit.js' />"></script>
</body>
</html>