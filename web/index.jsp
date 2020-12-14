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
  body{
    display: flex;
    justify-content: center;
    align-items: center;
  }
</style>
  <link type="text/css" rel="styleSheet"  href="myForm.css"/>
</head>
<body>
<div class="form-warpper">
<form action="${pageContext.request.contextPath}/goods/login" method="post">
  <h3>销售管理系统登录</h3>
  <div class="label">用户名</div><input type="text" name="userName"/><br>
  <div class="label">密码</div><input type="password" name="passWord"/><br>
  <button type="submit">提交</button>
</form>
</div>
</body>
</html>
