function goPage(curr) {
    $.ajax({
        type: "post",
        url: ctx + "/manage/study/employee-certificate/list.jhtml",
        cache: false,
        data: {
            "pageNum": curr,
            "paperId": $("#paperId").val(),
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

                    var certificateDate = moment(data.certificateDate).format("YYYY-MM-DD");

                    html += "<tr>";
                    html += "<td><a href=\"" + ctx  + "/manage/study/certificate/preview.jhtml?id=" + data.id + "\" target=\"_blank\">" + data.certificateName + "</td>";
                    html += "<td>" + data.certificateCode + "</td>";
                    html += "<td>" + certificateDate + "</td>";
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

function certificateState(state) {
    var val;
    switch (state) {
        case 1:
            val = "正常";
            break;
        case 2:
            val = "过期";
            break;
        case 3:
            val = "作废";
            break;
        default:
            val = "";
    }
    return val;

}

function EmployeeCertificate() {};

EmployeeCertificate.prototype = {
    list: goPage
};

var certificate = null;
$(function () {
    certificate = new EmployeeCertificate();
    certificate.list(1);

    $("#searchBotton").bind("click", function(){
        certificate.list(1);
    });
});