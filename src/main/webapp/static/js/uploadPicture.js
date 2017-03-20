/**
 * Created by yw on 2017/2/24.
 */
var container = new Vue({
    el:'#container',
    data: {
        inputs:[
            {value:'description', type:'text', title:'图片说明'},
            {value:'keyPerson', type:'text', title:'关键人物'},
            {value:'author', type:'text', title:'摄影人员'},
            {value:'place', type:'text', title:'拍摄地点'},
            {value:'department', type:'text', title:'归档部门'},
            {value:'category', type:'text', title:'图片种类'},
            {value:'photoDate', type:'text', title:'asdasd'},
            {value:'picture',type:'file',title:'picture'}
        ],
        uploadInputs: {
            description: '',
            keyPerson: '',
            author: '',
            place: '',
            department: '',
            category: '',
            photoDate:''
        },
        depSelects:[
            {label:'jiaowu',value:'0'},
            {label:'jiaoxue',value:'1'}
        ],
        catSelects:[
            {label:'xuexiao',value:'1'},
            {label:'xiaoqing',value:'2'}
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
        },
        fileList:[]
    },
    methods:{
        handlePreview:function(){},
        handleRemove:function(){},
        handleChange:function(file, fileList){
            console.log(file,fileList);
        },
        handleBefore:function(file){
            console.log(file);
        },
        submitUpload:function(){
            this.$refs.upload.submit();
            console.log(this.fileList);
        },
        upload:function(){
            $.post({
                url:'uploadPicture',
                data:{
                    description:this.description,
                    keyPerson:this.keyPerson,
                    author:this.author,
                    place:this.place,
                    department: this.department,
                    category:this.category,
                    photoDate:this.photoDate,
                },
                success:function(response){
                    console.log(response);
                }
            })
        }
    }
});