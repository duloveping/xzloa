<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/views/common/meta.jsp" %>
    <%@ include file="/WEB-INF/views/common/javascript.jsp" %>
    <script type="text/javascript" src="<c:url value='/static/js/common/laypage/laypage.js'/>"></script>
    <title>角色管理</title>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i>首页
    <span class="c-gray en">&gt;</span>系统管理
    <span class="c-gray en">&gt;</span>角色管理
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>
<div class="page-container">
    <div class="text-c">
        编号: <input type="text" class="input-text" id="code" name="code" placeholder="角色编号" maxlength="10" style="width: 100px;">
        名称: <input type="text" class="input-text" id="name" name="name" placeholder="角色名称" maxlength="50" style="width: 100px;">
        <button id="searchBotton" type="button" class="btn btn-success">
            <i class="Hui-iconfont">&#xe665;</i>搜索
        </button>
    </div>

    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a class="btn btn-primary radius" onclick="role.add();" href="javascript:void(0);"><i class="Hui-iconfont">&#xe600;</i> 添加</a>
        </span>
    </div>

    <table id="dataTableList" class="table table-border table-bordered table-hover table-bg table-sort">
        <thead>
        <tr class="text-c">
            <th scope="col" colspan="9" align="center">角色管理</th>
        </tr>
        <tr class="text-c">
            <th>角色编号</th>
            <th>角色名称</th>
            <th>角色备注</th>
            <th width="120">操作</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>
</div>

<div id="pageNav"></div>

<script type="text/javascript" src="<c:url value='/static/js/templates/manage/system/sys-role/role-index.js'/>" charset="utf-8"></script>
</body>
</html>