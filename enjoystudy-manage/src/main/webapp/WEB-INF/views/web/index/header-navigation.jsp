<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<div class="NavBg">
    <div class="Nav">
        <div class="NavItemSelected" onclick="location.href='<c:url value="/web/index/index.jhtml"/>'">首页</div>
        <div class="NavItem" id="Nav_1" onmouseover="NavBgOver(this.id)" onmouseout="NavBgOut(this.id)" onclick="location.href='<c:url value="/web/course/list.jhtml"/>'">课程中心</div>
        <div class="NavItem" id="Nav_2" onmouseover="NavBgOver(this.id)" onmouseout="NavBgOut(this.id)" onclick="location.href='<c:url value="/web/news/index.jhtml"/>'">新闻资讯</div>
        <div class="NavItem" id="Nav_3" onmouseover="NavBgOver(this.id)" onmouseout="NavBgOut(this.id)" onclick="location.href='<c:url value="/web/course-train-plan/index.jhtml"/>'">培训中心</div>
    </div>
</div>