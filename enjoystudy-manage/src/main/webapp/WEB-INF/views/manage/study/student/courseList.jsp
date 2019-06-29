<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/views/common/meta.jsp" %>
    <%@ include file="/WEB-INF/views/common/javascript.jsp" %>
    <script type="text/javascript" src="<c:url value='/static/js/common/laypage/laypage.js'/>"></script>
    <title>学员课程列表</title>
</head>
<body>
<div class="page-container">
    <table id="dataTableList" class="table table-border table-bordered table-hover table-bg table-sort">
        <thead>
        <tr class="text-c">
            <th>课程名称</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="ec" items="${list}">
                <tr class="text-c">
                    <td>${ec.course.name}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>