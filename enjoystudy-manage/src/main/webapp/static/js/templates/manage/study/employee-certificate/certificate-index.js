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

                    var certificateDate = moment(data.certificateDate).format("YYYY-MM-DD HH:mm:ss");

                    html += "<tr>";
                    html += "<td>" + data.certificateName + "</td>";
                    html += "<td>" + data.certificateCode + "</td>";
                    html += "<td>" + certificateState(data.certificateState) + "</td>";
                    html += "<td>" + data.organizationName + "</td>";
                    html += "<td>" + data.certificateDate + "</td>";
                    html += "<td class=\"td-manage\">";
                    html += "<a href=\"javascript:void(0);\" onclick=\"question.view('" + data.id + "');\" style=\"text-decoration:none\" class=\"ml-5\" title=\"查看\"><i class=\"fa fa-edit fa-lg\"></i></a>&nbsp;";
                    html += "</td>";
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