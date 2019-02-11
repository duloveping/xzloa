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
    <link rel="stylesheet" type="text/css" href="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/webuploader/0.1.5/webuploader.css'/>" />
    <script type="text/javascript" src="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/webuploader/0.1.5/webuploader.min.js'/>"></script>
    <title>广告管理</title>
</head>
<body>
<article class="page-container">
    <form:form id="inputForm" modelAttribute="so" method="post" action="#" cssClass="form form-horizontal">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>广告位置：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <span class="select-box">
                    <form:select id="placeId" path="placeId" cssClass="select">
                        <form:option label="请选择" value=""/>
                        <form:options items="${listPlace}" itemLabel="name" itemValue="id"/>
                    </form:select>
				</span>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>状态：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:radiobutton id="showState-1" path="showState" value="true" label="显示" cssClass="required"/>
                <form:radiobutton id="showState-2" path="showState" value="false" label="隐藏"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">class属性值：</label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="cssClass" path="cssClass" placeholder="class属性值" maxlength="300" cssClass="input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">style属性值：</label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="cssStyle" path="cssStyle" placeholder="style属性值" maxlength="300" cssClass="input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">广告图：</label>
            <div class="formControls col-xs-8 col-sm-10">
                <div class="uploader-thum-container">
                    <div id="fileList" class="uploader-list">
                        <c:if test="${not empty so.large}">
                            <div class="item upload-state-success">
                                <div class="pic-box"><img src="<c:url value="${so.icon}" width="100" height="100"/>"></div>
                                <div class="info">${so.title}</div>
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
            <label class="form-label col-xs-4 col-sm-2">排序号：</label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="serialNumber" path="serialNumber" placeholder="排序号" maxlength="5" cssClass="input-text"/>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
                <input class="btn btn-primary radius" type="submit" value="提交">
                <form:hidden id="id" path="id" />
                <form:hidden id="large" path="large" />
                <form:hidden id="middle" path="middle" />
                <form:hidden id="small" path="small" />
                <form:hidden id="icon" path="icon" />
                <form:hidden id="title" path="title" />
            </div>
        </div>
    </form:form>
</article>
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/web/advertisement/advertisement-edit.js' />"></script>
</body>
</html>