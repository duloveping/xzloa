$(function () {
    $("#inputForm").validate({
        rules : {
            code : {
                required : true,
                remote : {
                    type : "post",
                    url : ctx + "/manage/study/student/check.jhtml",
                    data : {
                        code : function() { return $("#code").val();},
                        id : function() { return $("#id").val();}
                    }
                }
            },
            fullName: {
                required : true
            },
            lockState: {
                required : true
            }
        },
        messages: {
            code: {
                required: "学员账号不能为空！"
            },
            fullName: {
                required: "学员姓名不能为空！"
            },
            lockState: {
                required: "状态不能为空！"
            }
        },
        onkeyup : false,
        focusCleanup : true,
        success : "valid",
        submitHandler : function(form) {
            $.ajax({
                type: "post",
                url: ctx + "/manage/study/student/save.jhtml",
                cache: false,
                data: $(form).serialize(),
                dataType: "json",
                success: function (res) {
                    layer.msg(res.info,{icon:1,time:3000});
                    if (res.status) {
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.student.list(1);
                        parent.layer.close(index);
                    }
                },
                error : function(XmlHttpRequest, textStatus, errorThrown) {
                    top.layer.alert('数据保存失败');
                }
            });
        }
    });
});
