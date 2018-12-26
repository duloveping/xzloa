$("#inputForm").validate({
    rules : {
        code : {
            required : true,
            remote : {
                type : "POST",
                url : ctx + "/manage/employee/account/check.jhtml",
                data : {
                    code : function() { return $("#code").val();},
                    id : function() { return $("#id").val();},
                }
            }
        },
        name : {
            required : true
        }
    },
    messages: {
        code: {
            required: "员工编号不能为空！",
            remote: jQuery.format("员工编号已经被使用")
        },
        name: {
            required: "员工名称不能为空！"
        }
    },
    onkeyup : false,
    focusCleanup : true,
    success : "valid",
    submitHandler : function(form) {
        $.ajax({
            type: "post",
            url: ctx + "/manage/employee/account/save.jhtml",
            cache: false,
            data: $(form).serialize(),
            dataType: "json",
            success: function (res) {
                layer.msg(res.info,{icon:1,time:3000});
                if (res.status) {
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.employee.list();
                    parent.layer.close(index);
                }
            },
            error : function(XmlHttpRequest, textStatus, errorThrown) {
                layer.alert('数据保存失败');
            }
        });
    }
});

function showDepartmentSingleDialog(departmentId) {
    layer.open({
        type: 2,
        title: '部门选择',
        shadeClose: true,
        shade: 0.8,
        area: ['480px', '600px'],
        maxmin: true,
        content: ctx + '/manage/employee/department/single-select.jhtml?ids=' + departmentId + '&rnd=' + Math.random(),
        btn: ['确定','关闭'],
        yes: function(index, layero){
            var data = $(layero).find("iframe")[0].contentWindow.getCheckValue();
            $("#departmentId").val(data.id);
            $("#departmentName").val(data.name);
            layer.close(index);
        },
        cancel: function(){
        }
    });
}