$(document).ready(function()
{
	$("#userEdit").hide();		//��ʼʱ���༭��������
	var counter_addUser = 0;
	/*�������û����༭����ʾ*/
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
	/*��������ý���ʱ���ú�ɫ��ʾ�߿�*/
	$(".username,.password,select").focus(function()
	{
			$(this).css("border-color","");
	})
	/*����ύ��ť���б���֤*/
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
			var reg = confirm("����˻�Ϊ��" + $('#edit_username').val() + "\n"
					+ "�������Ϊ��" + $('#edit_password').val() + "\n"
					+ "��Ӳ���Ϊ��" + $('#edit_departmentId option:selected').text() + "\n"
					+ "���Ȩ��Ϊ��" + $('#edit_permissionId option:selected').text() + "\n"
					+ "�Ƿ�ȷ��������û���")
			if(reg == true)
			{
				$("#editForm").submit();
			}
		}
	})
});