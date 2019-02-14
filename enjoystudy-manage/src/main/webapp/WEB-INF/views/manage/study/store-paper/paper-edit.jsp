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
    <title>考卷管理</title>
</head>
<body>
<article class="page-container">
    <form:form id="inputForm" modelAttribute="so" method="post" action="#" cssClass="form form-horizontal">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>考卷标题：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="title" path="title" placeholder="考卷标题" maxlength="200" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>所属课程：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <span class="select-box">
                    <form:select path="courseId" items="${courseList}" itemValue="id" itemLabel="name" cssClass="select"/>
                </span>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>显示状态：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:radiobutton path="showState" label="显示" value="true"/>
                <form:radiobutton path="showState" label="隐藏" value="false" cssClass="required"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>考试时长：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="duration" path="duration" placeholder="考试时长" maxlength="3" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>考试总成绩：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="totalScore" path="totalScore" maxlength="3" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>合格成绩：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="passScore" path="passScore" maxlength="3" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>补考次数：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="testAmount" path="testAmount" maxlength="2" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>考题数量：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="questionAmount" path="questionAmount" maxlength="3" cssClass="required input-text"/>
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
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/study/store-paper/paper-edit.js' />"></script>
</body>
</html>