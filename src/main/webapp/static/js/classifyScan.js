/**
 * Created by yw on 2017/3/7.
 */
$(document).ready(function(){
    $.ajax({
        url:'/getAllCategory',
        type:'GET',
        success:function(data){
            console.log(data);
        },
        error:function(data){
            console.log(data);
        }
    })
})
