$(function () {
    $("#onceBuy").on("click", function () {
        var id = $("#courseTable").attr("data-id");

        $.ajax({
            type: "get",
            url: "/web/shop/web-shopping-order/onceBuy.jhtml?courseId=" + id + "&rnd=" + Math.random(),
            dataType: "json",
            success: function (res) {
                if (res.status) {
                    document.location.href = "/web/shop/web-shopping-order/payment.jhtml?orderId=" + res.data.id;
                } else {
                    top.layer.alert(res.info);
                }
            },
            error : function(XmlHttpRequest, textStatus, errorThrown) {
                top.layer.alert('生成系统订单时出错了。');
            }
        });
    });
});