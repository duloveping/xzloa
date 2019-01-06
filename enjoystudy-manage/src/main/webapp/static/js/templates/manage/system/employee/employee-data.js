$("#inputForm").validate({
    rules : {
        education : {
            required : true
        },
        school : {
            required : true
        },
        provinceName : {
            required : true
        },
        cityName : {
            required : true
        },
        townName : {
            required : true
        },
        address : {
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
        school : {
            required : "毕业院校不能为空"
        },
        provinceName : {
            required : "现居地址所属省不能为空"
        },
        cityName : {
            required : "现居地址所属市不能为空"
        },
        townName : {
            required : "现居地址所属镇不能为空"
        },
        address : {
            required : "现居地址详情地址不能为空"
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
                console.log(res);
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