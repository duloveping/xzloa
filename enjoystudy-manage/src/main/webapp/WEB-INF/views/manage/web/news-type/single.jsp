<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/views/common/meta.jsp" %>
    <%@ include file="/WEB-INF/views/common/javascript.jsp" %>
    <link rel="stylesheet" type="text/css" href="<c:url value='/static/js/common/ztree/css/zTreeStyle/zTreeStyle.css'/>" />
    <script type="text/javascript" src="<c:url value='/static/js/common/ztree/js/jquery.ztree.all-3.5.min.js' />"></script>
    <title>新闻类别选择（单选）</title>
</head>
<body>
<article class="page-container">
    <div class="row cl">
        <div id="typeTree" class="ztree col-xs-8 col-sm-9"></div>
        <input id="typeId" name="typeId" type="hidden" value="">
        <input id="typeName" name="typeName" type="hidden" value="">
    </div>
</article>
<script type="application/javascript">var zNodes = ${types};</script>
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/web/news-type/type-single.js' />"></script>
</body>
</html>