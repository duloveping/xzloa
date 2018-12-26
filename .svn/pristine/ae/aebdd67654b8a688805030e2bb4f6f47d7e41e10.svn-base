$(function () {
    $("#inputForm").validate({
        rules : {
            code : {
                required : true,
                remote : {
                    type : "post",
                    url : "check.jhtml",
                    data : {
                        code : function() { return $("#code").val();},
                        id : function() { return $("#id").val();}
                    }
                }
            },
            name : {
                required : true,
                remote : {
                    type : "post",
                    url : "check.jhtml",
                    data : {
                        category : function() { return $("input[name=category][type=radio]:checked").val();},
                        parentId : function() { return $("#parentId").val();},
                        name : function() { return $("#name").val();},
                        id : function() { return $("#id").val();}
                    }
                }
            }
        },
        messages: {
            code: {
                required: "编号不能为空！"
            },
            name: {
                required: "名称不能为空！"
            }
        },
        submitHandler:function(form){
            $.ajax({
                type: "post",
                url: "save.jhtml",
                cache: false,
                data: $(form).serialize(),
                dataType: "json",
                success: function (res) {
                    if (res.status) {
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.department.list();
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
