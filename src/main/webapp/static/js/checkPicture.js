/**
 * Created by yw on 2017/3/20.
 */
var container = new Vue({
    el:'#container',
    data:{
        pictures:[
            {src:'/static/img/desert.jpg', fileNumber:'0', description:'lalala0', time:'2014.1.1',check:true},
            {src:'/static/img/background.jpg', fileNumber:'1', description:'lalala1', time:'2014.1.2',check:true},
            {src:'/static/img/penguin.jpg', fileNumber:'2', description:'lalala2', time:'2014.1.3',check:true},
            {src:'/static/img/penguin.jpg', fileNumber:'3', description:'lalala3', time:'2014.1.4',check:true}
        ],
        pagination:{
            currentPage:1,
            pageSize:6,
            total:100
        }
    },
    mounted:function(){
        $('.image').width($('.el-card').width());
    },
    methods:{
        handleCurrentChange:function(val){
            this.pagination.currentPage = val;
            $.get({
                url:'getCheckPic',
                data:{
                    currentPage:this.pagination.currentPage
                },
                success:function(response){
                    console.log(response);
                }
            });
        },
        uploadResult:function(){
            $.post({
                url:'postCheckResult',
                data:{},
                success:function(response){
                    console.log(response);
                },
                error:function(response){
                    console.log(response);
                }
            })
        }
    }
})