$(function () {
    $("#inputForm").validate({
        rules : {
            title: {
                required : true
            },
            courseId: {
                required : true
            },
            showState: {
                required : true
            },
            duration: {
                required : true
            },
            totalScore: {
                required : true
            },
            passScore: {
                required: true
            },
            testAmount: {
                required: true
            },
            questionAmount: {
                required: true
            }
        },
        messages: {
            title: {
                required: "标题不能为空！"
            },
            courseId: {
                required: "课程不能为空！"
            },
            showState: {
                required: "显示状态不能为空！"
            },
            duration: {
                required: "考试时长不能为空！"
            },
            totalScore: {
                required: "总成绩不能为空！"
            },
            passScore: {
                required: "合格分数不能为空！"
            },
            testAmount: {
                required: "补考次数不能为空！"
            },
            questionAmount: {
                required: "考试试题总数不能为空！"
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
