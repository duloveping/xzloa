<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/views/common/meta.jsp" %>
    <%@ include file="/WEB-INF/views/common/javascript.jsp" %>
    <script type="text/javascript" src="<c:url value='/static/js/common/laypage/laypage.js'/>"></script>
    <title>我的视频</title>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i>首页
    <span class="c-gray en">&gt;</span>学习中心
    <span class="c-gray en">&gt;</span>我的视频
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>
<div class="page-container">
    <div class="text-c">
        课程名称: <input type="text" class="input-text" id="courseName" name="courseName" value="${course.name}" readonly style="width: 200px;">
        <input id="courseId" name="courseId" type="hidden" value="${course.id}">
        视频名称: <input type="text" class="input-text" id="name" name="name" placeholder="视频名称" maxlength="200" style="width: 200px;">
        <button id="searchBotton" type="button" class="btn btn-success">
            <i class="Hui-iconfont">&#xe665;</i>搜索
        </button>
        <button id="backBotton" type="button" class="btn btn-primary">
            <i class="Hui-iconfont">&#xe6d4;</i>返回
        </button>
    </div>

    <table id="dataTableList" class="table table-border table-bordered table-hover table-bg table-sort">
        <thead>
        <tr class="text-c">
            <th scope="col" colspan="6" align="center">课程管理</th>
        </tr>
        <tr class="text-c">
            <th>名称</th>
            <th width="100">操作</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>
</div>

<div id="pageNav"></div>

<script type="text/javascript" src="<c:url value='/static/js/templates/manage/study/teach-course/course-video-index.js'/>"></script>
<script id="dataTableListTpl" type="text/html">
    {{#  $.each(d.list, function(index, item) { }}
    <tr class="text-c">
        <td>
            <a href="/web/course-video/view.jhtml?id={{item.id}}" target="_blank" style="text-decoration:none;" class="ml-5" title="视频播放">{{ item.name }}</a>
        </td>
        <td class="td-manage">
            <a href="/web/course-video/view.jhtml?id={{item.id}}" target="_blank" style="text-decoration:none;" class="ml-5" title="视频播放">
                <i class="fa fa-play fa-lg"></i>
            </a>
        </td>
    </tr>
    {{#  }); }}
</script>
</body>
</html>