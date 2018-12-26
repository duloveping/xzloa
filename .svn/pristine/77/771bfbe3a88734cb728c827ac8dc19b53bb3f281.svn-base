<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/views/common/meta.jsp" %>
    <%@ include file="/WEB-INF/views/common/javascript.jsp" %>
    <link rel="stylesheet" type="text/css" href="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/icheck/icheck.css'/>" />
    <script type="text/javascript" src="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/icheck/jquery.icheck.min.js'/>"></script>
    <title>考生考试</title>
    <style type="text/css">
        ul.countdown {
            list-style: none;
            padding: 0;
            display: block;
            text-align: center;
        }

        ul.countdown li {
            display: inline-block;
        }

        ul.countdown li span {
            font-size: 80px;
            font-weight: 300;
            line-height: 80px;
        }

        ul.countdown li.seperator {
            font-size: 80px;
            line-height: 70px;
            vertical-align: top;
        }

        ul.countdown li p {
            color: #a7abb1;
            font-size: 12px;
        }

    </style>
</head>
<body>
<article class="page-container">
    <div class="row cl">
        <label class="form-label col-xs-4 col-sm-2">
            <span class="c-red">*</span>剩余时间：
        </label>
        <div class="formControls col-xs-8 col-sm-10">
            <ul class="countdown">
                <li>
                    <span class="days">00</span>
                    <p class="days_ref">天</p>
                </li>
                <li class="seperator">.</li>
                <li>
                    <span class="hours">00</span>
                    <p class="hours_ref">时</p>
                </li>
                <li class="seperator">:</li>
                <li>
                    <span class="minutes">00</span>
                    <p class="minutes_ref">分</p>
                </li>
                <li class="seperator">:</li>
                <li>
                    <span class="seconds">00</span>
                    <p class="seconds_ref">秒</p>
                </li>
            </ul>
        </div>
    </div>
    <div class="row cl">
        <label class="form-label col-xs-4 col-sm-2">
            <span class="c-red">*</span>题目：
        </label>
        <div id="questionList" class="formControls col-xs-8 col-sm-10"></div>
    </div>
    <div class="row cl">
        <label class="form-label col-xs-4 col-sm-2">
            <span class="c-red">*</span>考题：
        </label>
        <div id="question" class="formControls col-xs-8 col-sm-10"></div>
    </div>
    <div class="row cl">
        <label class="form-label col-xs-4 col-sm-2">
            <span class="c-red">*</span>选项：
        </label>
        <div id="itemList" class="formControls col-xs-8 col-sm-10"></div>
    </div>

    <div class="row cl">
        <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
            <input id="previous" class="btn btn-primary radius" type="button" value="上一题">
            <input id="next" class="btn btn-primary radius" type="button" value="下一题">
            <input id="submit" class="btn btn-primary radius" type="button" value="交卷">
            <input id="paperId" name="paperId" type="hidden" value="${paperId}">
        </div>
    </div>
</article>
<script type="text/javascript" src="<c:url value='/static/js/common/moment/moment.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/study/employee-examination/jquery.downCount.js' />"></script>
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/study/employee-examination/paper-test.js' />"></script>
</body>
</html>