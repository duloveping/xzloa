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
    <title>考试设置</title>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i>首页
    <span class="c-gray en">&gt;</span>员工管理
    <span class="c-gray en">&gt;</span>修改密码
</nav>

<article class="page-container">
    <form id="inputForm" method="post" action="#" cssClass="form form-horizontal">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>当前密码：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <input id="oldpwd" name="oldpwd" type="password" value="" class="required input-text">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>新的密码：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <input id="newpwd" name="newpwd" type="password" value="" class="required input-text">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>确认密码：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <input id="okpwd" name="okpwd" type="password" value="" class="required input-text">
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
                <input class="btn btn-primary radius" type="submit" value="修改">
                <input id="id" name="id" type="hidden" value="" />
            </div>
        </div>
    </form>
</article>
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/study/examination-config/config-edit.js' />"></script>
</body>
</html>