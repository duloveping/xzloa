<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>9001-2015内审员培训证书</title>
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
        <div class="englishCertify">Internal Auditor Training</div>
        <div class="chineseCertify">内审员培训</div>
        <div class="englishCertify">Course and Examination</div>
        <div class="chineseCertify">课程与考试</div>
        <div class="courseContent">
            <p class="p1">
                The course includes the assessment and evaluation of<br/>
                Quality System to conform to the requirements of<br/>
                ISO9001:2015
            </p>
            <p class="p2">课程内容包括评估和评价符合质量体系要求<br/>ISO9001:2015</p>
        </div>
    </div>
    <div class="bottom">
        <div>
            <ul>
                <li>
                    Authorising<br>Signature：
                    <span class="line">
                            &nbsp;&nbsp;<span class="sign">zhang suo</span>&nbsp;&nbsp;
                        </span>
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
