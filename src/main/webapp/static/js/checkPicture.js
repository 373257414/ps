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
        pictures:[],
        picturesInfo:{},
        pagination:{
            currentPage:1,
            pageSize:6,
            total:0
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
        this.getPicture();
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
            this.getPicture();
        },
        getPicture:function(){
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
                                        src:'/pspic/checkpicture/' + responsePic[i].name,
                                        fileNumber:responsePic[i].fileNumber,
                                        description:responsePic[i].description,
                                        time:responsePic[i].photoDate.toString()
                                    })
                                }
                                $('.image').width($('.el-card').width());
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
        },
        submitPic:function(){},
        deletePic:function(){}
    }
});