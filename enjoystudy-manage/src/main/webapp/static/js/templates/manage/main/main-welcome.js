function videoList() {
    $.ajax({
        type: "get",
        url: ctx + "/manage/main/course-list.jhtml?rnd=" + Math.random(),
        dataType: "json",
        success: function (res) {
            if (res.status) {
                var html = "";
                var array = res.videoList;
                for (var i = 0; i < array.length; i++) {
                    var data = array[i];
                    html += "<tr class=\"text-c\">";
                    html += "<td class=\"text-l\"><a href=\"javascript:void(0);\" target=\"_blank\" title=\"" + data.name + "\" onclick=\"study('" + data.id + "')\">" + data.name + "</a></td>";
                    html += "<td>" + data.courseName + "</td>";
                    html += "<td>" + data.teacherName + "</td>";
                    html += "</tr>";
                }
                $("#course-list > tbody").html(html);
            } else {
                layer.alert(res.info);
            }
        }
    });
}

function study(id) {
    top.layer.open({
        type: 2,
        title: '课程视频学习',
        shadeClose: true,
        shade: 0.8,
        area: ['640px', '480px'],
        maxmin: true,
        content: ctx + '/manage/study/course-study/study.jhtml?videoId=' + id + '&rnd=' + Math.random()
    });
}

function examinationList() {
    $.ajax({
        type: "get",
        url: ctx + "/manage/main/examination-list.jhtml?rnd=" + Math.random(),
        dataType: "json",
        success: function (res) {
            if (res.status) {
                var html = "";
                var array = res.examinationList;
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
                    html += "<a href=\"javascript:void(0);\" onclick=\"checkExamination('" + data.id + "');\" style=\"text-decoration:none\" class=\"ml-5\" title=\"进入考试\">进入考试</a>&nbsp;&nbsp;";
                    html += "</td>";
                    html += "</tr>";
                }

                $("#examination-list > tbody").html(html);
            } else {
                top.layer.alert(res.info);
            }
        },
        error : function(XmlHttpRequest, textStatus, errorThrown) {
            top.layer.alert('系统出错了');
        }
    });
}

function checkExamination(courseId) {
    $.ajax({
        type: "post",
        url: ctx + "/manage/study/employee-examination/check-test.jhtml",
        cache: false,
        data: {courseId: courseId, rnd: Math.random()},
        dataType: "json",
        success: function (res) {
            if (res.status == true) {
                examinationTest(res.paperId);
            } else {
                top.layer.alert(res.info);
            }
        },
        error : function(XmlHttpRequest, textStatus, errorThrown) {
            top.layer.alert('系统出错了');
        }
    });
}

function examinationTest(id) {
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

function scoreList() {
    $.ajax({
        type: "get",
        url: ctx + "/manage/study/employee-examination/score-list.jhtml?pageNum=1&pageSize=10&rnd=" + Math.random(),
        dataType: "json",
        success: function (res) {
            if (res.status) {
                var html = "";
                var array = res.datas;
                for (var i = 0; i < array.length; i++) {
                    var data = array[i];

                    var startTime = moment(data.startTime).format("YYYY-MM-DD HH:mm:ss");
                    var endTime = moment(data.endTime).format("YYYY-MM-DD HH:mm:ss");
                    var submitTime = moment(data.submitTime).format("YYYY-MM-DD HH:mm:ss");
                    var passState = data.passState ? "合格" : "不合格";

                    html += "<tr>";
                    html += "<td>" + data.courseName + "</td>";
                    html += "<td>" + startTime + "</td>";
                    html += "<td>" + endTime + "</td>";
                    html += "<td>" + submitTime + "</td>";
                    html += "<td class=\"text-c\">" + passState + "</td>";
                    html += "<td class=\"text-c\">" + data.testScore + "</td>";
                    html += "</tr>";
                }

                $("#score-list > tbody").html(html);
            } else {
                top.layer.alert(res.info);
            }
        },
        error : function(XmlHttpRequest, textStatus, errorThrown) {
            top.layer.alert('系统出错了');
        }
    });
}

function certificateList() {
    $.ajax({
        type: "get",
        url: ctx + "/manage/study/employee-certificate/list.jhtml?pageNum=1&pageSize=10&rnd=" + Math.random(),
        dataType: "json",
        success: function (res) {
            if (res.status) {
                var html = "";
                var array = res.datas;
                for (var i = 0; i < array.length; i++) {
                    var data = array[i];

                    var certificateDate = moment(data.certificateDate).format("YYYY-MM-DD");

                    html += "<tr>";
                    html += "<td><a href=\"" + ctx  + "/manage/study/certificate/preview.jhtml?id=" + data.id + "\" target=\"_blank\">" + data.certificateName + "</td>";
                    html += "<td>" + data.certificateCode + "</td>";
                    html += "<td>" + certificateDate + "</td>";
                    html += "</tr>";
                }

                $("#certificate-list > tbody").html(html);
            } else {
                layer.alert(res.info);
            }
        },
        error : function(XmlHttpRequest, textStatus, errorThrown) {
            layer.alert('系统出错了');
        }
    });
}

$(function () {
    videoList();
    examinationList();
    scoreList();
    certificateList();
});