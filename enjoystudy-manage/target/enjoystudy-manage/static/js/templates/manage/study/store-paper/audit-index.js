function goPage(curr) {
    $.ajax({
        type: "post",
        url: ctx + "/manage/study/store-paper/audit-list.jhtml",
        cache: false,
        data: {
            "pageNum": curr,
            "courseId": $.trim($("#courseId").val()),
            "title": $.trim($("#title").val()),
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
                    html += "<td>" + data.title + "</td>";
                    html += "<td>" + data.duration + "</td>";
                    html += "<td>" + data.questionAmount + "</td>";
                    html += "<td>" + data.totalScore + "</td>";
                    html += "<td>" + data.passScore + "</td>";
                    html += "<td>" + data.testAmount + "</td>";
                    html += "<td class=\"td-manage\">";
                    html += "<a href=\"javascript:void(0);\" onclick=\"paper.edit('" + data.id + "');\" style=\"text-decoration:none\" class=\"ml-5\" title=\"审核\"><i class=\"fa fa-edit fa-lg\"></i></a>&nbsp;";
                    html += "<a href=\"javascript:void(0);\" onclick=\"paper.view('" + data.id + "');\"style=\"text-decoration:none\" class=\"ml-5\" title=\"预览\"><i class=\"fa fa-newspaper-o fa-lg\"></i></a>"
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
                top.layer.alert(res.info);
            }
        },
        error : function(XmlHttpRequest, textStatus, errorThrown) {
            top.layer.alert('无权限操作');
        }
    });
}

function StorePaper() {};

StorePaper.prototype = {
    list: goPage,
    edit: function (id) {
        var index = layer.open({
            type: 2,
            title: '考卷审核',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: ctx + '/manage/study/store-paper/paper-audit.jhtml?id=' + id + '&rnd=' + Math.random()
        });
        layer.full(index);
    },
    view: function (id) {
        var index = top.layer.open({
            type: 2,
            title: '考卷预览',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: ctx + '/manage/study/store-paper/paper-view.jhtml?id=' + id + '&rnd=' + Math.random()
        });
        top.layer.full(index);
    }
};

var paper = null;
$(function () {
    paper = new StorePaper();
    paper.list(1);

    $("#searchBotton").bind("click", function(){
        paper.list(1);
    });
});