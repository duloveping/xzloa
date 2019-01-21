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
    <title>课程考试管理</title>
</head>
<body>
<article class="page-container">
    <form:form id="inputForm" modelAttribute="so" method="post" action="#" cssClass="form form-horizontal">
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
                <form:input id="name" path="name" placeholder="课程名称" maxlength="200" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>是否需要学习完课程方可考试：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:radiobutton path="studyToExamState" label="是" value="true"/>
                <form:radiobutton path="studyToExamState" label="否" value="false" cssClass="required"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>考试时长（单位：分钟）：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="duration" path="duration" maxlength="3" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>考试类型：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:radiobutton path="testType" label="学习完成后自动考试" value="1" cssClass="required"/>
                <form:radiobutton path="testType" label="统计安排考试" value="2" cssClass="required"/>
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
                <span class="c-red">*</span>补考次数（默认1次）：
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
                <form:radiobutton path="questionType" label="随机数量" value="1"/>
                <form:radiobutton path="questionType" label="固定数量" value="2" cssClass="required"/>
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
            </div>
        </div>
    </form:form>
</article>
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/study/course/examination-edit.js' />"></script>
</body>
</html>