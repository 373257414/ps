/**
 * Created by zhy on 2017/3/7.
 */
var container = new Vue({
    el: '#container',
    data: {
        categoryId:1,
        dialogVisible:false,
        dialogPictureSrc:'',
        categories:[],
        pictures:[
            {src:'/static/img/desert.jpg', fileNumber:'0', description:'lalala0', time:'2014.1.1'},
            {src:'/static/img/background.jpg', fileNumber:'1', description:'lalala1', time:'2014.1.2'},
            {src:'/static/img/penguin.jpg', fileNumber:'2', description:'lalala2', time:'2014.1.3'},
            {src:'/static/img/penguin.jpg', fileNumber:'3', description:'lalala3', time:'2014.1.4'}
        ],
        pagination:{
            currentPage:1,
            pageSize:6,
            total:100
        }
    },
    mounted:function(){
        $.get({
            url:'getAllCategory',
            success:function(response){
                for(var i in response) {
                    container.categories.push({
                        id:response[i].id,
                        name:response[i].name
                    });
                }
            },
            error:function(response){
                console.log(response);
            }
        });
        $.get({
            url:'getPicInCat',
            data:{
                categoryId:this.categoryId,
                currentPage:this.pagination.currentPage
            },
            success:function(response){
                console.log(response);
                for(var i in response){
                    container.pictures.push({
                        src:'F:/checkpicture/'+response[i].name
                    })
                }
            }
        });
        $('.image').width($('.el-card').width());
    },
    methods:{
        handleCurrentChange:function(val){
            this.pagination.currentPage = val;
            $.get({
                url:'getPicInCat',
                data:{
                    categoryId:this.categoryId,
                    currentPage:this.pagination.currentPage
                },
                success:function(response){
                    console.log(response);
                }
            })
        },
        handleCategoryChange:function(){
            this.categoryId = $("#myCategory").val();
            $.get({
                url:'getPicSumInCat',
                data:{
                    categoryId:this.categoryId,
                },
                success:function(response){
                    container.pagination.total = response;
                    $.get({
                        url:'getPicInCat',
                        data:{
                            categoryId:container.categoryId,
                            currentPage:1
                        },
                        success:function(responsePic){
                            console.log(responsePic);
                            container.pagination.currentPage = 1;
                        }
                    })
                }
            });
        },
        showPicture:function(event){
            this.dialogPictureSrc = event.target.src;
            this.dialogVisible = true;
        }
    }
});