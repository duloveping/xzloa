<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/views/common/meta.jsp" %>
    <%@ include file="/WEB-INF/views/common/javascript.jsp" %>
    <script type="text/javascript" src="<c:url value='/static/js/common/laypage/laypage.js'/>"></script>
    <title>考卷管理</title>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i>首页
    <span class="c-gray en">&gt;</span>考卷管理
    <span class="c-gray en">&gt;</span>考卷审核
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>

<div class="page-container">
    <div class="text-c">
        考卷标题: <input type="text" class="input-text" id="title" name="title" placeholder="考卷标题" maxlength="50" style="width: 100px;">
        所属课程: <span class="select-box" style="width:100px">
			<select class="select" id="courseId" name="courseId" size="1">
                <option value="">全部</option>
                <c:forEach var="course" items="${courseList}">
                    <option value="${course.id}">${course.name}</option>
                </c:forEach>
			</select>
			</span>
        <button id="searchBotton" type="button" class="btn btn-success">
            <i class="Hui-iconfont">&#xe665;</i>搜索
        </button>
    </div>

    <table id="dataTableList" class="table table-border table-bordered table-hover table-bg table-sort">
        <thead>
        <tr class="text-c">
            <th scope="col" colspan="8" align="center">考卷管理</th>
        </tr>
        <tr class="text-c">
            <th>标题</th>
            <th width="60">时长</th>
            <th width="60">题目数</th>
            <th width="60">总分数</th>
            <th width="60">合格分数</th>
            <th width="60">补考次数</th>
            <th width="60">操作</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>
</div>

<div id="pageNav"></div>

<script type="text/javascript" src="<c:url value='/static/js/templates/manage/study/store-paper/audit-index.js'/>"></script>
</body>
</html>