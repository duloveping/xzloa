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
    <title>会员注册</title>
</head>
<body>
<article class="page-container">
    <form:form id="inputForm" modelAttribute="so" method="post" action="#" cssClass="form form-horizontal">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>用户名：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="username" path="username" maxlength="50" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>登录密码：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:password id="loginPassword" path="loginPassword" maxlength="50" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>确认密码：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:password id="confirmPassword" path="confirmPassword" maxlength="50" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>姓名：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="realname" path="realname" maxlength="50" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>显示状态：</label>
            <div class="formControls col-xs-8 col-sm-10 skin-minimal">
                <div class="radio-box">
                    <form:radiobutton id="sex-1" path="sex" value="1"/>
                    <label for="sex-1">男</label>
                </div>
                <div class="radio-box">
                    <form:radiobutton id="sex-2" path="sex" value="2"/>
                    <label for="sex-2">女</label>
                </div>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>证件类型：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <span class="select-box">
                    <form:select id="identityType" path="identityType" cssClass="select">
                        <form:option value="1" label="居民身份证"></form:option>
                        <form:option value="2" label="军官证"></form:option>
                        <form:option value="3" label="香港特区护照/身份证明"></form:option>
                        <form:option value="4" label="澳门特区护照/身份证明"></form:option>
                        <form:option value="5" label="台湾居民来往大陆通行证"></form:option>
                        <form:option value="6" label="境外永久居住证"></form:option>
                    </form:select>
				</span>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>证件号码：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="identityCode" path="identityCode" maxlength="200" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>手机号码：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="mobile" path="mobile" maxlength="11" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>邮箱：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="email" path="email" maxlength="50" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>密码找回问题：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:select id="question" path="question" cssClass="select">
                    <form:options items="${questionList}" />
                </form:select>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>密码找回答案：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="answer" path="answer" maxlength="200" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>验证码：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="checkCode" path="checkCode" maxlength="4" cssClass="required input-text" cssStyle="width:150px;"/>
                <img id="kaptchaImage" alt="验证码" src="<c:url value='/images/kaptcha.jpg'/>"><a id="kanbuq" href="javascript:void(0);" onclick="$('#kaptchaImage').attr('src', '<c:url value="/images/kaptcha.jpg"/>?' + Math.floor(Math.random()*100));">看不清，换一张</a>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
                <input class="btn btn-primary radius" type="submit" value="提交">
            </div>
        </div>
    </form:form>
</article>
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/login/login-register.js' />"></script>
</body>
</html>