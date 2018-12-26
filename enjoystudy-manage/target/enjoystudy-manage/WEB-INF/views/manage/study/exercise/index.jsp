<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/views/common/meta.jsp" %>
    <%@ include file="/WEB-INF/views/common/javascript.jsp" %>
    <script type="text/javascript" src="<c:url value='/static/js/common/laypage/laypage.js'/>"></script>
    <title>课程练习题管理</title>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i>首页
    <span class="c-gray en">&gt;</span>学习中心
    <span class="c-gray en">&gt;</span>练习题管理
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>
<div class="page-container">
    <div class="text-c">
        标题: <input type="text" class="input-text" id="title" name="title" placeholder="标题" maxlength="300" style="width: 300px;">
        <button id="searchBotton" type="button" class="btn btn-success">
            <i class="Hui-iconfont">&#xe665;</i>搜索
        </button>
    </div>

    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a class="btn btn-primary radius" onclick="exercise.add();" href="javascript:void(0);"><i class="Hui-iconfont">&#xe600;</i> 添加</a>
        </span>
    </div>

    <table id="dataTableList" class="table table-border table-bordered table-hover table-bg table-sort">
        <thead>
        <tr class="text-c">
            <th scope="col" colspan="9" align="center">练习题管理</th>
        </tr>
        <tr class="text-c">
            <th width="200">课程</th>
            <th>标题</th>
            <th width="80">类型</th>
            <th width="80">分值</th>
            <th width="100">操作</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>
</div>

<div id="pageNav"></div>

<script type="text/javascript" src="<c:url value='/static/js/templates/manage/study/exercise/exercise-index.js'/>"></script>
</body>
</html>