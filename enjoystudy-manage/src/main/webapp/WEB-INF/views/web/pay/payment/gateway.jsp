<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="https://vsp.allinpay.com/apiweb/gateway/pay" method="post">
    <input name="cusid" type="text" value="${so.cusid}"><br>
    <input name="appid" type="text" value="${so.appid}"><br>
    <input name="charset" type="text" value="${so.charset}"><br>
    <input name="returl" type="text" value="${so.returl}"><br>
    <input name="notifyurl" type="text" value="${so.notifyurl}"><br>
    <input name="goodsid" type="text" value="${so.goodsid}"><br>
    <input name="goodsinf" type="text" value="${so.goodsinf}"><br>
    <input name="trxamt" type="text" value="${so.trxamt}"><br>
    <input name="orderid" type="text" value="${so.orderid}"><br>
    <input name="randomstr" type="text" value="${so.randomstr}"><br>
    <input name="gateid" type="text" value="${so.gateid}"><br>
    <input name="paytype" type="text" value="${so.paytype}"><br>
    <input name="validtime" type="text" value="${so.validtime}"><br>
    <input name="limitpay" type="text" value="${so.limitpay}"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
