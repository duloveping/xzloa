function goPage(curr) {
    $.ajax({
        type: "post",
        url: ctx + "/manage/study/employee-examination/score-list.jhtml",
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

                    var startTime = moment(data.startTime).format("YYYY-MM-DD HH:mm:ss");
                    var endTime = moment(data.endTime).format("YYYY-MM-DD HH:mm:ss");
                    var submitTime = "";
                    if (data.submitTime) {
                        submitTime = moment(data.submitTime).format("YYYY-MM-DD HH:mm:ss");
                    }

                    var passState = data.passState ? "合格" : "不合格";

                    html += "<tr>";
                    html += "<td>" + data.courseName + "</td>";
                    html += "<td>" + startTime + "</td>";
                    html += "<td>" + endTime + "</td>";
                    html += "<td>" + submitTime + "</td>";
                    html += "<td class=\"text-c\">" + passState + "</td>";

                    html += "<td class=\"text-c\">" + data.testScore;
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

function Examination() {};

Examination.prototype = {
    list: goPage
};

var examination = null;
$(function () {
    examination = new Examination();
    examination.list(1);
});