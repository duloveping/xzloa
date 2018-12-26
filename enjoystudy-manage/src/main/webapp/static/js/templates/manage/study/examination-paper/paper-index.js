function goPage(curr) {
    $.ajax({
        type: "post",
        url: ctx + "/manage/study/examination-paper/list.jhtml",
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
                    html += "<td class=\"td-manage\">";
                    html += "<a href=\"javascript:void(0);\" onclick=\"paper.edit('" + data.id + "');\" style=\"text-decoration:none\" class=\"ml-5\" title=\"编辑\"><i class=\"Hui-iconfont\">&#xe6df;</i></a>&nbsp;&nbsp;";
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

function ExaminationPaper() {};

ExaminationPaper.prototype = {
    list: goPage,
    edit: function (id) {
        var index = top.layer.open({
            type: 2,
            title: '修改考卷',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: ctx + '/manage/study/examination-paper/edit.jhtml?id=' + id + '&rnd=' + Math.random()
        });
        top.layer.full(index);
    }
};

var paper = null;
$(function () {
    paper = new ExaminationPaper();
    paper.list(1);

    $("#searchBotton").bind("click", function(){
        paper.list(1);
    });
});