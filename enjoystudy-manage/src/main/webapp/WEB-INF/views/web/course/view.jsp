<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <title>${course.name}</title>
    <link href="<c:url value='/static/js/templates/web/index/Style2018.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/static/js/templates/web/index/css.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/static/js/templates/web/index/lrtk.css'/>" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="/WEB-INF/views/web/index/header-top.jsp" %>
<%@ include file="/WEB-INF/views/web/index/header-navigation.jsp" %>
<table border="0" cellpadding="0" cellspacing="0" style="width:1200px; margin:0px auto; margin-top:20px;">
    <tbody>
        <tr>
            <td colspan="2" valign="top" style="border-bottom:1px dashed #c8c8c8;">
                <div style="width:100%; height:45px; line-height:45px; border-bottom:2px solid #eeeeee;">
                    <div class="LmIcon"></div>
                    <div class="LmTitle"><span style="font-size:16px;">课程详情</span></div>
                </div>
                <table border="0" cellpadding="3" cellspacing="0" class="KCDetailTable" style="margin-bottom:20px;">
                    <tbody>
                        <tr>
                            <td rowspan="9" valign="middle" style="width:330px; text-align:center; border:1px solid #eeeeee;">
                                <img src="<c:url value='${course.image}'/>" style="width:310px; height:206px;">
                            </td>
                            <td class="KCListTableTdValue">
                                <a href="javascript:void(0)" target="_blank" style="color:#cc3300; font-size:20px; margin-left:20px;">${course.name}</a>
                            </td>
                        </tr>
                        <tr>
                            <td class="KCListTableTdValue">
                                <span style="margin-left:20px;">
                                    价格：<span style="color:#ff2832; font-size:20px; font-weight:bold; margin-right:3px;">
                                        ￥<fmt:formatNumber value="${course.currentPrice}" pattern="##0.00" />
                                    </span>元
                                </span>
                                <span>学时：${fn:length(videoList)}</span>
                            </td>
                        </tr>
                        <tr>
                            <td class="KCListTableTdValue">
                                <span style="margin-left:20px;">
                                    课程分类：<a href="javascript:void(0)">${courseType.name}</a>
                                </span>
                            </td>
                        </tr>
                        <tr>
                            <td class="KCListTableTdValue">
                                <%-- <span style="margin-left:20px;">年度：<a href="javascript:void(0)">2017年度课程</a></span> --%>
                                <span>上传日期：<fmt:formatDate value="${course.createTime}" pattern="yyyy-MM-dd"/> </span>
                            </td>
                        </tr>
                        <%--
                        <tr>
                            <td class="KCListTableTdValue">
                                <span style="margin-left:20px;">现在购买此课程，学习时间将会在2020-09-08到期，到期后将不能继续学习。</span>
                            </td>
                        </tr>
                        --%>
                        <tr>
                            <td class="KCListTableTdValue">
                                <span style="margin-left:20px;">评价：
                                    <img src="<c:url value="/static/js/templates/web/index/PingJia-lingxing.jpg"/>" style="vertical-align:bottom;">
                                    （已有0人进行评价）
                                </span>
                            </td>
                        </tr>
                        <tr>
                            <td class="KCListTableTdValue">
                                <span style="margin-left:20px;">购买数量：
                                    1<input type="hidden" id="BuyCount" name="BuyCount" value="1">
                                </span>
                            </td>
                        </tr>
                        <tr>
                            <td class="KCListTableTdValue" style="height:50px;">
                                <img src="<c:url value="/static/js/templates/web/index/JoinGwcButton.jpg"/>" style="margin-right:20px; cursor:pointer; margin-left:20px;" onclick="BuyIt('${course.id}')">
                                <img src="<c:url value="/static/js/templates/web/index/ShoucangButton.jpg"/>" style="margin-right:20px; cursor:pointer;">
                            </td>
                        </tr>
                    </tbody>
                </table>
            </td>
        </tr>
        <tr>
            <td valign="top" style="width:180px;">
                <div class="ShopCatBox" style="margin-top:26px;" onclick="location.href='/User/ShopCart/'">
                    <div class="ShopcarImg"><img src="<c:url value="/static/js/templates/web/index/shopcar.png"/>"></div>
                    <div class="ShopcarTxt"><span>我的购物车</span></div>
                    <div class="ShopcarCount"><span>0</span></div>
                    <div class="ShopcarIcon"><img src="<c:url value="/static/js/templates/web/index/shopcarIcon.jpg"/>"></div>
                </div>

                <div class="LeRecommendBox">
                    <div class="LeRecommendTitleBox">
                        <div class="LeRecommendTitle">
                            <span>热门课程</span>
                        </div>
                    </div>
                    <c:forEach var="hotCourse" items="${hotCourseList}">
                        <div class="LeIItemBox">
                            <div class="LeIItemImg">
                                <a href="<c:url value='/web/course/view.jhtml?id=${hotCourse.id}'/>" target="_blank" title="${hotCourse.name}">
                                    <img src="<c:url value='${hotCourse.image}'/>" alt="${hotCourse.name}">
                                </a>
                            </div>
                            <div class="LeIITemTitle">
                                <a href="<c:url value='/web/course/view.jhtml?id=${hotCourse.id}'/>" target="_blank" title="${hotCourse.name}">${hotCourse.name}</a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </td>
            <td valign="top">
                <div style="width:96%; height:50px; line-height:50px; margin-left:25px; margin-top:20px;">
                    <div style="width:120px; height:50px; line-height:50px; float:left;" id="gkAra"><span onclick="LessonTagChange('gk')" style="font-size:16px; font-weight:bold; color:#2ba485;">课程概况</span></div>
                    <div style="width:120px; height:50px; line-height:50px; float:left;" id="mlAra"><span onclick="LessonTagChange('ml')" style="font-size:18px; color:#969696; cursor:pointer;">课程目录</span></div>
                    <div style="width:120px; height:50px; line-height:50px; float:left;" id="teAra"><span onclick="LessonTagChange('te')" style="font-size:16px; color:#969696; cursor:pointer;">主讲教师</span></div>
                    <div style="width:120px; height:50px; line-height:50px; float:left;" id="obAra"><span onclick="LessonTagChange('ob')" style="font-size:16px; color:#969696; cursor:pointer;">适用对象</span></div>
                    <div style="width:120px; height:50px; line-height:50px; float:left;" id="pjAra"><span onclick="LessonTagChange('pj')" style="font-size:16px; color:#969696; cursor:pointer;">课程评价</span></div>
                </div>
                <div id="gkDetailArea" style="width: 96%; min-height: 100px; height: auto; margin-left: 25px; margin-top: 20px; display: block;">
                    <table border="0" cellpadding="3" cellspacing="0" class="KCDetailTable">
                        <tbody>
                            <tr>
                                <td class="KCListTableTdValue"><span style="color:#333333; font-size:16px; font-weight:bold;">主要内容</span></td>
                            </tr>
                            <tr>
                                <td class="KCListTableTdValue" style="line-height:25px; border-bottom:2px dotted #c8c8c8;">${course.description}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div id="mlDetailArea" style="width: 96%; min-height: 100px; height: auto; margin-left: 25px; margin-top: 20px; display: none;">
                    <table border="0" cellpadding="3" cellspacing="0" class="KCDetailTable">
                        <tbody>
                            <tr>
                                <td colspan="2" style="height:35px;"><span style="color:#ff7c24;">提示：请先购买该课程后，点击“进入学习平台”-“已购买课程”栏目中，点击【开始学习】按钮，进行在线学习。</span></td>
                            </tr>
                            <c:forEach var="video" items="${videoList}">
                                <tr>
                                    <td style="width:21px;"><a href="<c:url value="/web/course-video/view.jhtml?id=${video.id}"/>" target="_blank"><img src="<c:url value="${video.image}"/>" style="margin-right:5px; vertical-align:middle; width: 50px; height: 50px;"></a></td>
                                    <td><a href="<c:url value="/web/course-video/view.jhtml?id=${video.id}"/>" target="_blank"><span style="font-size:15px; color:#666;">${video.name}</span></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div id="teDetailArea" style="width: 96%; min-height: 100px; height: auto; margin-left: 25px; margin-top: 20px; display: none;">
                    <table border="0" cellpadding="3" cellspacing="0" class="KCDetailTable">
                        <tbody>
                            <tr>
                                <td style="width:21px;"><img src="<c:url value="${teacher.image}"/>" style="margin-right:5px; vertical-align:middle; width: 50px; height: 50px;"></td>
                                <td><span style="font-size:15px; color:#666;">${teacher.fullName}</span></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div id="obDetailArea" style="width:96%; min-height:100px; height:auto; margin-left:25px; margin-top:20px; display:none;">
                    <table border="0" cellpadding="3" cellspacing="0" class="KCDetailTable">
                        <tbody>
                            <tr>
                                <td class="KCListTableTdValue" style="border-bottom:2px dotted #c8c8c8; line-height:25px;">
                                    <p>
                                        <span style="color:#515151; font-size:15px;">各体系继续教育人员</span>
                                    </p>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div id="pjDetailArea" style="width:96%; min-height:100px; height:auto; margin-left:25px; margin-top:20px;display:none;">
                    <table border="0" cellpadding="3" cellspacing="0" class="KCDetailTable">
                        <tbody><tr>
                            <td class="KCListTableTdValue"><span style="color:#333333; font-size:16px; font-weight:bold;">评价</span></td>
                        </tr>
                        <tr>
                            <td class="KCListTableTdValue" style="line-height:25px;">
                                <div id="CommentArea" style="width:100%;"></div>
                                <table border="0" cellpadding="0" cellspacing="0" style="width:100%; border-bottom:1px dotted #c8c8c8; margin-top:10px;">
                                    <tbody><tr>
                                        <td>
                                            <input type="radio" name="rb" value="1"><img src="<c:url value="/static/js/templates/web/index/PingJia-yixing.jpg"/>" style="vertical-align:middle; margin-left:7px;">
                                            <input type="radio" name="rb" value="2" style="margin-left:15px;"><img src="<c:url value="/static/js/templates/web/index/PingJia-erxing.jpg"/>" style="vertical-align:middle; margin-left:7px;">
                                            <input type="radio" name="rb" value="3" style="margin-left:15px;"><img src="<c:url value="/static/js/templates/web/index/PingJia-sanxing.jpg"/>" style="vertical-align:middle; margin-left:7px;">
                                            <input type="radio" name="rb" value="4" style="margin-left:15px;"><img src="<c:url value="/static/js/templates/web/index/PingJia-sixing.jpg"/>" style="vertical-align:middle; margin-left:7px;">
                                            <input type="radio" name="rb" value="5" style="margin-left:15px;"><img src="<c:url value="/static/js/templates/web/index/PingJia.jpg"/>" style="vertical-align:middle; margin-left:7px;">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><textarea id="Content" name="Content" style="width:80%; height:100px;"></textarea></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input type="hidden" id="LessonID" name="LessonID" value="169">
                                            <div onclick="commit()" style="width:100px; height:22px; line-height:22px; text-align:center; margin-top:10px; margin-bottom:10px; background-color:#f26e0c; cursor:pointer;">
                                                <span style="color:#fff; font-size:14px;">提交评价</span>
                                            </div>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </td>
                        </tr>
                        </tbody></table>
                </div>
            </td>
        </tr>
    </tbody>
