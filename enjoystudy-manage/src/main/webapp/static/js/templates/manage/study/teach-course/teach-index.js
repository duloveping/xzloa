function goPage(curr) {
    $.ajax({
        type: "post",
        url: "/manage/study/teach-course/teach-list.jhtml",
        cache: false,
        data: {
            "pageNum": curr,
            "pageSize": 20,
            "courseCode": $("#courseCode").val(),
            "courseName": $("#courseName").val(),
            "typeId": $("#typeId").val(),
            "typeCode": $("#typeCode").val(),
            "typeName": $("#typeName").val(),
            "teacherId": $("#teacherId").val(),
            "teacherName": $("#teacherName").val(),
            "rnd": Math.random()
        },
        dataType: "json",
        success: function (res) {
            if (res.status) {
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

function TeachCourse() {};

TeachCourse.prototype = {
    list: goPage,
};

var teachCourse = null;
$(function () {
    teachCourse = new TeachCourse();
    teachCourse.list(1);

    $("#searchBotton").on("click", function(){
        teachCourse.list(1);
    });
});