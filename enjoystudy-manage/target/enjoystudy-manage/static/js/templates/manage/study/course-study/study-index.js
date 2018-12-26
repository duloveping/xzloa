function goPage(curr) {
    $.ajax({
        type: "post",
        url: ctx + "/manage/study/course-study/list.jhtml",
        cache: false,
        data: {
            "pageNum": curr,
            "videoName": $.trim($("#videoName").val()),
            "courseId": $("#courseId").val(),
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
                    html += "<td>" + data.courseName + "</td>";
                    html += "<td><a onclick=\"study.study('" + data.videoId + "')\" href=\"javascript:void(0);\">" + data.videoName + "</a></td>";
                    html += "<td>" + data.studyAmount + "</td>";
                    html += "<td>" + (null == data.studyTime ? "" : moment(data.studyTime).format("YYYY-MM-DD HH:mm:ss")) + "</td>";
                    html += "</tr>";
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

function CourseStudy() {};

CourseStudy.prototype = {
    list: goPage,
    study: function (id) {
        var index = top.layer.open({
            type: 2,
            title: '课程视频学习',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: ctx + '/manage/study/course-study/study.jhtml?videoId=' + id + '&rnd=' + Math.random()
        });
    }
};

var study = null;
$(function () {
    study = new CourseStudy();
    study.list(1);

    $("#searchBotton").bind("click", function(){
        study.list(1);
    });
});