<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<nav class="navbar navbar-default met-nav navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="row">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle hamburger hamburger-close collapsed" data-target="#navbar-default-collapse" data-toggle="collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="hamburger-bar"></span>
                </button>
                <a href="#"​ class="navbar-brand navbar-logo vertical-align">
                    <div class="vertical-align-middle">
                        <xzlTag:advertisementListTag varid="webLogo" placeCode="web-logo" pageSize="1"/>
                        <c:if test="${empty webLogo}">
                            <img src="<c:url value="/static/js/images/logo.jpg"/>" alt="logo" title="logo" />
                        </c:if>
                        <c:if test="${not empty webLogo}">
                            <img src="<c:url value="${webLogo[0].large}"/>" alt="${webLogo.title}" title="${webLogo.title}" />
                        </c:if>
                    </div>
                </a>
            </div>
            <div class="collapse navbar-collapse navbar-collapse-toolbar" id="navbar-default-collapse">
                <ul class="nav navbar-nav navbar-right navlist">
                    <li>
                        <a href="<c:url value="/web/index/index.jhtml"/>" target="_blank" ​ title="网站首页" class="link  active">网站首页</a>
                    </li>
                    <%--
                    <li class="dropdown margin-left-20">
                        <a class="dropdown-toggle link " data-toggle="dropdown" data-hover="dropdown" aria-expanded="false" href="about.html">
                            关于我们<span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-right bullet">
                            <li><a href="about.html"​ class="" title="公司简介">公司简介</a></li>
                            <li><a href="message.html"​ class="" title="在线留言">在线留言</a></li>
                        </ul>
                    </li>
                    <li class="dropdown margin-left-20">
                        <a class="dropdown-toggle link " data-toggle="dropdown" data-hover="dropdown" aria-expanded="false" href="product.html">
                            产品中心<span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-right bullet">
                            <li><a href="productcate.html"​ class="" title="果树苗">果树苗</a></li>
                            <li><a href="productcate.html"​ class="" title="绿化苗">绿化苗</a></li>
                            <li><a href="productcate.html"​ class="" title="松柏类">松柏类</a></li>
                            <li><a href="productcate.html"​ class="" title="灌木类">灌木类</a></li>
                        </ul>
                    </li>
                    <li class="dropdown margin-left-20">
                        <a class="dropdown-toggle link " data-toggle="dropdown" data-hover="dropdown" aria-expanded="false" href="jidi.html">
                            基地展示<span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-right bullet">
                            <li><a href="jidi.html"​ class="" title="樱桃种植基地">樱桃种植基地</a></li>
                            <li><a href="jidi.html"​ class="" title="猕猴桃种植基地">猕猴桃种植基地</a></li>
                            <li><a href="jidi.html"​ class="" title="云杉苗种植基地">云杉苗种植基地</a></li>
                        </ul>
                    </li>
                    <li class="dropdown margin-left-20">
                        <a class=" link " href="honor.html">资质荣誉</a>
                        <ul class="dropdown-menu dropdown-menu-right bullet"></ul>
                    </li>
                    <li class="dropdown margin-left-20">
                        <a class="dropdown-toggle link " data-toggle="dropdown" data-hover="dropdown" aria-expanded="false" href="news.html">
                            新闻中心<span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-right bullet">
                            <li><a href="news.html"​ class="" title="技术要领">技术要领</a></li>
                            <li><a href="news.html"​ class="" title="行业资讯">行业资讯</a></li>
                        </ul>
                    </li>
                    <li class="dropdown margin-left-20">
                        <a class=" link " href="contact.html">联系我们</a>
                        <ul class="dropdown-menu dropdown-menu-right bullet"></ul>
                    </li>
                    --%>
                </ul>
            </div>
        </div>
    </div>
</nav>