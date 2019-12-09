<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/views/common/meta.jsp" %>
    <%@ include file="/WEB-INF/views/common/javascript.jsp" %>
    <script type="text/javascript" src="<c:url value='/static/js/common/laypage/laypage.js'/>"></script>
    <title>我的课程</title>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i>首页
    <span class="c-gray en">&gt;</span>学习中心
    <span class="c-gray en">&gt;</span>我的课程
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>
<div class="page-container">
    <div class="text-c">
        课程名称: <input type="text" class="input-text" id="courseName" name="courseName" placeholder="课程名称" maxlength="50" style="width: 100px;">
        <button id="searchBotton" type="button" class="btn btn-success">
            <i class="Hui-iconfont">&#xe665;</i>搜索
        </button>
    </div>

    <table id="dataTableList" class="table table-border table-bordered table-hover table-bg table-sort">
        <thead>
        <tr class="text-c">
            <th scope="col" colspan="9" align="center">我的课程</th>
        </tr>
        <tr class="text-c">
            <th>课程编号</th>
            <th>课程名称</th>
            <th>类别</th>
            <th>授课教师</th>
            <th width="50">操作</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>
</div>
<div id="pageNav"></div>
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/study/teach-course/learn-index.js'/>"></script>
<script id="dataTableListTpl" type="text/html">
    {{#  $.each(d.list, function(index, item) { }}
    <tr class="text-c">
        <td>{{ item.courseCode }}</td>
        <td>{{ item.courseName }}</td>
        <td>{{ item.typeName }}</td>
        <td>{{ item.teacherName }}</td>
        <td class="td-manage">
            <a href="/manage/study/teach-course/course-video-index.jhtml?courseId={{item.courseId}}" style="text-decoration:none;" class="ml-5" title="视频列表">
                <i class="fa fa-file-video-o fa-lg"></i>
            </a>
        </td>
    </tr>
    {{#  }); }}
</script>
</body>
</html>