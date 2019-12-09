function goPage(curr) {
    $.ajax({
        type: "post",
        url: "/manage/study/teach-course/course-video-list.jhtml",
        cache: false,
        data: {
            "pageNum": curr,
            "courseId": $.trim($("#courseId").val()),
            "name": $.trim($("#name").val()),
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
                top.layer.alert(res.info);
            }
        },
        error : function(XmlHttpRequest, textStatus, errorThrown) {
            top.layer.alert('无权限操作');
        }
    });
}

function CourseVideo() {};

CourseVideo.prototype = {
    list: goPage
};

var video = null;
$(function () {
    video = new CourseVideo();
    video.list(1);

    $("#searchBotton").bind("click", function(){
        video.list(1);
    });
});