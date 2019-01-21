function Advertisement() {};

Advertisement.prototype = {
    list: function (curr){
        $.ajax({
            type: "post",
            url: ctx + "/manage/web/advertisement/list.jhtml",
            cache: false,
            data: {
                "pageNum": curr,
                "placeId": $("#placeId").val(),
                "rnd": Math.random()
            },
            dataType: "json",
            success: function (res) {
                if (res.status) {
                    var html = "";
                    var array = res.datas;
                    var fmt = "YYYY-MM-DD HH:mm:ss";

                    for (var i = 0; i < array.length; i++) {
                        var data = array[i];
                        var uploadTime = moment(data.uploadTime).format(fmt);

                        html += "<tr>";
                        html += "<td>" + data.placeCode + "</td>";
                        html += "<td>" + data.placeName + "</td>";
                        html += "<td><img src=\"" + ctx + data.large + "\" width=\"120\" height=\"80\"></td>";
                        html += "<td>" + (data.showState ? "显示" : "隐藏") + "</td>";
                        html += "<td>" + uploadTime + "</td>";
                        html += "<td>";
                        html += "<a href=\"javascript:void(0);\" onclick=\"advertisement.edit('" + data.id + "');\">编辑</a>&nbsp;&nbsp;";
                        html += "<a href=\"javascript:void(0);\" onclick=\"advertisement.delete(this, '" + data.id + "');\">删除</a>"
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
            content: ctx + '/manage/web/advertisement/edit.jhtml?rnd=' + Math.random()
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
            content: ctx + '/manage/web/advertisement/edit.jhtml?id=' + id + '&rnd=' + Math.random()
        });
    },
    delete: function (obj, id) {
        layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                type : "post",
                url : ctx + "/manage/web/advertisement/delete.jhtml",
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

var advertisement = null;
$(function () {
    advertisement = new Advertisement();
    advertisement.list(1);

    $("#searchBotton").bind("click", function(){
        advertisement.list(1);
    });
});