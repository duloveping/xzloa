<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <title>首页</title>
    <link href="<c:url value='/static/js/templates/web/index/Style2018.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/static/js/templates/web/index/css.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/static/js/templates/web/index/lrtk.css'/>" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="/WEB-INF/views/web/index/header-top.jsp" %>
<%@ include file="/WEB-INF/views/web/index/header-navigation.jsp" %>
<div class="LoginMainBg">
    <div class="LoginMain">
        <div class="LoginBox">
            <div class="LoginBoxTitle">
                <div class="LoginBoxTitleBoxSelected" id="RegTitle" onclick="LoginTagOver('')">个人登录</div>
                <%--
                <div class="LoginBoxTitleBox" id="OtherTitle" onclick="LoginTagOver('non')">企业登录</div>
                --%>
            </div>
            <%--
            <div class="loginBoxContent" id="RegArea">
                <form id="frmLogin" name="frmLogin" action="http://pxpt.ccaa.org.cn/User/Login/" method="post">
                    <table style="font-size:15px; margin-top:30px; color:#373737;" cellpadding="0" cellspacing="0" border="0" width="100%" class="inputTable">
                        <tbody id="LoginNextArea">
                        <tr><td width="45" style="text-align:right; height:50px;"></td><td width="300" colspan="2">
                            <div style="width:270px; height:36px; border:1px solid #bfbfbf;">
                                <div style="width:50px; height:36px; float:left;"><img src="<c:url value='/static/js/templates/web/index/long_document_icon.jpg'/>"></div>
                                <div style="width:220px; height:36px; float:left;"><input class="inputText" id="DocumentNo" name="DocumentNo" placeholder="请输入档案号" style="width:220px; height:34px; border:0px;"></div>
                            </div>
                        </td><td></td></tr>
                        </tbody>
                        <tbody><tr><td width="45" style="text-align:right; height:50px;"></td><td width="90">
                            <div style="width:190px; height:36px; border:1px solid #bfbfbf;">
                                <div style="width:50px; height:36px; float:left;"><img src="<c:url value='/static/js/templates/web/index/long_vcode_icon.jpg'/>"></div>
                                <div style="width:140px; height:36px; float:left;"><input class="inputText" id="txtVCode" name="txtVCode" placeholder="请输入验证码" style="width:140px; height:34px; border:0px;"></div>
                            </div>
                        </td><td style="width:120px;"><span style="display:inline-block; margin-left:20px;"><img src="<c:url value='/static/js/templates/web/index/LoginVCode'/>" id="imgVCode" name="imgVCode" style="cursor: pointer; vertical-align:bottom;" alt="点击刷新" title="点击刷新" width="60" height="20"></span></td><td></td></tr>
                        <tr><td colspan="4" align="center" style="height:30px;">
                            <input type="hidden" id="step" name="step" value="1">
                            <input type="hidden" id="askNum" name="askNum" value="0">
                            <div onclick="UserLogin()" id="3logBtn" style="width:119px; height:35px; line-height:35px; float:left; background-color:#fe6f2b; text-align:center; cursor:pointer; border-radius:5px; margin-left:45px; margin-top:7px;"><span style="color:#fff; font-size:16px; font-weight:bold;">显示验证问题</span></div>
                            <div onclick="LoginReset()" style="width:90px; height:35px; line-height:35px; float:left; background-color:#aba9aa; text-align:center; cursor:pointer; border-radius:5px; margin-left:7px; margin-top:7px;"><span style="color:#fff; font-size:16px; font-weight:bold;">重 置</span></div>

                        </td></tr>
                        <tr>
                            <td colspan="4" style="height:10px;"></td>
                        </tr>
                        <tr>
                            <td width="45" style="text-align:right; height:50px;"></td>
                            <td colspan="3" style="line-height:30px;"><img src="<c:url value='/static/js/templates/web/index/IconDown.png'/>" style="width:14px; height:12px; margin-right:7px; vertical-align:middle;"><a href="http://pxpt.ccaa.org.cn/Content/%E5%9F%B9%E8%AE%AD%E5%B9%B3%E5%8F%B0%E5%AD%A6%E5%91%98%E4%BD%BF%E7%94%A8%E6%89%8B%E5%86%8C(V1.0).pdf" target="_blank" style="font-size:14px; text-decoration:none; color:#004998;">培训平台学员使用手册</a></td>
                        </tr>
                        </tbody></table>
                </form>
            </div>
            --%>
            <div class="loginBoxContent" id="OtherArea">
                <form id="NonfrmLogin" name="NonfrmLogin" action="" method="post">
                    <table style="font-size:15px; margin-top:30px; color:#373737;" cellpadding="0" cellspacing="0" border="0" width="100%" class="inputTable">
                        <tbody>
                            <tr>
                                <td width="110" style="text-align:right; height:40px;">用户名：</td>
                                <td width="300" colspan="2"><input class="inputText" id="username" name="username" style="width:220px;"></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td width="110" style="text-align:right; height:40px;">密　码：</td>
                                <td width="300" colspan="2"><input type="password" id="password" name="password" class="inputText" style="width:220px;"></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td width="110" style="text-align:right; height:40px;">验证码：</td>
                                <td width="90"><input class="inputText" id="checkCode" name="checkCode" style="width:90px;"></td>
                                <td style="width:120px;">
                                    <span style="display:inline-block;">
                                        <img src="<c:url value='/images/kaptcha.jpg'/>" id="nonImgVCode" name="nonImgVCode" style="cursor: pointer; vertical-align:bottom;" alt="点击刷新" title="点击刷新" width="60" height="20">
                                    </span>
                                </td>
                                <td></td>
                            </tr>
                            <tr>
                                <td colspan="4" align="center" style="height:30px;">
                                    <div onclick="NonUserLogin()" style="width:119px; height:35px; line-height:35px; float:left; background-color:#fe6f2b; text-align:center; cursor:pointer; border-radius:5px; margin-left:45px; margin-top:7px;">
                                        <span style="color:#fff; font-size:16px; font-weight:bold;">登 录</span></div>
                                    <div onclick="LoginOtherReset()" style="width:90px; height:35px; line-height:35px; float:left; background-color:#aba9aa; text-align:center; cursor:pointer; border-radius:5px; margin-left:7px; margin-top:7px;">
                                        <span style="color:#fff; font-size:16px; font-weight:bold;">重 置</span>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="4" style="height:10px;"></td>
                            </tr>
                            <tr>
                                <td colspan="4" style="text-align:center; height:40px; line-height:30px;">
                                    <div style="width:280px; height:30px; margin:0px auto;">
                                        <div style="width:35%; height:30px; line-height:30px; float:left; text-align:center;"><a href="http://pxpt.ccaa.org.cn/User/Register" style="font-size:14px; text-decoration:none; color:#004998;">注册新用户</a></div>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/views/web/index/fooder.jsp" %>
