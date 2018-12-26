var setting = {
    check: {
        enable: true,
        chkStyle: "checkbox"
    },
    data: {
        simpleData: {
            enable: true
        }
    }
};

function getCheckValue () {
    var treeObj = $.fn.zTree.getZTreeObj("departmentTree");
    var nodes = treeObj.getCheckedNodes(true);
    var array = new Array();
    for(var i = 0; i < nodes.length; i++){
        var n = nodes[i];
        var data = {"id": n.id, "name": n.name};
        array.push(data);
    }
    return array;
}

function setCheck() {
    setting.check.radioType = 'all';
    $.fn.zTree.init($("#departmentTree"), setting, zNodes);
}

$(function () {
    setCheck();
});
