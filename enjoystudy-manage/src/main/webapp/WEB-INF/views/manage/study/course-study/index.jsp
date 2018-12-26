<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/views/common/meta.jsp" %>
    <%@ include file="/WEB-INF/views/common/javascript.jsp" %>
    <script type="text/javascript" src="<c:url value='/static/js/common/laypage/laypage.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/js/common/moment/moment.js'/>"></script>
    <title>课程视频学习</title>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i>首页
    <span class="c-gray en">&gt;</span>学习中心
    <span class="c-gray en">&gt;</span>课程视频学习
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>
<div class="page-container">
    <div class="text-c">
        所属课程：<span class="select-box inline">
            <select id="courseId" name="courseId" class="select">
                <option value="">全部</option>
                <c:forEach var="course" items="${courseList}">
                    <option value="${course.id}">${course.name}</option>
                </c:forEach>
            </select>
        </span>
        视频名称: <input type="text" class="input-text" id="videoName" name="videoName" placeholder="视频名称" maxlength="300" style="width: 300px;">
        <button id="searchBotton" type="button" class="btn btn-success">
            <i class="Hui-iconfont">&#xe665;</i>搜索
        </button>
    </div>

    <table id="dataTableList" class="table table-border table-bordered table-hover table-bg table-sort">
        <thead>
        <tr class="text-c">
            <th scope="col" colspan="9" align="center">课程视频学习</th>
        </tr>
        <tr class="text-c">
            <th width="200">所属课程</th>
            <th>视频名称</th>
            <th width="80">学习次数</th>
            <th width="120">学习时间</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>
</div>

<div id="pageNav"></div>

<script type="text/javascript" src="<c:url value='/static/js/templates/manage/study/course-study/study-index.js'/>"></script>
</body>
</html>