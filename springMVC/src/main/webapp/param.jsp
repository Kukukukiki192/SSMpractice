<%--
  Created by IntelliJ IDEA.
  User: K
  Date: 2021/4/13
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>传值</title>
</head>
<body>
<%--传值 简单类型--%>
<%--    <a href="param/testParam?username=10">请求参数绑定</a>--%>

<%--传值 数据封装到JavaBean类中--%>
<%--    <form action="param/testSaveAccount" method="post">--%>
<%--        姓名<input type="text" name="username"><br>--%>
<%--        密码<input type="text" name="password"><br>--%>
<%--        现金<input type="text" name="money"><br>--%>
<%--        用户姓名<input type="text" name="user.name"><br>--%>
<%--        用户年龄<input type="text" name="user.age"><br>--%>
<%--        <input type="submit" value="提交">--%>
<%--    </form>--%>

    <%--传值 数据封装到Account类中 类中存在list、map集合--%>
<%--    <form action="param/testSaveAccount" method="post">--%>
<%--        姓名<input type="text" name="username"><br>--%>
<%--        密码<input type="text" name="password"><br>--%>
<%--        现金<input type="text" name="money"><br>--%>

<%--        用户姓名<input type="text" name="list[0].name"><br>--%>
<%--        用户年龄<input type="text" name="list[0].age"><br>--%>

<%--        用户姓名<input type="text" name="map['one'].name"><br>--%>
<%--        用户年龄<input type="text" name="map['one'].age"><br>--%>
<%--        <input type="submit" value="提交">--%>
<%--    </form>--%>

    <%--传值 数据封装到User类中 日期自定义类型转换--%>
    <form action="param/testSaveUser" method="post">
        用户姓名<input type="text" name="name"><br>
        用户年龄<input type="text" name="age"><br>
        用户生日<input type="text" name="date"><br>
        <input type="submit" value="提交">
    </form>

    <a href="param/testServlet">Servlet原生API</a>


</body>
</html>
