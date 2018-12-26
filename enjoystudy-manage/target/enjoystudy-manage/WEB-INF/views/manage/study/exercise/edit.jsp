<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/views/common/meta.jsp" %>
    <%@ include file="/WEB-INF/views/common/javascript.jsp" %>
    <script type="text/javascript" src="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/jquery.validation/1.14.0/jquery.validate.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/jquery.validation/1.14.0/validate-methods.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/js/common/ueditor/ueditor.config.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/js/common/ueditor/ueditor.all.min.js'/>"> </script>
    <script type="text/javascript" src="<c:url value='/static/js/common/ueditor/lang/zh-cn/zh-cn.js'/>"></script>
    <title>考试题管理</title>
</head>
<body>
<article class="page-container">
    <form:form id="inputForm" modelAttribute="so" method="post" action="#" cssClass="form form-horizontal">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>所属课程：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <span class="select-box">
                    <select id="courseId" name="courseId" class="select"></select>
				</span>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>所属课程：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <span class="select-box">
                    <select id="category" name="category" class="select">
                        <option value="1">单选题</option>
                        <option value="2">多选题</option>
                        <option value="4">判断题</option>
                    </select>
				</span>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>分值：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <input id="score" name="score" type="number" value="" placeholder="分值" min="1" max="100" maxlength="5" class="required input-text">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>问题：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:textarea id="title" path="title" rows="5" cols="80" maxlength="1000" cssClass="textarea valid" onKeyUp="$.Huitextarealength(this, 500);" placeholder="问题"></form:textarea>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>选项：
            </label>
            <div id="item" class="formControls col-xs-8 col-sm-10">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>参考答案：
            </label>
            <div id="answer" class="formControls col-xs-8 col-sm-10">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">解析：</label>
            <div class="formControls col-xs-8 col-sm-10">
                <textarea id="analysis" name="analysis" placeholder="解析" rows="5" cols="80" style="width:100%;height:480px;"></textarea>
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
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/study/examination/examination-edit.js' />"></script>
</body>
</html>