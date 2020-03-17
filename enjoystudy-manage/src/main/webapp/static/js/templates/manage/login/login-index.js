function keyDown(){
	var evt = window.event || arguments.callee.caller.arguments[0];
	if(evt.keyCode==13) {$("#loginform").submit()};
}

$(function(){
	$("#register").click(register);

    $("#inputForm").validate({
		rules : {
			username : {
				required : true,
			},
			password : {
				required : true,
			},
			checkCode : {
				required : true,
			}
		},
		onkeyup : false,
		focusCleanup : true,
		success : "valid",
		submitHandler : function(form) {
			var loadIndex = top.layer.load();
			$("#submit").prop("disabled", true);
			$("#reset").prop("disabled", true);
			$("#register").prop("register", true);

			$.ajax({
				type: "post",
				url: "login.jhtml",
				cache: false,
				data: $(form).serialize(),
				dataType: "json",
				success: function (res) {
					top.layer.close(loadIndex);
					$("#submit").prop("disabled", false);
					$("#reset").prop("disabled", false);
					$("#register").prop("register", false);

					if (res.success) {
						var menus = res.menus;
						localStorage.setItem(EMPLOYEE_MENU_PERMISSION_LIST, menus);
						var url = document.referrer;
						if (null !== url && typeof(url) !== "undefined" && "" !== url) {
							window.location.href = url;
						} else {
							window.location.href = "/manage/main/index.jhtml";
						}

					} else {
						$("#kaptchaImage").attr('src', '/images/kaptcha.jpg?' + Math.floor(Math.random()*100));
						$("#password").val("");
						$("#checkCode").val("");
                        layer.alert(res.message);
					}
				},
				error : function(XmlHttpRequest, textStatus, errorThrown) {
					top.layer.close(loadIndex);
					$("#submit").prop("disabled", false);
					$("#reset").prop("disabled", false);
					$("#register").prop("register", false);
					$("#kaptchaImage").attr('src', '/images/kaptcha.jpg?' + Math.floor(Math.random()*100));
					layer.alert('登录失败');
				}
			});
		}
	});
	
	$("#username").focus();
	
	$('#kaptchaImage').click(function () {
    	$(this).attr('src', '/images/kaptcha.jpg?' + Math.floor(Math.random()*100));
    });
});

function register() {
	document.location.href = "/manage/login/register.jhtml";
}


