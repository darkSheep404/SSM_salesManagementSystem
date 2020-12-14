<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/11/30
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <title>Title</title>
    <link type="text/css" rel="styleSheet"  href="../../mytable.css" />
    <link type="text/css" rel="styleSheet"  href="../../leftBar.css" />

</head>
<body>
<div class="leftBar">
    <div class="leftLink"><a href="${pageContext.request.contextPath}/contact/list" class="button-href">合同管理</a></div>
    <div class="leftLink"><a href="${pageContext.request.contextPath}/goods/list" class="button-href">商品管理</a></div>
    <div class="leftLink"><a href="${pageContext.request.contextPath}/forms/list" class="button-href">发货管理</a></div>
</div>
<%--<a href="${pageContext.request.contextPath}/goods/goodsAdd">添加</a>--%>
<div class="middle">
<div class="taleContainer">
    <h4>商品清单</h4>
    <button onclick="window.open('${pageContext.request.contextPath}/goods/goodsAdd','商品添加','height=700,width=1000,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no')">添加</button>
    <table>
    <c:if test="${requestScope.goods == null}">
        没有
    </c:if>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>onSale</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${requestScope.goods}" var="g">
        <tr>
            <td>${g.goodsId}</td>
            <td>${g.name}</td>
            <td>${g.price}</td>
            <td>${g.quantity}</td>
            <td>${g.onSale}</td>
            <td><a href="${pageContext.request.contextPath}/goods/edit/${g.goodsId}" >update</a> </td>
            <td><a href="${pageContext.request.contextPath}/goods/del/${g.goodsId}" >delete</a> </td>
        </tr>
    </c:forEach>
</table>
</div>
</div>
</body>
</html>
