$("#inputForm").validate({
    rules : {
        duration: {
            required : true
        },
        testType: {
            required : true
        }
    },
    messages: {
        duration: {
            required: "考试时长不能为空！"
        },
        testType: {
            required: "考试类型不能为空！"
        }
    },
    onkeyup : false,
    focusCleanup : true,
    success : "valid",
    submitHandler : function(form) {
        $.ajax({
            type: "post",
            url: ctx + "/manage/study/course/examinationSave.jhtml",
            cache: false,
            data: $(form).serialize(),
            dataType: "json",
            success: function (res) {
                layer.msg(res.info,{icon:1,time:3000});
                if (res.status) {
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.course.list(1);
                    parent.layer.close(index);
                }
            },
            error : function(XmlHttpRequest, textStatus, errorThrown) {
                top.layer.alert('数据保存失败');
            }
        });
    }
});

$(function () {

});
