$("#inputForm").validate({
    rules : {
        systemName: {
            required: true
        },
        copyright: {
            required: true
        },
        webSite: {
            required: true
        },
        allowUploadImage: {
            required: true
        },
        allowUploadFile: {
            required: true
        },
        allowUploadMedia: {
            required: true
        },
        allowUploadFlash: {
            required: true
        }
    },
    messages: {
        systemName: {
            required: "系统名称不能为空！"
        },
        copyright: {
            required: "版权所有者不能为空！"
        },
        webSite: {
            required: "网址不能为空！"
        },
        allowUploadImage: {
            required: "允许上传的图片扩展名不能为空！"
        },
        allowUploadFile: {
            required: "允许上传的文件扩展名不能为空！"
        },
        allowUploadMedia: {
            required: "允许上传的媒体扩展名不能为空！"
        },
        allowUploadFlash: {
            required: "允许上传的FLASH扩展名不能为空！"
        }
    },
    onkeyup : false,
    focusCleanup : true,
    success : "valid",
    submitHandler : function(form) {
        $.ajax({
            type: "post",
            url: ctx + "/manage/system/sys-base-config/save.jhtml",
            cache: false,
            data: $(form).serialize(),
            dataType: "json",
            success: function (res) {
                $("#id").val(res.id);
                top.layer.alert(res.info,{icon:1,time:3000});
            },
            error : function(XmlHttpRequest, textStatus, errorThrown) {
                top.layer.alert('数据保存失败');
            }
        });
    }
});

$(function() {
    $('.skin-minimal input').iCheck({
        checkboxClass: 'icheckbox-blue',
        radioClass: 'iradio-blue',
        increaseArea: '20%'
    });
});