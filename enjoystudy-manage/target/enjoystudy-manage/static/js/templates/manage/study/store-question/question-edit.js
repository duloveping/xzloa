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
        }
    },
    onkeyup : false,
    focusCleanup : true,
    success : "valid",
    submitHandler : function(form) {
        var analysis = $.trim(editor.getContent());

        entity.id = $("#id").val();
        entity.title = $.trim($("#title").val());
        entity.category = $.trim($("#category").val());
        entity.score = $.trim($("#score").val());
        entity.paperId = $.trim($("#paperId").val());

        entity.itemList = new Array();
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
            url: ctx + "/manage/study/store-question/save.jhtml",
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

function StoreQuestion() {};
StoreQuestion.prototype = {
    view: function (id) {
        $.ajax({
            type: "post",
            url: ctx + "/manage/study/store-question/view.jhtml",
            cache: false,
            data: {id: id, rnd: Math.random()},
            dataType: "json",
            success: function (res) {
                if (res.status) {
                    itemAmount = res.data.itemList.length;
                    entity.id = res.data.id;
                    entity.title = res.data.title;
                    entity.category = res.data.category;
                    entity.score = res.data.score;
                    entity.paperId = res.data.paperId;
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
                    $("#analysis").val(entity.analysis);
                    $("#paperId").val(entity.paperId);

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
function initSelect() {
    index = 0;
    var itemHtml = "";
    var answerHtml = "";
    for (var i = 0; i < itemAmount; i++) {
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

var question;

var entity = {
    id: "",
    title: "",
    category: 0,
    score: 0,
    analysis: "",
    paperId: "",
    itemList: new Array()
};

var index = 0;
var editor;
var itemAmount = 4;

$(function () {
    $("#category").change(changeCategory);

    $(".remove").click(function () {
        $(this).parent().remove();
    });

    question = new StoreQuestion();
    var id = $.trim($("#id").val());

    if ("" != id) {
        question.view(id);
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
