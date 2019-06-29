function CourseType() {};

CourseType.prototype = {id: null, name: null};

function getCheckValue() {
    return courseType;
}

function zTreeOnCheck(event, treeId, treeNode) {
    if (treeNode.checked) {
        courseType = new CourseType();
        courseType.id = treeNode.id;
        courseType.name = treeNode.name;
    }
};

var setting = {
    check: {
        enable: true,
        chkStyle: "radio"
    },
    data: {
        simpleData: {
            enable: true
        }
    },
    callback: {
        onCheck: zTreeOnCheck
    }
};

var courseType = null;
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
