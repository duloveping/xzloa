<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/views/common/meta.jsp" %>
    <%@ include file="/WEB-INF/views/common/javascript.jsp" %>
    <script type="text/javascript" src="<c:url value='/static/js/common/laypage/laypage.js'/>"></script>
    <title>学员试卷列表</title>
</head>
<body>
<div class="page-container">
    <table id="dataTableList" class="table table-border table-bordered table-hover table-bg table-sort">
        <thead>
        <tr class="text-c">
            <th>课程名称</th>
            <th>考试状态</th>
            <th>合格状态</th>
            <th>考试成绩</th>
            <th>考试时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="data" items="${list}">
            <tr class="text-c">
                <td>${data.courseName}</td>
                <td>
                    <c:choose>
                        <c:when test="${testState eq 1}">等待考试</c:when>
                        <c:when test="${testState eq 2}">开始考试</c:when>
                        <c:when test="${testState eq 3}">考试结束</c:when>
                        <c:otherwise>未开始</c:otherwise>
                    </c:choose>
                </td>
                <td>${data.passState ? '合格' : '不及格'}</td>
                <td>${data.testScore}</td>
                <td><fmt:formatDate value="${data.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td class="td-manage">
                    <a href="javascript:void(0);" onclick="deletePaper(this, '${data.id}')" style="text-decoration:none;" class="ml-5" title="删除"><i class="fa fa-remove fa-lg"></i></a>&nbsp;
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script type="text/javascript">
    function deletePaper(obj, paperId) {
        layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                type : "get",
                url : "/manage/study/employeeExaminationPaper/delete.jhtml?id=" + paperId,
                cache : false,
                dataType : "json",
                success : function(res){
                    if (res.status) {
                        $(obj).parents("tr").remove();
                        layer.msg('删除成功',{icon:1,time:3000});
                    } else {
                        layer.alert(res.info);
                    }
                }
            });
            layer.close(index);
        });
    }
</script>
</body>
</html>