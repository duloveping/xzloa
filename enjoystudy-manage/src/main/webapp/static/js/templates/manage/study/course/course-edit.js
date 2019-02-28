$("#inputForm").validate({
    rules : {
        code : {
            required : true,
            remote : {
                type : "post",
                url : ctx + "/manage/study/course/check.jhtml",
                data : {
                    code : function() { return $("#code").val();},
                    id : function() { return $("#id").val();}
                }
            }
        },
        name: {
            required : true
        },
        teacherId: {
            required : true
        },
        typeName: {
            required : true
        },
        marketPrice: {
            required : true
        },
        currentPrice: {
            required : true
        },
        salePrice: {
            required : true
        }
    },
    messages: {
        code: {
            required: "编号不能为空！"
        },
        name: {
            required: "课程名称不能为空！"
        },
        teacherId: {
            required: "授课老师不能为空！"
        },
        typeName: {
            required: "课程分类不能为空！"
        },
        marketPrice: {
            required : "市价不能为空"
        },
        currentPrice: {
            required : "现价不能为空"
        },
        salePrice: {
            required : "促销价不能为空"
        }
    },
    onkeyup : false,
    focusCleanup : true,
    success : "valid",
    submitHandler : function(form) {
        $.ajax({
            type: "post",
            url: ctx + "/manage/study/course/save.jhtml",
            cache: false,
            data: $(form).serialize(),
            dataType: "json",
            success: function (res) {
                layer.msg(res.info,{icon:1,time:3000});
                if (res.status) {
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.course.list(1);
                    parent.layer.close(index);
                }
            },
            error : function(XmlHttpRequest, textStatus, errorThrown) {
                top.layer.alert('数据保存失败');
            }
        });
    }
});

function showTypeSingleDialog(typeId) {
    top.layer.open({
        type: 2,
        title: '课程分类选择',
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
        }
    });
}

var $list = $("#fileList");
var $btn = $("#btn-star");
var state = "pending";
var ue;
var uploader;

$(function () {
    ue = UE.getEditor('description');

    uploader = WebUploader.create({
        auto: true,
        swf: ctx + '/static/js/common/H-ui.admin_v3.0/lib/webuploader/0.1.5/Uploader.swf',
        // 文件接收服务端。
        server: ctx + '/manage/study/course/upload-image.jhtml',
        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: '#filePicker'
    });

    uploader.on('fileQueued', function (file) {
        var $li = $(
            '<div id="' + file.id + '" class="item">' +
            '<div class="pic-box"><img/></div>' +
            '<div class="info">' + file.name + '</div>' +
            '<p class="state">等待上传...</p>' +
            '</div>'),
            $img = $li.find('img');
        $list.append($li);

        // 创建缩略图
        // 如果为非图片文件，可以不用调用此方法。
        // thumbnailWidth x thumbnailHeight 为 100 x 100

        var thumbnailWidth = 100;
        var thumbnailHeight = 100;

        uploader.makeThumb(file, function (error, src) {
            if (error) {
                $img.replaceWith('<span>不能预览</span>');
                return;
            }

            $img.attr('src', src);
        }, thumbnailWidth, thumbnailHeight);
    });

    // 文件上传过程中创建进度条实时显示。
    uploader.on('uploadProgress', function (file, percentage) {
        var $li = $('#' + file.id),
            $percent = $li.find('.progress-box .sr-only');

        // 避免重复创建
        if (!$percent.length) {
            $percent = $('<div class="progress-box"><span class="progress-bar radius"><span class="sr-only" style="width:0%"></span></span></div>').appendTo($li).find('.sr-only');
        }
        $li.find(".state").text("上传中");
        $percent.css('width', percentage * 100 + '%');
    });

    // 文件上传成功，给item添加成功class, 用样式标记上传成功。
    uploader.on('uploadSuccess', function (file, response) {
        if (response.state == true) {
            $("#image").val(response.large);
        }
        $('#' + file.id).addClass('upload-state-success').find(".state").text("已上传");
    });

    // 文件上传失败，显示上传出错。
    uploader.on('uploadError', function (file) {
        $('#' + file.id).addClass('upload-state-error').find(".state").text("上传出错");
    });

    // 完成上传完了，成功或者失败，先删除进度条。
    uploader.on('uploadComplete', function (file) {
        $('#' + file.id).find('.progress-box').fadeOut();
    });

    uploader.on('all', function (type) {
        if (type === 'startUpload') {
            state = 'uploading';
        } else if (type === 'stopUpload') {
            state = 'paused';
        } else if (type === 'uploadFinished') {
            state = 'done';
        }

        if (state === 'uploading') {
            $btn.text('暂停上传');
        } else {
            $btn.text('开始上传');
        }
    });

    $btn.on('click', function () {
        if (state === 'uploading') {
            uploader.stop();
        } else {
            uploader.upload();
        }
    });
});
