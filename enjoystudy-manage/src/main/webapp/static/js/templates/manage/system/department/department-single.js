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
        $("#departmentId").val(treeNode.id);
        $("#departmentName").val(treeNode.name);
    }
};

function setCheck() {
    setting.check.radioType = 'all';
    $.fn.zTree.init($("#departmentTree"), setting, zNodes);
}

function getCheckValue () {
    return {"id":$("#departmentId").val(), "name":$("#departmentName").val()};
}

$(function () {
    setCheck();
});
