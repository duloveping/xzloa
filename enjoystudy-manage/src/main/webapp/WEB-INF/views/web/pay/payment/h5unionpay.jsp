<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="https://syb.allinpay.com/apiweb/h5unionpay/unionorder" method="post">
    <input name="cusid" type="text" value="${so.cusid}"><br>
    <input name="appid" type="text" value="${so.appid}"><br>
    <input name="version" type="text" value="${so.version}"><br>
    <input name="trxamt" type="text" value="${so.trxamt}"><br>
    <input name="reqsn" type="text" value="${so.reqsn}"><br>
    <input name="charset" type="text" value="${so.charset}"><br>
    <input name="returl" type="text" value="${so.returl}"><br>
    <input name="notify_url" type="text" value="${so.notifyUrl}"><br>
    <input name="body" type="text" value="${so.body}"><br>
    <input name="remark" type="text" value="${so.remark}"><br>
    <input name="randomstr" type="text" value="${so.randomstr}"><br>
    <input name="validtime" type="text" value="${so.validtime}"><br>
    <input name="limit_pay" type="text" value="${so.limitPay}"><br>
    <input name="asinfo" type="text" value="${so.asinfo}"><br>
    <input name="sign" type="text" value="${so.sign}"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
