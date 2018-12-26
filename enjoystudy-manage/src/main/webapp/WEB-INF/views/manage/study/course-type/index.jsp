<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/views/common/meta.jsp" %>
    <%@ include file="/WEB-INF/views/common/javascript.jsp" %>
    <link rel="stylesheet" type="text/css" href="<c:url value='/static/js/common/treetable/css/jquery.treetable.css'/>"/>
    <script type="text/javascript" src="<c:url value='/static/js/common/treetable/jquery.treetable.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/js/common/laypage/laypage.js'/>"></script>
    <title>课程分类管理</title>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i>首页
    <span class="c-gray en">&gt;</span>学习中心
    <span class="c-gray en">&gt;</span>课程分类管理
    <a class="btn btn-refresh btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>
<div class="page-container">
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a class="btn btn-primary radius" onclick="courseType.add('0');" href="javascript:void(0);">
                <i class="Hui-iconfont">&#xe600;</i> 添加
            </a>
        </span>
    </div>

    <table id="dataTableList" class="table table-border table-bordered table-hover table-bg table-sort">
        <thead>
        <tr class="text-c">
            <th scope="col" colspan="9" align="center">课程分类管理</th>
        </tr>
        <tr class="text-c">
            <th>课程分类名称</th>
            <th width="200">操作</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>
</div>
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/study/course-type/type-index.js'/>" charset="utf-8"></script>
</body>
</html>