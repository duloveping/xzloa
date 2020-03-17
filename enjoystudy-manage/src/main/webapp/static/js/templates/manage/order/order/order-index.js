function goPage(curr) {
    $.ajax({
        type: "post",
        url: "/manage/order/order-admin/list.jhtml",
        cache: false,
        data: {
            "pageNum": curr,
            "fullName": $("#fullName").val(),
            "orderCode": $("#orderCode").val(),
            "startOrderTime": $("#startOrderTime").val(),
            "endOrderTime": $("#endOrderTime").val(),
            "startPayTime": $("#startPayTime").val(),
            "endPayTime": $("#endPayTime").val(),
            "rnd": Math.random()
        },
        dataType: "json",
        success: function (res) {
            if (res.status) {
                var getTpl = document.getElementById("dataTableListTpl").innerHTML;

                laytpl(getTpl).render({list: res.datas}, function (html) {
                    $("#dataTableList > tbody").html(html);
                });

                laypage({
                    cont: 'pageNav',
                    pages: res.pages,
                    groups: 10,
                    curr: curr || 1,
                    jump: function (obj, first) {
                        if (!first) {
                            goPage(obj.curr);
                        }
                    }
                });
            } else {
                top.layer.alert(res.info);
            }
        },
        error : function(XmlHttpRequest, textStatus, errorThrown) {
            top.layer.alert('系统出错了。');
        }
    });
}

function ShoppingOrder() {};

ShoppingOrder.prototype = {
    list: goPage
};

var shoppingOrder = null;
$(function () {
    shoppingOrder = new ShoppingOrder();
    shoppingOrder.list(1);

    $("#searchBotton").bind("click", function(){
        shoppingOrder.list(1);
    });
});