$("#inputForm").validate({
    rules : {
        title: {
            required : true
        },
        showState: {
            required : true
        }
    },
    messages: {
        title: {
            required : "标题不能为空"
        },
        showState: {
            required : "显示状态不能为空"
        }
    },
    onkeyup : false,
    focusCleanup : true,
    success : "valid",
    submitHandler : function(form) {
        var planList = new Array();
        var certificateIds = new Array();
        var courseIds = new Array();
        var showStates = new Array();
        var entryStates = new Array();
        var entryStartTimes = new Array();
        var entryEndTimes = new Array();
        var testStates = new Array();
        var testStartTimes = new Array();
        var testEndTimes = new Array();

        $.each($("select[name=certificateId]"), function(i, v){
            certificateIds.push(v.value);
        });
        $.each($("select[name=courseId]"), function(i, v){
            courseIds.push(v.value);
        });
        $.each($("select[name=showState]"), function(i, v){
            showStates.push(v.value);
        });
        $.each($("select[name=entryState]"), function(i, v){
            entryStates.push(v.value);
        });
        $.each($("input[name=entryStartTime]"), function(i, v){
            entryStartTimes.push(v.value);
        });
        $.each($("input[name=entryEndTime]"), function(i, v){
            entryEndTimes.push(v.value);
        });
        $.each($("select[name=testState]"), function(i, v){
            testStates.push(v.value);
        });
        $.each($("input[name=testStartTime]"), function(i, v){
            testStartTimes.push(v.value);
        });
        $.each($("input[name=testEndTime]"), function(i, v){
            testEndTimes.push(v.value);
        });

        if (certificateIds.length > 0) {
            for (var i = 0; i < certificateIds.length; i++) {
                var obj = {
                    certificateId: certificateIds[i],
                    courseId: courseIds[i],
                    showState: showStates[i],
                    entryState: entryStates[i],
                    entryStartTime: entryStartTimes[i],
                    entryEndTime: entryEndTimes[i],
                    testState: testStates[i],
                    testStartTime: testStartTimes[i],
                    testEndTime: testEndTimes[i]
                };
                planList.push(obj);
            }
        }

        var id = $("#id").val();
        var title = $("#title").val();
        var showState = $("input[name=showState][type=radio]:checked").val();

        var plan = {id: id, title: title, showState: showState, planList: planList};

        $.ajax({
            type: "post",
            url: ctx + "/manage/register/examination/examination-plan/save.jhtml",
            cache: false,
            data: JSON.stringify(plan),
            dataType: "json",
            contentType : 'application/json;charset=UTF-8',
            success: function (res) {
                layer.msg(res.info,{icon:1,time:3000});
                if (res.status) {
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.plan.list(1);
                    parent.layer.close(index);
                }
            },
            error : function(XmlHttpRequest, textStatus, errorThrown) {
                top.layer.alert('数据保存失败');
            }
        });
    }
});

var ue;
var courseSelect = "";
var certificateSelect = "";
$(function () {
    $('.skin-minimal input').iCheck({
        checkboxClass: 'icheckbox-blue',
        radioClass: 'iradio-blue',
        increaseArea: '20%'
    });


    ue = UE.getEditor('content');

    getCourseSelect();
    getCertificateList();
});

