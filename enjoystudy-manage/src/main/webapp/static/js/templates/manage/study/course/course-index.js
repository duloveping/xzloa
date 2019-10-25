function goPage(curr) {
    $.ajax({
        type: "post",
        url: ctx + "/manage/study/course/list.jhtml",
        cache: false,
        data: {
            "pageNum": curr,
            "code": $.trim($("#code").val()),
            "name": $.trim($("#name").val()),
            "typeId": $.trim($("#typeId").val()),
            "teacherId": $.trim($("#teacherId").val()),
            "rnd": Math.random()
        },
        dataType: "json",
        success: function (res) {
            if (res.status) {
                var getTpl = document.getElementById("course-data-list").innerHTML;

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
                layer.alert(res.info);
            }
        },
        error : function(XmlHttpRequest, textStatus, errorThrown) {
            layer.alert('无权限操作');
        }
    });
}

function Course() {};

Course.prototype = {
    list: goPage,
    add: function () {
        var index = layer.open({
            type: 2,
            title: '添加课程',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: ctx + '/manage/study/course/edit.jhtml?rnd=' + Math.random()
        });
        layer.full(index);
    },
    edit: function (id) {
        var index = layer.open({
            type: 2,
            title: '修改课程',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: ctx + '/manage/study/course/edit.jhtml?id=' + id + '&rnd=' + Math.random()
        });
        layer.full(index);
    },
    delete: function (obj, id) {
        layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                type : "post",
                url : ctx + "/manage/study/course/delete.jhtml",
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
            layer.close(index);
        });
    },
    videoList: function (id) {
        document.location.href = ctx  + '/manage/study/course-video/index.jhtml?courseId=' + id + '&rnd=' + Math.random();
    },
    attachmentList: function (id) {
        document.location.href = ctx  + '/manage/study/course-attachment/index.jhtml?courseId=' + id + '&rnd=' + Math.random();
    }
};

var course = null;
$(function () {
    course = new Course();
    course.list(1);

    $("#searchBotton").bind("click", function(){
        course.list(1);
    });
});