<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/12/2
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>编辑</title>
</head>
<body>
<h4>商品编辑页面</h4>
<form:form modelAttribute="goods" action="${pageContext.request.contextPath}/goods/update" method="post">
    <form:hidden path="goodsId"/>
    Name:${requestScope.goods.name}<br>
    Price:<form:input path="price"/><br>
    Quantity:<form:input path="quantity"/><br>
    onSale:<form:input path="onSale"/><br>
    <input type="hidden" name="_method" value="put">
    <input type="submit">
</form:form>
<%--TODO：状态的修改改为下拉框选择true或者false,或者单选框--%>
</body>
</html>
