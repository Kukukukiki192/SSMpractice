<%--
  Created by IntelliJ IDEA.
  User: K
  Date: 2021/4/14
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><%--应用服务器--%>
    <title>Title</title>
</head>
<body>

    <h3>SpringMVC文件上传</h3>
    <form action="user/fileUpload1" method="post" enctype="multipart/form-data">
        上传文件<input type="file" name="upload"/><br>
        <input type="submit" value="上传">
    </form>

    <h3>多个文件上传</h3>
    <form action="user/fileUpload2" method="post" enctype="multipart/form-data">
        选择文件:<input type="file" name="files"><br>
        选择文件:<input type="file" name="files"><br>
        选择文件:<input type="file" name="files"><br>
        <input type="submit" value="上传">
    </form>

    <h3>跨服务器文件上传</h3>
    <form action="user/fileUpload3" method="post" enctype="multipart/form-data">
        上传文件<input type="file" name="upload"/><br>
        <input type="submit" value="上传">
    </form>

    <h3>跨服务器多个文件上传</h3>
    <form action="user/fileUpload4" method="post" enctype="multipart/form-data">
        选择文件:<input type="file" name="files"><br>
        选择文件:<input type="file" name="files"><br>
        选择文件:<input type="file" name="files"><br>
        <input type="submit" value="上传">
    </form>

</body>
</html>
