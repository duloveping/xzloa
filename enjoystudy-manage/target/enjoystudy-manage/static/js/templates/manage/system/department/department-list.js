function goPage(curr) {
    var departmentId = $("#departmentId").val();
    $.ajax({
        type: "post",
        url: "select.jhtml?department.id=" + departmentId,
        cache: false,
        data: {
            "pageNumber": curr,
            "code": $.trim($("#code").val()),
            "name": $.trim($("#name").val()),
            "rnd": Math.random()
        },
        dataType: "json",
        success: function (res) {
            if (res.status) {
                var edit = $("#dataTableList > tbody").attr("data-edit");
                var del = $("#dataTableList > tbody").attr("data-delete");

                var html = "";
                var array = res.datas;
                for (var i = 0; i < array.length; i++) {
                    var data = array[i];
                    var caption = "";
                    if (null != data.caption) {
                        caption = data.caption;
                    }
                    html += "<tr>";
                    html += "<td>" + data.code + "</td>";
                    html += "<td>" + data.name + "</td>";
                    html += "<td>" + caption + "</td>";
                    html += "<td>";
                    if (edit == 1) {
                        html += "<a href=\"javascript:void(0);\" onclick=\"department.edit(" + data.id + ");\">编辑</a>&nbsp;&nbsp;";
                    }
                    if (del == 1) {
                        html += "<a href=\"javascript:void(0);\" onclick=\"department.delete(this, " + data.id + ");\">删除</a>"
                    }
                    html += "</td></tr>";
                }

                $("#dataTableList > tbody").html(html);

                laypage({
                    cont: 'pageNav',
                    pages: res.pages,
                    groups: 10,
                    curr: curr || 1,
                    jump: function (obj, first) {
                        if (!first) {
                            goPage(obj.curr);
                        }
                    }
                });
            } else {
                layer.alert(res.info);
            }
        },
        error : function(XmlHttpRequest, textStatus, errorThrown) {
            layer.alert('无权限操作');
        }
    });
}

function Department() {};

Department.prototype = {
    list: goPage,
    add: function () {
        var index = top.layer.open({
            type: 2,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            title: '添加部门',
            content: '../../manage/system/department/edit.jhtml?department.id=' + $("#departmentId").val() + '&rnd=' + Math.random()
        });
        top.layer.full(index);
    },
    edit: function (id) {
        var index = top.layer.open({
            type: 2,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            title: '添加部门',
            content: '../../manage/system/department/edit.jhtml?id=' + id + '&rnd=' + Math.random()
        });
        top.layer.full(index);
    },
    delete: function (obj, id) {
        top.layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                type : "post",
                url : "delete.jhtml",
                cache : false,
                data : {"id" : id, "rnd" : Math.random()},
                dataType : "json",
                success : function(res){
                    if (res.status) {
                        layer.msg('删除成功',{icon:1,time:3000});
                    } else {
                        layer.alert(res.info);
                    }

                }
            });
            $(obj).parents("tr").remove();
            layer.close(index);
        });
    }
};

var department = null;
$(function () {
    department = new Department();
    department.list(1);

    $("#searchBotton").bind("click", function(){
        department.list(1);
    });
});