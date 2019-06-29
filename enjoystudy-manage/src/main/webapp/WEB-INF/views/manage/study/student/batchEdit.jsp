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
    <title>批量生成学员账号</title>
</head>
<body>
<article class="page-container">
    <form id="inputForm" method="post" action="#" class="form form-horizontal">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>学员数量：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <input id="amount" path="amount" placeholder="学员数量" maxlength="4" class="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>状态：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <input type="radio" id="lockState-1" name="lockState" value="true"/><label for="lockState-1">锁定</label>
                <input type="radio" id="lockState-2" name="lockState" value="false" checked="checked"/><label for="lockState-2">解锁</label>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">登录密码：</label>
            <div class="formControls col-xs-8 col-sm-10">
                <input type="password" id="loginPassword" path="loginPassword" placeholder="登录密码" class="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">授课：</label>
            <div class="formControls col-xs-8 col-sm-10">
                <input type="hidden" id="courseId" name="courseId" value=""/>
                <input type="text" id="courseName" name="courseName" placeholder="授课名称" class="input-text" readonly="true"/>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <input class="btn btn-primary radius" type="submit" value="提交">
            </div>
        </div>
    </form>
</article>
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/study/student/student-batchEdit.js'/>"></script>
</body>
</html>