<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>${paper.courseName}</title>
    <link href="<c:url value="/static/js/templates/web/test/main.css" />" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/static/js/templates/web/test/iconfont.css" />" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/static/js/templates/web/test/test.css" />" rel="stylesheet" type="text/css" />
    <style>
        .hasBeenAnswer {
            background: #5d9cec;
            color:#fff;
        }
    </style>

</head>
<body>
<div class="main">
    <div class="test_main">
        <div class="nr_left">
            <div class="test">
                <form action="" method="post">
                    <input id="paperId" name="paperId" type="hidden" value="${paper.id}">
                    <input id="list1Amount" name="list1Amount" type="hidden" value="${fn:length(list1)}">
                    <input id="list2Amount" name="list2Amount" type="hidden" value="${fn:length(list2)}">
                    <input id="list4Amount" name="list4Amount" type="hidden" value="${fn:length(list4)}">
                    <div class="test_title">
                        <p class="test_time">
                            <i class="icon iconfont">&#xe6fb;</i><b class="alt-1">01:40</b>
                        </p>
                        <font><input id="test_jiaojuan" type="button" name="test_jiaojuan" value="交卷"></font>
                    </div>

                    <c:if test="${not empty list1}">
                        <div class="test_content">
                            <div class="test_content_title">
                                <h2>单选题</h2>
                                <p>
                                    <span>共</span><i class="content_lit">${fn:length(list1)}</i><span>题，</span>
                                    <c:set var="total1" value="0"/>
                                    <c:forEach var="question" items="${list1}" varStatus="status">
                                        <c:set var="total1" value="${total1 + question.score}"/>
                                    </c:forEach>
                                    <span>合计</span><i class="content_fs">${total1}</i><span>分</span>
                                </p>
                            </div>
                        </div>
                        <div class="test_content_nr">
                            <ul>
                                <c:forEach var="question" items="${list1}" varStatus="status">
                                    <li id="qu_1_${status.index}" data-id="${question.id}">
                                        <div class="test_content_nr_tt">
                                            <i>${status.count}</i><span>(${question.score}分)</span><font>${question.title}</font><b class="icon iconfont">&#xe881;</b>
                                        </div>
                                        <div class="test_content_nr_main">
                                            <ul>
                                                <c:forEach var="answer" items="${question.itemList}" varStatus="answerStatus">
                                                <li class="option">
                                                    <input type="radio" class="radioOrCheck" name="1_answer_${status.index}" id="1_answer_${status.index}_option_${answerStatus.index}" value="${answer.id}" <c:if test="${answer.checkState}">checked="checked"</c:if>/>
                                                    <label for="1_answer_${status.index}_option_${answerStatus.index}">
                                                        <c:choose>
                                                            <c:when test="${answerStatus.index == 0}">A.</c:when>
                                                            <c:when test="${answerStatus.index == 1}">B.</c:when>
                                                            <c:when test="${answerStatus.index == 2}">C.</c:when>
                                                            <c:when test="${answerStatus.index == 3}">D.</c:when>
                                                            <c:when test="${answerStatus.index == 4}">E.</c:when>
                                                            <c:when test="${answerStatus.index == 5}">F.</c:when>
                                                            <c:when test="${answerStatus.index == 6}">G.</c:when>
                                                            <c:when test="${answerStatus.index == 7}">H.</c:when>
                                                            <c:when test="${answerStatus.index == 8}">I.</c:when>
                                                        </c:choose>
                                                        <p class="ue" style="display: inline;">${answer.title}</p>
                                                    </label>
                                                </li>
                                                </c:forEach>
                                            </ul>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </c:if>

                    <c:if test="${not empty list2}">
                        <div class="test_content">
                            <div class="test_content_title">
                                <h2>多选题</h2>
                                <p>
                                    <span>共</span><i class="content_lit">${fn:length(list2)}</i><span>题，</span>
                                    <c:set var="total1" value="0"/>
                                    <c:forEach var="question" items="${list2}" varStatus="status">
                                        <c:set var="total1" value="${total1 + question.score}"/>
                                    </c:forEach>
                                    <span>合计</span><i class="content_fs">${total1}</i><span>分</span>
                                </p>
                            </div>
                        </div>
                        <div class="test_content_nr">
                            <ul>
                                <c:forEach var="question" items="${list2}" varStatus="status">
                                    <li id="qu_2_${status.index}" data-id="${question.id}">
                                        <div class="test_content_nr_tt">
                                            <i>${status.count}</i><span>(${question.score}分)</span><font>${question.title}</font><b class="icon iconfont">&#xe881;</b>
                                        </div>
                                        <div class="test_content_nr_main">
                                            <ul>
                                                <c:forEach var="answer" items="${question.itemList}" varStatus="answerStatus">
                                                    <li class="option">
                                                        <input type="checkbox" class="radioOrCheck" name="2_answer_${status.index}" id="2_answer_${status.index}_option_${answerStatus.index}" value="${answer.id}" <c:if test="${answer.checkState}">checked="checked"</c:if>/>
                                                        <label for="2_answer_${status.index}_option_${answerStatus.index}">
                                                            <c:choose>
                                                                <c:when test="${answerStatus.index == 0}">A.</c:when>
                                                                <c:when test="${answerStatus.index == 1}">B.</c:when>
                                                                <c:when test="${answerStatus.index == 2}">C.</c:when>
                                                                <c:when test="${answerStatus.index == 3}">D.</c:when>
                                                                <c:when test="${answerStatus.index == 4}">E.</c:when>
                                                                <c:when test="${answerStatus.index == 5}">F.</c:when>
                                                                <c:when test="${answerStatus.index == 6}">G.</c:when>
                                                                <c:when test="${answerStatus.index == 7}">H.</c:when>
                                                                <c:when test="${answerStatus.index == 8}">I.</c:when>
                                                            </c:choose>
                                                            <p class="ue" style="display: inline;">${answer.title}</p>
                                                        </label>
                                                    </li>
                                                </c:forEach>
                                            </ul>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </c:if>

                    <c:if test="${not empty list4}">
                        <div class="test_content">
                            <div class="test_content_title">
                                <h2>判断题</h2>
                                <p>
                                    <span>共</span><i class="content_lit">${fn:length(list4)}</i><span>题，</span>
                                    <c:set var="total1" value="0"/>
                                    <c:forEach var="question" items="${list4}" varStatus="status">
                                        <c:set var="total1" value="${total1 + question.score}"/>
                                    </c:forEach>
                                    <span>合计</span><i class="content_fs">${total1}</i><span>分</span>
                                </p>
                            </div>
                        </div>
                        <div class="test_content_nr">
                            <ul>
                                <c:forEach var="question" items="${list4}" varStatus="status">
                                    <li id="qu_4_${status.index}" data-id="${question.id}">
                                        <div class="test_content_nr_tt">
                                            <i>${status.count}</i><span>(${question.score}分)</span><font>${question.title}</font><b class="icon iconfont">&#xe881;</b>
                                        </div>
                                        <div class="test_content_nr_main">
                                            <ul>
                                                <c:forEach var="answer" items="${question.itemList}" varStatus="answerStatus">
                                                    <li class="option">
                                                        <input type="radio" class="radioOrCheck" name="4_answer_${status.index}" id="4_answer_${status.index}_option_${answerStatus.index}" value="${answer.id}" <c:if test="${answer.checkState}">checked="checked"</c:if>/>
                                                        <label for="4_answer_${status.index}_option_${answerStatus.index}">
                                                            <c:choose>
                                                                <c:when test="${answerStatus.index == 0}">A.</c:when>
                                                                <c:when test="${answerStatus.index == 1}">B.</c:when>
                                                            </c:choose>
                                                            <p class="ue" style="display: inline;">${answer.title}</p>
                                                        </label>
                                                    </li>
                                                </c:forEach>
                                            </ul>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </c:if>
                </form>
            </div>

        </div>
        <div class="nr_right">
            <div class="nr_rt_main">
                <div class="rt_nr1">
                    <div class="rt_nr1_title">
                        <h1>
                            <i class="icon iconfont">&#xe692;</i>答题卡
                        </h1>
                        <p class="test_time">
                            <i class="icon iconfont">&#xe6fb;</i><b class="alt-1">01:40</b>
                        </p>
                    </div>

                    <c:if test="${not empty list1}">
                    <div class="rt_content">
                        <div class="rt_content_tt">
                            <h2>单选题</h2>
                            <p>
                                <span>共</span><i class="content_lit">${fn:length(list1)}</i><span>题</span>
                            </p>
                        </div>
                        <div class="rt_content_nr answerSheet">
                            <ul>
                                <c:forEach var="question" items="${list1}" varStatus="status">
                                    <c:set var="selectState" value="false"/>
                                    <c:forEach var="answer" items="${question.itemList}" varStatus="answerStatus">
                                        <c:if test="${answer.checkState}">
                                            <c:set var="selectState" value="true"/>
                                        </c:if>
                                    </c:forEach>
                                    <li><a id="answer_sheet_item_1_${status.count}" href="#qu_1_${status.index}" <c:if test="${selectState}">class="hasBeenAnswer"</c:if>>${status.count}</a></li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    </c:if>

                    <c:if test="${not empty list2}">
                        <div class="rt_content">
                            <div class="rt_content_tt">
                                <h2>多选题</h2>
                                <p>
                                    <span>共</span><i class="content_lit">${fn:length(list2)}</i><span>题</span>
                                </p>
                            </div>
                            <div class="rt_content_nr answerSheet">
                                <ul>
                                    <c:forEach var="question" items="${list2}" varStatus="status">
                                        <c:set var="selectState" value="false"/>
                                        <c:forEach var="answer" items="${question.itemList}" varStatus="answerStatus">
                                            <c:if test="${answer.checkState}">
                                                <c:set var="selectState" value="true"/>
                                            </c:if>
                                        </c:forEach>
                                        <li><a id="answer_sheet_item_2_${status.count}" href="#qu_2_${status.index}" <c:if test="${selectState}">class="hasBeenAnswer"</c:if>>${status.count}</a></li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </c:if>

                    <c:if test="${not empty list4}">
                        <div class="rt_content">
                            <div class="rt_content_tt">
                                <h2>判断题</h2>
                                <p>
                                    <span>共</span><i class="content_lit">${fn:length(list4)}</i><span>题</span>
                                </p>
                            </div>
                            <div class="rt_content_nr answerSheet">
                                <ul>
                                    <c:forEach var="question" items="${list4}" varStatus="status">
                                        <c:set var="selectState" value="false"/>
                                        <c:forEach var="answer" items="${question.itemList}" varStatus="answerStatus">
                                            <c:if test="${answer.checkState}">
                                                <c:set var="selectState" value="true"/>
                                            </c:if>
                                        </c:forEach>
                                        <li><a id="answer_sheet_item_4_${status.count}" href="#qu_4_${status.index}" <c:if test="${selectState}">class="hasBeenAnswer"</c:if>>${status.count}</a></li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </c:if>

                </div>

            </div>
        </div>
    </div>
    <!--nr end-->
    <div class="foot"></div>
