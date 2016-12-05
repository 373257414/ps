$(document).ready(function()
{
	$("#userEdit").hide();		//初始时将编辑区域隐藏
	var counter_addUser = 0;
	/*点击添加用户将编辑区显示*/
	$("#addUserBtn").click(function()
	{
		counter_addUser++;
		if(counter_addUser%2 == 1)
		{
			$("#userEdit").show();
		}
		else if(counter_addUser%2 == 0)
		{
			$("#userEdit").hide();
		}	
	})
	/*当输入框获得焦点时重置红色提示边框*/
	$(".username,.password,select").focus(function()
	{
			$(this).css("border-color","");
	})
	/*点击提交按钮进行表单验证*/
	$("#submitBtn").click(function()
	{
		if($("#edit_username").val().trim() == "")
		{
			$("#edit_username").css("border-color","red");
			return false;
		}
		else if($("#edit_password").val() == "" || $("#edit_password").val().length<6 || $("#edit_password").val().length>15)
		{
			$("#edit_password").css("border-color","red");
		}
		else if($("#edit_departmentId").val() == "")
		{
			$("#edit_departmentId").css("border-color","red");
			return false;
		}
		else if($("#edit_permissionId").val() == "")
		{
			$("#edit_permissionId").css("border-color","red");
			return false;
		}
		else
		{
			var reg = confirm("添加账户为：" + $('#edit_username').val() + "\n"
					+ "添加密码为：" + $('#edit_password').val() + "\n"
					+ "添加部门为：" + $('#edit_departmentId option:selected').text() + "\n"
					+ "添加权限为：" + $('#edit_permissionId option:selected').text() + "\n"
					+ "是否确认添加新用户？")
			if(reg == true)
			{
				$("#editForm").submit();
			}
		}
	})
});