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
    <title>考试设置</title>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i>首页
    <span class="c-gray en">&gt;</span>员工管理
    <span class="c-gray en">&gt;</span>修改密码
</nav>

<article class="page-container">
    <form id="inputForm" method="post" action="#" cssClass="form form-horizontal">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>当前密码：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <input id="oldpwd" name="oldpwd" type="password" value="" class="required input-text">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>新的密码：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <input id="newpwd" name="newpwd" type="password" value="" class="required input-text">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>确认密码：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <input id="okpwd" name="okpwd" type="password" value="" class="required input-text">
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
                <input id="submit" class="btn btn-primary radius" type="submit" value="修改">
                <input id="id" name="id" type="hidden" value="" />
            </div>
        </div>
    </form>
</article>
<script type="text/javascript">
    $("#inputForm").validate({
        rules : {
            oldpwd: {
                required: true
            },
            newpwd: {
                required: true
            },
            okpwd: {
                required: true,
            }
        },
        messages: {
            oldpwd: {
                required: "旧密码不能为空"
            },
            newpwd: {
                required: "新的密码不能为空！"
            },
            okpwd: {
                required: "确认密码不能为空！"
            }
        },
        onkeyup : false,
        focusCleanup : true,
        success : "valid",
        submitHandler : function(form) {
            top.layer.load();
            $("#submit").prop("disabled", true);

            $.ajax({
                type: "post",
                url: ctx + "/manage/employee/account/save-password.jhtml",
                cache: false,
                data: $(form).serialize(),
                dataType: "json",
                success: function (res) {
                    if (res.status) {
                        $("#oldpwd").val("");
                        $("#newpwd").val("");
                        $("#okpwd").val("");
                    }
                    $("#submit").prop("disabled", false);
                    top.layer.alert(res.info,{icon:1,time:3000});
                    top.layer.closeAll('loading');
                },
                error : function(XmlHttpRequest, textStatus, errorThrown) {
                    $("#submit").prop("disabled", false);
                    top.layer.closeAll('loading');
                    top.layer.alert('数据保存失败');
                }
            });
        }
    });
</script>
</body>
</html>