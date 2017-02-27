$(document).ready(function()
{
    /*Vue.component('zhy-quickSearch',{
        template:'<div id="A_inputSec"><p v-for="col in input"><label :for="col.id">{{col.text}}</label><input :type="col.type" :id="col.id" :name="col.name" :size="col.size" :maxlength="col.maxlength"/></p></div>',
        data(){
            return{
                input:[
                    {id:'fileNumber',type:'text',name:'fileNumber',size:15,maxlength:20,text:'归档号码'},
                    {id:'pictureIntro',type:'text',name:'pictureIntro',size:15,maxlength:20,text:'图片说明'},
                    {id:'importantPerson',type:'text',name:'importantPerson',size:15,maxlength:20,text:'关键人物'},
                    {id:'photographer',type:'text',name:'photographer',size:15,maxlength:20,text:'摄影人员'},
                    {id:'placeOfTaken',type:'text',name:'placeOfTaken',size:15,maxlength:20,text:'拍摄地点'},
                    {id:'fileDepartment',type:'text',name:'fileDepartment',size:15,maxlength:20,text:'归档部门'},
                    {id:'pictureKind',type:'text',name:'pictureKind',size:15,maxlength:20,text:'图片种类'},
                ]
            };
        }
    })
    new Vue({
        el:'#A_searchForm',
    })*/

    var counter_search = 0;
    var $icon_change_search = $(".icon_change_search");
    $("#A_Search_link").click(function(event)
    {
        counter_search++;
        if(counter_search%2 == 1)
        {
            $(".firstSection").stop(true, false).slideUp(500,function()
            {
                $("#A_SearchSection").stop(true, false).animate({height:"215px"},500,function()
                {
                    $icon_change_search.attr("src","/static/img/ZHYgoup16.png");
                });
            });
        }
        else if(counter_search%2 == 0)
        {
            $("#A_SearchSection").stop(true, false).animate({height:"0"},500,function()
            {
                $(".firstSection").stop(true, false).slideDown(500,function()
                {
                    $icon_change_search.attr("src","/static/img/ZHYgodown16.png");
                });
            });
        }
        event.preventDefault();
    })


});