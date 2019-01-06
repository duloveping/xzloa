$("#inputForm").validate({
    rules : {
        username: {
            required: true,
            remote : {
                type : "post",
                url : ctx + "/manage/login/check.jhtml",
                data : {
                    username : function() { return $("#username").val();}
                }
            }
        },
        loginPassword: {
            required: true
        },
        confirmPassword: {
            required: true,
            equalTo: '#loginPassword'
        },
        realname: {
            required: true
        },
        sex: {
            required: true
        },
        identityType: {
            required: true
        },
        identityCode: {
            required: true
        },
        mobile: {
            required: true
        },
        question: {
            required: true
        },
        answer: {
            required: true
        },
        checkCode: {
            required: true
        }
    },
    messages: {
        username: {
            required: "用户名不能为空",
            remote: jQuery.format("该用户名已经被使用")
        },
        loginPassword: {
            required: "登录密码不能为空"
        },
        confirmPassword: {
            required: "确认密码不能为空",
            equalTo: "请输入相同的密码"
        },
        realname: {
            required: "姓名不能为空"
        },
        sex: {
            required: "性别不能为空"
        },
        identityType: {
            required: "证件类型不能为空"
        },
        identityCode: {
            required: "证件号码不能为空"
        },
        mobile: {
            required: "手机号码不能为空"
        },
        question: {
            required: "密码找回问题不能为空"
        },
        answer: {
            required: "密码找回答案不能为空"
        },
        checkCode: {
            required: "验证码"
        }
    },
    onkeyup : false,
    focusCleanup : true,
    success : "valid",
    submitHandler : function(form) {
        $.ajax({
            type: "post",
            url: ctx + "/manage/login/entry.jhtml",
            cache: false,
            data: $(form).serialize(),
            dataType: "json",
            success: function (res) {
                if (res.status) {
                    document.location.href = ctx + "/manage/login/index.jhtml";
                }
                top.layer.alert(res.info,{icon:1,time:3000});
            },
            error : function(XmlHttpRequest, textStatus, errorThrown) {
                top.layer.alert('数据保存失败');
            }
        });
    }
});