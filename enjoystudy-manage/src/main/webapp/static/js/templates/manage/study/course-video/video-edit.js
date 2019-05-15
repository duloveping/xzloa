$("#inputForm").validate({
    rules : {
        name: {
            required: true
        }
    },
    messages: {
        name: {
            required: "课程名称不能为空！"
        }
    },
    onkeyup : false,
    focusCleanup : true,
    success : "valid",
    submitHandler : function(form) {
        entity.id = $("#id").val();
        entity.name = $.trim($("#name").val());
        entity.introduction = $.trim($("#introduction").val());
        entity.description = $.trim(editor.getContent());
        entity.course.id = $("#courseId").val();
        entity.course.name = $("#courseName").val();
        entity.courseId = $("#courseId").val();
        entity.courseName = $("#courseName").val();

        $.ajax({
            type: "post",
            url: ctx + "/manage/study/course-video/save.jhtml",
            cache: false,
            data: JSON.stringify(entity),
            dataType: "json",
            contentType : 'application/json;charset=UTF-8',
            success: function (res) {
                if (res.status) {
                    parent.mainFrame.location.reload(); // 父页面刷新
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                } else {
                    top.layer.alert(res.info);
                }
            },
            error : function(XmlHttpRequest, textStatus, errorThrown) {
                top.layer.alert('数据保存失败');
            }
        });
    }
});

