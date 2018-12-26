function goPage(curr) {
    var typeId = $("#typeId").val();
    $.ajax({
        type: "post",
        url: "select.jhtml?type.id=" + typeId,
        cache: false,
        data: {
            "pageNumber": curr,
            "code": $.trim($("#code").val()),
            "name": $.trim($("#name").val()),
            "rnd": Math.random()
        },
        dataType: "json",
        success: function (res) {
            if (res.status) {
                var edit = $("#dataTableList > tbody").attr("data-edit");
                var del = $("#dataTableList > tbody").attr("data-delete");
                var html = "";
                var array = res.datas;
                for (var i = 0; i < array.length; i++) {
                    var data = array[i];
                    html += "<tr>";
                    html += "<td>" + data.name + "</td>";
                    html += "<td>";
                    if (edit == 1) {
                        html += "<a href=\"javascript:void(0);\" onclick=\"infoType.edit(" + data.id + ");\">编辑</a>&nbsp;&nbsp;";
                    }
                    if (edit == 1) {
                        html += "<a href=\"javascript:void(0);\" onclick=\"infoType.delete(this, " + data.id + ");\">删除</a>"
                    }
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

function InfoType() {};

InfoType.prototype = {
    list: goPage,
    add: function () {
        top.layer.open({
            type: 2,
            title: '添加分类',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: '../../manage/article/attachment-type/edit.jhtml?type.id=' + $("#typeId").val() + '&rnd=' + Math.random()
        });
    },
    edit: function (id) {
        top.layer.open({
            type: 2,
            title: '修改分类',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: '../../manage/article/attachment-type/edit.jhtml?id=' + id + '&rnd=' + Math.random()
        });
    },
    delete: function (obj, id) {
        top.layer.confirm('确认要删除吗？',function(index){
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

var infoType = null;
$(function () {
    infoType = new InfoType();
    infoType.list(1);

    $("#searchBotton").bind("click", function(){
        infoType.list(1);
    });
});