<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html lang="en">
  <head>
	<meta http-equiv="content-type" content="text/html;charset=utf-8"/>
      <title>北京邮电大学|图片档案馆|游客登录|分类浏览</title>
      <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-default/index.css">
	<link rel="stylesheet" href="static/css/classifyScan.css" media="screen">
    <link rel="stylesheet" href="static/css/reset.css" media="screen">
      <script src="static/js/jquery-2.2.4.js" type="text/javascript"></script>
      <script src="https://unpkg.com/vue@2.2.4/dist/vue.js"></script>
      <script src="https://unpkg.com/element-ui/lib/index.js"></script>

  </head>
  
<body>
    <div id="container">
        <header>
            <h1>分类浏览</h1>
        </header>
        <div id="classSection">
            <el-select v-model="categoryId" placeholder="请选择" @change="getPicture">
                <el-option v-for="category in categories" :label="category.name" :value="category.id"></el-option>
            </el-select>
        </div>
        <div id="scanSection">
            <el-dialog v-model="dialogVisible" custom-class="dialog" size="small">
                <img :src="dialogPictureInfo.src" style="width:300px">
                <div id="pictureInfo">
                    <P>摄影人员：{{dialogPictureInfo.author}}</P>
                    <P>主要人物：{{dialogPictureInfo.keyPerson}}</P>
                    <P>图片说明：{{dialogPictureInfo.description}}</P>
                    <P>图片名称：{{dialogPictureInfo.name}}</P>
                    <P>拍摄时间：{{dialogPictureInfo.time}}</P>
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
<script src="static/js/classifyScan.js" type="text/javascript"></script>
</body>
</html>
