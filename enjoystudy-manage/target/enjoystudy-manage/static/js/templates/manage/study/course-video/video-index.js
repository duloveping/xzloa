function goPage(curr) {
    $.ajax({
        type: "post",
        url: ctx + "/manage/study/course-video/list.jhtml",
        cache: false,
        data: {
            "pageNum": curr,
            "courseId": $.trim($("#courseId").val()),
            "name": $.trim($("#name").val()),
            "rnd": Math.random()
        },
        dataType: "json",
        success: function (res) {
            if (res.status) {
                var html = "";
                var array = res.datas;
                for (var i = 0; i < array.length; i++) {
                    var data = array[i];
                    html += "<tr>";
                    if ("" != data.image) {
                        html += "<td><img width=\"120\" class=\"product-thumb\" src=\"" + ctx + data.image + "\"></td>";
                    } else {
                        html += "<td></td>";
                    }
                    html += "<td>" + data.name + "</td>";
                    if (data.showState) {
                        html += "<td class=\"td-status\"><span class=\"label label-success radius\">显示</span></td>";
                    } else {
                        html += "<td class=\"td-status\"><span class=\"label label-default radius\">隐藏</span></td>";
                    }
                    html += "<td>" + data.introduction + "</td>";
                    html += "<td class=\"td-manage\">";
                    if (data.showState) {
                        html += "<a href=\"javascript:void(0);\" onclick=\"video.disabled(this, '" + data.id + "');\" style=\"text-decoration:none\" class=\"ml-5\" title=\"隐藏\"><i class=\"Hui-iconfont\">&#xe6de;</i></a>&nbsp;&nbsp;";
                    } else {
                        html += "<a href=\"javascript:void(0);\" onclick=\"video.enabled(this, '" + data.id + "');\" style=\"text-decoration:none\" class=\"ml-5\" title=\"显示\"><i class=\"Hui-iconfont\">&#xe6dc;</i></a>&nbsp;&nbsp;";
                    }
                    html += "<a href=\"javascript:void(0);\" onclick=\"video.edit('" + data.id + "');\" style=\"text-decoration:none\" class=\"ml-5\" title=\"编辑\"><i class=\"Hui-iconfont\">&#xe6df;</i></a>&nbsp;&nbsp;";
                    html += "<a href=\"javascript:void(0);\" onclick=\"video.delete(this, '" + data.id + "');\"style=\"text-decoration:none\" class=\"ml-5\" title=\"删除\"><i class=\"Hui-iconfont\">&#xe6e2;</i></a>"
                    html += "</td></tr>";
                }

                $("#dataTableList > tbody").html(html);
            } else {
                top.layer.alert(res.info);
            }
        },
        error : function(XmlHttpRequest, textStatus, errorThrown) {
            layer.alert('无权限操作');
        }
    });
}

function CourseVideo() {};

CourseVideo.prototype = {
    list: goPage,
    add: function () {
        var courseId = $("#courseId").val();
        var index = top.layer.open({
            type: 2,
            title: '添加课程',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: ctx + '/manage/study/course-video/edit.jhtml?courseId=' + courseId + '&rnd=' + Math.random()
        });
        top.layer.full(index);
    },
    edit: function (id) {
        var index = top.layer.open({
            type: 2,
            title: '修改课程',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: ctx + '/manage/study/course-video/edit.jhtml?id=' + id + '&rnd=' + Math.random()
        });
        top.layer.full(index);
    },
    delete: function (obj, id) {
        top.layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                type : "post",
                url : ctx + "/manage/study/course-video/delete.jhtml",
                cache : false,
                data : {"id" : id, "rnd" : Math.random()},
                dataType : "json",
                success : function(res){
                    if (res.status) {
                        layer.msg('删除成功',{icon:1,time:3000});
                    } else {
                        layer.alert(res.info);
                    }

                }
            });
            $(obj).parents("tr").remove();
            top.layer.close(index);
        });
    },
    enabled: function (obj, id) {
        top.layer.confirm('确认要显示吗？',function(index){
            $.ajax({
                type : "post",
                url : ctx + "/manage/study/course-video/update-video-state.jhtml",
                cache : false,
                data : {"videoId" : id, "showState": true, "rnd" : Math.random()},
                dataType : "json",
                success : function(res){
                    if (res.status) {
                        var html = "";
                        html += "<a href=\"javascript:void(0);\" onclick=\"video.disabled(this, '" + id + "');\"";
                        html += " style=\"text-decoration:none\" class=\"ml-5\" title=\"隐藏\">";
                        html += "<i class=\"Hui-iconfont\">&#xe6de;</i>";
                        html += "</a>";

                        $(obj).parents("tr").find(".td-manage").prepend(html);
                        $(obj).parents("tr").find(".td-status").html("<span class=\"label label-success radius\">显示</span>");
                        $(obj).remove();

                        top.layer.msg('显示成功!',{icon: 1,time:1000});
                    } else {
                        top.layer.alert(res.info);
                    }

                }
            });
            top.layer.close(index);
        });
    },
    disabled: function (obj, id) {
        top.layer.confirm('确认要隐藏吗？',function(index){
            $.ajax({
                type : "post",
                url : ctx + "/manage/study/course-video/update-video-state.jhtml",
                cache : false,
                data : {"videoId" : id, "showState": false, "rnd" : Math.random()},
                dataType : "json",
                success : function(res){
                    if (res.status) {
                        var html = "";
                        html += "<a href=\"javascript:void(0);\" onclick=\"video.enabled(this, '" + id + "');\"";
                        html += " style=\"text-decoration:none\" class=\"ml-5\" title=\"显示\">";
                        html += "<i class=\"Hui-iconfont\">&#xe642;</i>";
                        html += "</a>";

                        $(obj).parents("tr").find(".td-manage").prepend(html);
                        $(obj).parents("tr").find(".td-status").html("<span class=\"label label-default radius\">隐藏</span>");
                        $(obj).remove();

                        top.layer.msg('隐藏成功!',{icon: 1,time:1000});
                    } else {
                        top.layer.alert(res.info);
                    }
                }
            });
            top.layer.close(index);
        });
    }
};

var video = null;
$(function () {
    video = new CourseVideo();
    video.list(1);

    $("#searchBotton").bind("click", function(){
        video.list(1);
    });
});