function initUploader(element, url) {
    var $list = $("#" + element + "List");
    var $btn = $("#" + element + "-star");
    var state = "pending";
    var uploader;

    uploader = WebUploader.create({
        auto: true,
        swf: ctx + '/static/js/common/H-ui.admin_v3.0/lib/webuploader/0.1.5/Uploader.swf',
        // 文件接收服务端。
        server: ctx + url,
        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: '#' + element + 'Picker'
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
    uploader.on('uploadSuccess', function (f, response) {
        if (response.state == true) {
            if (element == "photo") {
                entity.image = response.large;
            } else if (element == "video") {
                entity.fileName = response.fileName;
                entity.fileType = response.contentType;
                entity.fileSize = response.size;
                entity.filePath = response.url;
                entity.uploadTime = new Date();

            } else if (element == "file") {
                var attachment = {
                    fileName: response.fileName,
                    fileType: response.contentType,
                    fileSize: response.size,
                    filePath: response.url,
                    uploadTime: new Date()
                }
                entity.attachmentList.push(attachment);
            }
        }
        $('#' + f.id).addClass('upload-state-success').find(".state").text("已上传");
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
}

function CourseVideo() {};
CourseVideo.prototype = {
    view: function (id) {
        $.ajax({
            type: "post",
            url: ctx + "/manage/study/course-video/video-view.jhtml",
            cache: false,
            data: {videoId: id, rnd: Math.random()},
            dataType: "json",
            success: function (res) {
                if (res.status) {
                    entity.course.id = res.video.courseId;
                    entity.course.name = res.video.courseName;
                    entity.id = res.video.id;
                    entity.name = res.video.name;
                    entity.introduction = res.video.introduction;
                    entity.description = res.video.description;

                    if (null != res.video.image && "" != res.video.image) {
                        entity.image = res.video.image;

                        var html = "";
                        html += "<div id=\"WU_FILE_0\" class=\"item upload-state-success\">";
                        html += "<div class=\"pic-box\"><img src=\"" + ctx + res.video.image + "\" width=\"100\" height=\"100\"></div>";
                        html += "<div class=\"info\">《" + res.video.name + "》的图片</div>";
                        html += "<p class=\"state\">已上传</p>";
                        html += "<div class=\"progress-box\" style=\"display: none;\">";
                        html += "<span class=\"progress-bar radius\">";
                        html += "<span class=\"sr-only\" style=\"width: 100%;\"></span>";
                        html += "</span>";
                        html += "</div>";
                        html += "</div>";
                        $("#photoList").html(html);
                    }

                    if (null != res.video.filePath && "" != res.video.filePath) {
                        entity.fileName = res.video.fileName;
                        entity.fileType = res.video.fileType;
                        entity.fileSize = res.video.fileSize;
                        entity.filePath = res.video.filePath;
                        entity.uploadTime = res.video.uploadTime;

                        var html = "";

                        html += "<div id=\"WU_FILE_1\" class=\"item upload-state-success\">";
                        html += "<div class=\"pic-box\"><span>不能预览</span></div>";
                        html += "<div class=\"info\">" + res.video.fileName + "</div>";
                        html += "<p class=\"state\">已上传</p>";
                        html += "<div class=\"progress-box\" style=\"display: none;\">";
                        html += "<span class=\"progress-bar radius\">";
                        html += "<span class=\"sr-only\" style=\"width: 100%;\"></span>";
                        html += "</span>";
                        html += "</div>";
                        html += "</div>";

                        $("#videoList").html(html);
                    }

                    $("#name").val(res.video.name);
                    $("#image").val(res.video.image);
                    $("#courseId").val(res.video.courseId);
                    $("#courseName").val(res.video.courseName);
                    $("#introduction").val(res.video.introduction);
                    $("#description").val(res.video.description);
                    $("#fileName").val(res.video.fileName);
                    $("#fileType").val(res.video.fileType);
                    $("#fileSize").val(res.video.fileSize);
                    $("#filePath").val(res.video.filePath);
                    $("#uploadTime").val(res.video.uploadTime);

                    if (null != res.video.attachmentList && res.video.attachmentList.length > 0) {
                        var html = "";
                        for (var i = 0; i < res.video.attachmentList.length; i++) {
                            var att = res.video.attachmentList[0];
                            entity.attachmentList.push(att);

                            html += "<div id=\"WU_FILE_" + (i + 3) + "\" class=\"item upload-state-success\">";
                            html += "<div class=\"pic-box\"><span>不能预览</span></div>";
                            html += "<div class=\"info\">" + att.fileName + "</div>";
                            html += "<p class=\"state\">已上传</p>";
                            html += "<div class=\"progress-box\" style=\"display: none;\">";
                            html += "<span class=\"progress-bar radius\">";
                            html += "<span class=\"sr-only\" style=\"width: 100%;\"></span>";
                            html += "</span>";
                            html += "</div>";
                            html += "</div>";
                        }

                        $("#fileList").html(html);

                    }
                } else {
                    top.layer.alert(res.info);
                }

            },
            error : function(XmlHttpRequest, textStatus, errorThrown) {
                top.layer.alert('请求失败');
            }
        });
    },
    courseDetail: function (id) {
        $.ajax({
            type: "post",
            url: ctx + "/manage/study/course-video/course-view.jhtml",
            cache: false,
            data: {courseId: id, rnd: Math.random()},
            dataType: "json",
            success: function (res) {
                if (res.status) {
                    entity.course.id = res.course.id;
                    entity.course.name = res.course.name;

                    $("#courseName").val(res.course.name);
                } else {
                    top.layer.alert(res.info);
                }
            },
            error : function(XmlHttpRequest, textStatus, errorThrown) {
                top.layer.alert('请求失败');
            }
        });
    }
};

var editor;
var courseVideo;

var entity = {
    id: "",
    name: "",
    image: "",
    courseId: "",
    courseName: "",
    course: {id: "", name: ""},
    introduction: "",
    description: "",
    fileName: "",
    fileType: "",
    fileSize: 0,
    filePath: "",
    uploadTime: new Date(),
    attachmentList: new Array()
};


$(function () {
    courseVideo = new CourseVideo();

    var id = $.trim($("#id").val());
    var courseId = $.trim($("#courseId").val());
    if ("" != id) {
        courseVideo.view(id);
    } else {
        courseVideo.courseDetail(courseId);
    }

    editor = UE.getEditor('description');
    editor.addListener( 'ready', function() {
        editor.setContent(entity.description);
    } );


    initUploader('photo', '/manage/study/course-video/upload-image.jhtml');
    initUploader('video', '/manage/study/course-video/upload-media.jhtml');
    initUploader('file', '/manage/study/course-video/upload-file.jhtml');
});
