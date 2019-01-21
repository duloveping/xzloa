$("#inputForm").validate({
    rules : {
        studyToExamState: {
            required: true
        },
        duration: {
            required: true
        },
        testType: {
            required: true,
        },
        paperType: {
            required: true,
        },
        totalScore: {
            required: true,
        },
        passScore: {
            required: true,
        },
        testAmount: {
            required: true,
        }
    },
    messages: {
        studyToExamState: {
            required: "是否需要学习完课程方可考试不能为空！"
        },
        duration: {
            required: "考试时长不能为空！"
        },
        testType: {
            required: "考试类型不能为空！"
        },
        paperType: {
            required: "考卷类型不能为空！"
        },
        totalScore: {
            required: "考试总成绩不能为空！"
        },
        passScore: {
            required: "考试合格成绩不能为空！"
        },
        testAmount: {
            required: "补考次数不能为空！"
        }
    },
    onkeyup : false,
    focusCleanup : true,
    success : "valid",
    submitHandler : function(form) {
        $.ajax({
            type: "post",
            url: ctx + "/manage/study/examination-config/save.jhtml",
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