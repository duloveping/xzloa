function goPage(curr) {
    $.ajax({
        type: "post",
        url: "list.jhtml",
        cache: false,
        data: {
            "pageNumber": curr,
            "code": $.trim($("#code").val()),
            "name": $.trim($("#name").val()),
            "showState": $.trim($("#showState").val()),
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
                	html += "<tr>";
                	html += "<td>" + data.code + "</td>";
                	html += "<td>" + data.name + "</td>";
                	html += "<td>" + ( data.showState ? "显示" : "隐藏" ) + "</td>";
                	html += "<td>" + data.sort + "</td>";
                	html += "<td >";
                	if (edit == 1) {
                        html += "<a href=\"javascript:void(0);\" onclick=\"dut.edit(" + data.id + ");\">编辑</a>&nbsp;&nbsp;";
                    }
                    if (del == 1) {
                        html += "<a href=\"javascript:void(0);\" onclick=\"dut.delete(this, " + data.id + ");\">删除</a>"
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

function Duty(){};

Duty.prototype = {
    list: goPage,
    add: function () {
        layer.open({
            type: 2,
            title: '添加职务',
            shadeClose: true,
            shade: 0.8,
            area: ['800px', '600px'],
            maxmin: true,
            content: 'edit.jhtml?rnd=' + Math.random()
        });
    },
    edit: function (id) {
        layer.open({
            type: 2,
            title: '修改职务',
            shadeClose: true,
            shade: 0.8,
            area: ['800px', '600px'],
            maxmin: true,
            content: 'edit.jhtml?id=' + id + '&rnd=' + Math.random()
        });
    },
    delete: function (obj, id) {
        layer.confirm('确认要删除吗？',function(index){
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

var dut = null;
$(function () {
	dut = new Duty();
	dut.list(1);

    $("#searchBotton").bind("click", function(){
    	dut.list(1);
    });
});