function goPage(curr) {
    $.ajax({
        type: "post",
        url: ctx + "/manage/study/employee-examination/paper-list.jhtml",
        cache: false,
        data: {
            "pageNum": curr,
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
                    html += "<td>" + data.totalScore + "</td>";
                    html += "<td>" + data.passScore + "</td>";
                    html += "<td>" + data.duration + "</td>";
                    html += "<td>" + data.questionAmount + "</td>";
                    html += "<td>" + data.testAmount + "</td>";
                    html += "<td>" + testState(data.testState) + "</td>";
                    html += "<td class=\"td-manage\">";
                    html += "<a href=\"javascript:void(0);\" onclick=\"paper.edit('" + data.id + "');\" style=\"text-decoration:none\" class=\"ml-5\" title=\"编辑\">进入考试</a>&nbsp;&nbsp;";
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

function testState(state) {
    var val = "";
    switch (state) {
        case 1:
            val = "等待考试";
            break;
        case 2:
            val = "开始考试";
            break;
        case 3:
            val = "结束考试";
            break;
        default:
            val = "";
    }
    return val;
}

function ExaminationPaper() {};

ExaminationPaper.prototype = {
    list: goPage,
    check: function (id) {
        $.ajax({
            type: "post",
            url: ctx + "/manage/study/employee-examination/check-test.jhtml",
            cache: false,
            data: {paperId: id, rnd: Math.random()},
            dataType: "json",
            success: function (res) {
                if (res.status == true) {
                    paper.test(id);
                } else {
                    top.layer.alert(res.info);
                }
            },
            error : function(XmlHttpRequest, textStatus, errorThrown) {
                top.layer.alert('系统出错了');
            }
        });
    },
    test: function (id) {
        var index = top.layer.open({
            type: 2,
            title: '考试',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: ctx + '/manage/study/employee-examination/edit.jhtml?id=' + id + '&rnd=' + Math.random()
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