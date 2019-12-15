<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/views/common/meta.jsp" %>
    <%@ include file="/WEB-INF/views/common/javascript.jsp" %>
    <script type="text/javascript" src="<c:url value='/static/js/common/laypage/laypage.js'/>"></script>
    <title>购物车管理</title>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i>首页
    <span class="c-gray en">&gt;</span>个人中心
    <span class="c-gray en">&gt;</span>我的购物车
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>
<div class="page-container">
    <div class="text-c">
        课程名称: <input type="text" class="input-text" id="courseName" name="courseName" placeholder="课程名称" maxlength="50" style="width: 200px;">
        <button id="searchBotton" type="button" class="btn btn-success">
            <i class="Hui-iconfont">&#xe665;</i>搜索
        </button>
    </div>

    <table id="dataTableList" class="table table-border table-bordered table-hover table-bg table-sort">
        <thead>
        <tr class="text-c">
            <th scope="col" colspan="6" align="center">购物车管理</th>
        </tr>
        <tr class="text-c">
            <th>课程名称</th>
            <th width="100">价格</th>
            <th width="50">操作</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>
</div>

<script type="text/javascript" src="<c:url value='/static/js/templates/manage/order/shopping-cart/cart-index.js'/>"></script>
<script id="dataTableListTpl" type="text/html">
    {{#  $.each(d.list, function(index, item) { }}
    <tr class="text-l">
        <td>
            {{#  if (null !== item.image && (typeof item.image !== "undefined") && "" !== item.image) { }}
            <img src="{{ item.image }}" width="60" height="60" align="center">
            {{#  } }}
            <a href="/web/course/view.jhtml?id={{ item.courseId }}" target="_blank">{{ item.courseName }}</a>
        </td>
        <td class="text-c">{{ item.currentPrice }}</td>
        <td class="text-c td-manage">
            <a href="javascript:void(0);" onclick="shoppingCart.delete(this, '{{item.id}}')" style="text-decoration:none;" class="ml-5" title="删除"><i class="fa fa-remove fa-lg"></i></a>
        </td>
    </tr>
    {{#  }); }}
</script>
</body>
</html>