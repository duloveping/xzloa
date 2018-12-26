<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/views/common/meta.jsp" %>
    <%@ include file="/WEB-INF/views/common/javascript.jsp" %>
    <script type="text/javascript" src="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/icheck/jquery.icheck.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/jquery.validation/1.14.0/jquery.validate.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/jquery.validation/1.14.0/validate-methods.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/jquery.validation/1.14.0/messages_zh.js'/>"></script>
    <title>角色管理</title>
</head>
<body>
<article class="page-container">
    <form:form id="inputForm" modelAttribute="po" method="post" action="#" cssClass="form form-horizontal">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>部门：
            </label>
            <div class="formControls col-xs-8 col-sm-9">
                <form:input id="departmentName" path="departmentName" readonly="true" placeholder="部门" cssClass="required input-text" onclick="showDepartmentSingleDialog($('#departmentId').val());"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>编号：
            </label>
            <div class="formControls col-xs-8 col-sm-9">
                <form:input id="code" path="code" placeholder="编号" maxlength="50" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>姓名：
            </label>
            <div class="formControls col-xs-8 col-sm-9">
                <form:input id="fullName" path="fullName" placeholder="姓名" maxlength="50" cssClass=" input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>密码：
            </label>
            <div class="formControls col-xs-8 col-sm-9">
                <form:password id="loginPassword" path="loginPassword" placeholder="密码" cssClass="input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>职务：
            </label>
            <div class="formControls col-xs-8 col-sm-9">
                <span class="select-box">
                    <form:select id="positionId" path="positionId" cssClass="select">
                        <form:options items="${positionList}" itemLabel="name" itemValue="id"></form:options>
                    </form:select>
				</span>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>状态：
            </label>
            <div class="formControls col-xs-8 col-sm-9">
                <form:radiobutton id="lockState-1" path="lockState" value="true" label="启用"/>
                <form:radiobutton id="lockState-2" path="lockState" value="false" label="禁用" cssClass="{required:true}"/>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
                <input class="btn btn-primary radius" type="submit" value="提交">
                <input class="btn btn-primary radius" type="button" value="测试" onclick="test()">
                <form:hidden id="id" path="id" />
                <form:hidden id="departmentId" path="departmentId" />
            </div>
        </div>
    </form:form>
</article>
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/system/employee/employee-edit.js' />"></script>
</body>
</html>