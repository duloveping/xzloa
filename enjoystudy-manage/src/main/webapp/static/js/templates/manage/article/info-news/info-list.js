function goPage(curr) {
    $.ajax({
        type: "post",
        url: "select.jhtml",
        cache: false,
        data: {
            "pageNumber": curr,
            "showState": $("#showState").val(),
            "typeId": $("#typeId").val(),
            "title": $.trim($("#title").val()),
            "author": $.trim($("#author").val()),
            "startDate": $.trim($("#startDate").val()),
            "endDate": $.trim($("#endDate").val()),
            "rnd": Math.random()
        },
        dataType: "json",
        success: function (res) {
            if (res.status) {
                var view = $("#dataTableList > tbody").attr("data-view");
                var edit = $("#dataTableList > tbody").attr("data-edit");
                var del = $("#dataTableList > tbody").attr("data-delete");
                var download = $("#dataTableList > tbody").attr("data-download");

                var html = "";
                var array = res.datas;
                for (var i = 0; i < array.length; i++) {
                    var data = array[i];
                    var caption = "";
                    if (null != data.caption) {
                        caption = data.caption;
                    }
                    html += "<tr>";
                    html += "<td>" + data.typeName + "</td>";
                    if (data.dataType == 'INFO_ARTICLE') {
                        if (view == "1") {
                            html += "<td><a href=\"javascript:void(0);\" onclick=\"info.view(" + data.id + ");\">" + data.title + "</a></td>";
                        } else {
                            html += "<td>" + data.title + "</td>";
                        }

                        html += "<td>" + data.author + "</td>";
                        html += "<td>" + data.publishDate + "</td>";

                    } else {
                        if (view == "1") {
                            html += "<td><a href=\"javascript:void(0);\" onclick=\"info.view(" + data.id + ");\">" + data.fileName + "</a></td>";
                        } else {
                            html += "<td>" + data.fileName + "</td>";
                        }
                        html += "<td>" + data.author + "</td>";
                        html += "<td>" + data.updateTime + "</td>";
                    }
                    html += "<td>";
                    if (view == "1") {
                        html += "<a href=\"javascript:void(0);\" onclick=\"info.view(" + data.id + ");\">查看</a>&nbsp;&nbsp;";
                    }
                    if (edit == "1") {
                        html += "<a href=\"javascript:void(0);\" onclick=\"info.editArticle(" + data.id + ");\">编辑</a>&nbsp;&nbsp;";
                    }
                    if (download == "1") {
                        if (data.dataType == 'INFO_DOCUMENT') {
                            html += "<a href=\"javascript:void(0);\" onclick=\"info.download(" + data.id + ");\">下载</a>&nbsp;&nbsp;";
                        }
                    }
                    if (del == "1") {
                        html += "<a href=\"javascript:void(0);\" onclick=\"info.delete(this, " + data.id + ");\">删除</a>"
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

function InfoNews() {};

InfoNews.prototype = {
    list: goPage,
    addType: function () {
        top.layer.prompt({
            formType: 0,
            title: '添加文章分类'
        }, function (value, index, elem) {
            top.layer.load();
            var typeId = $.trim($("#typeId").val());
            if ("" == typeId) {
                typeId = 0;
            }
            $.ajax({
                type: "post",
                url: "../../../manage/article/info-type/save.jhtml?type.id=" + typeId,
                cache: false,
                data: {"showState": true, "name": $.trim(value)},
                dataType: "json",
                success: function (res) {
                    if (res.status) {
                        var index=parent.layer.getFrameIndex(window.name);//获取当前弹出层的层级
                        window.parent.location.reload();//刷新父页面
                        parent.layer.close(index);//关闭弹出层
                    } else {
                        top.layer.alert(res.info);
                    }
                    top.layer.closeAll('loading');
                },
                error : function(XmlHttpRequest, textStatus, errorThrown) {
                    layer.alert('数据保存失败');
                }
            });

            top.layer.close(index);
        });
    },
    addArticle: function () {
        top.layer.open({
            type: 2,
            title: '添加信息',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: '../../manage/article/info-news/edit-article.jhtml?type.id=' + $("#typeId").val() + '&rnd=' + Math.random()
        });
    },
    editArticle: function (id) {
        top.layer.open({
            type: 2,
            title: '修改信息',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: '../../manage/article/info-news/edit-article.jhtml?id=' + id + '&rnd=' + Math.random()
        });
    },
    addDocument: function () {
        top.layer.open({
            type: 2,
            title: '添加信息',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: '../../manage/article/info-news/edit-document.jhtml?type.id=' + $("#typeId").val() + '&rnd=' + Math.random()
        });
    },
    editDocument: function (id) {
        top.layer.open({
            type: 2,
            title: '修改信息',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: '../../manage/article/info-news/edit-document.jhtml?id=' + id + '&rnd=' + Math.random()
        });
    },
    view: function (id) {
        top.layer.open({
            type: 2,
            title: '查看信息',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: '../../manage/article/info-news/view/' + id + '.jhtml?rnd=' + Math.random()
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
    },
    download: function (id) {
        window.open("download/" + id + ".jhtml", "_blank");
    }
};

var info = null;
$(function () {
    info = new InfoNews();
    info.list(1);

    $("#searchBotton").bind("click", function(){
        info.list(1);
    });
});