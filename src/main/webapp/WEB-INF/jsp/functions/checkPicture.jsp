<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html lang="en">
<head>

    <meta http-equiv="content-type" content="text/html;charset=utf-8"/>
    <title>北京邮电大学|图片档案馆|游客登录|分类浏览</title>
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-default/index.css">
    <link rel="stylesheet" href="/static/css/checkPicture.css" media="screen">
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
    </div>
    <div id="scanSection">
        <el-row>
            <el-col :span="8" v-for="picture in pictures">
                <el-card :body-style="{ padding: '0px' }">
                    <a href="javascript:;"><img :src="picture.src" class="image"></a>
                    <div style="padding: 14px;">
                        <p>档案号码：{{picture.fileNumber}}</p>
                        <p>图片说明：{{picture.description}}</p>
                        <p>拍摄时间：{{picture.time}}</p>
                        <el-switch v-model="picture.check" on-color="#13ce66" on-text="通过" off-color="#ff4949" off-text="删除"></el-switch>
                    </div>
                </el-card>
            </el-col>
        </el-row>
        <el-row>
            <el-button type="success" icon="uplaod" @click="uploadResult">提交审核结果</el-button>
        </el-row>
        <el-col :span="8" :offset="8">
            <el-pagination @current-change="handleCurrentChange" :current-page="pagination.currentPage" :page-size="pagination.pageSize" layout="total, prev, pager, next, jumper" :total="pagination.total"></el-pagination>
        </el-col>
    </div>
</div>
<script src="/static/js/checkPicture.js" type="text/javascript"></script>
</body>
</html>
