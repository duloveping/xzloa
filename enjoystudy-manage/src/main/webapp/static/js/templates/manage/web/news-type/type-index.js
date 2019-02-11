function NewsType() {};

NewsType.prototype = {
    list: function (curr){
        $.ajax({
            type: "post",
            url: ctx + "/manage/web/news-type/list.jhtml",
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
                        html += "<td class=\"text-l\">" + data.name + "</td>";
                        html += "<td>";
                        if (data.showState ) {
                            html += "显示";
                        } else {
                            html += "隐藏";
                        }
                        html += "</td>";
                        html += "<td>";
                        html += "<a href=\"javascript:void(0);\" onclick=\"newsType.edit('" + data.id + "');\">编辑</a>&nbsp;&nbsp;";
                        html += "<a href=\"javascript:void(0);\" onclick=\"newsType.delete(this, '" + data.id + "');\">删除</a>"
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
            title: '添加新闻类别',
            shadeClose: true,
            shade: 0.8,
            area: ['800px', '600px'],
            maxmin: true,
            content: ctx + '/manage/web/news-type/edit.jhtml?rnd=' + Math.random()
        });
    },
    edit: function (id) {
        layer.open({
            type: 2,
            title: '编辑新闻类别',
            shadeClose: true,
            shade: 0.8,
            area: ['800px', '600px'],
            maxmin: true,
            content: ctx + '/manage/web/news-type/edit.jhtml?id=' + id + '&rnd=' + Math.random()
        });
    },
    delete: function (obj, id) {
        layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                type : "post",
                url : ctx + "/manage/web/news-type/delete.jhtml",
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

var newsType = null;
$(function () {
    newsType = new NewsType();
    newsType.list(1);

    $("#searchBotton").bind("click", function(){
        newsType.list(1);
    });

    $("#btnAdd").click(function(){
        newsType.add("0")
    })
});