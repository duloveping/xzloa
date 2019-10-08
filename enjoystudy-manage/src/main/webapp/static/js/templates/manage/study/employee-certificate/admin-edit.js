$(function () {
    $("#inputForm").validate({
        rules : {
            employeeName: {
                required : true
            },
            certificateName: {
                required : true
            },
            certificateCode: {
                required : true
            },
            chineseContent: {
                required : true
            },
        },
        messages: {
            employeeName: {
                required: "姓名不能为空！"
            },
            certificateName: {
                required: "证书名称（中文）不能为空！"
            },
            certificateCode: {
                required: "证书编号不能为空！"
            },
            chineseContent: {
                required: "证书内容（中文）不能为空！"
            }
        },
        onkeyup : false,
        focusCleanup : true,
        success : "valid",
        submitHandler : function(form) {
            var loadIndex = top.layer.load();

            $.ajax({
                type: "post",
                url: ctx + "/manage/study/employee-certificate/admin-save.jhtml",
                cache: false,
                data: $(form).serialize(),
                dataType: "json",
                success: function (res) {
                    top.layer.close(loadIndex);
                    layer.msg(res.info,{icon:1,time:3000});
                    if (res.status) {
                        var index = parent.layer.getFrameIndex(window.name);
                        try {
                            parent.certificate.list(1);
                        } catch (e) {
                        } finally {
                            parent.layer.close(index);
                        }


                    }
                },
                error : function(XmlHttpRequest, textStatus, errorThrown) {
                    top.layer.alert('数据保存失败');
                    top.layer.close(loadIndex);
                }
            });
        }
    });
});
