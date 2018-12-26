function selectDialog(param, data, callback) {
    if ($.type(param) != "object") {
        param = {
            target: arguments[0],
            rootId: arguments[1],
            multiple: arguments[2],
            url: arguments[3],
            includeSelf: arguments[4]
        };
        var i;
        if ($.type(param.includeSelf) == "boolean") {
            i = 5;
        } else {
            i = 4;
            param.includeSelf = false;
        }
        data = arguments[i];
        callback = arguments[i + 1];
    }

    param = $.extend({
        target: 0,
        rootId: "-1",
        multiple: false,
        url: "/path/to/select/url",
        includeSelf: false,
        outData: undefined
    }, param);

    try {
        param.target = eval(param.target);
    } catch (err) {
        param.target = 0;
    }

    param.rootId = "" + param.rootId;

    try {
        param.multiple = (eval(param.multiple)) ? true : false;
    } catch (err) {
        param.multiple = false;
    }

    window.__selectDialog__ = {};
    window.__selectDialog__.param = param;
    window.__selectDialog__.data = data;
    window.__selectDialog__.callback = callback;

    var url;
    if ($.type(data) == "string" && $.trim(data) != "") {
        var getDataUrl = param.url.substring(0, param.url.lastIndexOf("/")) + "/getData";

        $.post(getDataUrl, {target: param.target, id: data}, function (result) {
            $.fn.selectDialog(window.__selectDialog__.param, result, window.__selectDialog__.callback);
        }, "json");
        return;
    }

    url = param.url + "?" + $.param({target: param.target, rootId: param.rootId, multiple: param.multiple});

    // dialog title
    var dialogTitle = ["选择用户", "选择部门", "选择单位", "选择单位或部门", "选择单位、部门或用户"][param.target];
    dialogTitle += (!param.multiple) ? "(单选)" : "(多选)";

    // dialog height
    var dialogHeight = ['460px', '405px', '460px', '460px', '460px'][param.target];

    layer.open({
        type: 2,
        content: [url, 'no'],
        btn: ['确定', '取消'/*, '清除'*/],
        yes: function (index, layero) { //或者使用btn1
            var dialog = layero.find("iframe")[0].contentWindow.__selectDialog__;
            var result = cloneData(dialog.value(dialog.OK));
            layer.close(index);
            window.__selectDialog__.callback(result, window.__selectDialog__.param.outData);
        },
        /*btn3: function (index, layero) {
             var dialog = layero.find("iframe")[0].contentWindow.__selectDialog__;
             var result = cloneData(dialog.value(dialog.CLEAR));
             layer.close(index);
             window.__selectDialog__.callback(result, window.__selectDialog__.param.outData);
         },*/
        offset: '80px',
        title: dialogTitle,
        shadeClose: true, //点击shade时，关闭层
        area: ['700px', dialogHeight]
    });
}

$.fn.selectDialog = selectDialog;

function cloneData(data) {
    var result = {flag: data.flag, id: [], name: []};

    for (var i = 0; i < data.id.length; i++) {
        result.id[i] = data.id[i];
        result.name[i] = data.name[i];
    }
    result.idResult = result.id.join(",");
    result.nameResult = result.name.join(",");

    return result;
}
