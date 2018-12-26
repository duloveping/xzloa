function CourseType() {};

CourseType.prototype = {
    list: function (){
        $.ajax({
            type: "post",
            url: ctx + "/manage/study/course-type/list.jhtml",
            cache: false,
            data: {
                "code": $.trim($("#code").val()),
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
                        if (data.parentId == "0") {
                            html += "<tr data-tt-id=\"" + data.id + "\">";
                        } else {
                            html += "<tr data-tt-id=\"" + data.id + "\" data-tt-parent-id=\"" + data.parentId + "\">";
                        }
                        html += "<td>" + data.name + "（" + data.code + "）</td>";
                        html += "<td>";
                        html += "<a href=\"javascript:void(0);\" onclick=\"courseType.add('" + data.id + "');\">新增子架构</a>&nbsp;&nbsp;";
                        html += "<a href=\"javascript:void(0);\" onclick=\"courseType.edit('" + data.id + "');\">编辑</a>&nbsp;&nbsp;";
                        html += "<a href=\"javascript:void(0);\" onclick=\"courseType.delete(this, '" + data.id + "');\">删除</a>"
                        html += "</td></tr>";
                    }
                    $("#dataTableList > tbody").html(html).treetable();
                } else {
                    layer.alert(res.info);
                }
            }
        });
    },
    add: function (pid) {
        layer.open({
            type: 2,
            title: '添加组织架构',
            shadeClose: true,
            shade: 0.8,
            area: ['800px', '600px'],
            maxmin: true,
            content: ctx + '/manage/study/course-type/edit.jhtml?parentId=' + pid + '&rnd=' + Math.random()
        });
    },
    edit: function (id) {
        layer.open({
            type: 2,
            title: '编辑组织架构',
            shadeClose: true,
            shade: 0.8,
            area: ['800px', '600px'],
            maxmin: true,
            content: ctx + '/manage/study/course-type/edit.jhtml?id=' + id + '&rnd=' + Math.random()
        });
    },
    delete: function (obj, id) {
        layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                type : "post",
                url : ctx + "/manage/study/course-type/delete.jhtml",
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
    }
};

var courseType = null;
$(function () {
    courseType = new CourseType();
    courseType.list();
});