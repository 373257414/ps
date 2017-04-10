var container = new Vue({
    el:'#container',//body内最大的容器container
    data:{
        //高级搜索区域伸缩的计数器
        toggleCounter:0,
        //导航区域数据
        navBars:[
            {href:'loginJsp', title:'首页'},
            {href:'testJsp', title:'人气排行'}
        ],
        //登录表单数据
        loginInputs:[
            {id:'login_username', src:'static/img/ZHYuser16.png', title:'账号', type:'text', class:'username', name:'userName', placeholder:'请输入账号'},
            {id:'login_password', src:'static/img/ZHYpassword16.png', title:'密码', type:'password', class:'password', name:'password', placeholder:'请输入6~15位字母或数字'}
        ],
        //搜索表单数据
        searchKeys:[
            {value:'fileNumber', type:'text', title:'档案号码'},
            {value:'description', type:'text', title:'图片说明'},
            {value:'keyPerson', type:'text', title:'关键人物'},
            {value:'author', type:'text', title:'摄影人员'},
            {value:'place', type:'text', title:'拍摄地点'}
        ],
        //选择输入框数据
        selectInputs:[
            {
                name:'department',
                title:'归档部门',
                options:[]
            }, {
                name:'category',
                title:'图片种类',
                options:[]
            }
        ],
        //系统管理员功能链接
        systemFunctions:[
            {href:'classifyScanJsp',title:'分类浏览'},
            {href:'classifyScanJsp',title:'下载照片'},
            {href:'depManageJsp',title:'部门管理'},
            {href:'checkPictureJsp',title:'照片类别管理'},
            {href:'userManageJsp',title:'用户管理'},
            {href:'classifyScanJsp',title:'图片管理'}
        ],
        //部门管理员功能链接
        departmentFunctions:[
            {href:'classifyScanJsp',title:'分类浏览'},
            {href:'uploadPictureJsp',title:'上传照片'},
            {href:'classifyScanJsp',title:'下载照片'},
            {href:'classifyScanJsp',title:'部门用户管理'}
        ],
        //普通用户功能链接
        normalFunctions:[
            {href:'classifyScanJsp',title:'分类浏览'},
            {href:'classifyScanJsp',title:'下载照片'},
            {href:'uploadPictureJsp',title:'照片征集'}
        ]
    },
    mounted:function(){
        /*同时绑定密码输入框失去焦点和键盘敲击事件进行表单验证*/
        $(".password").bind("blur keypress",function() {
            var $parent = $(this).parent();
            $parent.find(".icon_formtips").remove();
            if(this.value == "" || this.value.length<6 || this.value.length>15) {		//密码为空或长度错误
                $parent.append("<img class='icon_inline icon_formtips' src='static/img/ZHYerror16.png' alt='错误' title='长度错误'/>");
            }
            else {
                $parent.append("<img class='icon_inline icon_formtips' src='static/img/ZHYcorrect16.png' alt='正确' title='输入正确'/>");
            }
        });
        //获取所有部门名称放入对应的选择输入框中
        $.get({
            url:'getAllDepartment',
            success:function(response){
                for(var i in response) {
                    container.selectInputs[0].options.push({
                        label:response[i].name,
                        value:response[i].id
                    });
                }
            },
            error:function(response){
                container.$message.error(response.statusText);
            }
        });
        //获取所有类别名称放入对应的选择输入框中
        $.get({
            url:'getAllCategory',
            success:function(response){
                for(var i in response) {
                    container.selectInputs[1].options.push({
                        label:response[i].name,
                        value:response[i].id
                    });
                }
            }
        });
    },
    methods:{
        //功能区域标题的伸缩
        headerToggle:function(event){
            $(event.target).parent().next().stop(true, false).slideToggle(500);
        },
        /*当输入框获得焦点时重置红色提示边框*/
        inputFocus:function(event){
            $(event.target).css("border-color","");
        },
        //高级搜索区域的伸缩
        advancedSearchToggle:function(){
            this.toggleCounter++;
            if(this.toggleCounter%2 == 1) {
                $(".firstSection").stop(true, false).slideUp(500,function() {
                    $("#A_SearchSection").stop(true, false).animate({height:"215px"},500,function() {
                        $(".icon_change_search").attr("src","static/img/ZHYgoup16.png");
                    });
                });
            }else if(this.toggleCounter%2 == 0) {
                $("#A_SearchSection").stop(true, false).animate({height:"0"},500,function() {
                    $(".firstSection").stop(true, false).slideDown(500,function() {
                        $(".icon_change_search").attr("src","static/img/ZHYgodown16.png");
                    });
                });
            }
        },
        /*给登录按钮添加表单验证，成功后提交表单*/
        onLogin:function(event){
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
        }
    }
});
