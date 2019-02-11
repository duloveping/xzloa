$(function () {
    $("#inputForm").validate({
        rules : {
            code : {
                required : true,
                remote : {
                    type : "post",
                    url : ctx + "/manage/web/news-type/check.jhtml",
                    data : {
                        code : function() { return $("#code").val();},
                        id : function() { return $("#id").val();}
                    }
                }
            },
            name : {
                required : true
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
        onkeyup : false,
        focusCleanup : true,
        success : "valid",
        submitHandler:function(form){
            $.ajax({
                type: "post",
                url: ctx + "/manage/web/news-type/save.jhtml",
                cache: false,
                data: $(form).serialize(),
                dataType: "json",
                success: function (res) {
                    if (res.status) {
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.newsType.list(1);
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
