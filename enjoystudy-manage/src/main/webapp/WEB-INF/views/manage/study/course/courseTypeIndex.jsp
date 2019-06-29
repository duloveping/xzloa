<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/views/common/meta.jsp" %>
    <%@ include file="/WEB-INF/views/common/javascript.jsp" %>
    <link rel="stylesheet" type="text/css" href="<c:url value='/static/js/common/ztree/css/zTreeStyle/zTreeStyle.css'/>" />
    <script type="text/javascript" src="<c:url value='/static/js/common/ztree/js/jquery.ztree.all-3.5.min.js' />"></script>
    <title>课程选择（多选）</title>
</head>
<body>
<ul id="courseTree" class="ztree"></ul>
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/study/course/courseTypeList.js' />"></script>
</body>
</html>