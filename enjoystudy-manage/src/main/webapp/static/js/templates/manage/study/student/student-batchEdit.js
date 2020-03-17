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
            var loadIndex = top.layer.load();

            let courseIds = new Array();
            let courseId = $("#courseId").val();
            if (null !== courseId && typeof(courseId) !== "undefined" && "" !== courseId) {
                $.each(courseId.split(","),function(i, v){
                    let strs = v.split(":");
                    if (strs[0] == "1") {
                        courseIds.push(strs[1]);
                    }
                });
            }
            var param = {
                amount: $("#amount").val(),
                lockState: $("input[name=lockState][type=radio]:checked").val(),
                loginPassword: $("#loginPassword").val(),
                courseIds: courseIds
            };

            $.ajax({
                type: "post",
                url: "/manage/study/student/batchSave.jhtml",
                cache: false,
                data: JSON.stringify(param),
                contentType : 'application/json;charset=utf-8',
                dataType: "json",
                success: function (res) {
                    top.layer.close(loadIndex);
                    layer.msg(res.info,{icon:1,time:3000});
                    if (res.status) {
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.student.list(1);
                        parent.layer.close(index);
                    }
                },
                error : function(XmlHttpRequest, textStatus, errorThrown) {
                    top.layer.close(loadIndex);
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
        content: '/manage/study/course/courseTypeIndex.jhtml?courseIds=' + courseIds + '&rnd=' + Math.random(),
        btn: ['确定','关闭'],
        yes: function(index, layero){
            var data = $(layero).find("iframe")[0].contentWindow.getCheckValue();
            if (null != data && typeof(data) != "undefined") {
                let ids = new Array();
                let names = new Array();
                $.each(data,function(i, v){
                    ids.push(v.id);
                    names.push(v.name);
                });
                document.getElementById("courseId").value = ids.join(",");
                document.getElementById("courseName").value = names.join(",");
            }
            top.layer.close(index);
        }
    });
}