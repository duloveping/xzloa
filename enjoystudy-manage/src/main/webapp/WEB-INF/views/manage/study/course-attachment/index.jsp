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
    <span class="c-gray en">&gt;</span>《${course.name}》附件管理
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>
<div class="page-container">
    <div class="text-l">
        所属课程: <input type="text" class="input-text" id="courseName" name="courseName" value="${course.name}" readonly="readonly" style="width: 200px;">
        <input id="courseId" name="courseId" type="hidden" value="${course.id}">
        文件名称: <input type="text" class="input-text" id="fileName" name="fileName" placeholder="文件名称" maxlength="200" style="width: 200px;">
        <button id="searchBotton" type="button" class="btn btn-success">
            <i class="Hui-iconfont">&#xe665;</i>搜索
        </button>
        <button id="backButton" type="button" class="btn btn-success">
            <i class="Hui-iconfont">&#xe619;</i>返回
        </button>
    </div>

    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a class="btn btn-primary radius" onclick="attachment.add();" href="javascript:void(0);"><i class="Hui-iconfont">&#xe600;</i> 添加</a>
        </span>
    </div>

    <table id="dataTableList" class="table table-border table-bordered table-hover table-bg table-sort">
        <thead>
        <tr class="text-c">
            <th scope="col" colspan="6" align="center">课程管理</th>
        </tr>
        <tr class="text-c">
            <th>文件名称</th>
            <th width="150">文件类型</th>
            <th width="150">文件大小</th>
            <th width="140">上传时间</th>
            <th width="40">状态</th>
            <th width="80">操作</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>
</div>

<div id="pageNav"></div>
<script type="text/javascript" src="<c:url value='/static/js/common/moment/moment.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/study/course-attachment/course-attachment-index.js'/>"></script>
<script id="attachment-data-list" type="text/html">
    {{#  $.each(d.list, function(index, item) { }}
    <tr class="text-c">
        <td>{{ item.fileName }}</td>
        <td>{{ item.fileType }}</td>
        <td>{{ item.fileSize }}</td>
        <td>{{ moment(item.uploadTime).format("YYYY-MM-DD HH:mm:ss") }}</td>
        <td>{{ item.showState ? '显示' : '隐藏' }}</td>
        <td class="td-manage">
            <a href="javascript:void(0);" onclick="attachment.delete(this, '{{item.id}}')" style="text-decoration:none;" class="ml-5" title="删除"><i class="fa fa-remove fa-lg"></i></a>&nbsp;
        </td>
    </tr>
    {{#  }); }}
</script>
</body>
</html>