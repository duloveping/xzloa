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
                <span class="c-red">*</span>授课老师：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <span class="select-box">
                    <form:select id="teacherId" path="teacherId" cssClass="select">
                        <form:option value="" label="请选择"></form:option>
                        <form:options items="${teachers}" itemValue="id" itemLabel="fullName"></form:options>
                    </form:select>
				</span>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>课程编号：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="code" path="code" placeholder="课程编号" maxlength="50" cssClass="required input-text"/>
            </div>
        </div>
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
                <span class="c-red">*</span>课程分类：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:hidden id="typeId" path="typeId" />
                <form:input id="typeName" path="typeName" placeholder="课程分类" cssClass="required input-text" readonly="true" onclick="showTypeSingleDialog($('#typeId').val())"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">图片：</label>
            <div class="formControls col-xs-8 col-sm-10">
                <div class="uploader-thum-container">
                    <div id="fileList" class="uploader-list">
                        <c:if test="${not empty so.image}">
                            <div class="item upload-state-success">
                                <div class="pic-box"><img src="<c:url value="${so.image}"/>" width="100" height="100"></div>
                                <div class="info">${so.name}</div>
                                <p class="state">已上传</p>
                                <div class="progress-box" style="display: none;">
                                <span class="progress-bar radius">
                                    <span class="sr-only" style="width: 100%;"></span>
                                </span>
                                </div>
                            </div>
                        </c:if>
                    </div>
                    <div id="filePicker"><div class="webuploader-pick">选择图片</div></div>
                    <button id="btn-star" class="btn btn-default btn-uploadstar radius ml-10">开始上传</button>
                </div>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>市价：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="marketPrice" path="marketPrice" placeholder="市价" maxlength="200" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>现价：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="currentPrice" path="currentPrice" placeholder="现价" maxlength="200" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>促销价：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="salePrice" path="salePrice" placeholder="促销价" maxlength="200" cssClass="required input-text"/>
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
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>热门状态：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:radiobutton id="hotState-1" path="hotState" value="true" label="是" cssClass="required"/>
                <form:radiobutton id="hotState-2" path="hotState" value="false" label="否"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>推荐状态：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:radiobutton id="recommendState-1" path="recommendState" value="true" label="是" cssClass="required"/>
                <form:radiobutton id="recommendState-2" path="recommendState" value="false" label="否"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">简介：</label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:textarea id="introduction" path="introduction" rows="5" cols="80" maxlength="500" cssClass="textarea valid" onKeyUp="$.Huitextarealength(this, 500);" placeholder="简介"></form:textarea>
                <p class="textarea-numberbar"><em class="textarea-length">0</em>/500</p>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">内容：</label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:textarea id="description" path="description" rows="10" cols="80" placeholder="内容" cssStyle="width:100%;height:480px;"></form:textarea>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">证书模板：</label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:textarea id="templet" path="templet" rows="10" cols="80" placeholder="内容" cssStyle="width:100%;height:480px;"></form:textarea>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <input class="btn btn-primary radius" type="submit" value="提交">
                <form:hidden id="id" path="id" />
                <form:hidden id="image" path="image" />
            </div>
        </div>
    </form:form>
</article>
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/study/course/course-edit.js' />"></script>
</body>
</html>