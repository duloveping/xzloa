$(function () {
    $("#inputForm").validate({
        rules : {
            code : {
                required : true,
                remote : {
                    type : "post",
                    url : ctx + "/manage/study/course-type/check.jhtml",
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
                    url : ctx + "/manage/study/course-type/check.jhtml",
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
                url: ctx + "/manage/study/course-type/save.jhtml",
                cache: false,
                data: $(form).serialize(),
                dataType: "json",
                success: function (res) {
                    if (res.status) {
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.courseType.list();
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

function showTypeSingleDialog(typeId) {
    top.layer.open({
        type: 2,
        title: '部门选择',
        shadeClose: true,
        shade: 0.8,
        area: ['480px', '600px'],
        maxmin: true,
        content: ctx + '/manage/study/course-type/single-select.jhtml?ids=' + typeId + '&rnd=' + Math.random(),
        btn: ['确定','关闭'],
        yes: function(index, layero){
            var data = $(layero).find("iframe")[0].contentWindow.getCheckValue();
            $("#typeId").val(data.id)
            $("#typeName").val(data.name)
            top.layer.close(index);
        },
        cancel: function(){

        }
    });
}