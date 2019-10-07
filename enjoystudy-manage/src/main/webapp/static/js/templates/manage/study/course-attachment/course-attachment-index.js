function back() {
    document.location.href = "/manage/study/course/index.jhtml?rnd=" + Math.random();
}

function goPage(curr) {
    top.layer.load();

    $.ajax({
        type: "post",
        url: "/manage/study/course-attachment/list.jhtml",
        cache: false,
        data: {
            "pageNum": curr,
            "courseId": $.trim($("#courseId").val()),
            "fileName": $.trim($("#fileName").val()),
            "rnd": Math.random()
        },
        dataType: "json",
        success: function (res) {
            top.layer.closeAll('loading');

            if (res.status) {
                var getTpl = document.getElementById("attachment-data-list").innerHTML;

                laytpl(getTpl).render({list:res.datas}, function (html) {
                    $("#dataTableList > tbody").html(html);
                });

                laypage({
                    cont: 'pageNav',
                    pages: res.pages,
                    groups: 10,
                    curr: curr || 1,
                    jump: function (obj, first) {
                        if (!first) {
                            goPage(obj.curr);
                        }
                    }
                });
            } else {
                top.layer.alert(res.info);
            }
        },
        error : function(XmlHttpRequest, textStatus, errorThrown) {
            top.layer.closeAll('loading');
            layer.alert('无权限操作');
        }
    });
}

function CourseAttachment() {};

CourseAttachment.prototype = {
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
            content: ctx + '/manage/study/course-attachment/edit.jhtml?courseId=' + courseId + '&rnd=' + Math.random()
        });
        top.layer.full(index);
    },
    delete: function (obj, id) {
        top.layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                type : "get",
                url : "/manage/study/course-attachment/delete.jhtml?id=" + id,
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
                url : ctx + "/manage/study/course-attachment/change-show-state.jhtml",
                cache : false,
                data : {"attachmentId" : id, "showState": true, "rnd" : Math.random()},
                dataType : "json",
                success : function(res){
                    if (res.status) {
                        var html = "";
                        html += "<a href=\"javascript:void(0);\" onclick=\"attachment.disabled(this, '" + id + "');\"";
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
                url : ctx + "/manage/study/course-attachment/update-attachment-state.jhtml",
                cache : false,
                data : {"attachmentId" : id, "showState": false, "rnd" : Math.random()},
                dataType : "json",
                success : function(res){
                    if (res.status) {
                        var html = "";
                        html += "<a href=\"javascript:void(0);\" onclick=\"attachment.enabled(this, '" + id + "');\"";
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

var attachment = null;
$(function () {
    attachment = new CourseAttachment();
    attachment.list(1);

    $("#searchBotton").bind("click", function(){
        attachment.list(1);
    });

    $("#backButton").on("click", back)
});