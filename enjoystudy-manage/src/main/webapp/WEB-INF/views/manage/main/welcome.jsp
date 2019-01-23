<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
	<head>
		<%@ include file="/WEB-INF/views/common/meta.jsp" %>
		<%@ include file="/WEB-INF/views/common/javascript.jsp" %>
		<title>首页</title>
	</head>
	<body>
	<div class="page-container">
		<table id="course-list" class="table table-border table-bordered table-bg">
			<thead>
			<tr class="text-c">
				<th colspan="3" scope="col">在线课程</th>
			</tr>
			<tr class="text-c">
				<th>视频名称</th>
				<th width="300">所属课程</th>
				<th width="100">授课老师</th>
			</tr>
			</thead>
			<tbody></tbody>
		</table>

		<table id="examination-list" class="table table-border table-bordered table-bg mt-20">
			<thead>
			<tr class="text-c">
				<th scope="col" colspan="13" align="center">课程考试</th>
			</tr>
			<tr class="text-c">
				<th>课程名称</th>
				<th width="60">总分</th>
				<th width="60">合格分数</th>
				<th width="60">时长</th>
				<th width="60">补考次数</th>
				<th width="60">考题数</th>
				<th width="80">操作</th>
			</tr>
			</thead>
			<tbody></tbody>
		</table>

		<table id="score-list" class="table table-border table-bordered table-bg mt-20">
			<thead>
			<tr class="text-c">
				<th scope="col" colspan="13" align="center">成绩查询</th>
			</tr>
			<tr class="text-c">
				<th>课程名称</th>
				<th width="120">开始时间</th>
				<th width="120">结束时间</th>
				<th width="120">交卷时间</th>
				<th width="60">状态</th>
				<th width="60">考试成绩</th>
			</tr>
			</thead>
			<tbody></tbody>
		</table>

		<table id="certificate-list" class="table table-border table-bordered table-bg mt-20">
			<thead>
			<tr class="text-c">
				<th scope="col" colspan="13" align="center">证书管理</th>
			</tr>
			<tr class="text-c">
				<th>证书名称</th>
				<th width="200">证书编号</th>
				<th width="120">获得时间</th>
			</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
	<script type="text/javascript" src="<c:url value='/static/js/common/moment/moment.js'/>"></script>
	<script type="text/javascript" src="<c:url value="/static/js/templates/manage/main/main-welcome.js"/>"></script>
	</body>
</html>