<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE>
<html lang="en">
<head>
    <title>北京邮电大学|图片档案馆|系统管理员|部门管理</title>

    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <link rel="stylesheet" href="/static/css/uploadPicture.css" media="screen">
    <link rel="stylesheet" href="/static/css/reset.css" media="screen">
    <script src="/static/js/jquery-2.2.4.js" type="text/javascript"></script>

</head>

<body>
<div id="container">
    <header>
        <h1>上传图片</h1>
    </header>
    <div id="mainSection">
        <form action="">
            <p>
                <label for="fileNumber">fileNumber</label>
                <input type="text" id="fileNumber" name="fileNumber">
            </p>
            <p>
                <label for="description">description</label>
                <input type="text" id="description" name="description">
            </p>
            <p>
                <label for="author">author</label>
                <input type="text" id="author" name="author">
            </p>
            <p>
                <label for="place">place</label>
                <input type="text" id="place" name="place">
            </p>
            <p>
                <label for="department">department</label>
                <input type="text" id="department" name="department">
            </p>
            <p>
                <label for="category">category</label>
                <input type="text" id="category" name="category">
            </p>
            <p>
                <label for="file">category</label>
                <input type="file" id="file" name="file">
            </p>
            <button type="submit">submit</button>
        </form>
    </div>
</div>
</body>
</html>
