function goPage() {
    $.ajax({
        type: "post",
        url: "/manage/order/shopping-cart/list.jhtml",
        cache: false,
        data: {
            "courseName": $.trim($("#courseName").val()),
            "rnd": Math.random()
        },
        dataType: "json",
        success: function (res) {
            if (res.status) {
                var list = new Array();

                $.each(res.datas, function(i, v){
                    var cart= {
                        id: v.id,
                        accountId: "",
                        typeId: v.typeId,
                        typeCode: v.typeCode,
                        typeName: v.typeName,
                        teacherId: v.teacherId,
                        teacherName: v.teacherName,
                        courseId: v.courseId,
                        courseCode: v.courseCode,
                        courseName: v.courseName,
                        image: v.image,
                        currentPrice: v.currentPrice,
                        marketPrice: v.marketPrice,
                        salePrice: v.salePrice,
                        buyAmount: v.buyAmount,
                        totalPrice: v.totalPrice
                    };
                    list.push(cart);
                });

                var getTpl = document.getElementById("dataTableListTpl").innerHTML;

                laytpl(getTpl).render({list:list}, function (html) {
                    $("#dataTableList > tbody").html(html);
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

function ShoppingCart() {};

ShoppingCart.prototype = {
    list: goPage,
    delete: function (obj, id) {
        top.layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                type : "get",
                url : "/manage/order/shopping-cart/delete.jhtml",
                cache : false,
                data : {"id" : id, "rnd" : Math.random()},
                dataType : "json",
                success : function(res){
                    if (res.status) {
                        top.layer.msg('删除成功',{icon:1,time:3000});
                    } else {
                        top.layer.alert(res.info);
                    }

                }
            });
            $(obj).parents("tr").remove();
            top.layer.close(index);
        });
    },
};

var shoppingCart = null;
$(function () {
    shoppingCart = new ShoppingCart();
    shoppingCart.list(1);

    $("#searchBotton").bind("click", function(){
        shoppingCart.list(1);
    });
});