$(document).ready(function()
{
	$("#pwdChangeSection").hide();		//修改区域本身是隐藏的
	$("#emailChangeSection").hide();
	$("#pwdChange").click(function()
	{		//点击“修改登录密码”
		$("#password").find(".formtips").remove();		//每次点击“修改”将所有输入框重置
		$("#resetBtn").click();
		$("#emailChangeSection").hide();		//隐藏邮箱修改区域
		$("#pwdChangeSection").show();		//显示密码修改区域
		$("#newPassword1").focus(function()
		{		//为“请输入新密码”添加焦点事件
			var $parent = $(this).parent();
			$parent.find(".formtips").remove();		//防止追加冗余
			var Msg = "6~20位字符（字母、数字、符号）";
			$parent.append("<p class='formtips onError'>" + Msg + "</p>");
		});
		$("#password :input").blur(function()
		{		//为表单元素添加失去焦点事件
			var $parent = $(this).parent();
			$parent.find(".formtips").remove();		//防止追加冗余
			if($(this).is("#oldPassword"))
			{		//验证当前密码
				if(this.value == "")
				{		//当前密码为空
					var errorMsg = "请输入密码";
					$parent.append("<p class='formtips onError'>" + errorMsg + "</p>");
				}
			}
			if($(this).is("#newPassword1"))
			{		//新密码的验证
				if(this.value == "" || this.value.length<6 || this.value.length>20)
				{		//新密码长度错误
					var errorMsg = "密码长度不正确，请输入6~20个字符";
					$parent.append("<p class='formtips onError'>" + errorMsg + "</p>");
				}
				else if(this.value == $("#oldPassword").val())
				{
					var errorMsg = "新密码必须和当前密码不同";
					$parent.append("<p class='formtips onError'>" + errorMsg + "</p>");
				}
				else
				{
					var okMsg = "密码格式正确";
					$parent.append("<p class='formtips onOk'>" + okMsg + "</p>");
				}
			}
			if($(this).is("#newPassword2"))
			{		//新密码的二次验证
				if(this.value == "" || this.value.length<6 || this.value.length>20)
				{		//密码长度错误
					var errorMsg = "密码长度不正确，请输入6~20个字符";
					$parent.append("<p class='formtips onError'>" + errorMsg + "</p>");
				}
				else if(this.value != $("#newPassword1").val())
				{		//两次输入不一致
					var errorMsg = "两次密码输入的不一致，请重新输入";
					$parent.append("<p class='formtips onError'>" + errorMsg + "</p>");
				}
				else
				{		//两次输入一致
					var okMsg = "输入正确";
					$parent.append("<p class='formtips onOk'>" + okMsg + "</p>");
				}
			}
		});
		return false;		//阻止链接
	});
	$("#emailChange").click(function()
	{		//点击“修改电子邮箱”
		$("#email").find(".formtips").remove();		//每次点击“修改”将所有输入框重置
		$(".resetBtn").click();
		$("#pwdChangeSection").hide();		//隐藏密码修改区域
		$("#emailChangeSection").show();		//显示邮箱修改区域
		$("#email :input").blur(function()
		{		//为表单元素添加失去焦点事件
			var $parent = $(this).parent();
			$parent.find(".formtips").remove();		//防止追加冗余
			if($(this).is("#userName"))
			{		//用户名的验证
				if(this.value == "")
				{
					var errorMsg = "请输入当前用户名";
					$parent.append("<p class='formtips onError'>" + errorMsg + "</P>");
				}
			}
			if($(this).is("#pwdForEmail"))
			{		//密码的验证
				if(this.value == "")
				{
					var errorMsg = "请输入密码";
					$parent.append("<p class='formtips onError'>" + errorMsg + "</p>");
				}
			}
			if($(this).is("#newEmail"))
			{		//邮箱的验证
				if(this.value == "")
				{
					var errorMsg = "请输入新的电子邮箱";
					$parent.append("<p class='formtips onError'>" + errorMsg + "</p>");
				}
				else if(this.value!="" && !/.+@.+\.[a-zA-Z]{2,4}$/.test(this.value))
				{
					var errorMsg = "邮箱地址格式错误";
					$parent.append("<p class='formtips onError'>" + errorMsg + "</p>");
				}
				else
				{
					var okMsg = "输入正确";
					$parent.append("<p class='formtips onOk'>" + okMsg + "</p>");
				}
			}
		});
		return false;		//阻止链接
	});
});