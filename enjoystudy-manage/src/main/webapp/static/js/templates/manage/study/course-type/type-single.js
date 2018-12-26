var setting = {
    check: {
        enable: true,
        chkStyle: "radio"
    },
    data: {
        simpleData: {
            enable: true
        }
    },
    callback: {
        onCheck: zTreeOnCheck
    }
};

function zTreeOnCheck(event, treeId, treeNode) {
    if (treeNode.checked) {
        $("#typeId").val(treeNode.id);
        $("#typeName").val(treeNode.name);
    }
};

function setCheck() {
    setting.check.radioType = 'all';
    $.fn.zTree.init($("#typeTree"), setting, zNodes);
}

function getCheckValue () {
    return {"id":$("#typeId").val(), "name":$("#typeName").val()};
}

$(function () {
    setCheck();
});
