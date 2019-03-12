<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<div class="TopLineBg">
    <div class="TopLine">
        <a href="<c:url value='/manage/login/register.jhtml'/>" target="_blank">注册新用户</a>
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
    <div class="LoginEnter">
        <a href="<c:url value='/web/login/index.jhtml'/>" target="_blank">
            <img src="<c:url value='/static/js/templates/web/index/LoginEnterButton.jpg'/>" />
        </a>
    </div>
</div>