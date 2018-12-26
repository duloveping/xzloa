$("#inputForm").validate({
    rules : {
        title: {
            required: true
        },
        category: {
            required: true
        },
        score: {
            required: true
        },
        courseId: {
            required: true
        }
    },
    messages: {
        name: {
            required: "问题不能为空！"
        },
        category: {
            required: "类型不能为空！"
        },
        score: {
            required: "分值不能为空！"
        },
        courseId: {
            required: "所属课程不能为空！"
        }
    },
    onkeyup : false,
    focusCleanup : true,
    success : "valid",
    submitHandler : function(form) {
        var videoId = $.trim($("#videoId").val());
        var analysis = $.trim(editor.getContent());

        entity.id = $("#id").val();
        entity.title = $.trim($("#title").val());
        entity.category = $.trim($("#category").val());
        entity.score = $.trim($("#score").val());
        entity.courseId = $("#courseId").val();
        entity.courseName = $("#courseName").val();
        if (null != videoId) {
            entity.videoId = $("#videoId").val();
            entity.videoName = $("#videoName").val();
        } else {
            entity.videoId = "";
            entity.videoName = "";
        }

        $("input[name=itemList]").each(function (i, v) {
            var data = {id: "", title: v.value, answer: false };
            entity.itemList.push(data);
        });

        $("input[name=answerList]").each(function (i, v) {
            entity.itemList[i].answer = v.checked;
        });

        if ("" != analysis) {
            entity.analysis = analysis;
        }

        $.ajax({
            type: "post",
            url: ctx + "/manage/study/exercise/save.jhtml",
            cache: false,
            data: JSON.stringify(entity),
            dataType: "json",
            contentType : 'application/json;charset=UTF-8',
            success: function (res) {
                if (res.status) {
                    parent.mainFrame.location.reload(); // 父页面刷新
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                } else {
                    top.layer.alert(res.info,{icon:1,time:3000});
                }
            },
            error : function(XmlHttpRequest, textStatus, errorThrown) {
                top.layer.alert('数据保存失败');
            }
        });
    }
});

function Exercise() {};
Exercise.prototype = {
    view: function (id) {
        $.ajax({
            type: "post",
            url: ctx + "/manage/study/exercise/view.jhtml",
            cache: false,
            data: {id: id, rnd: Math.random()},
            dataType: "json",
            success: function (res) {
                if (res.status) {
                    entity.courseId = res.data.courseId;
                    entity.courseName = res.data.courseName;
                    entity.videoId = res.data.videoId;
                    entity.videoName = res.data.videoName;
                    entity.id = res.data.id;
                    entity.title = res.data.title;
                    entity.category = res.data.category;
                    entity.score = res.data.score;
                    entity.analysis = res.data.analysis;
                    if (null != res.data.itemList && res.data.itemList.length > 0) {
                        for (var i = 0; i < res.data.itemList.length; i++) {
                            var item = {id: "", title: "", answer: false};
                            item.id = res.data.itemList[i].id;
                            item.title = res.data.itemList[i].title;
                            item.answer = res.data.itemList[i].answer;
                            entity.itemList.push(item);
                        }
                    }

                    $("#title").val(entity.title);
                    $("#category").val(entity.category);
                    $("#score").val(entity.score);
                    $("#courseId").val(entity.courseId);
                    $("#courseName").val(entity.courseName);
                    $("#videoId").val(entity.videoId);
                    $("#videoName").val(entity.videoName);
                    $("#analysis").val(entity.analysis);

                    changeCategory();

                    $("input[name=itemList]").each(function (i, v) {
                        v.value = entity.itemList[i].title;
                    });

                    $("input[name=answerList]").each(function (i, v) {
                        v.checked = entity.itemList[i].answer;
                    });
                } else {
                    top.layer.alert(res.info);
                }
            },
            error : function(XmlHttpRequest, textStatus, errorThrown) {
                top.layer.alert('请求失败');
            }
        });
    }
};

function changeCategory() {
    var category = $("#category").val();
    if (category == 1 || category == 2) {
        initSelect();
    } else {
        initLogic();
    }
}

function initCourseList() {
    $.ajax({
        type: "post",
        url: ctx + "/manage/study/exercise/course-list.jhtml?rnd=" + Math.random(),
        cache: false,
        dataType: "json",
        success: function (res) {
            if (res.status) {
                var datas = res.datas;
                if (null != res.datas && res.datas.length > 0) {
                    var html = "";
                    for (var i = 0; i < res.datas.length; i++) {
                        html += "<option value=\"" + res.datas[i].id + "\">" + res.datas[i].name + "</option>";
                    }
                    $("#courseId").html(html);
                } else {
                    top.layer.alert("请先添加课程！");
                }
            } else {
                top.layer.alert(res.info);
            }
        },
        error : function(XmlHttpRequest, textStatus, errorThrown) {
            top.layer.alert('请求失败');
        }
    });
}

