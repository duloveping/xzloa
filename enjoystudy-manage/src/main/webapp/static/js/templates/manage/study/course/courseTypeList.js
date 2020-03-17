function CourseType() {};

CourseType.prototype = {id: null, name: null};

function getCheckValue() {
    let courses = new Array();
    let treeObj = $.fn.zTree.getZTreeObj("courseTree");
    let nodes = treeObj.getCheckedNodes(true);
    for(var i=0; i < nodes.length; i++) {
        var node = nodes[i];
        let course = new CourseType();
        course.id = node.id;
        course.name = node.name;
        courses.push(course);
    }
    return courses;
}

var setting = {
    check: {
        enable: true,
    },
    data: {
        simpleData: {
            enable: true
        }
    }
};

$(function () {
    $.ajax({
        type: "get",
        url: ctx + "/manage/study/course/courseTypeList.jhtml?rnd=" + Math.random(),
        cache: false,
        dataType: "json",
        success: function (res) {
            if (res.status) {
                $.fn.zTree.init($("#courseTree"), setting, res.datas);
            }
        },
        error : function(XmlHttpRequest, textStatus, errorThrown) {
            top.layer.alert('系统出错！');
        }
    });
});