</table>
<%@ include file="/WEB-INF/views/web/index/fooder.jsp" %>
<script type="text/javascript" src="<c:url value='/static/js/common/jquery/jquery-1.11.3.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/js/templates/web/index/function.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/js/templates/web/index/fordboy.js'/>"></script>
<script type="text/javascript">
    function LessonTagChange(str) {
        if (str == "gk") {
            $("#gkAra").html("<span onclick=\"LessonTagChange('gk')\" style=\"font-size:18px; font-weight:bold; color:#2ba485;\">课程概况</span>");
            $("#mlAra").html("<span onclick=\"LessonTagChange('ml')\" style=\"font-size:16px; color:#969696; cursor:pointer;\">课程目录</span>");
            $("#teAra").html("<span onclick=\"LessonTagChange('te')\" style=\"font-size:16px; color:#969696; cursor:pointer;\">主讲教师</span>");
            $("#obAra").html("<span onclick=\"LessonTagChange('ob')\" style=\"font-size:16px; color:#969696; cursor:pointer;\">适用对象</span>");
            $("#pjAra").html("<span onclick=\"LessonTagChange('pj')\" style=\"font-size:16px; color:#969696; cursor:pointer;\">课程评价</span>");
            $("#gkDetailArea").show(); $("#mlDetailArea").hide(); $("#pjDetailArea").hide(); $("#teDetailArea").hide(); $("#obDetailArea").hide();
        }

        if (str == "ml") {
            $("#gkAra").html("<span onclick=\"LessonTagChange('gk')\" style=\"font-size:16px; color:#969696; cursor:pointer;\">课程概况</span>");
            $("#mlAra").html("<span onclick=\"LessonTagChange('ml')\" style=\"font-size:18px; font-weight:bold; color:#2ba485;\">课程目录</span>");
            $("#teAra").html("<span onclick=\"LessonTagChange('te')\" style=\"font-size:16px; color:#969696; cursor:pointer;\">主讲教师</span>");
            $("#obAra").html("<span onclick=\"LessonTagChange('ob')\" style=\"font-size:16px; color:#969696; cursor:pointer;\">适用对象</span>");
            $("#pjAra").html("<span onclick=\"LessonTagChange('pj')\" style=\"font-size:16px; color:#969696; cursor:pointer;\">课程评价</span>");
            $("#gkDetailArea").hide(); $("#mlDetailArea").show(); $("#pjDetailArea").hide(); $("#teDetailArea").hide(); $("#obDetailArea").hide();
        }

        if (str == "te") {
            $("#gkAra").html("<span onclick=\"LessonTagChange('gk')\" style=\"font-size:16px; color:#969696; cursor:pointer;\">课程概况</span>");
            $("#mlAra").html("<span onclick=\"LessonTagChange('ml')\" style=\"font-size:16px; color:#969696; cursor:pointer;\">课程目录</span>");
            $("#teAra").html("<span onclick=\"LessonTagChange('te')\" style=\"font-size:18px; font-weight:bold; color:#2ba485;\">主讲教师</span>");
            $("#obAra").html("<span onclick=\"LessonTagChange('ob')\" style=\"font-size:16px; color:#969696; cursor:pointer;\">适用对象</span>");
            $("#pjAra").html("<span onclick=\"LessonTagChange('pj')\" style=\"font-size:16px; color:#969696; cursor:pointer;\">课程评价</span>");
            $("#gkDetailArea").hide(); $("#mlDetailArea").hide(); $("#pjDetailArea").hide(); $("#teDetailArea").show(); $("#obDetailArea").hide();
        }

        if (str == "ob") {
            $("#gkAra").html("<span onclick=\"LessonTagChange('gk')\" style=\"font-size:16px; color:#969696; cursor:pointer;\">课程概况</span>");
            $("#mlAra").html("<span onclick=\"LessonTagChange('ml')\" style=\"font-size:16px; color:#969696; cursor:pointer;\">课程目录</span>");
            $("#teAra").html("<span onclick=\"LessonTagChange('te')\" style=\"font-size:16px; color:#969696; cursor:pointer;\">主讲教师</span>");
            $("#obAra").html("<span onclick=\"LessonTagChange('ob')\" style=\"font-size:18px; font-weight:bold; color:#2ba485;\">适用对象</span>");
            $("#pjAra").html("<span onclick=\"LessonTagChange('pj')\" style=\"font-size:16px; color:#969696; cursor:pointer;\">课程评价</span>");
            $("#gkDetailArea").hide(); $("#mlDetailArea").hide(); $("#pjDetailArea").hide(); $("#teDetailArea").hide(); $("#obDetailArea").show();
        }
        //        if (str == "pj") {
        //            $("#gkAra").html("<span onclick=\"LessonTagChange('gk')\" style=\"font-size:16px; color:#969696; cursor:pointer;\">课程概况</span>");
        //            $("#mlAra").html("<span onclick=\"LessonTagChange('ml')\" style=\"font-size:16px; color:#969696; cursor:pointer;\">课程目录</span>");
        //            $("#teAra").html("<span onclick=\"LessonTagChange('te')\" style=\"font-size:16px; color:#969696; cursor:pointer;\">主讲教师</span>");
        //            $("#obAra").html("<span onclick=\"LessonTagChange('ob')\" style=\"font-size:16px; color:#969696; cursor:pointer;\">适用对象</span>");
        //            $("#pjAra").html("<span onclick=\"LessonTagChange('pj')\" style=\"font-size:18px; font-weight:bold; color:#2ba485;\">课程评价</span>");
        //            $("#gkDetailArea").hide(); $("#mlDetailArea").hide(); $("#pjDetailArea").show(); $("#teDetailArea").hide(); $("#obDetailArea").hide();
        //        }
    }
    function CountAdd() {
        var buyCount = $("#BuyCount").val();
        $("#BuyCount").val(parseInt(buyCount) + 1);
    }
    function CountSubtract(id) {
        var buyCount = $("#BuyCount_" + id).val();
        if (parseInt(buyCount) > 1) {
            $("#BuyCount").val(parseInt(buyCount) - 1);
        }
        else {
            $("#BuyCount").val("1");
        }
    }

    function BuyIt(id) {
        location.href = "<c:url value='/web/shop/shopping-cart/add.jhtml'/>?courseId=" + id + "&rnd=" + Math.random();
    }

    function commit() {
        var post = new Object();
        var rb = $('input:radio[name="rb"]:checked').val();
        if (rb == "") {
            alert("请您打分");
            return;
        }
        post.Score = rb;
        post.LessonID = $("#LessonID").val();
        post.Content = $("#Content").val();
        $.post('/User/UserCommentDataSave/?rand=' + new Date().getTime(), post, function (msg) {
            alert(msg.Message);
            if (parseInt(msg.RetCode) >= 0) { location.reload(); }
        }, 'json');
    }
    function CommentDel(id) {
        if (id != null && id != undefined && id != "") {
            if (!confirm('您确认要删除评论么？')) return;
            var post = new Object();
            post.id = id;
            $.post('/User/UserCommentDel/?rand=' + new Date().getTime(), post, function (msg) {
                alert(msg.Message);
                if (parseInt(msg.RetCode) >= 0) { location.reload(); }
            }, 'json');
        }
        else {
            alert("操作异常");
        }
    }
</script>
</body>
</html>