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

var code;

function showCode(str) {
    if (!code)
        code = $("#code");
    code.empty();
    code.append("<li>" + str + "</li>");
}


$(function () {
    $.fn.zTree.init($("#departmentTree"), setting, zNodes);

    $("#departmentIframe").iframeAutoHeight({
        callback: function(callbackObject){
            $(parent.document).find('#mainFrame').height(callbackObject.newFrameHeight);
            $("#departmentTree").height(callbackObject.newFrameHeight);
        }
    });
});
