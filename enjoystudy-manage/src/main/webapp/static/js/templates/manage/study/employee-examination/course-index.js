function goPage(curr) {
    $.ajax({
        type: "post",
        url: ctx + "/manage/study/employee-examination/course-list.jhtml",
        cache: false,
        data: {
            "pageNum": curr,
            "code": $.trim($("#code").val()),
            "name": $.trim($("#name").val()),
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
                    html += "<td>" + data.totalScore + "</td>";
                    html += "<td>" + data.passScore + "</td>";
                    html += "<td>" + data.duration + "</td>";
                    html += "<td>" + data.testAmount + "</td>";
                    html += "<td>" + data.questionAmount + "</td>";
                    html += "<td class=\"td-manage\">";
                    html += "<a href=\"javascript:void(0);\" onclick=\"course.check('" + data.id + "');\" style=\"text-decoration:none\" class=\"ml-5\" title=\"进入考试\">进入考试</a>&nbsp;&nbsp;";
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
            top.layer.alert('系统出错了');
        }
    });
}

function Course() {};

Course.prototype = {
    list: goPage,
    check: function (courseId) {
        $.ajax({
            type: "post",
            url: ctx + "/manage/study/employee-examination/check-test.jhtml",
            cache: false,
            data: {courseId: courseId, rnd: Math.random()},
            dataType: "json",
            success: function (res) {
                if (res.status == true) {
                    if (res.paperId) {
                        course.test(res.paperId);
                    } else {
                        top.layer.alert('系统出错了，请联系系统管理员！');
                    }
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
            content: ctx + '/manage/study/employee-examination/paper-test.jhtml?paperId=' + id + '&rnd=' + Math.random()
        });
        top.layer.full(index);
    }
};

var course = null;
$(function () {
    course = new Course();
    course.list(1);

    $("#searchBotton").bind("click", function(){
        course.list(1);
    });
});