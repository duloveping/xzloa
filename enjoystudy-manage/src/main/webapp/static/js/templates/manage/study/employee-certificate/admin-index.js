function goPage(curr) {
    $.ajax({
        type: "post",
        url: ctx + "/manage/study/employee-certificate/admin-list.jhtml",
        cache: false,
        data: {
            "pageNum": curr,
            "certificateState": $("#certificateState").val(),
            "employeeName": $.trim($("#employeeName").val()),
            "identityCode": $.trim($("#identityCode").val()),
            "certificateCode": $.trim($("#certificateCode").val()),
            "certificateName": $.trim($("#certificateName").val()),
            "rnd": Math.random()
        },
        dataType: "json",
        success: function (res) {
            if (res.status) {
                var list = new Array();

                var html = "";
                var array = res.datas;
                for (var i = 0; i < array.length; i++) {
                    var data = array[i];
                    var certificate = new Certificate();
                    certificate.employeeName = (null == data.employeeName ? "" : data.employeeName);
                    certificate.identityCode = (null == data.identityCode ? "" : data.identityCode);
                    certificate.certificateCode = (null == data.certificateCode ? "" : data.certificateCode);
                    certificate.chineseCertificateName = (null == data.certificateName ? "" : data.certificateName);
                    certificate.englishCertificateName = (null == data.englishName ? "" : data.englishName);
                    certificate.certificateDate = moment(data.certificateDate).format("YYYY-MM-DD");
                    certificate.certificateState = certificateState(data.certificateState);
                    certificate.chineseTeacherName = (null == data.teacherName ? "" : data.teacherName);
                    certificate.englishContent = (null == data.englishContent ? "" : data.englishContent);
                    certificate.chineseContent = (null == data.chineseContent ? "" : data.chineseContent);
                    list.push(certificate);
                }

                var getTpl = document.getElementById("dataTableListTpl").innerHTML;

                laytpl(getTpl).render({list:res.datas}, function (html) {
                    $("#dataTableList > tbody").html(html);
                });

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

function EmployeeCertificate() {};

EmployeeCertificate.prototype = {
    list: goPage,
    edit: function (id) {
        var index = layer.open({
            type: 2,
            title: '修改学员',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: ctx + '/manage/study/student/edit.jhtml?id=' + id + '&rnd=' + Math.random()
        });
        layer.full(index);
    },
};

var certificate = null;
$(function () {
    certificate = new EmployeeCertificate();
    certificate.list(1);

    $("#searchBotton").on("click", function(){
        certificate.list(1);
    });
});