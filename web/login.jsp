<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/12/11
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
    <style>
        .myInput{
            width: 10px;
            margin-left: 10px;
        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/goods/login" method="post">
    <a class="myInput">用户名：</a><input type="text" name="userName"/><br>
    <a class="myInput">密码：</a><input type="password" name="passWord"/><br>
    <button type="submit">提交</button>
</form>
</body>
</html>
