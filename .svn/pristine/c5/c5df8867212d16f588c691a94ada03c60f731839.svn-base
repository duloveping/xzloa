function goPage(curr) {
	var keywords = $.trim($("#keywords").val())
		if ("" == keywords) {
			layer.alert("关键词不能为空");
		} else {
			$.ajax({
				type : "post",
				url : "info-list.jhtml",
				cache : false,
				data : {
					"pageNumber" : curr,
					"keywords" : keywords,
					"rnd" : Math.random()
				},
				dataType : "json",
				success : function (res) {
					if (res.status) {
						var html = "";
						var array = res.datas;
						if (array.length > 0) {
							for (var i = 0; i < array.length; i++) {
								var data = array[i];
								var highlight = data.highlight;
								var title = (null == highlight.title ? data.title : highlight.title);
								html += "<tr>";
								if (data.dataType == 'INFO_ARTICLE') {
									html += "<td colspan=\"2\"><p><a href=\"javascript:void(0);\" onclick=\"searchObj.articleView(" + data.dataId + ")\">" + title + "</a></p><p><a href=\"javascript:void(0);\" onclick=\"searchObj.articleView(" + data.dataId + ")\">" + highlight.content + "</a></p></td>";
								} else {
									html += "<td colspan=\"2\"><p><a href=\"javascript:void(0);\" onclick=\"searchObj.documentView(" + data.dataId + ")\">" + title + "</a></p><p><a href=\"javascript:void(0);\" onclick=\"searchObj.documentView(" + data.dataId + ")\">" + highlight.content + "</a></p></td>";
								}
								html += "</tr>";
							}
						} else {
							html += "<tr>";
							html += "<td><p>没有搜索到相关记录。</p></td>";
							html += "</tr>";
						}

						$("#dataTableList").html(html);

						laypage({
							cont : 'pageNav',
							pages : res.pages,
							groups : 10,
							curr : curr || 1,
							jump : function (obj, first) {
								if (!first) {
									goPage(obj.curr);
								}
							}
						});
					} else {
						layer.alert(res.info);
					}
				},
				error : function (XmlHttpRequest, textStatus, errorThrown) {
					layer.alert('无权限操作');
				}
			});
		}

}

function SolrSearch() {};

SolrSearch.prototype = {
	list : goPage,
	articleView : function (id) {
		top.layer.open({
            type: 2,
            title: '文件预览',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: '../../manage/article/info-news/view/' + id + '.jhtml'
        });
	},
	documentView : function (id) {
		top.layer.open({
			type : 2,
			title : '文件预览',
			shadeClose : true,
			shade : 0.8,
			area : ['640px', '480px'],
			maxmin : true,
			content : '../../manage/article/info-attachment/view/' + id + '.jhtml'
		});
	}
}

var searchObj = null;
$(function () {
	searchObj = new SolrSearch();

	$("#searchBotton").bind("click", function () {
		searchObj.list(1);
	});
});
