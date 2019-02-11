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
                <xzlTag:courseListTag varid="courseList"/>
                <c:if test="${not empty courseList}">
                    <ul class="met-column-nav-ul invisible-xs">
                        <c:forEach var="course" items="${courseList}">
                            <li><a href="productcate.html" class="link" title="${course.name}">${course.name}</a></li>
                        </c:forEach>
                    </ul>
                </c:if>
            </div>
            <div class="product-search">
                <form name="formsearch" action="<c:url value="/web/course-video/list.jhtml"/>" method="post">
                    <input type="hidden" name="kwtype" value="0" />
                    <input type="hidden" name="kwtype" value="0" />
                    <input type="hidden" name="kwtype" value="0" />
                    <input type="hidden" name="kwtype" value="0" />
                    <input type="hidden" name="kwtype" value="0" />
                    <input type="hidden" name="kwtype" value="0" />
                    <input type="hidden" name="kwtype" value="0" />
                    <input type="hidden" name="kwtype" value="0" />
                    <input type="hidden" name="kwtype" value="0" />
                    <input type="hidden" name="kwtype" value="0" />
                    <input type="hidden" name="kwtype" value="0" />
                    <input type="hidden" name="kwtype" value="0" />
                    <div class="form-group">
                        <div class="input-search">
                            <button type="submit" class="input-search-btn">
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
            <c:forEach var="course" items="${pageInfo.list}">
                <li class=" shown">
                    <div class="widget widget-shadow">
                        <figure class="widget-header cover">
                            <a href="productshow.html" title="${course.name}" target="_blank">
                                <img class="cover-image" src="<c:url value="${course.image}" />" alt="${course.name}" style='height:200px;'>
                            </a>
                        </figure>
                        <div class="widget-body">
                            <h4 class="widget-title">${course.name}</h4>
                            <p>${course.introduction}</p>
                            <div class="widget-body-footer">
                                <div class="widget-actions pull-right">
                                    <a href="productshow.html" title="${course.name}">
                                        <i class="icon wb-eye" aria-hidden="true"></i>
                                        <span>36</span>
                                    </a>
                                </div>
                                <a href="productshow.html" title="${course.name}" target="_blank" class="btn btn-outline btn-primary btn-squared">查看详情</a>
                            </div>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
        <div>
            <div class='met_pager'>
                <span class='PreSpan'>上一页</span>
                <a class="Ahover">1</a>
                <a href='list_4_2.html'>2</a>
                <a href='list_4_2.html'>下一页</a>
            </div>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/views/web/common/footer-nav.jsp" %>
<%@ include file="/WEB-INF/views/web/common/footer.jsp" %>
<script type="text/javascript" src="<c:url value="/static/js/templates/web/index/js/index.js"/>"></script>
</body>
</html>