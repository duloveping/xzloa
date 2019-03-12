$(function () {
    $("#inputForm").validate({
        rules : {
            courseName: {
                required : true
            },
            companyName: {
                required : true
            },
            trainAddress: {
                required : true
            },
            linkManName: {
                required : true
            },
            linkManMobile: {
                required : true
            },
            trainTeacherName: {
                required : true
            },
            trainTeacherMobile: {
                required : true
            },
            trainStartTime: {
                required : true
            },
            trainEndTime: {
                required : true
            },
            showState: {
                required : true
            }
        },
        messages: {
            courseName: {
                required: "培训课程名称不能为空！"
            },
            companyName: {
                required: "培训单位名称不能为空！"
            },
            trainAddress: {
                required: "培训地址不能为空！"
            },
            linkManName: {
                required: "联系人姓名不能为空！"
            },
            linkManMobile: {
                required: "联系人手机不能为空！"
            },
            trainTeacherName: {
                required: "培训师姓名不能为空！"
            },
            trainTeacherMobile: {
                required: "培训师手机不能为空！"
            },
            trainStartTime: {
                required: "培训开始时间不能为空！"
            },
            trainEndTime: {
                required: "培训结束时间不能为空！"
            },
            showState: {
                required: "显示状态不能为空！"
            }
        },
        onkeyup : false,
        focusCleanup : true,
        success : "valid",
        submitHandler : function(form) {
            $.ajax({
                type: "post",
                url: ctx + "/manage/web/course-train-plan/save.jhtml",
                cache: false,
                data: $(form).serialize(),
                dataType: "json",
                success: function (res) {
                    top.layer.msg(res.info,{icon:1,time:3000});
                    if (res.status) {
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.plan.list(1);
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