<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>9001-2015内审员培训证书</title>
    <%@ include file="/WEB-INF/views/common/meta.jsp" %>
    <style media="print">
        @page {
            size: auto;  /* auto is the initial value */
            margin: 0mm; /* this affects the margin in the printer settings */
        }
    </style>
    <style type="text/css">
        @media print {
            body{
                -webkit-print-color-adjust:exact;
                -moz-print-color-adjust:exact;
                -ms-print-color-adjust:exact;
                print-color-adjust:exact;
            }
        }
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
            padding-left: 20px;
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
            <p class="p2">
                课程内容包括评估和评价符合质量体系要求<br/>ISO9001:2015
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
    <div  style="background-image:url(<c:url value="/static/js/images/xzlgz.png"/>); background-repeat :no-repeat; background-position:right bottom; width: 700px; height: 150px;"></div>
</div>
<input type="button" onclick="print()" value="打印"/>
<script type="text/javascript" src="<c:url value='/static/js/common/jquery/jquery-1.11.3.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/static/js/common/jquery-print/jQuery.print.js' />"></script>
<script type="text/javascript">
    function print() {
        $.print("#paper");
    }
</script>
</body>
</html>
