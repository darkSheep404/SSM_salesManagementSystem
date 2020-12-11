<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/11/30
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>菜鸡管理系统</title>
    <style type="text/css">
      body{
        background: black;
        display: flex;
        flex-direction: column;
        justify-items: center;
        align-items: center;
      }
      .bar{
        text-align: center;
        background: blue;
        display: block;
        width: 300px;
        color: white;
        }

</style>
  </head>
  <body>
  <h4 style="
    color: white;
">菜鸟商品管理系统</h4>
  <a href="${pageContext.request.contextPath  }/goods/list" class="bar">商品管理</a>
  <a href="${pageContext.request.contextPath  }/goods/list" class="bar">合同管理</a>
  <a href="${pageContext.request.contextPath  }/goods/list" class="bar">仓库管理员管理</a>
  <a href="WEB-INF/views/goodsAdd.jsp">链接跳转添加</a>
  </body>
</html>
