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
<div class="middle">
    <div class="taleContainer">
        <h4>合同清单</h4>
        <table>
            <c:if test="${requestScope.forms == null}">
                无需要发货的发货单
            </c:if>
            <tr>
                <th>ID</th>
                <th>商品id</th>
                <th>数量</th>
                <th>发货</th>
            </tr>
            <c:forEach items="${requestScope.forms}" var="f">
                <tr>
                    <td>${f.formId}</td>
                    <td>${f.goodsId}</td>
                    <td>${f.quantity}</td>
                    <td><button style="width: auto" >
                        <a class="button-href" href="${pageContext.request.contextPath}/forms/finish/${f.formId}">发货</a>
                    </button></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="taleContainer">
        <h4>已发货物流信息</h4>
        <table>
            <th>发货单id</th>
            <th>发货时间</th>
            <th>发出商品Id</th>
            <th>发出商品数量</th>
            <c:forEach items="${requestScope.logs}" var="s">
                    <tr>
                        <td>${s.id}</td>
                        <td>${s.date}</td>
                        <td>${s.goodsId}</td>
                        <td>${s.quantity}</td>
                    </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
