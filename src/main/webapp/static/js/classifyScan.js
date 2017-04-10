/**
 * Created by zhy on 2017/3/7.
 */
var container = new Vue({
    el: '#container',
    data: {
        categoryId:1,
        //详细查看图片的对话框可见性
        dialogVisible:false,
        //详细查看图片的信息
        dialogPictureInfo:{
            src:'',
            author:'',
            keyPerson:'',
            description:'',
            name:'',
            time:''
        },
        //类别数组
        categories:[],
        //图片数组
        pictures:[],
        //分页组件的属性
        pagination:{
            currentPage:1,
            pageSize:6,
            total:0
        }
    },
    mounted:function(){
        //获取所有类别
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
        //页码变化
        handleCurrentChange:function(val){
            this.pagination.currentPage = val;
            $.get({
                url:'getPicInCat',
                data:{
                    categoryId:this.categoryId,
                    currentPage:this.pagination.currentPage
                },
                success:function(response){
                    container.pictures = [];
                    for(var i in response){
                        container.pictures.push({
                            src:'pspic/checkpicture/' + response[i].name,
                            fileNumber:response[i].fileNumber,
                            description:response[i].description,
                            time:response[i].photoDate.toString(),
                            author:response[i].author,
                            keyPerson:response[i].keyPerson,
                            name:response[i].name
                        })
                    }
                }
            })
        },
        //获取图片
        getPicture:function(){
            //获取类别内图片个数
            $.get({
                url:'getPicSumInCat',
                data:{
                    categoryId:this.categoryId,
                },
                success:function(response){
                    container.pagination.total = response;
                    //获取类别内图片，每页6张
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
                                        src:'pspic/checkpicture/' + responsePic[i].name,
                                        fileNumber:responsePic[i].fileNumber,
                                        description:responsePic[i].description,
                                        time:responsePic[i].photoDate.toString(),
                                        author:responsePic[i].author,
                                        keyPerson:responsePic[i].keyPerson,
                                        name:responsePic[i].name
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
        //详细展示图片，未完成
        showPicture:function(event){
            this.dialogPictureInfo.src = event.target.src;
            /*this.dialogPictureInfo.author = event.target.author;
            this.dialogPictureInfo.keyPerson = event.target.keyPerson;
            this.dialogPictureInfo.description = event.target.description;
            this.dialogPictureInfo.name = event.target.name;
            this.dialogPictureInfo.time = event.target.time;*/
            this.dialogVisible = true;
        }
    }
});