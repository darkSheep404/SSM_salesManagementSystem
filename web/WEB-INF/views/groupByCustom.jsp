<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/12/29
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询统计</title>
    <link type="text/css" rel="styleSheet" href="../../mytable.css"/>
    <link type="text/css" rel="styleSheet" href="../../leftBar.css"/>
</head>
<body>
<div class="leftBar">
    <%--TODO 仓库管理员标准左侧栏--%>
    <div><h2 class="button-href">仓库管理</h2></div>
    <div class="leftLink"><a href="${pageContext.request.contextPath}/goods/list" class="button-href">商品管理</a></div>
    <div class="leftLink"><a href="${pageContext.request.contextPath}/forms/list" class="button-href">发货管理</a></div>
    <div class="leftLink"><a href="${pageContext.request.contextPath}/forms/buyList" class="button-href">进货管理</a></div>
    <div class="leftLink"><a href="${pageContext.request.contextPath}/groupBy/goods" class="button-href">销售统计</a></div>
    <div class="leftLink"><a href="${pageContext.request.contextPath}/index.jsp" class="button-href">注销</a></div>
</div>
<div class="middle">
    <div class="taleContainer">
        <h4>商品统计</h4>
        <table>
            <c:if test="${requestScope.goods == null}">
                未售出商品
            </c:if>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Quantity</th>
            </tr>
            <c:forEach items="${requestScope.goods}" var="g">
                <tr>
                    <td>${g.goodsId}</td>
                    <td>${g.name}</td>
                    <td>${g.quantity}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
