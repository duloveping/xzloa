var setting = {
    view: {
        dblClickExpand: false,
        showLine: false,
        selectedMulti: false
    },
    data: {
        simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "pId",
            rootPId: ""
        }
    }
};

$(function () {
    $.fn.zTree.init($("#infoTypeTree"), setting, zNodes);
});
