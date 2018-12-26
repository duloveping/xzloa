$("#inputForm").validate({
    rules : {
        code : {
            required : true,
            remote : {
                type : "POST",
                url : "check.jhtml",
                data : {
                    code : function() { return $("#code").val();},
                    id : function() { return $("#id").val();},
                }
            }
        },
        name : {
            required : true
        }
    },
    messages: {
        code: {
            required: "部门编号不能为空！",
            remote: jQuery.format("部门编号已经被使用")
        },
        name: {
            required: "部门名称不能为空！"
        }
    },
    onkeyup : false,
    focusCleanup : true,
    success : "valid",
    submitHandler : function(form) {
        $.ajax({
            type: "post",
            url: "save.jhtml",
            cache: false,
            data: $(form).serialize(),
            dataType: "json",
            success: function (res) {
                layer.msg(res.info,{icon:1,time:3000});
                if (res.status) {
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);//关闭弹出的子页面窗口
                }
            },
            error : function(XmlHttpRequest, textStatus, errorThrown) {
                layer.alert('数据保存失败');
            }
        });
    }
});

$(function(){

});