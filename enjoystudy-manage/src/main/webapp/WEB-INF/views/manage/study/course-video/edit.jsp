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
    <title>${course.name} - 视频管理</title>
</head>
<body>
<article class="page-container">
    <form:form id="inputForm" modelAttribute="so" method="post" action="#" cssClass="form form-horizontal">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>所属课程：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <input id="courseId" name="courseId" type="hidden" value="${so.courseId}">
                <input id="courseName" name="courseName" type="text" value="" placeholder="所属课程" class="required input-text">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>视频名称：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="name" path="name" placeholder="视频姓名" maxlength="200" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>排序序号：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="serialNumber" path="serialNumber" placeholder="排序序号" maxlength="4" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">封面：</label>
            <div class="formControls col-xs-8 col-sm-10">
                <div class="uploader-thum-container">
                    <div id="photoList" class="uploader-list">
                        <c:if test="${not empty image}">
                            <div id="WU_FILE_0" class="item upload-state-success">
                                <div class="pic-box"><img src=""></div>
                                <div class="info">${so.name}封面图片</div>
                                <p class="state">已上传</p>
                                <div class="progress-box" style="display: none;">
                                    <span class="progress-bar radius">
                                        <span class="sr-only" style="width: 100%;"></span>
                                    </span>
                                </div>
                            </div>
                        </c:if>
                    </div>
                    <div id="photoPicker"><div class="webuploader-pick">选择图片</div></div>
                    <button id="photo-star" class="btn btn-default btn-uploadstar radius ml-10">开始上传</button>
                </div>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">视频：</label>
            <div class="formControls col-xs-8 col-sm-10">
                <div class="uploader-thum-container">
                    <div id="videoList" class="uploader-list">
                        <c:if test="${not empty attachmentList}">
                            <div id="WU_FILE_2" class="item upload-state-success">
                                <div class="pic-box"><span>不能预览</span></div>
                                <div class="info">QQ视频20160828223532.mp4</div>
                                <p class="state">已上传</p>
                                <div class="progress-box" style="display: none;">
                                <span class="progress-bar radius">
                                    <span class="sr-only" style="width: 100%;"></span>
                                </span>
                                </div>
                            </div>
                        </c:if>
                    </div>
                    <div id="videoPicker"><div class="webuploader-pick">选择视频</div></div>
                    <button id="video-star" class="btn btn-default btn-uploadstar radius ml-10">开始上传</button>
                </div>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">附件：</label>
            <div class="formControls col-xs-8 col-sm-10">
                <div class="uploader-thum-container">
                    <div id="fileList" class="uploader-list"></div>
                    <div id="filePicker"><div class="webuploader-pick">选择文件</div></div>
                    <button id="file-star" class="btn btn-default btn-uploadstar radius ml-10">开始上传</button>
                </div>
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
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <input class="btn btn-primary radius" type="submit" value="提交">
                <form:hidden id="id" path="id" />
                <form:hidden id="image" path="image" />
            </div>
        </div>
    </form:form>
</article>
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/study/course-video/video-edit.js' />"></script>
</body>
</html>