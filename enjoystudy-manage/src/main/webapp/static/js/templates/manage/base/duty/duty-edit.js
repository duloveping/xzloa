function addDictionaryItem() {
    var html = "";
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
                        parent.dut.list(1);
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
