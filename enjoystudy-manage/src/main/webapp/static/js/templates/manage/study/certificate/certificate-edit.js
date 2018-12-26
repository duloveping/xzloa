$("#inputForm").validate({
    rules : {
        name: {
            required : true
        },
        courseIds: {
            required : true
        }
    },
    messages: {
        name: {
            required: "证书名称不能为空！"
        },
        courseIds: {
            required: "所属课程不能为空！"
        }
    },
    onkeyup : false,
    focusCleanup : true,
    success : "valid",
    submitHandler : function(form) {
        $.ajax({
            type: "post",
            url: ctx + "/manage/study/certificate/save.jhtml",
            cache: false,
            data: $(form).serialize(),
            dataType: "json",
            success: function (res) {
                if (res.status) {
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.mainFrame.location.reload();
                    parent.layer.close(index);
                } else {
                    top.layer.msg(res.info,{icon:1,time:3000});
                }
            },
            error : function(XmlHttpRequest, textStatus, errorThrown) {
                top.layer.alert('数据保存失败');
            }
        });
    }
});