function goPage(curr) {
    $.ajax({
        type: "post",
        url: ctx + "/manage/study/course/list.jhtml",
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

                    var testType = "";
                    var questionType = "";
                    var testState = "";


                    if (data.testType == 1) {
                        testType = "课程学习完成后自动考试";
                    } else if (data.testType == 2) {
                        testType = "由教师统计安排统计";
                    }

                    if (data.questionType == 1) {
                        questionType = "随机数量";
                    } else if (data.questionType == 2) {
                        questionType = "固定数量";
                    }

                    if (data.testState == 1) {
                        testState = "等待考试";
                    } else if (data.testState == 2) {
                        testState = "开始考试";
                    } else if (data.testState == 3) {
                        testState = "结束考试";
                    }

                    html += "<tr>";
                    html += "<td>" + data.name + "</td>";
                    html += "<td>" + testType + "</td>";
                    html += "<td>" + data.totalScore + "</td>";
                    html += "<td>" + data.passScore + "</td>";
                    html += "<td>" + data.duration + "</td>";
                    html += "<td>" + data.testAmount + "</td>";
                    html += "<td>" + data.questionAmount + "</td>";
                    html += "<td>" + questionType + "</td>";
                    if (data.questionType == 1) {
                        html += "<td>" + data.singleAmount + "</td>";
                        html += "<td>" + data.multiAmount + "</td>";
                        html += "<td>" + data.judgeAmount + "</td>";
                    } else if (data.questionType == 2) {
                        html += "<td>0</td>";
                        html += "<td>0</td>";
                        html += "<td>0</td>";
                    }
                    html += "<td>" + testState + "</td>";
                    html += "<td class=\"td-manage\">";
                    html += "<a href=\"javascript:void(0);\" onclick=\"course.edit('" + data.id + "');\" style=\"text-decoration:none\" class=\"ml-5\" title=\"编辑\"><i class=\"fa fa-edit fa-lg\"></i></a>&nbsp;";
                    html += "<a href=\"javascript:void(0);\" onclick=\"course.start('" + data.id + "');\" style=\"text-decoration:none\" class=\"ml-5\" title=\"开始考试\"><i class=\"fa fa-play fa-lg\"></i></a>&nbsp;";
                    html += "<a href=\"javascript:void(0);\" onclick=\"course.stop('" + data.id + "');\" style=\"text-decoration:none\" class=\"ml-5\" title=\"结束考试\"><i class=\"fa fa-stop fa-lg\"></i></a>&nbsp;";
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

function Course() {};

Course.prototype = {
    list: goPage,
    edit: function (id) {
        var index = layer.open({
            type: 2,
            title: '修改课程考试',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: ctx + '/manage/study/course/examination-edit.jhtml?id=' + id + '&rnd=' + Math.random()
        });
        layer.full(index);
    },
    start: function (id) {
        top.layer.confirm('确认要开始考试吗？',function(index){
            $.ajax({
                type : "post",
                url : ctx + "/manage/study/course/test-state.jhtml",
                cache : false,
                data : {"id" : id, "testState": 2, "rnd" : Math.random()},
                dataType : "json",
                success : function(res){
                    top.layer.msg(res.info,{icon:1,time:3000});
                }
            });
            $(obj).parents("tr").remove();
            layer.close(index);
        });
    },
    stop: function (id) {
        top.layer.confirm('确认要结束考试吗？',function(index){
            $.ajax({
                type : "post",
                url : ctx + "/manage/study/course/test-state.jhtml",
                cache : false,
                data : {"id" : id, "testState": 3, "rnd" : Math.random()},
                dataType : "json",
                success : function(res){
                    top.layer.msg(res.info,{icon:1,time:3000});
                }
            });
            $(obj).parents("tr").remove();
            top.layer.close(index);
        });
    },
};

var course = null;
$(function () {
    course = new Course();
    course.list(1);

    $("#searchBotton").bind("click", function(){
        course.list(1);
    });
});