<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<xzlTag:sysBaseConfigTag/>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/views/web/common/meta.jsp" %>
    <title>${so.name} - ${so.courseName} - ${sysBaseConfig.systemName}</title>
    <%@ include file="/WEB-INF/views/web/common/javascript.jsp" %>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/js/common/flowplayer-7.2.7/skin/skin.css"/>"/>
</head>

<body class="met-navfixed">
<%@ include file="/WEB-INF/views/web/common/header.jsp" %>
<%@ include file="/WEB-INF/views/web/common/navbar.jsp" %>
<div class="met-position  pattern-show">
    <div class="container">
        <div class="row">
            <ol class="breadcrumb">
                <li>
                    <a href='<c:url value="/web/index/index.jhtml"/>'>主页</a>&gt;
                    <a href='<c:url value="/web/course-video/list.jhtml"/>'>课程中心</a>&gt;
                    <a href='<c:url value="/web/course-video/details.jhtml"/>'>${so.name}</a>
                </li>
            </ol>
        </div>
    </div>
</div>
<div class="page met-showproduct pagetype1 animsition">
    <div class="met-showproduct-head">
        <div class="container">
            <div class="row">
                <div class="col-md-7">
                    <div id="met-showproduct-list" class="fngallery text-center met-imgs-carousel flowplayer" data-file-path="<c:url value="${so.filePath}"/>" data-swf="<c:url value="/static/js/common/flowplayer-7.2.7/flowplayer.swf"/>" data-img="<c:url value="${so.image}"/>" data-ratio="0.4167">
                    </div>
                    <%--
                    <div class='met-showproduct-list fngallery text-center ' id="met-imgs-carousel">
                        <div class='slick-slide lg-item-box' data-src="<c:url value="${so.image}"/>" data-exthumbimage="<c:url value="${so.image}"/>">
                            <span>
                                <img src="<c:url value="${so.image}"/>" data-src='<c:url value="${so.image}"/>' class="img-responsive" alt="${so.name}" />
                            </span>
                        </div>
                    </div>
                    --%>
                </div>
                <div class="col-md-5 product-intro">
                    <h1 class='font-weight-300'>${so.name}</h1>
                    <p class="description">${so.introduction}</p>
                </div>
            </div>
        </div>
    </div>
    <div class="met-showproduct-body">
        <div class="container">
            <div class="row no-space">
                <div class="col-md-9 product-content-body">
                    <div class="row">
                        <div class="panel product-detail">
                            <div class="panel-body">
                                <ul class="nav nav-tabs nav-tabs-line met-showproduct-navtabs affix-nav">
                                    <li class="active">
                                        <a data-toggle="tab" href="#product-details" data-get="product-details">详细信息</a>
                                    </li>
                                </ul>
                                <div class="tab-content">
                                    <div class="tab-pane met-editor lazyload clearfix animation-fade active" id="product-details" data-id="${so.id}">
                                        <div>${so.description}</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--右侧开始-->
                <div class="col-md-3">
                    <div class="row">
                        <div class="panel product-hot">
                            <div class="panel-body">
                                <h2 class="margin-bottom-15 font-size-16 font-weight-300">热门推荐</h2>
                                <xzlTag:courseVideoListTag varid="videoList" pageSize="5" showState="true"/>
                                <ul class="blocks-2 blocks-sm-3 mob-masonry" data-scale='1'>
                                    <c:forEach var="video" items="${videoList}">
                                        <li>
                                            <a href=""<c:url value="/web/course-video/details.jhtml?id=${video.id}"/>" class="img" title="${video.name}">
                                                <img data-original="<c:url value="${video.image}"/>" class="cover-image" style='height:200px;' alt="${video.name}">
                                            </a>
                                            <a href=""<c:url value="/web/course-video/details.jhtml?id=${video.id}"/>" class="txt" title="${video.name}">${video.name}</a>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <!--右侧结束-->
            </div>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/views/web/common/footer-nav.jsp" %>
<%@ include file="/WEB-INF/views/web/common/footer.jsp" %>
<script type="text/javascript" src="<c:url value="/static/js/common/jquery/jquery-1.11.3.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/common/flowplayer-7.2.7/flowplayer.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/templates/web/index/js/index.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/templates/web/course-video/video-details.js"/>"></script>
</body>
</html>