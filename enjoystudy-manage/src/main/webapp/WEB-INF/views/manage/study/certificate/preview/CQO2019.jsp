<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>首席质量官证书</title>
    <%@ include file="/WEB-INF/views/common/meta.jsp" %>
    <%@ include file="/WEB-INF/views/manage/study/certificate/common/common.jsp" %>
</head>
<body>
<div id="paper" class="paper">
    <div class="logo">
        <img src="<c:url value='/static/js/images/logo.jpg'/>">
    </div>
    <div class="content">
        <div class="englishName">Certificate of training</div>
        <div class="chineseName">培训证书</div>
        <div class="englishCertify">This is to Certify that</div>
        <div class="chineseCertify">兹证明</div>
        <div class="fullName">${certificate.employeeName }</div>
        <div class="englishCertify">Has successfully completed the</div>
        <div class="chineseCertify">已成功完成了</div>
        <div class="englishCertify">E-study LTD.</div>
        <div class="chineseCertify">新咨力科技</div>
        <div class="englishCertify">CQO Training</div>
        <div class="chineseCertify">首席质量官培训</div>
        <div class="englishCertify">Course and Examination</div>
        <div class="chineseCertify">课程与考试</div>
        <div class="courseContent">
            <p class="p2">
                课程内容包括：课程内容包括：产品质量法规、质量战略、质量文化、质量经济性、质量管理基础、生产现场质量管理、质量改进与创新变革、质量管理体系、质量分析和改进工具、质量人才培养。
            </p>
        </div>
    </div>
    <div class="bottom">
        <div>
            <ul>
                <li>
                    Authorising<br>Signature：
                    <span class="line">&nbsp;&nbsp;<span class="sign">guqingfei</span>&nbsp;&nbsp;</span>
                </li>
                <li>
                    Course Date：<span class="line">&nbsp;&nbsp;<fmt:formatDate value="${certificate.certificateDate}" pattern="yyyy-MM-dd"/> &nbsp;&nbsp;</span>
                </li>
            </ul>
        </div>
        <div>
            <ul>
                <li>&nbsp;<br>&nbsp;</li>
                <li>Cert no：<span class="line">&nbsp;&nbsp;${certificate.certificateCode}</span>&nbsp;&nbsp;</li>
            </ul>
        </div>
    </div>
    <div  style="background-image:url(<c:url value="/static/js/images/xzlgz.png"/>); background-repeat :no-repeat; background-position:right bottom; width: 700px; height: 150px;"></div>
</div>
<input type="button" onclick="print()" value="打印"/>
</body>
</html>
