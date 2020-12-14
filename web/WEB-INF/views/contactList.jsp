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
</head>
<body>
<div class="taleContainer">
<h4>合同清单</h4>
<button ><a href="${pageContext.request.contextPath }/goods/goodsAdd" class="button-href">添加</a></button>
<table>
    <c:if test="${requestScope.contacts == null}">
        没有
    </c:if>
    <tr>
        <th>ID</th>
        <th>客户</th>
        <th>销售员</th>
        <th>履行状态</th>
        <th>未发货的发货单</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${requestScope.contacts}" var="co">
        <tr>
            <td>${co.contactId}</td>
            <td>${co.custom.customName}</td>
            <td>${co.salesman.salesmanName}</td>
            <td>${co.runStatus}</td>
            <td>${co.notdelivery}</td>
            <td><a href="${pageContext.request.contextPath}/goods/edit/${g.goodsId}">update</a> </td>
            <td><a href="${pageContext.request.contextPath}/goods/del/${g.goodsId}">delete</a> </td>
        </tr>
    </c:forEach>
</table>
</div>
<div class="taleContainer">
<h4>采购清单</h4>
<table border="1" cellpadding="0" cellspacing="3">
    <th>合同id</th>
    <th>采购单Id</th>
    <th>商品Id</th>
    <th>商品数量</th>
    <th>已生成发货单</th>
    <th>已经发货</th>
    <c:forEach items="${requestScope.contacts}" var="co">
        <c:forEach items="${co.salesForms}" var="s">
                <tr>
                    <td>${s.contactId}</td>
                    <td>${s.formId}</td>
                    <td>${s.goodsId}</td>
                    <td>${s.quantity}</td>
                    <td>${s.generateStatus}</td>
                    <td>${s.deliveryStatus}</td>
                </tr>
        </c:forEach>
    </c:forEach>
</table>
</div>
</body>
</html>
