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
        name: {
            required: "分类名称不能为空！"
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
                    parent.infoType.list(1);
                    parent.layer.close(index);
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