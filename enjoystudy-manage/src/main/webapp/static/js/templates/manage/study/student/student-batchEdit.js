$(function () {
    $("#courseName").click(getCourse);

    $("#inputForm").validate({
        rules : {
            amount: {
                required : true
            },
            lockState: {
                required : true
            },
            loginPassword: {
                required : true
            }
        },
        messages: {
            amount: {
                required: "学员数量不能为空！"
            },
            loginPassword: {
                required: "初始密码不能为空！"
            },
            lockState: {
                required: "状态不能为空！"
            }
        },
        onkeyup : false,
        focusCleanup : true,
        success : "valid",
        submitHandler : function(form) {
            $("#courseId").val();
            var param = {
                amount: $("#amount").val(),
                lockState: $("input[name=lockState][type=radio]:checked").val(),
                loginPassword: $("#loginPassword").val(),
                courseId:$("#courseId").val()
            };
            $.ajax({
                type: "post",
                url: ctx + "/manage/study/student/batchSave.jhtml",
                cache: false,
                data:  param,
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
            return false;
        }
    });
});

function getCourse() {
    var courseIds = $("#courseId").val();
    top.layer.open({
        type: 2,
        title: '课程选择',
        shadeClose: true,
        shade: 0.8,
        area: ['480px', '600px'],
        maxmin: true,
        content: ctx + '/manage/study/course/courseTypeIndex.jhtml?courseIds=' + courseIds + '&rnd=' + Math.random(),
        btn: ['确定','关闭'],
        yes: function(index, layero){
            var data = $(layero).find("iframe")[0].contentWindow.getCheckValue();
            if (null != data && typeof(data) != "undefined") {
                var strs = data.id.split(":");
                if (strs[0] == 1) {
                    var courseId = strs[1];
                    document.getElementById("courseId").value = courseId;
                    // $("#courseId").val(courseId);
                    $("#courseName").val(data.name);
                }
            }
            top.layer.close(index);
        }
    });
}