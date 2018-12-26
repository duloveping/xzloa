function goPage(curr) {
    $.ajax({
        type: "post",
        url: ctx + "/manage/study/exercise/list.jhtml",
        cache: false,
        data: {
            "pageNum": curr,
            "title": $.trim($("#title").val()),
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
                    html += "<td>" + data.courseName + "</td>";
                    html += "<td>" + data.title + "</td>";
                    html += "<td>" + showCategory(data.category) + "</td>";
                    html += "<td>" + data.score + "</td>";
                    html += "<td class=\"td-manage\">";
                    html += "<a href=\"javascript:void(0);\" onclick=\"exercise.edit('" + data.id + "');\" style=\"text-decoration:none\" class=\"ml-5\" title=\"编辑\"><i class=\"fa fa-edit fa-lg\"></i></a>&nbsp;";
                    html += "<a href=\"javascript:void(0);\" onclick=\"exercise.delete(this, '" + data.id + "');\"style=\"text-decoration:none\" class=\"ml-5\" title=\"删除\"><i class=\"fa fa-remove fa-lg\"></i></a>"
                    html += "</td></tr>";
                }

                $("#dataTableList > tbody").html(html);

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

function showCategory(category) {
    var val = "";
    switch (category) {
        case 1:
            val = "单选题";
            break;
        case 2:
            val = "多选题";
            break;
        case 3:
            val = "不定项选择题";
            break;
        case 4:
            val = "判断题";
            break;
        case 5:
            val = "填空题";
            break;
        case 6:
            val = "主观题";
            break;
        default:
            val = "";
    }
    return val;
}

function Exercise() {};

Exercise.prototype = {
    list: goPage,
    add: function () {
        var index = top.layer.open({
            type: 2,
            title: '添加练习题',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: ctx + '/manage/study/exercise/edit.jhtml?rnd=' + Math.random()
        });
        top.layer.full(index);
    },
    edit: function (id) {
        var index = top.layer.open({
            type: 2,
            title: '修改练习题',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: ctx + '/manage/study/exercise/edit.jhtml?id=' + id + '&rnd=' + Math.random()
        });
        top.layer.full(index);
    },
    delete: function (obj, id) {
        top.layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                type : "post",
                url : ctx + "/manage/study/exercise/delete.jhtml",
                cache : false,
                data : {"id" : id, "rnd" : Math.random()},
                dataType : "json",
                success : function(res){
                    if (res.status) {
                        top.layer.msg('删除成功',{icon:1,time:3000});
                    } else {
                        top.layer.alert(res.info);
                    }

                }
            });
            $(obj).parents("tr").remove();
            top.layer.close(index);
        });
    }
};

var exercise = null;
$(function () {
    exercise = new Exercise();
    exercise.list(1);

    $("#searchBotton").bind("click", function(){
        exercise.list(1);
    });
});