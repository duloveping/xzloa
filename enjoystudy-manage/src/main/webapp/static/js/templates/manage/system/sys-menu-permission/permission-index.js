function Permission() {};

Permission.prototype = {
    list: function (){
        $.ajax({
            type: "post",
            url: "permission-list.jhtml",
            cache: false,
            data: {
                "menuId": $("#dataTableList").attr("data-id"),
                "rnd": Math.random()
            },
            dataType: "json",
            success: function (res) {
                var html = "";
                var array = res.datas;
                for (var i = 0; i < array.length; i++) {
                    var data = array[i];
                    html += "<tr>";
                    html += "<td>" + data.permission + "</td>";
                    html += "<td>" + data.name + "</td>";
                    html += "<td>" + (data.showState == true ? "显示" : "隐藏") + "</td>";
                    if (null == data.caption) {
                        html += "<td></td>";
                    } else {
                        html += "<td>" + $.trim(data.caption) +  "</td>";
                    }
                    html += "<td>";
                    html += "<a href=\"javascript:void(0);\" onclick=\"permission.edit(" + data.id + ");\">编辑</a>&nbsp;|&nbsp;";
                    html += "<a href=\"javascript:void(0);\" onclick=\"permission.delete(this, " + data.id + ");\">删除</a></td>"
                    html += "</tr>";
                }

                $("#dataTableList > tbody").html(html);
            }
        });
    },
    add: function (menuId) {
        $("#listPage").hide();
        $("#editPage").show();
        $("#editPage").load("permission-edit.jhtml", {"menu.id":menuId, "rnd":Math.random()});
    },
    edit: function (id) {
        $("#listPage").hide();
        $("#editPage").show();
        $("#editPage").load("permission-edit.jhtml", {"id":id, "rnd":Math.random()});
    },
    delete: function (obj, id) {
        layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                type : "post",
                url : "permission-delete.jhtml",
                cache : false,
                data : {"id" : id, "rnd" : Math.random()},
                dataType : "json",
                success : function(msg){
                    layer.msg('删除成功',{icon:1,time:3000});
                }
            });
            $(obj).parents("tr").remove();
            layer.close(index);
        });
    }
};

var permission = null;
$(function () {
    permission = new Permission();
    permission.list();
});