function initSelect() {
    index = 0;
    var itemHtml = "";
    var answerHtml = "";
    for (var i = 0; i < 4; i++) {
        itemHtml += "<div id=\"item-" + index + "\" class=\"row cl\">";
        itemHtml += letters[i] + ".<input name=\"itemList\" type=\"text\" value=\"\" maxlength=\"500\" class=\"required input-text\" style=\"width:90%\">";
        itemHtml += "<a class=\"ml-5\" onclick=\"appendItem()\" href=\"javascript:void(0);\" title=\"添加\"><i class=\"Hui-iconfont\">&#xe600;</i></a>";
        itemHtml += "<a class=\"ml-5\" onclick=\"\" href=\"javascript:void(0);\" title=\"删除\"><i class=\"Hui-iconfont\">&#xe6e2;</i></a>";
        itemHtml += "</div>";

        if ($("#category").val() == 1) {
            answerHtml += "<label id=\"answer-" + index + "\"><input name=\"answerList\" type=\"radio\" value=\"false\">" + letters[i] + "</label>&nbsp;&nbsp;";
        } else {
            answerHtml += "<label id=\"answer-" + index + "\"><input name=\"answerList\" type=\"checkbox\" value=\"false\">" + letters[i] + "</label>&nbsp;&nbsp;";
        }

        index++;
    }

    $("#item").html(itemHtml);
    $("#answer").html(answerHtml);
}

function initLogic() {
    var itemHtml = "";
    var answerHtml = "";

    itemHtml += "<div class=\"row cl\">";
    itemHtml += "对<input name=\"itemList\" type=\"hidden\" value=\"对\">";
    itemHtml += "</div>";
    itemHtml += "<div class=\"row cl\">";
    itemHtml += "错<input name=\"itemList\" type=\"hidden\" value=\"错\">";
    itemHtml += "</div>";

    answerHtml += "<label><input name=\"answerList\" type=\"radio\" value=\"true\">对</label>&nbsp;&nbsp;";
    answerHtml += "<label><input name=\"answerList\" type=\"radio\" value=\"false\">错</label>&nbsp;&nbsp;";

    $("#item").html(itemHtml);
    $("#answer").html(answerHtml);
}

function appendItem() {

}

function appendItem() {
    var itemHtml = "";
    var answerHtml = "";

    itemHtml += "<div class=\"row cl\">";
    itemHtml += letters[index] + ".<input name=\"itemList\" type=\"text\" value=\"\" maxlength=\"500\" class=\"required input-text\" style=\"width:90%\">";
    itemHtml += "<a class=\"ml-5 addtion\" onclick=\"appendItem()\" href=\"javascript:void(0);\" title=\"添加\"><i class=\"Hui-iconfont\">&#xe600;</i></a>";
    itemHtml += "<a class=\"ml-5 remove\" onclick=\"\" href=\"javascript:void(0);\" title=\"删除\"><i class=\"Hui-iconfont\">&#xe6e2;</i></a>";
    itemHtml += "</div>";

    if ($("#category").val() == 1) {
        answerHtml += "<label><input name=\"answerList\" type=\"radio\" value=\"false\">" + letters[index] + "</label>&nbsp;&nbsp;";
    } else {
        answerHtml += "<label><input name=\"answerList\" type=\"checkbox\" value=\"false\">" + letters[index] + "</label>&nbsp;&nbsp;";
    }

    $("#item").append(itemHtml);
    $("#answer").append(answerHtml);

    index++;
}

var letters = ["A", "B", "C", "D", "E", "F","G", "H", "I", "J", "K",
    "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"];

var exercise;

var entity = {
    id: "",
    title: "",
    category: 0,
    score: 0,
    courseId: "",
    courseName: "",
    videoId: "",
    videoName: "",
    analysis: "",
    itemList: new Array()
};

var index = 0;
var editor;

$(function () {
    $("#category").change(changeCategory);

    $(".remove").click(function () {
        $(this).parent().remove();
    });

    initCourseList();

    exercise = new Exercise();
    var id = $.trim($("#id").val());

    if ("" != id) {
        exercise.view(id);
    } else {
        entity.category = $("#category").val();

        if (entity.category == 1 || entity.category == 2) {
            initSelect();
        } else if (entity.category == 4) {
            initLogic();
        }
    }

    editor = UE.getEditor('analysis');
    editor.addListener( 'ready', function() {
        editor.setContent(entity.analysis);
    } );
});
