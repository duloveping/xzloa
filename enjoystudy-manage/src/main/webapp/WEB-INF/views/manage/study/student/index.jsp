<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/views/common/meta.jsp" %>
    <%@ include file="/WEB-INF/views/common/javascript.jsp" %>
    <script type="text/javascript" src="<c:url value='/static/js/common/laypage/laypage.js'/>"></script>
    <title>学员管理</title>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i>首页
    <span class="c-gray en">&gt;</span>学习中心
    <span class="c-gray en">&gt;</span>学员管理
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>
<div class="page-container">
    <div class="text-c">
        账号: <input type="text" class="input-text" id="code" name="code" placeholder="学员编号" maxlength="50" style="width: 100px;">
        姓名: <input type="text" class="input-text" id="fullName" name="fullName" placeholder="学员姓名" maxlength="50" style="width: 100px;">
        状态：<span class="select-box" style="width: 100px;">
            <select id="lockState" name="lockState" class="select">
                <option value="" selected="selected">全部</option>
                <option value="true">启用</option>
                <option value="false">禁用</option>
            </select>
        </span>
        <button id="searchBotton" type="button" class="btn btn-success">
            <i class="Hui-iconfont">&#xe665;</i>搜索
        </button>
    </div>

    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a class="btn btn-primary radius" onclick="student.add();" href="javascript:void(0);"><i class="Hui-iconfont">&#xe600;</i>&nbsp;添加</a>
            <a class="btn btn-primary radius" onclick="student.batchEdit();" href="javascript:void(0);"><i class="Hui-iconfont">&#xe61f;</i>&nbsp;批量</a>
            <a class="btn btn-primary radius" onclick="student.export();" href="javascript:void(0);"><i class="Hui-iconfont">&#xe641;</i>&nbsp;导出学员</a>
            <a class="btn btn-primary radius" onclick="student.exportScore();" href="javascript:void(0);"><i class="Hui-iconfont">&#xe640;</i>&nbsp;导出成绩</a>
            <a id="grantCourse" class="btn btn-primary radius" href="javascript:void(0);"><i class="Hui-iconfont">&#xe637;</i>&nbsp;授课</a>
            <a id="grantCourseForAll" class="btn btn-primary radius" href="javascript:void(0);"><i class="Hui-iconfont">&#xe637;</i>&nbsp;全部学员授课</a>
            <a id="removeCourseForAll" class="btn btn-primary radius" href="javascript:void(0);"><i class="Hui-iconfont">&#xe637;</i>&nbsp;全部学员撤课</a>
        </span>
    </div>

    <table id="dataTableList" class="table table-border table-bordered table-hover table-bg table-sort">
        <thead>
        <tr class="text-c">
            <th scope="col" colspan="9" align="center">学员管理</th>
        </tr>
        <tr class="text-c">
            <th width="10"><input type="checkbox" name="checkAll" value="0"></th>
            <th>编号</th>
            <th>名称</th>
            <th width="100">状态</th>
            <th width="100">操作</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>
</div>

<div id="pageNav"></div>

<script type="text/javascript" src="<c:url value='/static/js/templates/manage/study/student/student-index.js'/>"></script>
<script id="dataTableListTpl" type="text/html">
    {{#  $.each(d.list, function(index, item) { }}
    <tr class="text-c">
        <td><input type="checkbox" name="studentId" value="{{ item.id }}"></td>
        <td>{{ item.code }}</td>
        <td>{{ item.fullName }}</td>
        <td>{{ item.lockState == true ? '启用' : '禁用' }}</td>
        <td class="td-manage">
            <a href="javascript:void(0);" onclick="student.edit('{{item.id}}')" style="text-decoration:none;" class="ml-5" title="编辑"><i class="fa fa-edit fa-lg"></i></a>&nbsp;
            <a href="javascript:void(0);" onclick="student.delete('{{item.id}}')" style="text-decoration:none;" class="ml-5" title="删除"><i class="fa fa-remove fa-lg"></i></a>&nbsp;
            <a href="javascript:void(0);" onclick="student.courseList('{{item.id}}')" style="text-decoration:none;" class="ml-5" title="课程"><i class="fa fa-file-video-o fa-lg"></i></a>&nbsp;
            <a href="javascript:void(0);" onclick="student.paperList('{{item.id}}')" style="text-decoration:none;" class="ml-5" title="试卷"><i class="fa fa-list-alt fa-lg"></i></a>&nbsp;
        </td>
    </tr>
    {{#  }); }}
</script>
</body>
</html>