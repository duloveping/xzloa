<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<xzlTag:sysBaseConfigTag/>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/views/web/common/meta.jsp" %>
    <title>课程视频列表 - ${sysBaseConfig.systemName}</title>
    <%@ include file="/WEB-INF/views/web/common/javascript.jsp" %>
</head>

<body class="met-navfixed">
<%@ include file="/WEB-INF/views/web/common/header.jsp" %>
<%@ include file="/WEB-INF/views/web/common/navbar.jsp" %>

<div class="met-column-nav bordernone">
    <div class="container">
        <div class="row">
            <div class="sidebar-tile">
                <xzlTag:courseListTag varid="courseList" pageSize="10" showState="true"/>
                <c:if test="${not empty courseList}">
                    <ul class="met-column-nav-ul invisible-xs">
                        <c:forEach var="course" items="${courseList}">
                            <li><a href="javascript:void(0);" class="link" title="${course.name}" data-id="${course.id}">${course.name}</a></li>
                        </c:forEach>
                    </ul>
                </c:if>
            </div>
            <div class="product-search">
                <form name="formsearch" action="<c:url value="/web/course-video/list.jhtml"/>" method="post">
                    <input type="hidden" id="teacherId" name="teacherId" value="${so.teacherId}" />
                    <input type="hidden" id="courseId" name="courseId" value="${so.courseId}" />
                    <input type="hidden" id="courseCode" name="courseCode" value="${so.courseCode}" />
                    <input type="hidden" id="courseRecommendState" name="courseRecommendState" value="${so.courseRecommendState}" />
                    <input type="hidden" id="courseHotState" name="courseHotState" value="${so.courseHotState}" />
                    <input type="hidden" id="name" name="name" value="${so.name}" />
                    <input type="hidden" id="showState" name="showState" value="true" />
                    <div class="form-group">
                        <div class="input-search">
                            <button type="button" class="input-search-btn" onclick="video.list(1)">
                                <i class="icon wb-search" aria-hidden="true"></i>
                            </button>
                            <input type="text" class="form-control" name="q" value="" placeholder="Search">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="met-product animsition type-3">
    <div class="container-fluid">
        <ul class="blocks-2 blocks-sm-2 blocks-md-4 blocks-xlg-4  met-page-ajax met-grid" id="met-grid" data-scale='0.75117370892019'>
        </ul>
        <div>
            <div id="pageNav" class='met_pager'></div>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/views/web/common/footer-nav.jsp" %>
<%@ include file="/WEB-INF/views/web/common/footer.jsp" %>
<script type="text/javascript" src="<c:url value='/static/js/common/laypage/laypage.js'/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/templates/web/index/js/index.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/templates/web/course-video/video-list.js"/>"></script>
</body>
</html>