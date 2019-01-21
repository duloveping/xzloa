function AdvertisementPlace() {};

AdvertisementPlace.prototype = {
    list: function (curr){
        $.ajax({
            type: "post",
            url: ctx + "/manage/web/advertisement-place/list.jhtml",
            cache: false,
            data: {
                "pageNum": curr,
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
                        html += "<tr>";
                        html += "<td>" + data.code + "</td>";
                        html += "<td>" + data.name + "</td>";
                        if (data.description != null) {
                            html += "<td>" + data.description + "</td>";
                        } else {
                            html += "<td></td>";
                        }

                        html += "<td>";
                        if (data.showState ) {
                            html += "显示";
                        } else {
                            html += "隐藏";
                        }
                        html += "</td>";
                        html += "<td>";
                        html += "<a href=\"javascript:void(0);\" onclick=\"place.edit('" + data.id + "');\">编辑</a>&nbsp;&nbsp;";
                        html += "<a href=\"javascript:void(0);\" onclick=\"place.delete(this, '" + data.id + "');\">删除</a>"
                        html += "</td>";
                        html += "</tr>";


                    }
                    $("#dataTableList > tbody").html(html);
                } else {
                    layer.alert(res.info);
                }
            }
        });
    },
    add: function (pid) {
        layer.open({
            type: 2,
            title: '添加广告位置',
            shadeClose: true,
            shade: 0.8,
            area: ['800px', '600px'],
            maxmin: true,
            content: ctx + '/manage/web/advertisement-place/edit.jhtml?rnd=' + Math.random()
        });
    },
    edit: function (id) {
        layer.open({
            type: 2,
            title: '编辑广告位置',
            shadeClose: true,
            shade: 0.8,
            area: ['800px', '600px'],
            maxmin: true,
            content: ctx + '/manage/web/advertisement-place/edit.jhtml?id=' + id + '&rnd=' + Math.random()
        });
    },
    delete: function (obj, id) {
        layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                type : "post",
                url : ctx + "/manage/web/advertisement-place/delete.jhtml",
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

var place = null;
$(function () {
    place = new AdvertisementPlace();
    place.list(1);

    $("#searchBotton").bind("click", function(){
        place.list(1);
    });
});