function goPage(curr) {
    $.ajax({
        type: "post",
        url: ctx + "/manage/study/certificate/list.jhtml",
        cache: false,
        data: {
            "pageNum": curr,
            "fullName": $.trim($("#fullName").val()),
            "rnd": Math.random()
        },
        dataType: "json",
        success: function (res) {
            if (res.status) {
                var html = "";
                var array = res.datas;
                for (var i = 0; i < array.length; i++) {
                    var data = array[i];
                    html += "<tr>";
                    html += "<td>" + data.name + "</td>";
                    html += "<td class=\"td-manage\">";
                    html += "<a href=\"javascript:void(0);\" onclick=\"certificate.edit('" + data.id + "');\" style=\"text-decoration:none\" class=\"ml-5\" title=\"编辑\"><i class=\"fa fa-edit fa-lg\"></i></a>&nbsp;";
                    html += "<a href=\"javascript:void(0);\" onclick=\"certificate.delete(this, '" + data.id + "');\"style=\"text-decoration:none\" class=\"ml-5\" title=\"删除\"><i class=\"fa fa-remove fa-lg\"></i></a>&nbsp;"
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

function Certificate() {};

Certificate.prototype = {
    list: goPage,
    add: function () {
        var index = top.layer.open({
            type: 2,
            title: '添加课程',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: ctx + '/manage/study/certificate/edit.jhtml?rnd=' + Math.random()
        });
        top.layer.full(index);
    },
    edit: function (id) {
        var index = top.layer.open({
            type: 2,
            title: '修改课程',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: ctx + '/manage/study/certificate/edit.jhtml?id=' + id + '&rnd=' + Math.random()
        });
        top.layer.full(index);
    },
    delete: function (obj, id) {
        top.layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                type : "post",
                url : ctx + "/manage/study/certificate/delete.jhtml",
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
            top.layer.close(index);
        });
    },
    videoList: function (id) {
        document.location.href = ctx  + '/manage/study/certificate-video/index.jhtml?courseId=' + id + '&rnd=' + Math.random();
    }
};

var certificate = null;
$(function () {
    certificate = new Certificate();
    certificate.list(1);

    $("#searchBotton").bind("click", function(){
        certificate.list(1);
    });
});