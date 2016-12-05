$(document).ready(function()
{
	/*��������ý���ʱ���ú�ɫ��ʾ�߿�*/
	$(".username,.password").focus(function()
		{
			$(this).css("border-color","");
		})
	/*ͬʱ�����������ʧȥ����ͼ����û��¼����б���֤*/
	$(".password").bind("blur keypress",function()
		{
			var $parent = $(this).parent();
			$parent.find(".icon_formtips").remove();
			if(this.value == "" || this.value.length<6 || this.value.length>15)
				{		//����Ϊ�ջ򳤶ȴ���
					$parent.append("<img class='icon_inline icon_formtips' src='img/ZHYerror16.png' alt='����' title='���ȴ���'/>");
				}
			else
				{
					$parent.append("<img class='icon_inline icon_formtips' src='img/ZHYcorrect16.png' alt='��ȷ' title='������ȷ'/>");
				}
		})
	/*����¼��ť��ӱ���֤������ת��controller����*/
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
	/*��ȡ��ַ���������ж����˺Ż����������*/
 	var args = getQueryStringArgs();
	if(args["message"] == "�˺Ų�����")
		{
			$("#login_username").css("border-color","red");
		}
	if(args["message"] == "�������")
		{
			$("#login_password").css("border-color","red");
		}
});