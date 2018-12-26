function Company() {};

Company.prototype = {
    list: function (){
        $.ajax({
            type: "post",
            url: "list.jhtml",
            cache: false,
            data: {
                "code": $.trim($("#code").val()),
                "name": $.trim($("#name").val()),
                "rnd": Math.random()
            },
            dataType: "json",
            success: function (res) {
                if (res.status) {
                    var create = $("#dataTableList > tbody").attr("data-create");
                    var edit = $("#dataTableList > tbody").attr("data-edit");
                    var del = $("#dataTableList > tbody").attr("data-delete");
                    var grant = $("#dataTableList > tbody").attr("data-grant");

                    var html = "";
                    var array = res.datas;
                    for (var i = 0; i < array.length; i++) {
                        var data = array[i];
                        var sort = "";
                        if (data.office.id == 0) {
                            html += "<tr data-tt-id=\"" + data.id + "\">";
                        } else {
                            html += "<tr data-tt-id=\"" + data.id + "\" data-tt-parent-id=\"" + data.office.id + "\">";
                        }
                        html += "<td>" + data.name + "（" + data.code + "）" + "</td>";
                        html += "<td>" + (data.showState ? "显示" : "隐藏") + "</td>";
                        html += "<td>" + data.serialNumber + "</td>";
                        html += "<td>";
                        if (create == 1) {
                            html += "<a href=\"javascript:void(0);\" onclick=\"company.add(" + data.id + ");\">新增子单位</a>&nbsp;&nbsp;";
                        }
                        if (edit == 1) {
                            html += "<a href=\"javascript:void(0);\" onclick=\"company.edit(" + data.id + ");\">编辑</a>&nbsp;&nbsp;";
                        }
                        if (del == 1) {
                            html += "<a href=\"javascript:void(0);\" onclick=\"company.delete(this, " + data.id + ");\">删除</a>"
                        }
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
            title: '添加单位',
            shadeClose: true,
            shade: 0.8,
            area: ['800px', '600px'],
            maxmin: true,
            content: 'edit.jhtml?office.id=' + pid + '&rnd=' + Math.random()
        });
    },
    edit: function (id) {
        layer.open({
            type: 2,
            title: '编辑单位',
            shadeClose: true,
            shade: 0.8,
            area: ['800px', '600px'],
            maxmin: true,
            content: 'edit.jhtml?id=' + id + '&rnd=' + Math.random()
        });
    },
    delete: function (obj, id) {
        layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                type : "post",
                url : "delete.jhtml",
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

var company = null;
$(function () {
    company = new Company();
    company.list();
});