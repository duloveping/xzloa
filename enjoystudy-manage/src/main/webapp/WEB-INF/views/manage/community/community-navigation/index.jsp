<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/views/common/meta.jsp" %>
    <%@ include file="/WEB-INF/views/common/javascript.jsp" %>
    <script type="text/javascript" src="<c:url value='/static/js/common/moment/moment.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/js/common/laypage/laypage.js'/>"></script>
    <title>社区导航管理</title>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i>首页
    <span class="c-gray en">&gt;</span>网站管理
    <span class="c-gray en">&gt;</span>社区导航管理
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>
<div class="page-container">
    <div class="text-c">
        社区导航位置: <span class="select-box" style="width:100px">
			<select class="select" id="placeId" name="placeId" size="1">
                <option value="">全部</option>
                <c:forEach var="place" items="${listPlace}">
                    <option value="${place.id}">${place.name}</option>
                </c:forEach>
			</select>
			</span>
        <button id="searchBotton" type="button" class="btn btn-success">
            <i class="Hui-iconfont">&#xe665;</i>搜索
        </button>
    </div>

    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a class="btn btn-primary radius" onclick="advertisement.add();" href="javascript:void(0);"><i class="Hui-iconfont">&#xe600;</i> 添加</a>
        </span>
    </div>

    <table id="dataTableList" class="table table-border table-bordered table-hover table-bg table-sort">
        <thead>
        <tr class="text-c">
            <th scope="col" colspan="9" align="center">社区导航管理</th>
        </tr>
        <tr class="text-c">
            <th width="150">编号</th>
            <th width="150">名称</th>
            <th>链接地址</th>
            <th width="60">显示状态</th>
            <th>图标</th>
            <th>style属性</th>
            <th>class属性</th>
            <th width="100">操作</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>
</div>

<div id="pageNav"></div>

<script type="text/javascript" src="<c:url value='/static/js/templates/manage/community/community-navigation/navigation-index.js'/>" charset="utf-8"></script>

<script id="dataTableListTpl" type="text/html">
    {{#  $.each(d.list, function(i, v){ }}
    <tr class="text-c">
        <td>{{ v.code }}</td>
        <td>{{ v.name }}</td>
        <td>{{ v.href }}</td>
        <td>{{ v.showState ? '显示' : '隐藏' }}</td>
        <td>{{ v.icon }}</td>
        <td>{{ v.cssStyle }}</td>
        <td>{{ v.cssClass }}</td>
        <td>操作</td>
    </tr>
    {{# }); }}
</script>
</body>
</html>