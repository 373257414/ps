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
                change:'handleDepChange',
                title:'归档部门',
                options:[
                    {label:'教务处',value:'0'},
                    {label:'教学处',value:'1'}
                ]
            }, {
                name:'category',
                change:'handleCatChange',
                title:'图片种类',
                options:[
                    {label:'校园',value:'1'},
                    {label:'校庆',value:'2'}
                ]
            }
        ],
        pickerOptions: {
            disabledDate:function(time) {
                return time.getTime() > Date.now();
            },
            shortcuts: [{
                text: '今天',
                onClick:function(picker) {
                    picker.$emit('pick', new Date());
                }
            },{
                text: '一周前',
                onClick:function(picker) {
                    var date = new Date();
                    date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
                    picker.$emit('pick', date);
                }
            }]
        }
    },
    methods:{
        handleDepChange:function(){},
        handleCatChange:function(){}
    }
});