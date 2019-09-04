<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/views/common/meta.jsp" %>
    <%@ include file="/WEB-INF/views/common/javascript.jsp" %>
    <script type="text/javascript" src="<c:url value='/static/js/common/laypage/laypage.js'/>"></script>
    <title>电子证书管理</title>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i>首页
    <span class="c-gray en">&gt;</span>认证中心
    <span class="c-gray en">&gt;</span>电子证书管理
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>
<div class="page-container">
    <div class="text-c">
        姓名: <input type="text" class="input-text" id="employeeName" name="employeeName" placeholder="姓名" maxlength="10" style="width: 100px;">
        身份证号: <input type="text" class="input-text" id="identityCode" name="identityCode" placeholder="身份证号" maxlength="18" style="width: 100px;">
        证书编号: <input type="text" class="input-text" id="certificateCode" name="certificateCode" placeholder="证书编号" maxlength="30" style="width: 100px;">
        证书名称: <input type="text" class="input-text" id="certificateName" name="certificateName" placeholder="证书名称" maxlength="50" style="width: 100px;">
        状态：<span class="select-box" style="width: 100px;">
            <select id="certificateState" name="certificateState" class="select">
                <option value="" selected="selected">全部</option>
                <option value="1">正常</option>
                <option value="2">过期</option>
                <option value="3">作废</option>
            </select>
        </span>
        <button id="searchBotton" type="button" class="btn btn-success">
            <i class="Hui-iconfont">&#xe665;</i>搜索
        </button>
    </div><br />

    <table id="dataTableList" class="table table-border table-bordered table-hover table-bg table-sort">
        <thead>
        <tr class="text-c">
            <th scope="col" colspan="13" align="center">证书管理</th>
        </tr>
        <tr class="text-c">
            <th>姓名</th>
            <th>身份证号</th>
            <th>证书编号</th>
            <th>证书名称</th>
            <th>发证日期</th>
            <th width="120">操作</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>
</div>

<div id="pageNav"></div>

<script type="text/javascript" src="<c:url value='/static/js/common/moment/moment.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/study/employee-certificate/certificate.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/study/employee-certificate/admin-index.js'/>"></script>

<script id="dataTableListTpl" type="text/html">
    {{#  $.each(d.list, function(index, item) { }}
    <tr class="text-c">
        <td>{{ item.employeeName }}</td>
        <td>{{ item.identityCode }}</td>
        <td>{{ item.certificateCode }}</td>
        <td>{{ item.certificateName }}</td>
        <td>{{ moment(item.certificateDate).format("YYYY-MM-DD") }}</td>
        <td class="td-manage">
            <a href="javascript:void(0);" onclick="student.edit('{{item.id}}')" style="text-decoration:none;" class="ml-5" title="编辑"><i class="fa fa-edit fa-lg"></i></a>&nbsp;
            <a href="javascript:void(0);" onclick="student.delete('{{item.id}}')" style="text-decoration:none;" class="ml-5" title="删除"><i class="fa fa-remove fa-lg"></i></a>&nbsp;
            <a href="javascript:void(0);" onclick="student.courseList('{{item.id}}')" style="text-decoration:none;" class="ml-5" title="课程"><i class="fa fa-file-video-o fa-lg"></i></a>&nbsp;
        </td>
    </tr>
    {{#  }); }}
</script>
</body>
</html>