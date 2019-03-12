<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/views/common/meta.jsp" %>
    <%@ include file="/WEB-INF/views/common/javascript.jsp" %>
    <script type="text/javascript" src="<c:url value='/static/js/common/laypage/laypage.js'/>"></script>
    <title>课程培训管理</title>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i>首页
    <span class="c-gray en">&gt;</span>学习中心
    <span class="c-gray en">&gt;</span>课程培训管理
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>
<div class="page-container">
    <div class="text-c">
        课程名称: <input type="text" class="input-text" id="courseName" name="courseName" placeholder="课程名称" maxlength="300" style="width: 200px;">
        <button id="searchBotton" type="button" class="btn btn-success">
            <i class="Hui-iconfont">&#xe665;</i>搜索
        </button>
    </div>

    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a class="btn btn-primary radius" onclick="plan.add();" href="javascript:void(0);"><i class="Hui-iconfont">&#xe600;</i> 添加</a>
        </span>
    </div>

    <table id="dataTableList" class="table table-border table-bordered table-hover table-bg table-sort">
        <thead>
        <tr class="text-c">
            <th scope="col" colspan="9" align="center">课程培训管理</th>
        </tr>
        <tr class="text-c">
            <th width="200">培训课程名称</th>
            <th width="200">培训单位名称</th>
            <th>培训地址</th>
            <th width="120">联系人姓名</th>
            <th width="120">培训师姓名</th>
            <th width="120">开始时间</th>
            <th width="120">结束时间</th>
            <th width="40">状态</th>
            <th width="60">操作</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>
</div>

<div id="pageNav"></div>
<script type="text/javascript" src="<c:url value='/static/js/common/moment/moment.js'/>" charset="utf-8"></script>
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/web/course-train-plan/plan-index.js'/>" charset="utf-8"></script>
</body>
</html>