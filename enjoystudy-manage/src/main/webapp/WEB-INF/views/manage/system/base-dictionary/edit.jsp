<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/views/common/meta.jsp" %>
    <%@ include file="/WEB-INF/views/common/javascript.jsp" %>
    <script type="text/javascript" src="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/jquery.validation/1.14.0/jquery.validate.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/jquery.validation/1.14.0/validate-methods.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/js/common/H-ui.admin_v3.0/lib/jquery.validation/1.14.0/messages_zh.js'/>"></script>
    <title>字典管理</title>
</head>
<body>
<article class="page-container">
    <form:form id="inputForm" modelAttribute="so" method="post" action="#" cssClass="form form-horizontal">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">
                <span class="c-red">*</span>编号：
            </label>
            <div class="formControls col-xs-8 col-sm-9">
                <form:input id="code" path="code" placeholder="编号" maxlength="50" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">
                <span class="c-red">*</span>名称：
            </label>
            <div class="formControls col-xs-8 col-sm-9">
                <form:input id="name" path="name" placeholder="名称" maxlength="50" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">
                <span class="c-red">*</span>项目：
            </label>
            <div class="formControls col-xs-8 col-sm-9">
                <table class="table table-border table-bordered table-bg mt-20">
                    <thead>
                        <tr class="text-c" align="center">
                            <th scope="col">编号</th>
                            <th scope="col">名称</th>
                            <th scope="col">状态</th>
                            <th scope="col">排序</th>
                            <th scope="col">删除</th>
                        </tr>
                    </thead>
                    <tbody id="dictionaryItemList">
                        <c:if test="${empty so.itemList}">
                            <tr>
                                <td>
                                    <input name="itemCodes" type="text" value="" maxlength="10" placeholder="项目编号" class="required input-text">
                                </td>
                                <td>
                                    <input name="itemNames" type="text" value="" maxlength="100" placeholder="项目名称" class="required input-text">
                                </td>
                                <td width="80">
                                    <span class="select-box">
                                        <select name="itemStates" class="required select">
                                            <option value="true">显示</option>
                                            <option value="false" selected="selected">隐藏</option>
                                        </select>
                                    </span>
                                </td>
                                <td width="80">
                                    <input name="itemSorts" type="number" value="1" maxlength="4" placeholder="项目排序" max="9999" min="0" class="required input-text">
                                </td>
                                <td width="50">
                                    <a class="btn btn-primary radius" onclick="$(this).parent().parent().remove();" href="javascript:void(0);" title="删除项目">
                                        <i class="Hui-iconfont">&#xe6a1;</i>
                                    </a>
                                </td>
                            </tr>
                        </c:if>
                        <c:if test="${not empty so.itemList}">
                            <c:forEach var="item" items="${so.itemList}">
                                <tr>
                                    <td>
                                        <input name="itemCodes" type="text" value="${item.itemValue}" maxlength="10" placeholder="项目编号" class="required input-text">
                                    </td>
                                    <td>
                                        <input name="itemNames" type="text" value="${item.itemText}" maxlength="100" placeholder="项目名称" class="required input-text">
                                    </td>
                                    <td width="80">
                                        <span class="select-box">
                                            <select name="itemStates" class="required select">
                                                <option value="true" <c:if test="${item.showState eq true}">selected="selected"</c:if>>显示</option>
                                                <option value="false" <c:if test="${item.showState eq false}">selected="selected"</c:if>>隐藏</option>
                                            </select>
                                        </span>
                                    </td>
                                    <td width="80">
                                        <input name="itemSorts" type="number" value="${item.serialNumber}" maxlength="4" placeholder="项目排序" max="9999" min="0" class="required input-text">
                                    </td>
                                    <td width="50">
                                        <a class="btn btn-primary radius" onclick="$(this).parent().parent().remove();" href="javascript:void(0);" title="删除项目">
                                            <i class="Hui-iconfont">&#xe6a1;</i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:if>
                    </tbody>
                    <tfoot>
                        <tr>
                            <th colspan="5" scope="col">
                                <a class="btn btn-primary radius" onclick="addDictionaryItem()" href="javascript:void(0);" title="添加项目">
                                    <i class="Hui-iconfont">&#xe600;</i>
                                </a>
                            </th>
                        </tr>
                    </tfoot>
                </table>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">
                <span class="c-red">*</span>状态：
            </label>
            <div class="formControls col-xs-8 col-sm-9">
                <form:radiobutton id="showState-1" path="showState" value="true" label="显示" cssClass="required"/>
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
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <input class="btn btn-primary radius" type="submit" value="提交">
                <form:hidden id="id" path="id" />
            </div>
        </div>
    </form:form>
</article>
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/system/dictionary/dictionary-edit.js' />"></script>
</body>
</html>