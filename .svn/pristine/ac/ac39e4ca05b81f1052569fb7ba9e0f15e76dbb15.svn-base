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
            equalTo: "#newpwd"
        }
    },
    messages: {
        oldpwd: {
            required: "当前密码不能为空！"
        },
        newpwd: {
            required: "新的密码不能为空！"
        },
        okpwd: {
            required: "确认密码不能为空！",
            equalTo: "新的密码与确认密码不相同！"
        }
    },
    onkeyup : false,
    focusCleanup : true,
    success : "valid",
    submitHandler : function(form) {
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

                top.layer.alert(res.info,{icon:1,time:3000});
            },
            error : function(XmlHttpRequest, textStatus, errorThrown) {
                top.layer.alert('数据保存失败');
            }
        });
    }
});