</div>
<script type="application/javascript" src="<c:url value="/static/js/common/jquery/jquery-1.11.3.min.js" />"></script>
<script type="application/javascript" src="<c:url value="/static/js/templates/web/test/jquery.easy-pie-chart.js" />"></script>
<script type="application/javascript" src="<c:url value="/static/js/templates/web/test/jquery.countdown.js" />"></script>
<script type="application/javascript" src="<c:url value="/static/js/common/layer/layer.js" />"></script>
<script>
    window.jQuery(function($) {
        "use strict";

        $('time').countDown({
            with_separators : false
        });
        $('.alt-1').countDown({
            css_class : 'countdown-alt-1'
        });
        $('.alt-2').countDown({
            css_class : 'countdown-alt-2'
        });

    });


    $(function() {
        $('li.option label,input').click(function() {
            var examId = $(this).closest('.test_content_nr_main').closest('li').attr('id'); // 得到题目ID
            var cardLi = $('a[href=#' + examId + ']'); // 根据题目ID找到对应答题卡
            // 设置已答题
            if(!cardLi.hasClass('hasBeenAnswer')){
                cardLi.addClass('hasBeenAnswer');
            }
        });

        $("#test_jiaojuan").on("click", function () {
            var yesAmount = 0;
            var noAmount = 0;
            var list1Amount = parseInt($("#list1Amount").val());
            var list2Amount = parseInt($("#list2Amount").val());
            var list4Amount = parseInt($("#list4Amount").val());

            var questionList = new Array();

            var i1 = 0;
            while (i1 < list1Amount) {
                var itemList = new Array();
                $.each($("input[type=radio][name=1_answer_" + i1 + "]"), function(i, v){
                    var item = {id: v.value, checkState: v.checked};
                    itemList.push(item)
                });

                var question = {id: $("#qu_1_" + i1).attr("data-id"), itemList: itemList};
                questionList.push(question);

                if ($("#answer_sheet_item_1_" + (i1 + 1)).hasClass('hasBeenAnswer')) {
                    yesAmount += 1;
                } else {
                    noAmount += 1;
                }

                i1++;
            }

            var i2 = 0;
            while (i2 < list2Amount) {
                var itemList = new Array();
                $.each($("input[type=radio][name=2_answer_" + i2 + "]"), function(i, v){
                    var item = {id: v.value, checkState: v.checked};
                    itemList.push(item)
                });

                var question = {id: $("#qu_2_" + i2).attr("data-id"), itemList: itemList};
                questionList.push(question);

                if ($("#answer_sheet_item_2_" + (i2 + 1)).hasClass('hasBeenAnswer')) {
                    yesAmount += 1;
                } else {
                    noAmount += 1;
                }
                i2++;
            }

            var i4 = 0;
            while (i4 < list4Amount) {
                var itemList = new Array();
                $.each($("input[type=radio][name=4_answer_" + i4 + "]"), function(i, v){
                    var item = {id: v.value, checkState: v.checked};
                    itemList.push(item)
                });

                var question = {id: $("#qu_4_" + i4).attr("data-id"), itemList: itemList};
                questionList.push(question);

                if ($("#answer_sheet_item_4_" + (i4 + 1)).hasClass('hasBeenAnswer')) {
                    yesAmount += 1;
                } else {
                    noAmount += 1;
                }
                i4++;
            }

            var paper = {id: $("#paperId").val(), questionList: questionList};

            if (noAmount > 0) {
                layer.confirm('您还有' + noAmount + '条题没做，确定要交卷吗？',function(index){
                    submitPaper(paper);
                    layer.close(index);
                });
            } else {
                layer.confirm('您确定要交卷吗？',function(index){
                    submitPaper(paper);
                    layer.close(index);
                });
            }

        });
    });

    function submitPaper(paper) {
        var loadIndex = layer.load();

        $.ajax({
            type : "post",
            url : "/manage/study/employee-examination/save-paper.jhtml",
            cache : false,
            data: JSON.stringify(paper),
            dataType : "json",
            contentType : 'application/json;charset=UTF-8',
            success : function(res){
                layer.close(loadIndex);
                layer.alert(res.info);

            },
            error : function(XmlHttpRequest, textStatus, errorThrown) {
                layer.close(loadIndex);
                layer.alert('系统出错了');
            }
        });
    }
</script>

<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
    <p>适用浏览器：360、FireFox、Chrome、Safari、Opera、傲游、搜狗、世界之窗. 不支持IE8及以下浏览器。</p>
</div>
</body>
</html>

