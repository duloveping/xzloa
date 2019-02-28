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
    <span class="c-gray en">&gt;</span>学习中心
    <span class="c-gray en">&gt;</span>课程管理
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>
<div class="page-container">
    <div class="text-c">
        课程编号: <input type="text" class="input-text" id="code" name="code" placeholder="课程编号" maxlength="50" style="width: 100px;">
        课程名称: <input type="text" class="input-text" id="name" name="name" placeholder="课程名称" maxlength="200" style="width: 100px;">
        <input id="typeId" name="typeId" type="hidden" value="">
        课程分类 : <input type="text" class="input-text" id="typeName" name="typeName" placeholder="课程分类" readonly="readonly" style="width: 100px;" onclick="showCourseTypeSingleDialog($('#typeId').val())">
        授课老师: <span class="select-box" style="width:100px">
			<select class="select" name="teacherId" id="teacherId" size="1">
                <option value="">全部</option>
                <c:forEach var="teacher" items="${teachers}">
                    <option value="${teacher.id}">${teacher.fullName}</option>
                </c:forEach>
			</select>
			</span>
        <button id="searchBotton" type="button" class="btn btn-success">
            <i class="Hui-iconfont">&#xe665;</i>搜索
        </button>
    </div>

    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a class="btn btn-primary radius" onclick="course.add();" href="javascript:void(0);"><i class="Hui-iconfont">&#xe600;</i> 添加</a>
        </span>
    </div>

    <table id="dataTableList" class="table table-border table-bordered table-hover table-bg table-sort">
        <thead>
        <tr class="text-c">
            <th scope="col" colspan="9" align="center">课程管理</th>
        </tr>
        <tr class="text-c">
            <th width="150">分类名称</th>
            <th width="150">课程编号</th>
            <th width="150">课程名称</th>
            <th width="150">授课老师</th>
            <th width="100">市价</th>
            <th width="100">现价</th>
            <th width="100">促销价</th>
            <th>简介</th>
            <th width="100">操作</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>
</div>

<div id="pageNav"></div>

<script type="text/javascript" src="<c:url value='/static/js/templates/manage/study/course/course-index.js'/>"></script>
</body>
</html>