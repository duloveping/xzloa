$(function () {
    var filePath = $("#met-showproduct-list").attr("data-file-path");
    var img = $("#met-showproduct-list").attr("data-img");

    var container = document.getElementById("met-showproduct-list");
    var api = flowplayer(container, {
        poster: img,
        clip: {
            sources: [{
                type: "video/mp4",
                src: filePath
            }
            ]
        }
    });

    api.on("ready", function () {
    });


    $.ajax({
        type: "post",
        url: ctx + "/web/course-video/updateClickAmount.jhtml",
        cache: false,
        data: {
            "id": $("#product-details").attr("data-id")
        },
        dataType: "json",
        success: function (res) {
            if (res.status) {
                console.log("数据更新成功");
            }
        },
        error : function(XmlHttpRequest, textStatus, errorThrown) {
            console.log("系统出错了");
        }
    });
});