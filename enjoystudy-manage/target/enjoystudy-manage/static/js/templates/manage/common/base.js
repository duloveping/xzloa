var EMPLOYEE_MENU_PERMISSION_LIST = "employee_menu_permission_list";

function hasPermission(val) {
    var flag = false;
    var menus = localStorage.getItem(EMPLOYEE_MENU_PERMISSION_LIST);
    if (null != menus && menus.length > 0) {
        for (var i = 0; i < menus.length; i++) {
            var menu = menus[i];
            if (menu.code == val) {
                flag = true;
                continue;
            }
        }
    }
    return flag;
}

function showCourseTypeSingleDialog(typeId) {
    top.layer.open({
        type: 2,
        title: '课程分类选择',
        shadeClose: true,
        shade: 0.8,
        area: ['480px', '600px'],
        maxmin: true,
        content: ctx + '/manage/study/course-type/single-select.jhtml?ids=' + typeId + '&rnd=' + Math.random(),
        btn: ['确定','关闭'],
        yes: function(index, layero){
            var data = $(layero).find("iframe")[0].contentWindow.getCheckValue();
            $("#typeId").val(data.id)
            $("#typeName").val(data.name)
            top.layer.close(index);
        }
    });
}