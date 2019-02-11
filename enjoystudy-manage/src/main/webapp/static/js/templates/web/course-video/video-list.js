function goPage(curr) {
    $.ajax({
        type: "post",
        url: ctx + "/web/course-video/search.jhtml",
        cache: false,
        data: {
            "pageNum": curr,
            "pageSize": 20,
            "teacherId": $.trim($("#teacherId").val()),
            "courseId": $.trim($("#courseId").val()),
            "courseCode": $.trim($("#courseCode").val()),
            "courseRecommendState": $.trim($("#courseRecommendState").val()),
            "courseHotState": $.trim($("#courseHotState").val()),
            "name": $.trim($("#name").val()),
            "showState": $.trim($("#showState").val())
        },
        dataType: "json",
        success: function (res) {
            if (res.status) {
                var html = "";
                var array = res.datas;
                for (var i = 0; i < array.length; i++) {
                    var data = array[i];
                    html += "<li class=\"shown\">";
                    html += "<div class=\"widget widget-shadow\">";
                    html += "<figure class=\"widget-header cover\">";
                    html += "<a href=\""  + ctx +  "/web/course-video/details.jhtml?id=" + data.id + "\" title=\"" + data.name + "\" target=\"_blank\">";
                    html += "<img style=\"width: 433px; height: 332px;\" class=\"cover-image\" src=\"" + ctx + data.image + "\" alt=\"" + data.name + "\"/>";
                    html += "</a>";
                    html += "</figure>";
                    html += "<div class=\"widget-body\">";
                    html += "<h4 class=\"widget-title\">" + data.name + "</h4>";
                    html += "<p style=\"overflow: hidden;white-space: nowrap;text-overflow:ellipsis;\">" + data.introduction + "</p>";
                    html += "<div class=\"widget-body-footer\">";
                    html += "<div class=\"widget-actions pull-right\">";
                    html += "<a href=\""  + ctx +  "/web/course-video/details.jhtml?id="  + data.id +  "\" title=\"" + data.name + "\">";
                    html += "<i class=\"icon wb-eye\" aria-hidden=\"true\"></i>";
                    html += "<span>" + data.clickAmount + "</span>";
                    html += "</a>";
                    html += "</div>";
                    html += "<a href=\"" + ctx + "/web/course-video/details.jhtml?id="  + data.id +  "\" title=\"" + data.name + "\" target=\"_blank\" class=\"btn btn-outline btn-primary btn-squared\">查看详情</a>";
                    html += "</div>";
                    html += "</div>";
                    html += "</div>";
                    html += "</li>";
                }

                $("#met-grid").html(html);

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
            console.log("系统出错了");
        }
    });
}

function CourseVideo() {};

CourseVideo.prototype = {
    list: goPage,
};

var video = null;
$(function () {
    video = new CourseVideo();
    video.list(1);

    $(".link").click(function(){
        var courseId = $(this).attr("data-id");
        $("#courseId").val(courseId);
        video.list(1);
    })
});