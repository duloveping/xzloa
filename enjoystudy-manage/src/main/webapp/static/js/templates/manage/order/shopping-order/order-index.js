function goPage(curr) {
    $.ajax({
        type: "post",
        url: "/manage/order/shopping-order/list.jhtml",
        cache: false,
        data: {
            "pageNum": curr,
            "courseName": $.trim($("#courseName").val()),
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
    list: goPage,
    delete: function (obj, id) {
        top.layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                type : "get",
                url : "/manage/order/shopping-order/delete.jhtml",
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

var shoppingOrder = null;
$(function () {
    shoppingOrder = new ShoppingOrder();
    shoppingOrder.list(1);

    $("#searchBotton").bind("click", function(){
        shoppingOrder.list(1);
    });
});