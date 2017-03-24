<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html lang="en">
<head>

    <meta http-equiv="content-type" content="text/html;charset=utf-8"/>
    <title>北京邮电大学|图片档案馆|游客登录|审核图片</title>
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-default/index.css">
    <link rel="stylesheet" href="/static/css/classifyScan.css" media="screen">
    <link rel="stylesheet" href="/static/css/reset.css" media="screen">
    <script src="/static/js/jquery-2.2.4.js" type="text/javascript"></script>
    <script src="https://unpkg.com/vue@2.2.4/dist/vue.js"></script>
    <script src="https://unpkg.com/element-ui/lib/index.js"></script>

</head>

<body>
<div id="container">
    <header>
        <h1>审核图片</h1>
    </header>
    <div id="classSection">
        <el-select v-model="categoryId" placeholder="请选择" @change="handleCategoryChange">
            <el-option v-for="category in categories" :label="category.name" :value="category.id"></el-option>
        </el-select>
    </div>
    <div id="scanSection">
        <el-dialog v-model="dialogVisible" custom-class="dialog" size="large">
            <img :src="dialogPictureSrc" style="width:300px;height:300px">
            <div>
                <div id="pictureInfo">

                </div>
                <el-button-group>
                    <el-button type="primary" @click="submitPic()">通过</el-button>
                    <el-button type="danger" @click="deletePic()">删除</el-button>
                </el-button-group>
            </div>
        </el-dialog>
        <el-row>
            <el-col :span="8" v-for="picture in pictures">
                <el-card :body-style="{ padding: '0px' }">
                    <a href="javascript:;" @click="showPicture"><img :src="picture.src" class="image"></a>
                    <div style="padding: 14px;">
                        <p>档案号码：{{picture.fileNumber}}</p>
                        <p>图片说明：{{picture.description}}</p>
                        <p>拍摄时间：{{picture.time}}</p>
                    </div>
                </el-card>
            </el-col>
        </el-row>
        <el-col :span="8" :offset="8">
            <el-pagination @current-change="handleCurrentChange" :current-page="pagination.currentPage" :page-size="pagination.pageSize" layout="total, prev, pager, next, jumper" :total="pagination.total"></el-pagination>
        </el-col>
    </div>
</div>
<script src="/static/js/classifyScan.js" type="text/javascript"></script>
</body>
</html>
