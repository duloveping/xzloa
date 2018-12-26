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
    <script type="text/javascript" src="<c:url value='/static/js/common/ueditor/ueditor.config.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/js/common/ueditor/ueditor.all.min.js'/>"> </script>
    <script type="text/javascript" src="<c:url value='/static/js/common/ueditor/lang/zh-cn/zh-cn.js'/>"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/webuploader/0.1.5/webuploader.css'/>" />
    <script type="text/javascript" src="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/webuploader/0.1.5/webuploader.min.js'/>"></script>
    <title>课程管理</title>
</head>
<body>
<article class="page-container">
    <form:form id="inputForm" modelAttribute="so" method="post" action="#" cssClass="form form-horizontal">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>课程名称：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="name" path="name" placeholder="课程姓名" maxlength="200" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>课程：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:checkboxes path="courseIds" items="${courseList}" itemValue="id" itemLabel="name" cssClass="required"/>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
                <input class="btn btn-primary radius" type="submit" value="提交">
                <form:hidden id="id" path="id" />
            </div>
        </div>
    </form:form>
</article>
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/study/certificate/certificate-edit.js' />"></script>
</body>
</html>