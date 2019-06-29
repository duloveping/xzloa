function goPage(curr) {
    $.ajax({
        type: "post",
        url: ctx + "/manage/study/course-study/course-list.jhtml",
        cache: false,
        data: {
            "pageNum": curr,
            "courseName": $.trim($("#courseName").val()),
            "rnd": Math.random()
        },
        dataType: "json",
        success: function (res) {
            if (res.status) {
                var getTpl = document.getElementById("dataTableListTpl").innerHTML;

                $("#dataTableList > tbody").empty();

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

function CourseStudy() {};

CourseStudy.prototype = {
    list: goPage
};

var study = null;
$(function () {
    study = new CourseStudy();
    study.list(1);

    $("#searchBotton").bind("click", function(){
        study.list(1);
    });
});