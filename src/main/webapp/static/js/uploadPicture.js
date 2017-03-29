/**
 * Created by yw on 2017/2/24.
 */
var container = new Vue({
    el:'#container',
    data: {
        textInputs:[
            {value:'description', type:'text', title:'图片说明'},
            {value:'keyPerson', type:'text', title:'关键人物'},
            {value:'author', type:'text', title:'摄影人员'},
            {value:'place', type:'text', title:'拍摄地点'},
            {value:'photoDate', type:'date', title:'拍摄时间'}
        ],
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
    },
    mounted:function(){
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
        handleDepChange:function(){},
        handleCatChange:function(){},
    }
});