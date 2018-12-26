function goPage(curr) {
    var typeId = $("#typeId").val();
    $.ajax({
        type: "post",
        url: "select.jhtml?type.id=" + typeId,
        cache: false,
        data: {
            "pageNumber": curr,
            "fileName": $.trim($("#fileName").val()),
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
                    html += "<tr>";
                    if (view == "1") {
                        html += "<td><a href=\"javascript:void(0);\" onclick=\"infoAtta.view(" + data.id + ");\">" + data.fileName + "</a></td>";
                    } else {
                        html += "<td>" + data.fileName + "</td>";
                    }

                    html += "<td>" + data.fileSize + "</td>";
                    html += "<td>" + data.updateTime + "</td>";
                    html += "<td>";
                    if (view == "1") {
                        html += "<a href=\"javascript:void(0);\" onclick=\"infoAtta.view(" + data.id + ");\">查看</a>&nbsp;&nbsp;";
                    }
                    if (edit == "1") {
                        html += "<a href=\"javascript:void(0);\" onclick=\"infoAtta.editArticle(" + data.id + ");\">编辑</a>&nbsp;&nbsp;";
                    }
                    if (download == "1") {
                        html += "<a href=\"javascript:void(0);\" onclick=\"infoAtta.download(" + data.id + ");\">下载</a>&nbsp;&nbsp;";
                    }
                    if (del == "1") {
                        html += "<a href=\"javascript:void(0);\" onclick=\"infoAtta.delete(this, " + data.id + ");\">删除</a>"
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

function InfoAttachment() {};

InfoAttachment.prototype = {
    list: goPage,
    addType: function () {
        top.layer.prompt({
            formType: 0,
            title: '添加文档分类'
        }, function (value, index, elem) {
            top.layer.load();
            var typeId = $.trim($("#typeId").val());
            if ("" == typeId) {
                typeId = 0;
            }
            $.ajax({
                type: "post",
                url: "../../../manage/article/attachment-type/save.jhtml?type.id=" + typeId,
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
    add: function () {
        top.layer.open({
            type: 2,
            title: '添加文件',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: '../../manage/article/info-attachment/add.jhtml?type.id=' + $("#typeId").val() + '&rnd=' + Math.random()
        });
    },
    edit: function (id) {
        top.layer.open({
            type: 2,
            title: '修改文件',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: '../../manage/article/info-attachment/edit.jhtml?id=' + id + '&rnd=' + Math.random()
        });
    },
    view: function (id) {
        top.layer.open({
            type: 2,
            title: '文件预览',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: '../../manage/article/info-attachment/view/' + id + '.jhtml'
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
    },
    download: function (id) {
        window.open("download/" + id + ".jhtml", "_blank");
    }
};

var infoAtta = null;
$(function () {
    infoAtta = new InfoAttachment();
    infoAtta.list(1);

    $("#searchBotton").bind("click", function(){
        infoAtta.list(1);
    });
});