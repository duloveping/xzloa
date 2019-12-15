<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/views/common/meta.jsp" %>
    <%@ include file="/WEB-INF/views/common/javascript.jsp" %>
    <script type="text/javascript" src="<c:url value='/static/js/common/laypage/laypage.js'/>"></script>
    <title>我的订单</title>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i>首页
    <span class="c-gray en">&gt;</span>个人中心
    <span class="c-gray en">&gt;</span>我的订单
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>
<div class="page-container">
    <table id="dataTableList" class="table table-border table-bordered table-hover table-bg table-sort">
        <thead>
        <tr class="text-c">
            <th scope="col" colspan="7" align="center">订单管理</th>
        </tr>
        <tr class="text-c">
            <th width="150">订单编号</th>
            <th>课程名称</th>
            <th width="150">订单时间</th>
            <th width="100">付款状态</th>
            <th width="150">付款时间</th>
            <th width="100">价格</th>
            <th width="50">操作</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>

    <div id="pageNav"></div>
</div>
<script type="text/javascript" src="<c:url value='/static/js/common/moment/moment.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/js/templates/manage/order/shopping-order/order-index.js'/>"></script>
<script id="dataTableListTpl" type="text/html">
    {{#  $.each(d.list, function(index, item) { }}
    <tr class="text-l">
        <td>{{ item.orderCode }}</td>
        <td>
            {{#  $.each(item.orderItemList, function(i, v) { }}
            <p><a href="/web/course/view.jhtml?id={{ v.courseId }}" target="_blank">{{ v.courseName }}</a></p>
            {{#  }); }}
        </td>
        <td>{{ moment(item.orderTime).format("YYYY-MM-DD HH:mm:ss") }}</td>
        <td>
            {{# if (item.payState == 0){ }}
                待付款
            {{# } else if (item.payState == 1){ }}
                已付款
            {{# } }}
        </td>
        <td>
            {{# if (item.payState == 1){ }}
                {{ moment(item.payTime).format("YYYY-MM-DD HH:mm:ss") }}
            {{# } }}
        </td>
        <td class="text-c">{{ item.totalPrice }}</td>
        <td class="text-c td-manage">
            {{# if (item.payState == 0){ }}
            <a href="/web/shop/web-shopping-order/payment.jhtml?orderId={{ item.id }}" style="text-decoration:none;" class="ml-5" title="支付" target="_blank"><i class="fa fa-credit-card fa-lg"></i></a>
            <a href="javascript:void(0);" onclick="shoppingOrder.delete(this, '{{item.id}}')" style="text-decoration:none;" class="ml-5" title="删除"><i class="fa fa-remove fa-lg"></i></a>
            {{# } }}
        </td>
    </tr>
    {{#  }); }}
</script>
</body>
</html>