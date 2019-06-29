$("#inputForm").validate({
    rules : {
        education : {
            required : true
        },
        fullName : {
            required : true
        },
        sex : {
            required : true
        },
        identityType : {
            required : true
        },
        identityCode : {
            required : true
        },
        mobile : {
            required : true
        }
    },
    messages: {
        education : {
            required : "学历不能为空"
        },
        fullName : {
            required : "姓名不能为空"
        },
        identityType : {
            required : "证件类型不能为空"
        },
        sex : {
            required : "性别不能为空"
        },
        identityCode : {
            required : "证件号码不能为空"
        },
        mobile : {
            required : "手机号码不能为空"
        }
    },
    onkeyup : false,
    focusCleanup : true,
    success : "valid",
    submitHandler : function(form) {
        $("#provinceCode").val($("#provinceName").find("option:selected").attr("data-code"));
        $("#cityCode").val($("#cityName").find("option:selected").attr("data-code"));
        $("#townCode").val($("#townName").find("option:selected").attr("data-code"));

        $.ajax({
            type: "post",
            url: ctx + "/manage/employee/account/save-data.jhtml",
            cache: false,
            data: $(form).serialize(),
            dataType: "json",
            success: function (res) {
                top.layer.msg(res.info,{icon:1,time:3000});
            },
            error : function(XmlHttpRequest, textStatus, errorThrown) {
                top.layer.alert('数据保存失败');
            }
        });
    }
});

$(function () {
    var provinceName = $("#provinceName").attr("data-province");
    var cityName = $("#cityName").attr("data-city");
    var townName = $("#townName").attr("data-district");

    $('#distpicker').distpicker({
        province: provinceName,
        city: cityName,
        district: townName
    });
});