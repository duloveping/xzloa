<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>证书预览</title>
    <%@ include file="/WEB-INF/views/common/meta.jsp" %>
    <style type="text/css">
        .paper{
            margin: auto 0px;
            width: 210mm;
            text-align: center;
        }

        .paper .logo{
        }

        .paper .content{
            margin: 0 auto;
            width: 190mm;
        }

        .paper .content > .englishName{
            font-family: Calibri Light;
            font-size: 56px;
            text-align: center;

        }
        .paper .content > .chineseName{
            font-family: 黑体;
            font-size: 48px;
        }

        .paper .content > .englishCertify{
            font-family: Calibri Light;
            font-size: 32px;
        }

        .paper .content > .chineseCertify{
            font-family: 黑体;
            font-size: 24px;
        }

        .paper .content > .fullName{
            background-color: #CCCCCC;
            margin: 0 auto;
            width: 100mm;
            font-family: 黑体;
            font-size: 24px;
        }

        .paper .content > .courseContent{
            width: 170mm;
            font-size: 24px;
        }

        .courseContent > .p1{
            font-family: Calibri Light;
        }

        .courseContent > .p2{
            font-family: 黑体;
        }

        .paper .bottom{
        }

        .paper .bottom > div{
            float: left;
            text-align: left;
            width: 105mm;
        }

        .paper .bottom > div > ul li{
            list-style-type:none;
            font-size: 16px;
        }

        .line{
            text-decoration: underline;
        }

        .sign {
            font-family: Gigi;
        }

    </style>
</head>
<body>
    <div class="paper">
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
                    The course includes the assessment and evaluation of<br>
                    Quality System to conform to the requirements of<br>
                    ${certificate.certificateName}
                </p>
                <p class="p2">
                    课程内容包括评估和评价符合质量体系要求<br>
                    ${certificate.certificateName}
                </p>
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
    </div>
</body>
</html>
