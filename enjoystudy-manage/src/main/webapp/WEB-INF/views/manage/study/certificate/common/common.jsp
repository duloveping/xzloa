<%@ page pageEncoding="UTF-8"%>
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
        margin: 30px 0px auto 0px;
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
<script type="text/javascript" src="<c:url value='/static/js/common/jquery/jquery-1.11.3.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/static/js/common/jquery-print/jQuery.print.js' />"></script>
<script type="text/javascript">
    function print() {
        $.print("#paper");
    }
</script>