$(function () {
    $("#inputForm").validate({
        rules: {
            name: {
                required: true,
                remote: {
                    type: "post",
                    url: "check-name.jhtml",
                    data: {
                        name: function () {
                            return $("#name").val();
                        },
                        officeId: function () {
                            return $("#officeId").val();
                        },
                        id: function () {
                            return $("#id").val();
                        }
                    }
                }
            },
            code: {
                required: true,
                remote: {
                    type: "post",
                    url: "check-code.jhtml",
                    data: {
                        code: function () {
                            return $("#code").val();
                        },
                        id: function () {
                            return $("#id").val();
                        }
                    }
                }
            },
            showState: {
                required: true
            }
        },
        messages: {
            code: {
                required: "公司编号不能为空！",
                remote: jQuery.format("公司编号已被使用！")
            },
            name: {
                required: "公司名称不能为空！",
                remote: jQuery.format("公司名称已被使用！")
            },
            showState: {
                required: "显示状态不能为空！"
            },
        },
        submitHandler: function (form) {
            var category = 1;
            var code = $.trim($("#code").val());
            var name = $.trim($("#name").val());
            var showState = $("input[name='showState'][type='radio']:checked").val();
            var serialNumber = $.trim($("#serialNumber").val());
            var officeId = $.trim($("#officeId").val());
            var id = $.trim($("#id").val());

            var data = {
                "id": id,
                "category": category,
                "code": code,
                "name": name,
                "showState": showState,
                "serialNumber": serialNumber,
                "office.id": officeId
            };
            $.ajax({
                type: "post",
                url: "save.jhtml",
                cache: false,
                data: data,
                dataType: "json",
                success: function (res) {
                    if (res.status) {
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.company.list();
                        parent.layer.close(index);
                    } else {
                        layer.alert(res.info);
                    }
                },
                error: function (XmlHttpRequest, textStatus, errorThrown) {
                    layer.alert('数据保存失败');
                }
            });
        }
    });
});