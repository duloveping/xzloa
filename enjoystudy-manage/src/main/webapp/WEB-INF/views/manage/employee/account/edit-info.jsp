<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/views/common/meta.jsp" %>
    <%@ include file="/WEB-INF/views/common/javascript.jsp" %>
    <script type="text/javascript" src="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/icheck/jquery.icheck.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/jquery.validation/1.14.0/jquery.validate.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/jquery.validation/1.14.0/validate-methods.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/jquery.validation/1.14.0/messages_zh.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/js/common/My97DatePicker/WdatePicker.js'/>"></script>
    <title>编辑资料</title>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i>首页
    <span class="c-gray en">&gt;</span>学员信息
    <span class="c-gray en">&gt;</span>编辑资料
</nav>

<article class="page-container">
    <form id="inputForm" method="post" action="<c:url value="/manage/employee/account/save-data.jhtml"/>" class="form form-horizontal">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>用户名：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <input id="code" name="code" type="text" value="${so.code}" disabled="disabled" class="required input-text">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>姓名：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <input id="fullName" name="fullName" type="text" value="${so.fullName}" class="required input-text">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">性别：</label>
            <div class="formControls col-xs-8 col-sm-10 skin-minimal">
                <div class="radio-box">
                    <input id="sex-1" name="sex" type="radio" value="1" <c:if test="${so.sex eq 1}">checked="checked"</c:if>>
                    <label for="sex-1">男</label>
                </div>
                <div class="radio-box">
                    <input id="sex-2" name="sex" type="radio" value="2" <c:if test="${so.sex eq 2}">checked="checked"</c:if>>
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
                    <select id="identityType" name="identityType" class="select">
                        <option value="1" <c:if test="${so.identityType eq 1}">elected="selected"</c:if>>居民身份证</option>
                        <option value="2" <c:if test="${so.identityType eq 2}">elected="selected"</c:if>>军官证</option>
                        <option value="3" <c:if test="${so.identityType eq 3}">elected="selected"</c:if>>香港特区护照/身份证明</option>
                        <option value="4" <c:if test="${so.identityType eq 4}">elected="selected"</c:if>>门特区护照/身份证明</option>
                        <option value="5" <c:if test="${so.identityType eq 5}">elected="selected"</c:if>>台湾居民来往大陆通行证</option>
                        <option value="6" <c:if test="${so.identityType eq 6}">elected="selected"</c:if>>境外永久居住证</option>
                    </select>
				</span>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>证件号码：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <input id="identityCode" name="identityCode" type="text" value="${so.identityCode}" maxlength="18" class="required input-text">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">出生日期：</label>
            <div class="formControls col-xs-8 col-sm-10">
                <input id="birthday" name="birthday" type="text" value="<fmt:formatDate value="${so.birthday}" pattern="yyyy-MM-dd"/>" onfocus="WdatePicker()" maxlength="11" readonly="readonly" class="required input-text Wdate">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">学历：</label>
            <div class="formControls col-xs-8 col-sm-10">
                <span class="select-box">
                    <select id="education" name="education" class="select">
                        <option value="0">请选择</option>
                        <option value="1" <c:if test="${so.education eq 1}">selected="selected"</c:if>>小学</option>
                        <option value="2" <c:if test="${so.education eq 2}">selected="selected"</c:if>>初中</option>
                        <option value="3" <c:if test="${so.education eq 3}">selected="selected"</c:if>>高中/中专/中技/职高/理工</option>
                        <option value="4" <c:if test="${so.education eq 4}">selected="selected"</c:if>>大学专科</option>
                        <option value="5" <c:if test="${so.education eq 5}">selected="selected"</c:if>>大学本科</option>
                        <option value="6" <c:if test="${so.education eq 6}">selected="selected"</c:if>>硕士研究生</option>
                        <option value="7" <c:if test="${so.education eq 7}">selected="selected"</c:if>>博士研究生</option>
                    </select>
				</span>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>手机：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <input id="mobile" name="mobile" type="text" value="${communication.mobile}" maxlength="11" class="required input-text">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">邮箱：</label>
            <div class="formControls col-xs-8 col-sm-10">
                <input id="email" name="email" type="text" value="${communication.email}" maxlength="50" class="input-text">
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
                <input class="btn btn-primary radius" type="submit" value="修改">
            </div>
        </div>
    </form>
</article>
<script type="text/javascript" src="<c:url value='/static/js/common/distpicker/distpicker.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/system/employee/student-data.js' />"></script>
</body>
</html>