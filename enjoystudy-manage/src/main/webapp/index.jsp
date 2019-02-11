<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<xzlTag:sysBaseConfigTag/>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/views/web/common/meta.jsp" %>
    <title>${sysBaseConfig.systemName}</title>
    <%@ include file="/WEB-INF/views/web/common/javascript.jsp" %>
</head>
<body>
    <%@ include file="/WEB-INF/views/web/common/header.jsp" %>
    <%@ include file="/WEB-INF/views/web/common/navbar.jsp" %>

    <xzlTag:advertisementListTag varid="bannerList" pageSize="10" placeCode="index-header-banner" />
    <c:if test="${not empty bannerList}">
        <div class="met-banner" data-height="" style="">
            <c:forEach var="banner" items="${bannerList}">
                <div class="slick-slide">
                    <img class="cover-image" src="<c:url value="${banner.large}" />" sizes="(max-width: 767px) 767px" alt="${banner.title}">
                </div>
            </c:forEach>
        </div>
    </c:if>

    <%--
    <xzlTag:advertisementListTag varid="hotCourseList" pageSize="4" placeCode="index-hot-course" />
    <c:if test="${not empty hotCourseList}">
        <div class="met-index-hot met-index-body" id="hot">
            <div class="title">
                <h2 class="">热门推荐课程</h2>
                <div class="home-line" style="background:url(<c:url value="/static/js/templates/web/index/images/1514365123.png" />)center no-repeat;"></div>
                <p class="desc">我们用心为您做的更好</p>
            </div>
            <div class="container">
                <ul class="blocks-100 blocks-sm-2 blocks-md-4 blocks-xlg-4 " data-scale=''>
                    <c:forEach var="hotCourse" items="${hotCourseList}">
                        <li class="">
                            <div class="widget widget-article widget-shadow">
                                <div class="widget-header cover overlay overlay-hover">
                                    <img class="cover-image overlay-scale" src="<c:url value="${hotCourse.large}"/>" alt="<c:url value="${hotCourse.title}"/>">
                                </div>
                                <div class="widget-body">
                                    <h3 class="widget-title">${hotCourse.title}</h3>
                                    <p class="des">${hotCourse.title}</p>
                                    <div class="widget-body-footer">
                                        <a class="btn btn-info waves-effect waves-light" href="productshow.html">查看详情</a>
                                        <div class="widget-actions pull-right"><a href="#"​>关注人数：121</a></div>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
                <div class="hot-btns"><a href="<c:url value="/web/course-video/list.jhtml"/>"​>查看更多</a></div>
            </div>
        </div>
    </c:if>
    --%>

    <%--
    <!--string(4) "news" string(4) "news" -->
    <div class="met-index-imgnews met-index-body" id="news">
        <div class="title">
            <h2 class="">新闻中心</h2>
            <div class="home-line" style="background:url(<c:url value="/static/js/templates/web/index/images/1514365123.png"/>)center no-repeat;"></div>
            <p class="desc"></p>
        </div>
        <div class="container">
            <div class="clearfix" data-plugin="matchHeight">
                <div class="col-md-7 col-xs-12 left-news">
                    <div class="sec-title">
                        <h3>技术要领</h3>
                        <span class="line"></span>
                        <a href="newsshow.html" title="技术要领">更多</a>
                    </div>
                    <div class="slick" id="imgnews-slick">
                        <div>
                            <a href="newsshow.html" title="金叶榆行情下跌，来源于“跟风”太紧！" target='_self'>
                                <div class="text">
                                    <span class="icon"><img src="picture/1514428334.png" alt=""></span>
                                    <h3>
                                        <span>01</span>
                                        金叶榆行情下跌，来源于“跟风”太紧！
                                    </h3>
                                    <p class="des">今年由于种植金叶榆的人越来越多，不少苗农开始担忧金叶榆苗木价格的走势。据河北保定绿化苗木基地负责人的分析介绍，出现了这样的情况。昔日不愁嫁，今朝盼客来...</p>
                                </div>
                                <img class="cover-image" src="picture/1-1p1031k1590-l.jpg" sizes="(max-width: 991px) 991px" alt="">
                            </a>
                        </div>
                        <div>
                            <a href="newsshow.html" title="元宝枫价格贵不贵？元宝枫具有哪些功效作用呢"
                               target='_self'>
                                <div class="text">
                                    <span class="icon"><img src="picture/1514428334.png" alt=""></span>
                                    <h3>
                                        <span>02</span>
                                        元宝枫价格贵不贵？元宝枫具有哪些功效作用呢
                                    </h3>
                                    <p class="des">之所以现在种植元宝枫的基地越来越多，主要的原因就是因为元宝枫的经济价值非常高，而且具有着非常多的功效和作用，给我们生活带来了很多的优势，针对于元宝枫价...</p>
                                </div>
                                <img class="cover-image" src="picture/1-1p1031k2330-l.jpg" sizes="(max-width: 991px) 991px" alt="">
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-md-5 col-xs-12 right-news news-ul">
                    <div class="sec-title">
                        <h3>新闻资讯</h3>
                        <span class="line"></span>
                        <a href="news.html" title="行业资讯">更多</a>
                    </div>
                    <xzlTag:newsListTag varid="newsList" pageSize="10" showState="true" typeState="true"/>
                    <c:forEach var="news" items="${newsList}">
                        <li class="">
                            <span class="badge badge-radius badge-default color">1</span>
                            <a href="newsshow.html" title="${news.title}" target='_blank'>${news.title}</a>
                            <span>[<fmt:formatDate value="${news.publishTime}" pattern="MM-dd"/>]</span>
                        </li>
                    </c:forEach>
                </div>
            </div>
            <div class="news-bg">
                <div class="bg" style="background:url(images/1514367423.jpg)center no-repeat;">
                    <div class="text">
                        <h3>扫一扫关注微信！</h3>
                        <p>每周我们会通过微信给您推送苗木的最新知识，让您随时随地掌握苗木的一线知识。您也可以通过微信与我们交流。分享您育苗中遇到的难题，让我们第一时间给您解决</p>
                        <img src="picture/weixin.jpg" alt="">
                    </div>
                </div>
            </div>
        </div>
    </div>
    --%>

    <div class="met-index-product met-index-body" id='product'>
        <div class="title">
            <h2 class="">课程中心</h2>
            <div class="home-line" style="background:url(<c:url value="/static/js/templates/web/index/images/1514365123.png"/>)center no-repeat;"></div>
            <p class="desc"></p>
        </div>
        <div class="container">
            <xzlTag:courseListTag varid="courseList"/>
            <c:if test="${not empty courseList}">
                <div class=''>
                    <ul class="nav nav-tabs">
                        <c:forEach var="course" items="${courseList}">
                            <li><a href="<c:url value="/web/course-video/list.jhtml?courseId=${course.id}"/>" title="${course.name}" target="_blank"><h3>${course.name}</h3></a></li>
                        </c:forEach>
                    </ul>
                </div>
            </c:if>
            <xzlTag:courseVideoListTag varid="videoList" pageSize="20" showState="true"/>
            <c:if test="${not empty videoList}">
                <ul class="blocks-2 blocks-sm-2 blocks-md-4 blocks-xlg-4 no-space" id="indexprolist" data-scale='0.75117370892019'>
                    <c:forEach var="video" items="${videoList}">
                        <li>
                            <div class="widget">
                                <figure class="widget-header cover">
                                    <a href="<c:url value="/web/course-video/details.jhtml?id=${video.id}"/>" title="${video.name}" target='_blank'>
                                        <img class="cover-image overlay-scale" src="<c:url value="${video.image}"/>" style="height:300px;" alt="${video.name}">
                                    </a>
                                </figure>
                                <h4 class="widget-title">
                                    <a href="<c:url value="/web/course-video/details.jhtml?id=${video.id}"/>" title="${video.name}" target='_blank'>
                                        ${video.name}<span><i class="fa fa-eye"></i>${video.clickAmount}人浏览</span>
                                    </a>
                                </h4>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </c:if>
        </div>
    </div>

    <div class="met-index-about met-index-body" id="about">
        <div class="title">
            <h2 class="">师资力量</h2>
            <div class="home-line" style="background:url(<c:url value="/static/js/templates/web/index/images/1514365123.png"/>)center no-repeat;"></div>
            <p class="desc"></p>
        </div>
        <div class="container">
            <div class="about-list">
                <xzlTag:teacherListTag varid="teacherList" pageSize="10"/>
                <c:forEach var="teacher" items="${teacherList}" varStatus="status">
                    <div>
                        <div class="col-md-6 img"><img src="<c:url value="${teacher.image}"/>" alt="${teacher.fullName}"></div>
                        <div class="col-md-6 text">
                            <h3>${teacher.fullName}<span>/${status.count}</span></h3>
                            <p>${teacher.introduction}</p>
                            <a href="jidi.html" title="${teacher.fullName}" target='_blank' class="btn btn-info waves-effect waves-light">查看更多</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>

    <%@ include file="/WEB-INF/views/web/common/footer-nav.jsp" %>
    <%@ include file="/WEB-INF/views/web/common/footer.jsp" %>
    <script type="text/javascript" src="<c:url value="/static/js/templates/web/index/js/index.js"/>"></script>
</body>
</html>