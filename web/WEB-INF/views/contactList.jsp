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
<table >
    <th>合同id</th>
    <th>采购单Id</th>
    <th>商品Id</th>
    <th>商品数量</th>
    <th>已生成发货单</th>
    <th>操作</th>
    <c:forEach items="${requestScope.contacts}" var="co">
        <c:forEach items="${co.salesForms}" var="s">
                <tr>
                    <td>${s.contactId}</td>
                    <td>${s.formId}</td>
                    <td>${s.goodsId}</td>
                    <td>${s.quantity}</td>
                    <td>${s.generateStatus}</td>
                    <td><button style="width: auto" >
                        <%--需要比较商品库存，采购的商品数目,更改合同属性，与当前表单完成状态，需要使用除表单id外所有属性--%>
                           <%-- <a href="${pageContext.request.contextPath}/contact/run/${co.contactId}/${s.quantity}/${s.goodsId}"/>--%>
                            <a class="button-href" href="${pageContext.request.contextPath}/contact/run/${s.formId}">生成发货单</a>
                    </button></td>
                </tr>
        </c:forEach>
    </c:forEach>
</table>
</div>
</div>
</body>
</html>
