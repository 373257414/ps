$(document).ready(function()
{
	$("#depEdit").hide();
	$("#departments>option").click(function()
		{		/*select����¼�*/
			var index = $("option").index(this);		/*��ȡselect���������optionѡ�������,��0��ʼ*/
			$("#depId").attr("value",index+1);		/*ʵʱ��ʾ���ű����Ϣ*/
			var name = $(this).text();		/*��ȡ�������option�е��ı�*/
			$("#depName").attr("value",name);		/*ʵʱ��ʾ����������Ϣ*/
			/*ʣ�µĲ��ŵ绰�Ͳ��ŵ�ַ�������ݿ�������*/
		});
	$("#editDepBtn").click(function()
		{		/*�༭���Ű�ť����¼�*/
			$("#depEdit").show();		/*��ʾ���ű༭����*/
		});
});