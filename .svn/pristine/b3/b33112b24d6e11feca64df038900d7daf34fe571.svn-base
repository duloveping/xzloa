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
            required: "角色编号不能为空！",
            remote: jQuery.format("角色编号已经被使用")
        },
        name: {
            required: "角色名称不能为空！"
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
                    parent.role.list(1);
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
    $(".permission-list dt input:checkbox").click(function(){
        $(this).closest("dl").find("dd input:checkbox").prop("checked",$(this).prop("checked"));
    });
    $(".permission-list2 dd input:checkbox").click(function(){
        var l =$(this).parent().parent().find("input:checked").length;
        var l2=$(this).parents(".permission-list").find(".permission-list2 dd").find("input:checked").length;
        if($(this).prop("checked")){
            $(this).closest("dl").find("dt input:checkbox").prop("checked",true);
            $(this).parents(".permission-list").find("dt").first().find("input:checkbox").prop("checked",true);
        }
        else{
            if(l==0){
                $(this).closest("dl").find("dt input:checkbox").prop("checked",false);
            }
            if(l2==0){
                $(this).parents(".permission-list").find("dt").first().find("input:checkbox").prop("checked",false);
            }
        }
    });
});