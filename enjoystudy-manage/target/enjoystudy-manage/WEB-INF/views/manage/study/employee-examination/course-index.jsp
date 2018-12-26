<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/views/common/meta.jsp" %>
    <%@ include file="/WEB-INF/views/common/javascript.jsp" %>
    <script type="text/javascript" src="<c:url value='/static/js/common/laypage/laypage.js'/>"></script>
    <title>课程管理</title>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i>首页
    <span class="c-gray en">&gt;</span>考试管理
    <span class="c-gray en">&gt;</span>课程考试管理
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>
<div class="page-container">
    <div class="text-c">
        课程编号: <input type="text" class="input-text" id="code" name="code" placeholder="课程编号" maxlength="50" style="width: 100px;">
        课程名称: <input type="text" class="input-text" id="name" name="name" placeholder="课程名称" maxlength="200" style="width: 100px;">
        <button id="searchBotton" type="button" class="btn btn-success">
            <i class="Hui-iconfont">&#xe665;</i>搜索
        </button>
    </div>

    <table id="dataTableList" class="table table-border table-bordered table-hover table-bg table-sort">
        <thead>
        <tr class="text-c">
            <th scope="col" colspan="13" align="center">课程管理</th>
        </tr>
        <tr class="text-c">
            <th>课程名称</th>
            <th width="60">总分</th>
            <th width="60">合格分数</th>
            <th width="60">时长</th>
            <th width="60">补考次数</th>
            <th width="60">考题数</th>
            <th width="80">操作</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>
</div>

<div id="pageNav"></div>

<script type="text/javascript" src="<c:url value='/static/js/templates/manage/study/employee-examination/course-index.js'/>"></script>
</body>
</html>