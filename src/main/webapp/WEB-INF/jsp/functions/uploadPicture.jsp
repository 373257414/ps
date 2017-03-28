<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
    <title>北京邮电大学|图片档案馆|上传图片</title>

    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-default/index.css">
    <link rel="stylesheet" href="static/css/uploadPicture.css" media="screen">
    <link rel="stylesheet" href="static/css/reset.css" media="screen">
    <script src="static/js/jquery-2.2.4.js" type="text/javascript"></script>
    <script src="https://unpkg.com/vue@2.2.4/dist/vue.js"></script>
    <script src="https://unpkg.com/element-ui/lib/index.js"></script>

</head>

<body>
<div id="container">
    <header>
        <h1>上传图片</h1>
    </header>
    <div id="mainSection">
        <el-col :span="8" :offset="8">
        <form action="uploadAction" enctype="multipart/form-data" method="post">
            <el-row v-for="textInput in textInputs">
                <label :for="textInput.value">{{textInput.title}}</label>
                <input :type="textInput.type" :id="textInput.value" :name="textInput.value" size="15" maxlength="20">
            </el-row>
            <el-row v-for="select in selectInputs">
            <label :for="select.name">{{select.title}}</label>
            <select :name="select.name" :id="select.name">
                <option v-for="option in select.options" :value="option.value">{{option.label}}</option>
            </select>
        </el-row>
            <el-row>
                <label for="file">图片上传</label>
                <input type="file" id="file" name="file" size="15" maxlength="20">
            </el-row>
            <button type="submit">submit</button>
            <button type="reset">reset</button>
        </form>
        </el-col>
    </div>
</div>
<script src="static/js/uploadPicture.js" type="text/javascript"></script>
</body>
</html>