function appendPlanItem() {
    var html = "<tr class=\"text-c\">";
    html += "<td>";
    html += certificateSelect;
    html += "</td>";
    html += "<td>";
    html += courseSelect;
    html += "</td>";
    html += "<td>";
    html += "<span class=\"select-box\">";
    html += "<select name=\"showState\" class=\"select\">";
    html += "<option>请选择</option><option value=\"true\">显示</option><option value=\"false\">隐藏</option>";
    html += "</select>";
    html += "</span>";
    html += "</td>";
    html += "<td>";
    html += "<span class=\"select-box\">";
    html += "<select name=\"entryState\" class=\"select\">";
    html += "<option>请选择</option><option value=\"1\">待报名</option><option value=\"2\">开报名</option><option value=\"3\">结束报名</option>";
    html += "</select>";
    html += "</span>";
    html += "</td>";
    html += "<td>";
    html += "<input name=\"entryStartTime\" type=\"text\" onfocus=\"WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})\" class=\"input-text Wdate\">";
    html += "</td>";
    html += "<td>";
    html += "<input name=\"entryEndTime\" type=\"text\" onfocus=\"WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})\" class=\"input-text Wdate\">";
    html += "</td>";
    html += "<td>";
    html += "<span class=\"select-box\">";
    html += "<select name=\"testState\" class=\"select\">";
    html += "<option>请选择</option><option value=\"1\">待考试</option><option value=\"2\">开始考试</option><option value=\"3\">结束考试</option>";
    html += "</select>";
    html += "</span>";
    html += "</td>";
    html += "<td>";
    html += "<input name=\"testStartTime\" type=\"text\" onfocus=\"WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})\" class=\"input-text Wdate\">";
    html += "</td>";
    html += "<td>";
    html += "<input name=\"testEndTime\" type=\"text\" onfocus=\"WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})\" class=\"input-text Wdate\">";
    html += "</td>";
    html += "<td>";
    html += "<a style=\"text-decoration:none\" class=\"ml-5\" onclick=\"copyPlanItem(this)\" href=\"javascript:void(0);\" title=\"添加\">";
    html += "<i class=\"Hui-iconfont\">&#xe600;</i>";
    html += "</a>";
    html += "<a style=\"text-decoration:none\" class=\"ml-5\" onclick=\"removePlanItem(this)\" href=\"javascript:void(0);\" title=\"删除\">";
    html += "<i class=\"Hui-iconfont\">&#xe6a1;</i>";
    html += "</a>";
    html += "</td>";
    html += "</tr>";

    $("#plan-list > tbody").append(html);
}

function getCourseSelect() {
    $.ajax({
        type: "post",
        url: ctx + "/manage/register/examination/examination-plan/course-list.jhtml",
        cache: false,
        dataType: "json",
        success: function (res) {
            courseSelect = "";
            courseSelect += "<span class=\"select-box\">";
            courseSelect = "<select name=\"courseId\" class=\"select\">";
            courseSelect += "<option>请选择</option>";
            for (var i = 0; i < res.datas.length; i++) {
                courseSelect += "<option value=\"" + res.datas[i].id + "\">" + res.datas[i].name + "</option>";
            }
            courseSelect += "</select>";
            courseSelect += "</span>";
        },
        error : function(XmlHttpRequest, textStatus, errorThrown) {
            top.layer.alert('数据保存失败');
        }
    });
}

function getCertificateList() {
    $.ajax({
        type: "post",
        url: ctx + "/manage/register/examination/examination-plan/certificate-list.jhtml",
        cache: false,
        dataType: "json",
        success: function (res) {
            certificateSelect = "";
            certificateSelect += "<span class=\"select-box\">";
            certificateSelect = "<select name=\"certificateId\" class=\"select\">";
            certificateSelect += "<option>请选择</option>";
            for (var i = 0; i < res.datas.length; i++) {
                certificateSelect += "<option value=\"" + res.datas[i].id + "\">" + res.datas[i].name + "</option>";
            }
            certificateSelect += "</select>";
            certificateSelect += "</span>";
        },
        error : function(XmlHttpRequest, textStatus, errorThrown) {
            top.layer.alert('数据保存失败');
        }
    });
}

function copyPlanItem(obj) {
    var rows = obj.parentNode.parentNode.rowIndex;
    $("#plan-list > tbody").append($("table tr").eq(rows).clone());
}

function removePlanItem(obj) {
    top.layer.confirm('确认要删除吗？',function(index){
        obj.parentNode.parentNode.remove();
        top.layer.close(index);
    });
}