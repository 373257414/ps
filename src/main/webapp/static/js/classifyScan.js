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
            {src:'/static/img/background.jpg', fileNumber:'1', description:'lalala1', time:'2014.1.2'}
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
                        src:'/pic/checkpicture/' + response[i].name
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
                            if(responsePic.length !== 0){
                                container.pictures = [];
                                for(var i in responsePic){
                                    container.pictures.push({
                                        src:'/checkpicture/' + responsePic[i].name
                                    })
                                }
                            }else{
                                container.$message.error('此类别中无图片');
                            }
                        },
                        error:function(responsePic){
                            container.$message.error("获取图片失败");
                        }
                    })
                },
                error:function(response){
                    container.$message.error("获取个数失败")
                }
            });
        },
        showPicture:function(event){
            this.dialogPictureSrc = event.target.src;
            this.dialogVisible = true;
        }
    }
});