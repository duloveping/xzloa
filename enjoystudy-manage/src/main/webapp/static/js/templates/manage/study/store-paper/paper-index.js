function goPage(curr) {
    $.ajax({
        type: "post",
        url: ctx + "/manage/study/store-paper/paper-list.jhtml",
        cache: false,
        data: {
            "pageNum": curr,
            "courseId": $.trim($("#courseId").val()),
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
                    html += "<tr>";
                    html += "<td>" + data.title + "</td>";
                    html += "<td>" + data.duration + "</td>";
                    html += "<td>" + data.questionAmount + "</td>";
                    html += "<td>" + data.totalScore + "</td>";
                    html += "<td>" + data.passScore + "</td>";
                    html += "<td>" + data.testAmount + "</td>";
                    html += "<td>" + (data.showState ? "显示" : "隐藏") + "</td>";
                    html += "<td class=\"td-manage\">";
                    html += "<a href=\"javascript:void(0);\" onclick=\"paper.edit('" + data.id + "');\" style=\"text-decoration:none\" class=\"ml-5\" title=\"编辑\"><i class=\"fa fa-edit fa-lg\"></i></a>&nbsp;";
                        html += "<a href=\"javascript:void(0);\" onclick=\"paper.delete(this, '" + data.id + "');\"style=\"text-decoration:none\" class=\"ml-5\" title=\"删除\"><i class=\"fa fa-remove fa-lg\"></i></a>&nbsp;"
                        html += "<a href=\"javascript:void(0);\" onclick=\"paper.send('" + data.id + "');\"style=\"text-decoration:none\" class=\"ml-5\" title=\"提交\"><i class=\"fa fa-send fa-lg\"></i></a>"
                        html += "<a href=\"javascript:void(0);\" onclick=\"paper.questionList('" + data.id + "');\"style=\"text-decoration:none\" class=\"ml-5\" title=\"试题\"><i class=\"fa fa-list-ol fa-lg\"></i></a>"
                    html += "<a href=\"javascript:void(0);\" onclick=\"paper.view('" + data.id + "');\"style=\"text-decoration:none\" class=\"ml-5\" title=\"预览\"><i class=\"fa fa-newspaper-o fa-lg\"></i></a>"
                    html += "</td></tr>";
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
                top.layer.alert(res.info);
            }
        },
        error : function(XmlHttpRequest, textStatus, errorThrown) {
            top.layer.alert('无权限操作');
        }
    });
}

function StorePaper() {};

StorePaper.prototype = {
    list: goPage,
    add: function (id) {
        var index = top.layer.open({
            type: 2,
            title: '添加考卷',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: ctx + '/manage/study/store-paper/paper-edit.jhtml?rnd=' + Math.random()
        });
        top.layer.full(index);
    },
    edit: function (id) {
        var index = top.layer.open({
            type: 2,
            title: '修改考卷',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: ctx + '/manage/study/store-paper/paper-edit.jhtml?id=' + id + '&rnd=' + Math.random()
        });
        top.layer.full(index);
    },
    view: function (id) {
        var index = top.layer.open({
            type: 2,
            title: '考卷预览',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: ctx + '/manage/study/store-paper/paper-view.jhtml?id=' + id + '&rnd=' + Math.random()
        });
        top.layer.full(index);
    },
    delete: function (obj, id) {
        top.layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                type : "post",
                url : ctx + "/manage/study/store-paper/paper-delete.jhtml",
                cache : false,
                data : {"id" : id, "rnd" : Math.random()},
                dataType : "json",
                success : function(res){
                    if (res.status) {
                        top.layer.msg('删除成功',{icon:1,time:3000});
                    } else {
                        top.layer.alert(res.info);
                    }

                }
            });
            $(obj).parents("tr").remove();
            top.layer.close(index);
        });
    },
    send: function (id) {
        top.layer.confirm('确认要提交审核吗？',function(index){
            $.ajax({
                type : "post",
                url : ctx + "/manage/study/store-paper/paper-submit.jhtml",
                cache : false,
                data : {"id" : id, "rnd" : Math.random()},
                dataType : "json",
                success : function(res){
                    if (res.status) {
                        paper.list(1);
                        top.layer.msg('提交成功',{icon:1,time:3000});
                    } else {
                        top.layer.alert(res.info);
                    }
                }
            });
            top.layer.close(index);
        });
    },
    questionList: function (id) {
        document.location.href = ctx  + '/manage/study/store-question/index.jhtml?paperId=' + id + '&rnd=' + Math.random();
    }
};

var paper = null;
$(function () {
    paper = new StorePaper();
    paper.list(1);

    $("#searchBotton").bind("click", function(){
        paper.list(1);
    });
});