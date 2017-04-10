<%@ page language="java" pageEncoding="utf-8" %>

<!DOCTYPE HTML>
<html>
<head>

    <title>北京邮电大学|图片档案馆|个人信息</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-default/index.css">
    <link rel="stylesheet" href="static/css/userInformation.css" media="screen">
    <link rel="stylesheet" href="static/css/reset.css" media="screen">
    <script src="static/js/jquery-2.2.4.js" type="text/javascript"></script>
    <script src="https://unpkg.com/vue@2.2.4/dist/vue.js"></script>
    <script src="https://unpkg.com/element-ui/lib/index.js"></script>
</head>

<body>
<div id="container">
    <header>
        <h1>个人信息</h1>
    </header>
    <div id="mainSection">
        <el-row>
            <el-table :data="userData" border>
                <el-table-column prop="username" label="用户名" fixed="left" width="120"></el-table-column>
                <el-table-column prop="nickname" label="昵称" width="120"></el-table-column>
                <el-table-column prop="password" label="密码" width="150"></el-table-column>
                <el-table-column prop="email" label="邮箱" width="150"></el-table-column>
                <el-table-column prop="department" label="部门" width="80"></el-table-column>
                <el-table-column prop="permission" label="权限" width="80"></el-table-column>
                <el-table-column fixed="right" label="操作" width="70">
                    <template scope="scope"><el-button-group>
                        <el-tooltip class="item" effect="dark" content="修改" placement="top"><el-button type="primary" size="small" icon="edit" @click="editUser(scope.$index, scope.row)"></el-button></el-tooltip>
                    </el-button-group></template>
                </el-table-column>
            </el-table>
        </el-row>
    </div>
</div>
<script src="static/js/userInformation.js" type="text/javascript"></script>
</body>
</html>
