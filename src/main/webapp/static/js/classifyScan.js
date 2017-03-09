/**
 * Created by zhy on 2017/3/7.
 */
$(document).ready(function(){
    var container = new Vue({
        el: '#container',
        data: {
            categories:[],
            pictures:[
                {src:'/static/img/desert.jpg', fileNumber:'0', description:'lalala0', author:'zhy'},
                {src:'/static/img/background.jpg', fileNumber:'1', description:'lalala1', author:'lrz'},
                {src:'/static/img/penguin.jpg', fileNumber:'2', description:'lalala2', author:'wm'},
                {src:'/static/img/penguin.jpg', fileNumber:'3', description:'lalala3', author:'yg'}
                ],
            pagination:{
                currentPage:1,
                pageSize:6,
                total:4
            }
        },
    });
    $('.image').width($('.el-card').width());
    $.ajax({
        url:'getAllCategory',
        type:'GET',
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
    $.ajax({
        url:'getPicture',
        type:'GET',
        success:function(response){
            console.log(response);
        }
    })
})
function getPicture(){
    console.log($("#myCategory").val());
};
