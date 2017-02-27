$(document).ready(function()
{
	/*当输入框获得焦点时重置红色提示边框*/
	$(".username,.password").focus(function()
	{
		$(this).css("border-color","");
	})
	/*同时绑定密码输入框失去焦点和键盘敲击事件进行表单验证*/
	$(".password").bind("blur keypress",function()
	{
		var $parent = $(this).parent();
		$parent.find(".icon_formtips").remove();
		if(this.value == "" || this.value.length<6 || this.value.length>15)
		{		//密码为空或长度错误
			$parent.append("<img class='icon_inline icon_formtips' src='/static/img/ZHYerror16.png' alt='错误' title='长度错误'/>");
		}
		else
		{
			$parent.append("<img class='icon_inline icon_formtips' src='/static/img/ZHYcorrect16.png' alt='正确' title='输入正确'/>");
		}
	})
	/*给登录按钮添加表单验证，并跳转到action对象*/
	$("#loginBtn").click(function()
	{
		if($("#login_username").val().trim() == "")
		{
			$("#login_username").css("border-color","red");
			return false;
		}
		else if($("#login_password").val() == "" || $("#login_password").val().length<6 || $("#login_password").val().length>15)
		{
			$("#login_password").css("border-color","red");
			return false;
		}
		else
		{
			document.getElementById("loginForm").action = "loginAction";
			$("#loginForm").submit();
		}
	})
	/*获取地址栏参数并判断是账号还是密码错误*/
	var args = getQueryStringArgs();
	if(args["message"]){
        if(args["message"] == "账号不存在")
        {
            $("#login_username").css("border-color","red");
        }
        if(args["message"] == "密码错误")
        {
            $("#login_password").css("border-color","red");
        }
	}
});