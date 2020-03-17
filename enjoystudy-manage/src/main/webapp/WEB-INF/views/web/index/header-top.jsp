<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<div class="TopLineBg">
    <div class="TopLine">
        <c:if test="${not empty manage_login_user}">
            <span>欢迎，${manage_login_user.fullName}</span>
            <a href="<c:url value="/manage/main/index.jhtml"/>" style="color:#7f7f7f; font-size:13px; margin-right:15px; margin-left:15px;">[进入学习平台]</a>
            <a href="<c:url value="/web/shop/shopping-cart/index.jhtml"/>" style="color:#3c8aff; font-size:13px; margin-right:4px;">
                <img src="<c:url value="/static/js/images/guc.png"/>" style="vertical-align:middle; margin-right:4px; border:0px; width:17px;">购物车
            </a>
            <a href="<c:url value="/web/login/logout.jhtml"/>" style="color:#7f7f7f; font-size:13px; margin-left:11px;">[退出]</a>
        </c:if>
        <c:if test="${empty manage_login_user}">
            <a href="<c:url value='/manage/login/register.jhtml'/>" target="_blank">注册新用户</a>
        </c:if>
    </div>
</div>
<div class="Banner">
    <div class="Logo">
        <a href="<c:url value='/web/index/index.jhtml'/>">
            <img src="<c:url value='/static/js/templates/web/index/logo.jpg'/>"/>
        </a>
    </div>
    <div class="Search">
        <form id="frmSearch" name="frmSearch" action="<c:url value="/web/course/list.jhtml"/>" method="post">
            <div class="SearchInput">
                <input name="name" id="name" type="search" placeholder="搜索您感兴趣的课程" value="${so.name}">
            </div>
            <div class="SearchButton">
                <img onclick="Search()" src="<c:url value='/static/js/templates/web/index/SearchButton.jpg'/>" />
            </div>
        </form>
        <script type="text/javascript">
            function Search() {
                $("#frmSearch").attr("action", "<c:url value="/web/course/list.jhtml"/>");
                document.getElementById("frmSearch").submit();
            }
        </script>
    </div>
    <c:if test="${empty manage_login_user}">
        <div class="LoginEnter">
            <a href="<c:url value='/web/login/index.jhtml'/>" target="_blank">
                <img src="<c:url value='/static/js/templates/web/index/LoginEnterButton.jpg'/>" />
            </a>
        </div>
    </c:if>
</div>
</div>