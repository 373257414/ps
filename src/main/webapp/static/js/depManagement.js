$(document).ready(function()
{
	$("#depEdit").hide();
	$("#departments>option").click(function()
		{		/*select点击事件*/
			var index = $("option").index(this);		/*获取select里所点击的option选项的索引,从0开始*/
			$("#depId").attr("value",index+1);		/*实时显示部门编号信息*/
			var name = $(this).text();		/*获取所点击的option中的文本*/
			$("#depName").attr("value",name);		/*实时显示部门名称信息*/
			/*剩下的部门电话和部门地址根据数据库来调用*/
		});
	$("#editDepBtn").click(function()
		{		/*编辑部门按钮点击事件*/
			$("#depEdit").show();		/*显示部门编辑区域*/
		});
});