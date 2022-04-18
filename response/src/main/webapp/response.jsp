<%--
  Created by IntelliJ IDEA.
  User: K
  Date: 2021/4/16
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>response</title>
    <script src="js/jquery.min.js"></script>
    <script>
        //页面加载,绑定单击事件
        $(function (){
            $("#btn").click(function (){
                // alert("hello btn");
                //发生ajax请求
                $.ajax({
                    //编写json格式，设置属性和值
                    url: "user/testAjax",
                    contentType: "application/json;charset=UTF-8",
                    data: '{"username":"k","password":"111","age":"22"}',
                    dataType: "json",
                    type: "post",
                    success:function (data){
                        //data服务器端响应的json数据,进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                });
            });
        });

        <%--function test(){--%>
        <%--    //获取id值--%>
        <%--    var username=${"#username"}.val();--%>
        <%--    var password=${"#password"}.val();--%>
        <%--    var age=${"#age"}.val();--%>
        <%--    $.ajax({--%>
        <%--        //编写json格式，设置属性和值--%>
        <%--        url: "user/testAjax",--%>
        <%--        contentType: "application/json;charset=UTF-8",--%>
        <%--        data: JSON.stringify({username:username,password:password,age:age}),--%>
        <%--        dataType: "json",--%>
        <%--        type: "post",--%>
        <%--        success:function (data){--%>
        <%--            //data服务器端响应的json数据,进行解析--%>
        <%--            if(data!=null)--%>
        <%--            alert(data+'\n'+"姓名:"+data.username+"密码:"+data.password+"年龄:"+data.age);--%>
        <%--        }--%>
        <%--    });--%>
        <%--}--%>
    </script>
</head>
<body>
    <h3>响应数据</h3>
    <a href="user/testString">testString</a><br>
    <a href="user/testVoid">testVoid</a><br>
    <a href="user/testModelAndView">testModelAndView</a><br>
    <a href="user/testForward_Redirect">testForward_Redirect</a><br>

    <button id="btn">发生ajax请求</button>

<%--    <form>--%>
<%--        姓名<input type="text" name="username" id="username"><br>--%>
<%--        密码<input type="password" name="password" id="password"><br>--%>
<%--        年龄<input type="text" name="age" id="age"><br>--%>
<%--        <input type="button" value="提交" onclick="test()">--%>
<%--    </form>--%>

</body>
</html>
