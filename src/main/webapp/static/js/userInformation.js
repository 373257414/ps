var container = new Vue({
	el:'#container',
	data:{
		userId:0,
		userData:[
			{username:'zhy', nickname:'zhy', password:12345678, email:'qwe@asd.com', department:'1', permission:'3'}
		]
	},
	mounted:function(){
		this.getUserData();
	},
	methods:{
		getUserData:function(){
			$.get({
				url:'getUserData',
				data:this.userId,
				success:function(response){},
				error:function(response){}
			});
		},
		editUser:function(index,row){}
	}
});