$(document).ready(function() {
	var container = new Vue({
		el:'#container',
		data:{
			navBars:[
				{href:'/loginJsp', title:'首页'},
				{href:'#', title:'人气排行'}
				],
			loginInputs:[
				{id:'login_username', src:'/static/img/ZHYuser16.png', title:'账号', type:'text', class:'username', name:'userName', placeholder:'请输入账号'},
				{id:'login_password', src:'/static/img/ZHYpassword16.png', title:'密码', type:'password', class:'password', name:'password', placeholder:'请输入6~15位字母或数字'}
				],
            searchKeys:[
                {value:'fileNumber', type:'text', title:'档案号码', select:'selected'},
                {value:'description', type:'text', title:'图片说明'},
                {value:'keyPerson', type:'text', title:'关键人物'},
                {value:'author', type:'text', title:'摄影人员'},
                {value:'place', type:'text', title:'拍摄地点'},
                {value:'department', type:'text', title:'归档部门'},
                {value:'category', type:'text', title:'图片种类'}
                ]
		}
	});
	/*当输入框获得焦点时重置红色提示边框*/
	$(".username,.password").focus(function() {
		$(this).css("border-color","");
	})
	/*同时绑定密码输入框失去焦点和键盘敲击事件进行表单验证*/
	$(".password").bind("blur keypress",function() {
		var $parent = $(this).parent();
		$parent.find(".icon_formtips").remove();
		if(this.value == "" || this.value.length<6 || this.value.length>15) {		//密码为空或长度错误
			$parent.append("<img class='icon_inline icon_formtips' src='/static/img/ZHYerror16.png' alt='错误' title='长度错误'/>");
		}
		else {
			$parent.append("<img class='icon_inline icon_formtips' src='/static/img/ZHYcorrect16.png' alt='正确' title='输入正确'/>");
		}
	})
	/*给登录按钮添加表单验证，并跳转到action对象*/
	$("#loginBtn").click(function() {
		if($("#login_username").val().trim() == "") {
			$("#login_username").css("border-color","red");
			return false;
		}
		else if($("#login_password").val() == "" || $("#login_password").val().length<6 || $("#login_password").val().length>15) {
			$("#login_password").css("border-color","red");
			return false;
		}
		else {
			document.getElementById("loginForm").action = "loginAction";
			$("#loginForm").submit();
		}
	})
	/*获取地址栏参数并判断是账号还是密码错误*/
	/*var args = getQueryStringArgs();
	if(args !== 'undefined'){
        if(args["message"] == "账号不存在") {
            $("#login_username").css("border-color","red");
        }
        if(args["message"] == "密码错误") {
            $("#login_password").css("border-color","red");
        }
	}*/
});