<script type="text/javascript" src="<c:url value='/static/js/common/jquery/jquery-1.11.3.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/js/templates/web/index/function.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/js/templates/web/index/fordboy.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/jquery.validation/1.14.0/jquery.validate.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/jquery.validation/1.14.0/validate-methods.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/jquery.validation/1.14.0/messages_zh.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/layer/2.4/layer.js'/>"></script>
<script type="text/javascript">
    function NonUserLogin() {
        $("#NonfrmLogin").submit()
    }

    function LoginOtherReset() {
        document.getElementById("NonfrmLogin").reset();
        validator.resetForm();
    }


    var validator;
    $(function(){
        validator = $("#NonfrmLogin").validate({
            rules : {
                username : {
                    required : true,
                },
                password : {
                    required : true,
                },
                checkCode : {
                    required : true,
                }
            },
            onkeyup : false,
            focusCleanup : true,
            success : "valid",
            submitHandler : function(form) {
                $.ajax({
                    type: "post",
                    url: "<c:url value='/manage/login/login.jhtml'/>",
                    cache: false,
                    data: $(form).serialize(),
                    dataType: "json",
                    success: function (res) {
                        if (res.success) {
                            window.location.href = "<c:url value='/manage/main/index.jhtml'/>";
                        } else {
                            $("#kaptchaImage").attr('src', '<c:url value='/images/kaptcha.jpg'/>?rnd=' + Math.floor(Math.random()*100));
                            $("#password").val("");
                            $("#checkCode").val("");
                            layer.alert(res.message);
                        }
                    },
                    error : function(XmlHttpRequest, textStatus, errorThrown) {
                        $("#kaptchaImage").attr('src', '<c:url value='/images/kaptcha.jpg'/>?rnd=' + Math.floor(Math.random()*100));
                        layer.alert('登录失败');
                    }
                });
            }
        });

        $("#username").focus();

        $('#kaptchaImage').click(function () {
            $(this).attr('src', '<c:url value='/images/kaptcha.jpg'/>?rnd=' + Math.floor(Math.random()*100));
        });
    });
</script>
</body>
</html>