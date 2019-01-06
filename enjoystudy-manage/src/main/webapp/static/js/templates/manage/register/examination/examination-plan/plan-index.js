function goPage(curr) {
    $.ajax({
        type: "post",
        url: ctx + "/manage/register/examination/examination-plan/list.jhtml",
        cache: false,
        data: {
            "pageNum": curr,
            "title": $.trim($("#title").val()),
            "showState": $.trim($("#showState").val()),
            "entryState": $.trim($("#entryState").val()),
            "testState": $.trim($("#testState").val()),
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
                    html += "<td>" + data.title + "</td>";
                    if (data.showState) {
                        html += "<td class=\"td-status\"><span class=\"label label-success radius\">显示</span></td>";
                    } else {
                        html += "<td class=\"td-status\"><span class=\"label label-default radius\">隐藏</span></td>";
                    }
                    html += "<td class=\"td-manage\">";
                    if (data.showState) {
                        html += "<a href=\"javascript:void(0);\" onclick=\"plan.disabled(this, '" + data.id + "');\" style=\"text-decoration:none\" class=\"ml-5\" title=\"隐藏\"><i class=\"Hui-iconfont\">&#xe6de;</i></a>&nbsp;&nbsp;";
                    } else {
                        html += "<a href=\"javascript:void(0);\" onclick=\"plan.enabled(this, '" + data.id + "');\" style=\"text-decoration:none\" class=\"ml-5\" title=\"显示\"><i class=\"Hui-iconfont\">&#xe6dc;</i></a>&nbsp;&nbsp;";
                    }
                    html += "<a href=\"javascript:void(0);\" onclick=\"plan.edit('" + data.id + "');\" style=\"text-decoration:none\" class=\"ml-5\" title=\"编辑\"><i class=\"fa fa-edit fa-lg\"></i></a>&nbsp;";
                    html += "<a href=\"javascript:void(0);\" onclick=\"plan.delete(this, '" + data.id + "');\"style=\"text-decoration:none\" class=\"ml-5\" title=\"删除\"><i class=\"fa fa-remove fa-lg\"></i></a>&nbsp;"
                    html += "</td>";
                    html += "</tr>";
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

function ExaminationPlan() {};

ExaminationPlan.prototype = {
    list: goPage,
    add: function () {
        var index = layer.open({
            type: 2,
            title: '添加考试计划安排',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: ctx + '/manage/register/examination/examination-plan/edit.jhtml?rnd=' + Math.random()
        });
        layer.full(index);
    },
    edit: function (id) {
        var index = layer.open({
            type: 2,
            title: '编辑考试计划安排',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: ctx + '/manage/register/examination/examination-plan/edit.jhtml?id=' + id + '&rnd=' + Math.random()
        });
        layer.full(index);
    },
    delete: function (obj, id) {
        layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                type : "post",
                url : ctx + "/manage/register/examination/examination-plan/delete.jhtml",
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
    enabled: function (obj, id) {
        top.layer.confirm('确认要显示吗？',function(index){
            $.ajax({
                type : "post",
                url : ctx + "/manage/register/examination/examination-plan/change-show-state.jhtml",
                cache : false,
                data : {"id" : id, "showState": true, "rnd" : Math.random()},
                dataType : "json",
                success : function(res){
                    if (res.status) {
                        var html = "";
                        html += "<a href=\"javascript:void(0);\" onclick=\"plan.disabled(this, '" + id + "');\"";
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
                url : ctx + "/manage/register/examination/examination-plan/change-show-state.jhtml",
                cache : false,
                data : {"id" : id, "showState": false, "rnd" : Math.random()},
                dataType : "json",
                success : function(res){
                    if (res.status) {
                        var html = "";
                        html += "<a href=\"javascript:void(0);\" onclick=\"plan.enabled(this, '" + id + "');\"";
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

var plan = null;
$(function () {
    plan = new ExaminationPlan();
    plan.list(1);

    $("#searchBotton").bind("click", function(){
        plan.list(1);
    });
});