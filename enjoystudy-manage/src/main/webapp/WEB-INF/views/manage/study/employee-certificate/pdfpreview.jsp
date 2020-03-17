<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="UTF-8">
        <title>在指定div中浏览PDF</title>
        <!--在此引入bootstrap只为初始化样式div样式-->
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <style>
            /* 添加样式是为了实现全屏效果 */
            html,body{
                height: 100%;
                overflow: hidden;
            }
            
            #example1{
                height: 100%;
            }
            
            .pdfobject-container{
                /* height: 500px; */
            }
            
            .pdfobject{
                /* border: 1px solid #666; */
            }
        </style>
    </head>

    <body>
        <div id="example1"></div>
        <script type="text/javascript" src="<c:url value='/static/js/templates/manage/study/employee-certificate/pdfobject.min.js'/>"></script>
        <script>
            window.location="<c:url value='/static/'/>"+"${pdfpath}";
        </script>
    </body>
</html>