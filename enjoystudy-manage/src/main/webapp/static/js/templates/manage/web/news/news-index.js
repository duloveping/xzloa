function goPage(curr) {
    $.ajax({
        type: "post",
        url: ctx + "/manage/web/news/list.jhtml",
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
                    var publishTime = moment(data.publishTime).format("YYYY-MM-DD HH:mm:ss");

                    html += "<tr>";
                    html += "<td>" + data.title + "</td>";
                    html += "<td>" + data.publisherName + "</td>";
                    html += "<td>" + publishTime + "</td>";
                    html += "<td>" + (data.showState ? "显示" : "隐藏" ) + "</td>";
                    html += "<td class=\"td-manage\">";
                    html += "<a href=\"javascript:void(0);\" onclick=\"news.edit('" + data.id + "');\" style=\"text-decoration:none\" class=\"ml-5\" title=\"编辑\"><i class=\"Hui-iconfont\">&#xe6df;</i></a>&nbsp;&nbsp;";
                    html += "<a href=\"javascript:void(0);\" onclick=\"news.delete(this, '" + data.id + "');\"style=\"text-decoration:none\" class=\"ml-5\" title=\"删除\"><i class=\"Hui-iconfont\">&#xe6e2;</i></a>"
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

function News() {};

News.prototype = {
    list: goPage,
    add: function () {
        var index = layer.open({
            type: 2,
            title: '添加新闻',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: 'edit.jhtml?rnd=' + Math.random()
        });
        layer.full(index);
    },
    edit: function (id) {
        var index = layer.open({
            type: 2,
            title: '修改新闻',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: ctx + '/manage/web/news/edit.jhtml?id=' + id + '&rnd=' + Math.random()
        });
        layer.full(index);
    },
    delete: function (obj, id) {
        layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                type : "post",
                url : ctx + "/manage/web/news/delete.jhtml",
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

var news = null;
$(function () {
    news = new News();
    news.list(1);

    $("#searchBotton").bind("click", function(){
        news.list(1);
    });
});