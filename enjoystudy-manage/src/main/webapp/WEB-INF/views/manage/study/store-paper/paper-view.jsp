<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/views/common/meta.jsp" %>
    <%@ include file="/WEB-INF/views/common/javascript.jsp" %>
    <script type="text/javascript" src="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/jquery.validation/1.14.0/jquery.validate.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/jquery.validation/1.14.0/validate-methods.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/jquery.validation/1.14.0/messages_zh.js'/>"></script>
    <title>考卷预览</title>
</head>
<body>
<div class="page-container">
    <table class="table table-border table-bordered table-bg">
        <thead>
        <tr>
            <th scope="col">${paper.title}</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${not empty list4}">
            <tr class="text-c">
                <td style="text-align: left;">判断题（${fn:length(list4)}）</td>
            </tr>
            <c:forEach var="question" items="${list4}" varStatus="s">
                <tr class="text-c">
                    <td style="text-align: left;">${s.count}.${question.title}</td>
                </tr>
                <tr class="text-c">
                    <td style="text-align: left;">
                        <c:forEach var="item" items="${question.itemList}" varStatus="status">
                            <c:choose>
                                <c:when test="${status.count eq 1}">A.</c:when>
                                <c:when test="${status.count eq 2}">B.</c:when>
                                <c:when test="${status.count eq 3}">C.</c:when>
                                <c:when test="${status.count eq 4}">D.</c:when>
                                <c:when test="${status.count eq 5}">E.</c:when>
                                <c:when test="${status.count eq 6}">F.</c:when>
                                <c:when test="${status.count eq 7}">I</c:when>
                                <c:when test="${status.count eq 8}">K</c:when>
                                <c:when test="${status.count eq 9}">L</c:when>
                                <c:when test="${status.count eq 10}">M</c:when>
                                <c:otherwise></c:otherwise>
                            </c:choose>
                            ${item.title}<br>
                        </c:forEach>
                    </td>
                </tr>
                <tr class="text-c" style="display: none;">
                    <td>${question.analysis}</td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${not empty list1}">
            <tr class="text-c">
                <td style="text-align: left;">单选题（${fn:length(list1)}）</td>
            </tr>
            <c:forEach var="question" items="${list1}" varStatus="s">
                <tr class="text-c">
                    <td style="text-align: left;">${s.count}.${question.title}</td>
                </tr>
                <tr class="text-c">
                    <td style="text-align: left;">
                        <c:forEach var="item" items="${question.itemList}" varStatus="status">
                            <c:choose>
                                <c:when test="${status.count eq 1}">A.</c:when>
                                <c:when test="${status.count eq 2}">B.</c:when>
                                <c:when test="${status.count eq 3}">C.</c:when>
                                <c:when test="${status.count eq 4}">D.</c:when>
                                <c:when test="${status.count eq 5}">E.</c:when>
                                <c:when test="${status.count eq 6}">F.</c:when>
                                <c:when test="${status.count eq 7}">I</c:when>
                                <c:when test="${status.count eq 8}">K</c:when>
                                <c:when test="${status.count eq 9}">L</c:when>
                                <c:when test="${status.count eq 10}">M</c:when>
                                <c:otherwise></c:otherwise>
                            </c:choose>
                            ${item.title}<br>
                        </c:forEach>
                    </td>
                </tr>
                <tr class="text-c" style="display: none;">
                    <td>${question.analysis}</td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${not empty list2}">
            <tr class="text-c">
                <td style="text-align: left;">多选题（${fn:length(list2)}）</td>
            </tr>
            <c:forEach var="question" items="${list2}" varStatus="s">
                <tr class="text-c">
                    <td style="text-align: left;">${s.count}.${question.title}</td>
                </tr>
                <tr class="text-c">
                    <td style="text-align: left;">
                        <c:forEach var="item" items="${question.itemList}" varStatus="status">
                            <c:choose>
                                <c:when test="${status.count eq 1}">A.</c:when>
                                <c:when test="${status.count eq 2}">B.</c:when>
                                <c:when test="${status.count eq 3}">C.</c:when>
                                <c:when test="${status.count eq 4}">D.</c:when>
                                <c:when test="${status.count eq 5}">E.</c:when>
                                <c:when test="${status.count eq 6}">F.</c:when>
                                <c:when test="${status.count eq 7}">I</c:when>
                                <c:when test="${status.count eq 8}">K</c:when>
                                <c:when test="${status.count eq 9}">L</c:when>
                                <c:when test="${status.count eq 10}">M</c:when>
                                <c:otherwise></c:otherwise>
                            </c:choose>
                            ${item.title}<br>
                        </c:forEach>
                    </td>
                </tr>
                <tr class="text-c" style="display: none;">
                    <td>${question.analysis}</td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>

</div>
</body>
</html>