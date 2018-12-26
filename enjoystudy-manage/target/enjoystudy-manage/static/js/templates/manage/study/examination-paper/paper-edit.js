$(function () {
    $("#inputForm").validate({
        rules : {
            title: {
                required : true
            },
            duration: {
                required : true
            },
            testType: {
                required : true
            },
            testState: {
                required : true
            }
        },
        messages: {
            title: {
                required: "考卷标题不能为空！"
            },
            duration: {
                required: "考试时长不能为空！"
            },
            testType: {
                required: "考试类型不能为空！"
            },
            testState: {
                required: "考试状态不能为空！"
            }
        },
        onkeyup : false,
        focusCleanup : true,
        success : "valid",
        submitHandler : function(form) {
            $.ajax({
                type: "post",
                url: ctx + "/manage/study/examination-paper/save.jhtml",
                cache: false,
                data: $(form).serialize(),
                dataType: "json",
                success: function (res) {
                    if (res.status == false) {
                        layer.msg(res.info,{icon:1,time:3000});
                    } else {
                        parent.mainFrame.location.reload(); // 父页面刷新
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index);
                    }
                },
                error : function(XmlHttpRequest, textStatus, errorThrown) {
                    layer.alert('数据保存失败');
                }
            });
        }
    });
});
