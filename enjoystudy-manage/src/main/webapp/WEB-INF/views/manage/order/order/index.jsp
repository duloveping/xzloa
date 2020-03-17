<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/views/common/meta.jsp" %>
    <%@ include file="/WEB-INF/views/common/javascript.jsp" %>
    <script type="text/javascript" src="<c:url value='/static/js/common/My97DatePicker/WdatePicker.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/js/common/laypage/laypage.js'/>"></script>
    <title>购物车管理</title>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i>首页
    <span class="c-gray en">&gt;</span>商城管理
    <span class="c-gray en">&gt;</span>订单管理
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>
<div class="page-container">
    <div class="text-c">
        购买人: <input type="text" class="input-text" id="fullName" name="fullName" placeholder="购买人" maxlength="100" style="width: 100px;">
        订单编号: <input type="text" class="input-text" id="orderCode" name="orderCode" placeholder="订单编号" maxlength="100" style="width: 100px;">
        下单开始时间: <input type="text" class="input-text" id="startOrderTime" name="startOrderTime" placeholder="下单开始时间" maxlength="10" onfocus="WdatePicker()" class="Wdate" style="width: 100px;">
        下单结束时间: <input type="text" class="input-text" id="endOrderTime" name="endOrderTime" placeholder="下单结束时间" maxlength="10" onfocus="WdatePicker()" class="Wdate" style="width: 100px;">
        支付开始时间: <input type="text" class="input-text" id="startPayTime" name="startPayTime" placeholder="支付开始时间" maxlength="10" onfocus="WdatePicker()" class="Wdate" style="width: 100px;">
        支付结束时间: <input type="text" class="input-text" id="endPayTime" name="endPayTime" placeholder="支付结束时间" maxlength="10" onfocus="WdatePicker()" class="Wdate" style="width: 100px;">
        <button id="searchBotton" type="button" class="btn btn-success">
            <i class="Hui-iconfont">&#xe665;</i>搜索
        </button>
    </div>

    <table id="dataTableList" class="table table-border table-bordered table-hover table-bg table-sort">
        <thead>
        <tr class="text-c">
            <th scope="col" colspan="8" align="center">购物车管理</th>
        </tr>
        <tr class="text-c">
            <th width="100">购买人</th>
            <th width="130">订单编号</th>
            <th>课程名称</th>
            <th width="150">下单时间</th>
            <th width="150">付款时间</th>
            <th width="100">状态</th>
            <th width="100">金额</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>

    <div id="pageNav"></div>
</div>
<script type="text/javascript" src="<c:url value='/static/js/common/moment/moment.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/order/order/order-index.js'/>"></script>
<script id="dataTableListTpl" type="text/html">
    {{#  $.each(d.list, function(index, item) { }}
    <tr class="text-l">
        <td class="text-c">{{ item.fullName }}</td>
        <td class="text-c">{{ item.orderCode }}</td>
        <td class="text-c">
            {{#  $.each(item.orderItemList, function(i, v) { }}
                {{ v.courseName }}
                {{#  if(i > 0) { }}
                    <br />
                {{#  } }}
            {{#  }); }}
        </td>
        <td class="text-c">{{ moment(item.orderTime).format("YYYY-MM-DD HH:mm:ss") }}</td>
        <td class="text-c">{{ item.payState == 1 ? moment(item.payTime).format("YYYY-MM-DD HH:mm:ss") : '' }}</td>
        <td class="text-c">{{ item.payState == 1 ? '已支付' : '待支付' }}</td>
        <td class="text-c">{{ item.totalPrice }}</td>
    </tr>
    {{#  }); }}
</script>
</body>
</html>