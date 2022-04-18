<%--
  Created by IntelliJ IDEA.
  User: K
  Date: 2021/4/13
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--常用注解--%>

    <a href="anno/testRequestParam?name=K">RequestParam</a>

    <%--RequestBody get不适用 json需要用--%>
    <form action="anno/testRequestBody" method="post">
        用户姓名<input type="text" name="name"><br><!--这里中文现实为16进制??-->
        用户年龄<input type="text" name="age"><br>
        <input type="submit" value="提交">
    </form>

    <a href="anno/testPathVariable/10">PathVariable</a><br>

    <a href="anno/testRequestHeader">RequestHeader</a><br>

    <a href="anno/testCookieValue">testCookieValue</a><br>

    <form action="anno/testModelAttribute" method="post">
        用户姓名<input type="text" name="name"><br>
        用户年龄<input type="text" name="age"><br>
        <input type="submit" value="提交">
    </form>


</body>
</html>
