<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/views/common/meta.jsp" %>
    <%@ include file="/WEB-INF/views/common/javascript.jsp" %>
    <script type="text/javascript" src="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/icheck/jquery.icheck.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/jquery.validation/1.14.0/jquery.validate.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/jquery.validation/1.14.0/validate-methods.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/jquery.validation/1.14.0/messages_zh.js'/>"></script>
    <title>角色管理</title>
</head>
<body>
<article class="page-container">
    <form:form id="inputForm" modelAttribute="vo" method="post" action="#" cssClass="form form-horizontal">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">
                <span class="c-red">*</span>编号：
            </label>
            <div class="formControls col-xs-8 col-sm-9">
                <form:input id="code" path="code" placeholder="编号" maxlength="50" cssClass="input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">
                <span class="c-red">*</span>名称：
            </label>
            <div class="formControls col-xs-8 col-sm-9">
                <form:input id="name" path="name" placeholder="名称" maxlength="50" cssClass="input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">
                <span class="c-red">*</span>名称：
            </label>
            <div class="formControls col-xs-8 col-sm-9">
                <form:radiobutton id="showState-1" path="showState" value="true" label="显示"/>
                <form:radiobutton id="showState-2" path="showState" value="false" label="隐藏"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">备注：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <form:textarea id="caption" path="caption" rows="5" cols="80" maxlength="255" cssClass="textarea valid" onKeyUp="$.Huitextarealength(this,255);" placeholder="备注"></form:textarea>
                <p class="textarea-numberbar"><em class="textarea-length">0</em>/255</p>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">权限：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <xzlTag:sysRoleMenuListTag varid="rmList" roleId="${vo.id}" />
                <xzlTag:sysMenuListTag varid="oneList" category="1" parentId="0" />
                <c:forEach var="menu1" items="${oneList }" varStatus="status">
                    <dl class="permission-list">
                        <dt>
                            <label><input type="checkbox" value="${menu1.id }" name="menuIds" id="menu-${menu1.id }" <c:forEach var="rm" items="${rmList }"><c:if test="${rm.menu.id eq menu1.id }">checked="checked"</c:if></c:forEach>/>${menu1.name }</label>
                        </dt>
                        <dd>
                            <xzlTag:sysMenuListTag varid="menu2List" category="1" parentId="${menu1.id}" />
                            <c:forEach var="menu2" items="${menu2List }">
                                <dl class="cl permission-list2">
                                    <dt>
                                        <label><input type="checkbox" value="${menu2.id }" name="menuIds" id="menu-${menu1.id }-${menu2.id }" <c:forEach var="rm2" items="${rmList }"><c:if test="${rm2.menu.id eq menu2.id }">checked="checked"</c:if></c:forEach>>${menu2.name }</label>
                                    </dt>
                                    <dd>
                                        <xzlTag:sysMenuListTag varid="menu3List" category="2" parentId="${menu2.id}" />
                                        <c:forEach var="permission" items="${menu3List }">
                                            <label><input type="checkbox" value="${permission.id }" name="menuIds" id="menu-${menu1.id }-${menu2.id }-${permission.id}" <c:forEach var="rm3" items="${rmList }"><c:if test="${rm3.menu.id eq permission.id }">checked="checked"</c:if></c:forEach>>${permission.name }</label>
                                        </c:forEach>
                                    </dd>
                                </dl>
                            </c:forEach>
                        </dd>
                    </dl>
                </c:forEach>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <input class="btn btn-primary radius" type="submit" value="提交">
                <form:hidden id="id" path="id" />
            </div>
        </div>
    </form:form>
</article>
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/system/sys-role/role-edit.js' />"></script>
</body>
</html>