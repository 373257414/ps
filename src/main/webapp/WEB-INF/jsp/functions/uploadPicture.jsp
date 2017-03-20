<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
    <title>北京邮电大学|图片档案馆|上传图片</title>

    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-default/index.css">
    <link rel="stylesheet" href="/static/css/uploadPicture.css" media="screen">
    <link rel="stylesheet" href="/static/css/reset.css" media="screen">
    <script src="/static/js/jquery-2.2.4.js" type="text/javascript"></script>
    <script src="https://unpkg.com/vue@2.2.4/dist/vue.js"></script>
    <script src="https://unpkg.com/element-ui/lib/index.js"></script>

</head>

<body>
<div id="container">
    <header>
        <h1>上传图片</h1>
    </header>
    <div id="mainSection">
        <!--<el-col :span="10">
        <el-form :model="uploadInputs" label-width="80px">
            <el-form-item label="图片说明">
                <el-input v-model="uploadInputs.description"></el-input>
            </el-form-item>
            <el-form-item label="关键人物">
                <el-input v-model="uploadInputs.keyPerson"></el-input>
            </el-form-item>
            <el-form-item label="摄影人员">
                <el-input v-model="uploadInputs.author"></el-input>
            </el-form-item>
            <el-form-item label="拍摄地点">
                <el-input v-model="uploadInputs.place"></el-input>
            </el-form-item>
            <el-form-item label="归档部门">
                <el-select v-model="uploadInputs.department">
                    <el-option v-for="depSelect in depSelects" :label="depSelect.label" :value="depSelect.value"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="图片种类">
                <el-select v-model="uploadInputs.category">
                    <el-option v-for="catSelect in catSelects" :label="catSelect.label" :value="catSelect.value"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="拍摄日期">
                <el-date-picker v-model="uploadInputs.photoDate" type="date" placeholder="选择日期" :picker-options="pickerOptions"></el-date-picker>
            </el-form-item>
        </el-form>
        </el-col>
        <el-col :span="10" :offset="2">
            <el-upload ref="upload" action="https://jsonplaceholder.typicode.com/posts/" :on-change="handleChange" :on-preview="handlePreview" :before-upload="handleBefore" :file-list="fileList" :auto-upload="false">
                <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
                <div slot="tip" class="el-upload__tip">只能上传jpg/png文件</div>
            </el-upload>
        </el-col>
        <el-button style="margin-left: 10px;" size="small" type="success" @click="submitUpload">上传到待审核库</el-button>-->
        <form action="/uploadAction" enctype="multipart/form-data" method="post">
            <p v-for="input in inputs">
                <label :for="input.value">{{input.title}}</label>
                <input :type="input.type" :id="input.value" :name="input.value" size="15" maxlength="20">
            </p>
            <button type="submit">submit</button>
            <button type="reset">reset</button>
        </form>
    </div>
</div>
<script src="/static/js/uploadPicture.js" type="text/javascript"></script>
</body>
</html>

