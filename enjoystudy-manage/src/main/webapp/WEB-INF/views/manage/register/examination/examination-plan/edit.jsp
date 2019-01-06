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
    <script type="text/javascript" src="<c:url value='/static/js/common/My97DatePicker/WdatePicker.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/js/common/ueditor/ueditor.config.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/js/common/ueditor/ueditor.all.min.js'/>"> </script>
    <script type="text/javascript" src="<c:url value='/static/js/common/ueditor/lang/zh-cn/zh-cn.js'/>"></script>
    <title>考试计划安排管理</title>
</head>
<body>
<article class="page-container">
    <form:form id="inputForm" modelAttribute="so" method="post" action="#" cssClass="form form-horizontal">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>标题：
            </label>
            <div class="formControls col-xs-8 col-sm-10">
                <form:input id="title" path="title" placeholder="标题" maxlength="200" cssClass="required input-text"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>显示状态：</label>
            <div class="formControls col-xs-8 col-sm-10 skin-minimal">
                <div class="radio-box">
                    <form:radiobutton id="showState-1" path="showState" value="true"/>
                    <label for="showState-1">显示</label>
                </div>
                <div class="radio-box">
                    <form:radiobutton id="showState-2" path="showState" value="false"/>
                    <label for="showState-2">隐藏</label>
                </div>
            </div>
        </div>
        <div class="row cl">
            <table id="plan-list" class="table table-border table-bordered table-bg">
                <thead>
                <tr>
                    <th colspan="10" scope="col">考试安排计划明细</th>
                </tr>
                <tr class="text-c">
                    <th width="16%">证书</th>
                    <th width="16%">课程</th>
                    <th width="80">显示状态</th>
                    <th width="80">开始状态</th>
                    <th width="11%">开始报名时间</th>
                    <th width="11%">结束报名时间</th>
                    <th width="80">考试状态</th>
                    <th width="11%">开始考试时间</th>
                    <th width="11%">结束考试时间</th>
                    <th width="40">操作</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach var="data" items="${planList}">
                        <tr class="text-c">
                            <td>
                                <span class="select-box">
                                    <select name="certificateId" class="required select">
                                        <option>请选择</option>
                                        <c:forEach var="cert" items="${certificateList}">
                                            <option value="${cert.id}" <c:if test="${cert.id eq data.certificateId}">selected="selected"</c:if>>${cert.name}</option>
                                        </c:forEach>
                                    </select>
                                </span>
                            </td>
                            <td>
                                <span class="select-box">
                                    <select name="courseId" class="required select">
                                        <option>请选择</option>
                                        <c:forEach var="course" items="${courseList}">
                                            <option value="${course.id}"<c:if test="${course.id eq data.courseId}">selected="selected"</c:if>>${course.name}</option>
                                        </c:forEach>
                                    </select>
                                </span>
                            </td>
                            <td>
                                <span class="select-box">
                                    <select name="showState" class="required select">
                                        <option>请选择</option>
                                        <option value="true" <c:if test="${data.showState eq true}">selected="selected"</c:if>>显示</option>
                                        <option value="false" <c:if test="${data.showState eq false}">selected="selected"</c:if>>隐藏</option>
                                    </select>
                                </span>
                            </td>
                            <td>
                                <span class="select-box">
                                    <select name="entryState" class="required select">
                                        <option>请选择</option>
                                        <option value="1" <c:if test="${data.entryState eq 1}">selected="selected"</c:if>>待报名</option>
                                        <option value="2" <c:if test="${data.entryState eq 2}">selected="selected"</c:if>>开报名</option>
                                        <option value="3" <c:if test="${data.entryState eq 3}">selected="selected"</c:if>>结束报名</option>
                                    </select>
                                </span>
                            </td>
                            <td><input name="entryStartTime" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="required input-text Wdate" value="<fmt:formatDate value="${data.entryStartTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"></td>
                            <td><input name="entryEndTime" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="required input-text Wdate" value="<fmt:formatDate value="${data.entryEndTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"></td>
                            <td>
                                <span class="select-box">
                                    <select name="testState" class="required select">
                                        <option>请选择</option>
                                        <option value="1" <c:if test="${data.testState eq 1}">selected="selected"</c:if>>待考试</option>
                                        <option value="2" <c:if test="${data.testState eq 2}">selected="selected"</c:if>>开始考试</option>
                                        <option value="3" <c:if test="${data.testState eq 3}">selected="selected"</c:if>>结束考试</option>
                                    </select>
                                </span>
                            </td>
                            <td><input name="testStartTime" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="required input-text Wdate" value="<fmt:formatDate value="${data.testStartTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"></td>
                            <td><input name="testEndTime" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="required input-text Wdate" value="<fmt:formatDate value="${data.testEndTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"></td>
                            <td>
                                <a style="text-decoration:none" class="ml-5" onclick="copyPlanItem(this)" href="javascript:void(0);" title="添加">
                                    <i class="Hui-iconfont">&#xe600;</i>
                                </a>
                                <a style="text-decoration:none" class="ml-5" onclick="removePlanItem(this)" href="javascript:void(0);" title="删除">
                                    <i class="Hui-iconfont">&#xe6a1;</i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
                <tfoot>
                <tr>
                    <th colspan="10" scope="col">
                        <span class="l">
                            <a class="btn btn-primary radius" onclick="appendPlanItem()" href="javascript:void(0);">
                                <i class="Hui-iconfont">&#xe600;</i>
                            </a>
                        </span>
                    </th>
                </tr>
                </tfoot>
            </table>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
                <input class="btn btn-primary radius" type="submit" value="提交">
                <form:hidden id="id" path="id"/>
            </div>
        </div>
    </form:form>
</article>
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/register/examination/examination-plan/plan-edit.js' />"></script>
</body>
</html>