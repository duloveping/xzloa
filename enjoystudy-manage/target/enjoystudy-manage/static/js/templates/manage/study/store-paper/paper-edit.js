$(function () {
    $("#inputForm").validate({
        rules : {
            title: {
                auditorName : true
            },
            auditState: {
                required : true
            },
            auditTime: {
                required : true
            },
            auditorMind: {
                required : true
            }
        },
        messages: {
            auditorName: {
                required: "审核人不能为空！"
            },
            auditState: {
                required: "审核状态不能为空！"
            },
            auditTime: {
                required: "审核时间不能为空！"
            },
            auditorMind: {
                required: "审核意见不能为空！"
            }
        },
        onkeyup : false,
        focusCleanup : true,
        success : "valid",
        submitHandler : function(form) {
            $.ajax({
                type: "post",
                url: ctx + "/manage/study/store-paper/save-audit.jhtml",
                cache: false,
                data: $(form).serialize(),
                dataType: "json",
                success: function (res) {
                    if (res.status == false) {
                        top.layer.msg(res.info,{icon:1,time:3000});
                    } else {
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.paper.list();
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
