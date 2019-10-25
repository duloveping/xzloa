<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<c:choose>
    <c:when test="${certificate.courseCode eq 'ISO9001-2015'}">
        <%@ include file="preview/ISO9001-2015.jsp" %>
    </c:when>
    <c:when test="${certificate.courseCode eq 'CQO2019'}">
        <%@ include file="preview/CQO2019.jsp" %>
    </c:when>
    <c:otherwise>
        <%@ include file="preview/other.jsp" %>
    </c:otherwise>
</c:choose>
