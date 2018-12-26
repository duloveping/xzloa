$("#inputForm").validate({
    rules : {
        code : {
            required : true,
            remote : {
                type : "POST",
                url : "permission-check.jhtml",
                data : {
                    menuId : function() { return $("#menuId").val(); },
                    permission : function() { return $("#permission").val(); },
                    id : function() { return $("#id").val(); }
                }
            }
        },
        name : {
            required : true
        }
    },
    messages: {
        code: {
            required: "权限编号不能为空！",
            remote: jQuery.format("权限编号已经被使用")
        },
        name: {
            required: "权限名称不能为空！"
        }
    },
    onkeyup : false,
    focusCleanup : true,
    success : "valid",
    submitHandler : function(form) {
        $.ajax({
            type: "post",
            url: "permission-save.jhtml",
            cache: false,
            data: $(form).serialize(),
            dataType: "json",
            success: function (res) {
                if (res.status) {
                    $("#listPage").show();
                    permission.list();
                    $("#editPage").hide();
                } else {
                    layer.msg(res.info,{icon:1,time:3000});
                }
            },
            error : function(XmlHttpRequest, textStatus, errorThrown) {
                layer.msg('数据保存失败',{icon:1,time:3000});
            }
        });
    }
});

function backListPage() {
    $("#listPage").show();
    permission.list();
    $("#editPage").hide();
}