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
    <form:form id="inputForm" modelAttribute="so" method="post" action="#" cssClass="form form-horizontal">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">
                <span class="c-red">*</span>所属菜单：
            </label>
            <div class="formControls col-xs-8 col-sm-9">
                <c:choose>
                    <c:when test="${so.parentId eq '0'}">一级组织架构</c:when>
                    <c:otherwise>${department.name}</c:otherwise>
                </c:choose>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">
                <span class="c-red">*</span>类型：
            </label>
            <div class="formControls col-xs-8 col-sm-9">
                <form:radiobutton path="category" value="1" label="单位"/>
                <form:radiobutton path="category" value="2" label="部门"/>
                <form:radiobutton path="category" value="3" label="小组"/>
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
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <input class="btn btn-primary radius" type="submit" value="提交">
                <form:hidden id="id" path="id"/>
                <form:hidden id="parentId" path="parentId" />
            </div>
        </div>
    </form:form>
</article>
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/employee/department/department-edit.js' />"></script>
</body>
</html>