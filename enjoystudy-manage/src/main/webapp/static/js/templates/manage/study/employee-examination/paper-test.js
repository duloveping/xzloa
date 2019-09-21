function TestPaper() {};

TestPaper.prototype = {
    load: function () {
        var paperId = $("#paperId").val();
        $.ajax({
            type: "post",
            url: ctx + "/manage/study/employee-examination/paper-details.jhtml",
            cache: false,
            data: {paperId: paperId, rnd: Math.random()},
            dataType: "json",
            success: function (res) {
                if (res.status == true) {
                    var html = "";
                    testPaper = res.paper;
                    questionList = testPaper.questionList;

                    $('.countdown').downCount({
                        date: moment(testPaper.endTime).format("YYYY-MM-DD HH:mm:ss"),
                        offset: +10
                    }, function () {
                        paper.save();
                    });

                    for (var i = 0; i < questionList.length; i++) {
                        var question = questionList[i];
                        // 作答状态：1未作答，2作答标记，3已作答
                        if (question.answerState == 1) {
                            html += "<a data-id=\"" + question.id + "\" style=\"text-decoration:none\" class=\"ml-5\" href=\"javascript:void(0);\" title=\"第" + (i + 1) + "题\"><span class=\"badge badge-default radius\">" + (i + 1) + "</span></a>&nbsp;&nbsp;";
                        } else if (question.answerState == 2) {
                            html += "<a data-id=\"" + question.id + "\" style=\"text-decoration:none\" class=\"ml-5\" href=\"javascript:void(0);\" title=\"第" + (i + 1) + "题\"><span class=\"badge badge-warning radius\">" + (i + 1) + "</span></a>&nbsp;&nbsp;";
                        } else if (question.answerState == 3) {
                            html += "<a data-id=\"" + question.id + "\" style=\"text-decoration:none\" class=\"ml-5\" href=\"javascript:void(0);\" title=\"第" + (i + 1) + "题\"><span class=\"badge badge-primary radius\">" + (i + 1) + "</span></a>&nbsp;&nbsp;";
                        }
                    }

                    $("#questionList").html(html);

                    $("#questionList > a").click(function(){
                        index = parseInt($(this).text()) - 1;
                        paper.show(index);
                    });

                    paper.show(0);

                } else {
                    top.layer.alert(res.info);
                }
            },
            error : function(XmlHttpRequest, textStatus, errorThrown) {
                top.layer.alert('系统出错了');
            }
        });
    },
    show: function (id) {
        var question = questionList[id];
        var itemList = question.itemList;
        var questionHtml = "类型：";

        if (question.category == 1) {
            questionHtml += "单选题";
        } else if (question.category == 2) {
            questionHtml += "多选题";
        } else if (question.category == 3) {
            questionHtml += "不定项选择题";
        } else if (question.category == 4) {
            questionHtml += "判断题";
        }
        questionHtml += "（" + question.score + "分）<br/>";
        questionHtml += (id + 1) + "." + question.title;


        $("#question").html(questionHtml);

        var itemHtml = "";
        // 类型：1单选题，2多选题，3不定项选择题，4判断题，5填空题，6主观题
        if (question.category == 1 || question.category == 4) {
            for (var i = 0; i < itemList.length; i++) {
                var item = itemList[i];
                if (question.category == 1) {
                    itemHtml += "<label><input data-id=\"" + item.id + "\" name=\"itemList\" type=\"radio\" value=\"" + item.checkState + "\"" + (item.checkState ? "checked=\"checked\"" : "") + ">" + letters[i] + "." + item.title + "</label><br/>";
                } else {
                    itemHtml += "<label><input data-id=\"" + item.id + "\" name=\"itemList\" type=\"radio\" value=\"" + item.checkState + "\"" + (item.checkState ? "checked=\"checked\"" : "") + ">" + item.title + "</label><br/>";
                }
            }
        } else if (question.category == 2 || question.category == 3) {
            for (var i = 0; i < itemList.length; i++) {
                var item = itemList[i];
                itemHtml += "<label><input data-id=\"" + item.id + "\" name=\"itemList\" type=\"checkbox\" value=\"" + item.checkState + "\"" + (item.checkState ? "checked=\"checked\"" : "") + ">" + letters[i] + "." + item.title + "</label><br/>";
            }
        }

        $("#itemList").html(itemHtml);
    },
    previous: function () {
        if (paper.answer() == false) {
            index -= 1;
            if (index <= 0) {
                index = 0;
            }
            paper.show(index);
        }
    },
    next: function () {
        if (paper.answer() == false) {
            index += 1;
            if (index >= (questionList.length - 1)) {
                index = questionList.length - 1;
            }
            paper.show(index);
        }
    },
    answer: function () {
        var bool = true;

        var question = questionList[index];
        var itemList = question.itemList;

        $.each($("input[name=itemList]"), function(i,val){
            var dataId = val.getAttribute("data-id");

            for (var i = 0; i < itemList.length; i++) {
                var item = itemList[i];
                if (item.id == dataId) {
                    item.checkState = val.checked;
                }
            }

            if (val.checked) {
                bool = false;
            }
        });

        if (bool) {
            top.layer.alert("请选择答题项");
        } else {
            question.answerState = 3;
            question.itemList = itemList;

            $.ajax({
                type: "post",
                url: ctx + "/manage/study/employee-examination/save-answer.jhtml",
                cache: false,
                data: JSON.stringify(question),
                dataType: "json",
                contentType : 'application/json;charset=UTF-8',
                success: function (res) {
                    if (res.status) {
                        $("a[data-id='" + question.id + "'] > span").removeClass("badge-default").addClass("badge-primary");
                    } else {
                        top.layer.alert(res.info,{icon:1,time:3000});
                    }
                },
                error : function(XmlHttpRequest, textStatus, errorThrown) {
                    top.layer.alert('数据保存失败');
                }
            });
        }
        return bool;
    },
    submit: function () {
        var amount = 0;
        for (var i = 0; i < questionList.length; i++) {
            var question = questionList[i];
            if (question.answerState != 3) {
                amount += 1;
            }
        }

        if (amount > 0) {
            top.layer.confirm('您目前还有' + amount + '道题还没做完，确定要交卷吗？',function(index){
                paper.save();
            });
        } else {
            testPaper.questionList = questionList;
            paper.save();
        }
    },
    save: function () {
        $.ajax({
            type : "post",
            url : ctx + "/manage/study/employee-examination/save-paper.jhtml",
            cache : false,
            data: JSON.stringify(testPaper),
            dataType : "json",
            contentType : 'application/json;charset=UTF-8',
            success : function(res){
                if (res.status) {
                    testPaper = null;
                }
                top.layer.alert(res.info);
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);

            }
        });
    }
};

var paper = null;
var testPaper = null;
var index = 0;
var questionList = new Array();
var letters = ["A", "B", "C", "D", "E", "F","G", "H", "I", "J",
                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z"];

$(function () {
    paper = new TestPaper();
    paper.load();

    $("#previous").click(function(){
        paper.previous();
    });

    $("#next").click(function(){
        paper.next();
    });

    $("#submit").click(function(){
        paper.submit();
    });

});