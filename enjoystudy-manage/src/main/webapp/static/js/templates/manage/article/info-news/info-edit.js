function selectInfoTypeDialog() {
    var typeId = $("#typeId").val();
    top.layer.open({
        type: 2,
        title: '信息类别选择框',
        shadeClose: true,
        shade: 0.8,
        area: ['640px', '480px'],
        maxmin: true,
        content: '../../manage/article/info-type/single.jhtml?typeId=' + typeId + '&rnd=' + Math.random(),
        btn: ['确定', '关闭'],
        yes: function (index, layero) {
            var data = $(layero).find("iframe")[0].contentWindow.getCheckValue();
            $("#typeId").val(data.id)
            $("#typeName").val(data.name)
            top.layer.close(index);
        },
        cancel: function () {}
    });
}
var $list = $("#fileList");
var $btn = $("#btn-star");
var state = "pending";
var contextPath = $("#inputForm").attr("data-context-path");

$(function () {
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

    var uploader = WebUploader.create({
        auto: true,
        swf: contextPath + '/static/js/common/H-ui.admin_v3.0/lib/webuploader/0.1.5/Uploader.swf/Uploader.swf',
        // 文件接收服务端。
        server: 'upload-file.jhtml',
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
            $("#fileName").val(response.fileName);
            $("#contentType").val(response.contentType);
            $("#fileSize").val(response.size);
            $("#filePath").val(response.url);
            if (null != response.large && typeof(response.large) == "undefined") {
                $("#large").val(response.large);
            }
            if (null != response.middle && typeof(response.middle) == "undefined") {
                $("#middle").val(response.middle);
            }
            if (null != response.small && typeof(response.small) == "undefined") {
                $("#small").val(response.small);
            }
            if (null != response.thumb && typeof(response.thumb) == "undefined") {
                $("#thumb").val(response.thumb);
            }
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

    var ue = UE.getEditor('content');
    $("#typeName").bind("click", selectInfoTypeDialog);


    $("#inputForm").validate({
        submitHandler: function (form) {
            layer.load();
            $.ajax({
                type: "post",
                url: "save.jhtml",
                cache: false,
                data: $(form).serialize(),
                dataType: "json",
                success: function (res) {
                    layer.closeAll('loading');
                    if (res.status) {
                        parent.mainFrame.location.reload();//刷新mainFrame数据
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭
                    } else {
                        layer.alert(res.info);
                    }
                },
                error: function (XmlHttpRequest, textStatus, errorThrown) {
                    layer.alert('数据保存失败');
                }
            });
        }
    });
});
