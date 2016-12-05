$(document).ready(function()
{
	$("#pwdChangeSection").hide();		//�޸������������ص�
	$("#emailChangeSection").hide();
	$("#pwdChange").click(function()
		{		//������޸ĵ�¼���롱
			$("#password").find(".formtips").remove();		//ÿ�ε�����޸ġ����������������
			$("#resetBtn").click();
			$("#emailChangeSection").hide();		//���������޸�����
			$("#pwdChangeSection").show();		//��ʾ�����޸�����
			$("#newPassword1").focus(function()
				{		//Ϊ�������������롱��ӽ����¼�
					var $parent = $(this).parent();
					$parent.find(".formtips").remove();		//��ֹ׷������
					var Msg = "6~20λ�ַ�����ĸ�����֡����ţ�";
					$parent.append("<p class='formtips onError'>" + Msg + "</p>");
				});
			$("#password :input").blur(function()
				{		//Ϊ��Ԫ�����ʧȥ�����¼�
					var $parent = $(this).parent();
					$parent.find(".formtips").remove();		//��ֹ׷������
					if($(this).is("#oldPassword"))
						{		//��֤��ǰ����
							if(this.value == "")
								{		//��ǰ����Ϊ��
									var errorMsg = "����������";
									$parent.append("<p class='formtips onError'>" + errorMsg + "</p>");
								}
						}
					if($(this).is("#newPassword1"))
						{		//���������֤
							if(this.value == "" || this.value.length<6 || this.value.length>20)
								{		//�����볤�ȴ���
									var errorMsg = "���볤�Ȳ���ȷ��������6~20���ַ�";
									$parent.append("<p class='formtips onError'>" + errorMsg + "</p>");
								}
							else if(this.value == $("#oldPassword").val())
								{
									var errorMsg = "���������͵�ǰ���벻ͬ";
									$parent.append("<p class='formtips onError'>" + errorMsg + "</p>");
								}
							else
								{
									var okMsg = "�����ʽ��ȷ";
									$parent.append("<p class='formtips onOk'>" + okMsg + "</p>");
								}
						}
					if($(this).is("#newPassword2"))
						{		//������Ķ�����֤
							if(this.value == "" || this.value.length<6 || this.value.length>20)
								{		//���볤�ȴ���
									var errorMsg = "���볤�Ȳ���ȷ��������6~20���ַ�";
									$parent.append("<p class='formtips onError'>" + errorMsg + "</p>");
								}
							else if(this.value != $("#newPassword1").val())
								{		//�������벻һ��
									var errorMsg = "������������Ĳ�һ�£�����������";
									$parent.append("<p class='formtips onError'>" + errorMsg + "</p>");
								}
							else
								{		//��������һ��
									var okMsg = "������ȷ";
									$parent.append("<p class='formtips onOk'>" + okMsg + "</p>");
								}
						}
				});
				return false;		//��ֹ����
		});
	$("#emailChange").click(function()
		{		//������޸ĵ������䡱
			$("#email").find(".formtips").remove();		//ÿ�ε�����޸ġ����������������
			$(".resetBtn").click();
			$("#pwdChangeSection").hide();		//���������޸�����
			$("#emailChangeSection").show();		//��ʾ�����޸�����
			$("#email :input").blur(function()
				{		//Ϊ��Ԫ�����ʧȥ�����¼�
					var $parent = $(this).parent();
					$parent.find(".formtips").remove();		//��ֹ׷������
					if($(this).is("#userName"))
						{		//�û�������֤
							if(this.value == "")
								{
									var errorMsg = "�����뵱ǰ�û���";
									$parent.append("<p class='formtips onError'>" + errorMsg + "</P>");
								}
						}
					if($(this).is("#pwdForEmail"))
						{		//�������֤
							if(this.value == "")
								{
									var errorMsg = "����������";
									$parent.append("<p class='formtips onError'>" + errorMsg + "</p>");
								}
						}
					if($(this).is("#newEmail"))
						{		//�������֤
							if(this.value == "")
								{
									var errorMsg = "�������µĵ�������";
									$parent.append("<p class='formtips onError'>" + errorMsg + "</p>");
								}
							else if(this.value!="" && !/.+@.+\.[a-zA-Z]{2,4}$/.test(this.value))
								{
									var errorMsg = "�����ַ��ʽ����";
									$parent.append("<p class='formtips onError'>" + errorMsg + "</p>");
								}
							else
								{
									var okMsg = "������ȷ";
									$parent.append("<p class='formtips onOk'>" + okMsg + "</p>");
								}
						}
				});
			return false;		//��ֹ����
		});
});