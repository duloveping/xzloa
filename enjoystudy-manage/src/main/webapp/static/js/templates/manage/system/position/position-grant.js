$(function () {
    $("#inputForm").validate({
        rules : {
            roleIds : {
                required : true
            }
        },
        messages: {
            roleIds: {
                required: "系统角色不能为空！"
            }
        },
        onkeyup : false,
        focusCleanup : true,
        success : "valid",
        submitHandler:function(form){
            var positionId = $.trim($("#id").val());
            var roleIds = new Array();

            $("input[name=roleIds][type=checkbox]:checked").each(function(index, element){
                roleIds.push(element.value);
            });

            $.ajax({
                type: "post",
                url: "grantSave.jhtml",
                cache: false,
                data: {positionId: positionId, roleIds: roleIds.join(",")},
                dataType: "json",
                success: function (res) {
                    if (res.status) {
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.position.list(1);
                        parent.layer.close(index);
                    } else {
                        layer.alert(res.info);
                    }
                },
                error : function(XmlHttpRequest, textStatus, errorThrown) {
                    layer.alert('数据保存失败');
                }
            });
        }
    });
});
