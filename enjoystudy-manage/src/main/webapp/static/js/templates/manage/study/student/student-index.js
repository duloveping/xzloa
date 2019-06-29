function goPage(curr) {
    $.ajax({
        type: "post",
        url: ctx + "/manage/study/student/list.jhtml",
        cache: false,
        data: {
            "pageNum": curr,
            "pageSize": 20,
            "fullName": $.trim($("#fullName").val()),
            "code": $.trim($("#code").val()),
            "lockState": $.trim($("#lockState").val()),
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

function Student() {};

Student.prototype = {
    list: goPage,
    add: function () {
        var index = layer.open({
            type: 2,
            title: '添加学员',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: ctx + '/manage/study/student/edit.jhtml?rnd=' + Math.random()
        });
        layer.full(index);
    },
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
    batchEdit: function () {
        var index = layer.open({
            type: 2,
            title: '批量生成学员账号',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: ctx + '/manage/study/student/batchEdit.jhtml?rnd=' + Math.random()
        });
        layer.full(index);
    },
    delete: function (id) {
        layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                type : "get",
                url : ctx + "/manage/study/student/delete.jhtml?id=" + id + '&rnd=' + Math.random(),
                cache : false,
                dataType : "json",
                success : function(res){
                    if (res.status) {
                        layer.msg('删除成功',{icon:1,time:3000});
                    } else {
                        layer.alert(res.info);
                    }

                }
            });
            $(obj).parents("tr").remove();
            layer.close(index);
        });
    },
    courseList: function (id) {
         top.layer.open({
            type: 2,
            title: '课程列表',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: ctx + '/manage/study/student/courseList.jhtml?employeeId=' + id + '&rnd=' + Math.random()
        });
    },
    export: function () {
        var studentIds = new Array();
        $.each($('input[name=studentId][type=checkbox]:checked'),function(i, v){
            studentIds.push(v.value);
        });
        if (studentIds.length == 0) {
            top.layer.alert("请选择要导出的学员信息！");
        } else {
            window.open(ctx + "/manage/study/student/export.jhtml?studentIds=" + studentIds.join(",") + "&rnd=" + Math.random());
        }
    }
};

var student = null;
$(function () {
    student = new Student();
    student.list(1);

    $("#searchBotton").bind("click", function(){
        student.list(1);
    });

    $("#grantCourse").bind("click", function(){
        var studentIds = new Array();
        $.each($('input[name=studentId][type=checkbox]:checked'),function(i, v){
            studentIds.push(v.value);
        });

        if (null != studentIds && studentIds.length > 0) {
            top.layer.open({
                type: 2,
                title: '课程选择',
                shadeClose: true,
                shade: 0.8,
                area: ['480px', '600px'],
                maxmin: true,
                content: ctx + '/manage/study/course/courseTypeIndex.jhtml?rnd=' + Math.random(),
                btn: ['确定','关闭'],
                yes: function(index, layero){
                    var data = $(layero).find("iframe")[0].contentWindow.getCheckValue();
                    if (null != data && typeof(data) != "undefined") {
                        var strs = data.id.split(":");
                        if (strs[0] == 1) {
                            var obj = {employeeIds: studentIds, courseId: strs[1]};
                            $.ajax({
                                type: "post",
                                url: ctx + "/manage/study/student/saveCourse.jhtml?courseId=" + obj.courseId + "&employeeIds=" + obj.employeeIds.join(","),
                                cache: false,
                                dataType: "json",
                                success: function (res) {
                                    top.layer.msg(res.info);
                                },
                                error : function(XmlHttpRequest, textStatus, errorThrown) {
                                    top.layer.alert('系统出错！');
                                }
                            });
                        }
                    }
                    top.layer.close(index);
                }
            });
        } else {
            top.layer.alert("请选择授课学员！");
        }
    });
});