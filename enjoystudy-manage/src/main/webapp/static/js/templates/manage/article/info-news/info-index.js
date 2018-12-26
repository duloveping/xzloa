function addHoverDom(treeId, treeNode) {
    var sObj = $("#" + treeNode.tId + "_span");
    if (treeNode.editNameFlag || $("#addBtn_" + treeNode.tId).length > 0)
        return;
    var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
        + "' title='add node' onfocus='this.blur();'></span>";
    sObj.after(addStr);
    var btn = $("#addBtn_" + treeNode.tId);
    if (btn) {
        btn.bind("click", function () {
            layer.prompt({
                formType: 0,
                title: '添加分类'
            }, function (value, index, elem) {
                layer.load();
                $.ajax({
                    type: "post",
                    url: "../../../manage/article/info-type/save.jhtml?type.id=" + treeNode.id,
                    cache: false,
                    data: {
                        "showState": true,
                        "name": $.trim(value)
                    },
                    dataType: "json",
                    success: function (res) {
                        var zTree = $.fn.zTree.getZTreeObj("infoTypeTree");
                        zTree.addNodes(treeNode, {
                            id: res.id,
                            pId: treeNode.id,
                            name: res.name
                        });
                        layer.closeAll('loading');
                    },
                    error: function (XmlHttpRequest, textStatus, errorThrown) {
                        layer.alert('数据保存失败');
                    }
                });
                layer.close(index);
            });
            return false;
        });
    }
}

function removeHoverDom(treeId, treeNode) {
    $("#addBtn_" + treeNode.tId).unbind().remove();
}

function beforeRemove(treeId, treeNode) {
    var zTree = $.fn.zTree.getZTreeObj("infoTypeTree");
    zTree.selectNode(treeNode);
    layer.confirm('确认要删除吗？',function(index){
        layer.load();
        $.ajax({
            type: "post",
            url: "../../../manage/article/info-type/delete.jhtml?id=" + treeNode.id,
            cache: false,
            dataType: "json",
            success: function (res) {
                zTree.removeNode(treeNode);
                layer.closeAll('loading');
                layer.close(index);
            },
            error: function (XmlHttpRequest, textStatus, errorThrown) {
                layer.alert('数据保存失败');
            }
        });
    });
    return false;
}

function beforeEditName(treeId, treeNode) {

}

function beforeRename(treeId, treeNode, newName, isCancel) {
    if (newName.length == 0) {
        layer.alert("分类名称不能为空");
        return false;
    }
    return true;
}

function onRemove(e, treeId, treeNode) {
}

function onRename(e, treeId, treeNode, isCancel) {
    $.ajax({
        type: "post",
        url: "../../../manage/article/info-type/save.jhtml?type.id=" + treeNode.pId,
        cache: false,
        data: {
            "id": treeNode.id,
            "showState": true,
            "name": $.trim(treeNode.name)
        },
        dataType: "json",
        success: function (res) {
        },
        error: function (XmlHttpRequest, textStatus, errorThrown) {
            layer.alert('数据保存失败');
        }
    });
}

function onClick(event, treeId, treeNode) {
    $("#infoTypeIframe").attr("src", treeNode.url)
};

$(function () {
    $.fn.zTree.init($("#infoTypeTree"), setting, zNodes);
});
