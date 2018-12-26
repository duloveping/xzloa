function addDictionaryItem() {
    var html = "";
    html += "<tr>";
    html += "<td>";
    html += "<input name=\"itemCodes\" type=\"text\" value=\"\" maxlength=\"10\" placeholder=\"项目编号\" class=\"required input-text\">";
    html += "</td>";
    html += "<td>";
    html += "<input name=\"itemNames\" type=\"text\" value=\"\" maxlength=\"100\" placeholder=\"项目名称\" class=\"required input-text\">";
    html += "</td>";
    html += "<td width=\"80\">";
    html += "<span class=\"select-box\">";
    html += "<select name=\"itemStates\" class=\"required select\">";
    html += "<option value=\"true\">显示</option>";
    html += "<option value=\"false\" selected=\"selected\">隐藏</option>";
    html += "</select>";
    html += "</span>";
    html += "</td>";
    html += "<td width=\"80\">";
    html += "<input name=\"itemSorts\" type=\"number\" value=\"1\" maxlength=\"4\" placeholder=\"项目排序\" max=\"9999\" min=\"0\" class=\"required input-text\">";
    html += "</td>";
    html += "<td width=\"50\">";
    html += "<a class=\"btn btn-primary radius\" onclick=\"$(this).parent().parent().remove();\" href=\"javascript:void(0);\" title=\"删除项目\">";
    html += "<i class=\"Hui-iconfont\">&#xe6a1;</i>";
    html += "</a>";
    html += "</td>";
    html += "</tr>";
    $("#dictionaryItemList").append(html);
}

$(function () {
    $("#inputForm").validate({
        submitHandler:function(form){
            $.ajax({
                type: "post",
                url: "save.jhtml",
                cache: false,
                data: $(form).serialize(),
                dataType: "json",
                success: function (res) {
                    if (res.status) {
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.dict.list(1);
                        parent.layer.close(index);
                    } else {
                        layer.alert(res.info);
                    }
                },
                error : function(XmlHttpRequest, textStatus, errorThrown) {
                    layer.alert('数据保存失败');
                }
            });
        }
    });
});
