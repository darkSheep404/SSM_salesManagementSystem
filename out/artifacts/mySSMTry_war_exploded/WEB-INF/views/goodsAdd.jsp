<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/12/10
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <link type="text/css" rel="styleSheet"  href="../../myForm.css" />
    </head>
<body>
<%--<h4>商品添加页面</h4>
<jsp:useBean id="goods" class="com.dgut.ssm.bean.Goods" scope="request"/>
<form:form  modelAttribute="goods" action="${pageContext.request.contextPath}/goods/add" method="post">
    goodsId:<form:input path="goodsId"/><br>
    Name:<form:input path="name"/><br>
    Price:<form:input path="price"/><br>
    Quantity:<form:input path="quantity"/><br>
    <input type="submit">
</form:form>--%>
<div class="form-warpper">
    <h4>商品添加页面</h4>

    <form id="goods" action="/goods/add" method="post">
        <div class="label">goodsId</div><input id="goodsId" name="goodsId" type="text" value=""><br>
        <div class="label"> Name</div><input id="name" name="name" type="text" value=""><br>
        <div class="label"> Price</div><input id="price" name="price" type="text" value=""><br>
        <div class="label"> Quantity</div><input id="quantity" name="quantity" type="text" value=""><br>
        <button type="submit">Submit</button>
    </form>
</div>
<%--TODO:设置添加页面的上架状态默认为true，不传递onSale值过去--%>
</body>
</html>

</head>
<body>

</body>
</html>
