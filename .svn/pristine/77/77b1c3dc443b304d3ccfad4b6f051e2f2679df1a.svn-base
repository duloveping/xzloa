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
                <span class="c-red">*</span>考试时长：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="duration" path="duration" placeholder="考试时长" maxlength="3" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>考试类型：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:radiobutton path="testType" label="自动考试" value="1"/>
                <form:radiobutton path="testType" label="统一考试" value="2" cssClass="required"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>考试总成绩（默认100分）：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="totalScore" path="totalScore" maxlength="3" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>合格成绩（默认60分）：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="passScore" path="passScore" maxlength="3" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>补考次数（默认2次）：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="testAmount" path="testAmount" maxlength="2" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>考题数量（默认100题）：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="questionAmount" path="questionAmount" maxlength="3" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>考题分配情况：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:radiobutton path="questionType" label="随机分配题型数量" value="1"/>
                <form:radiobutton path="questionType" label="自行分配题型数量" value="2" cssClass="required"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">单选题数量：</label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="singleAmount" path="singleAmount" maxlength="3" cssClass="input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">多选题数量：</label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="multiAmount" path="multiAmount" maxlength="3" cssClass="input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">判断题数量：</label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="judgeAmount" path="judgeAmount" maxlength="3" cssClass="input-text"/>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
                <input class="btn btn-primary radius" type="submit" value="提交">
                <form:hidden id="id" path="id" />
                <form:hidden id="courseId" path="courseId" />
                <form:hidden id="testState" path="testState" />
                <form:hidden id="checkAmount" path="checkAmount" />
                <form:hidden id="fillAmount" path="fillAmount" />
            </div>
        </div>
    </form:form>
</article>
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/study/examination-paper/paper-edit.js' />"></script>
</body>
</html>