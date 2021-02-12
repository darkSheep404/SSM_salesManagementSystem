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
    <link type="text/css" rel="styleSheet" href="../../mytable.css"/>
    <link type="text/css" rel="styleSheet" href="../../leftBar.css"/>
    <style>
        .spanLabel {
            width: 120px;
        }
    </style>
</head>
<body>
<div class="leftBar">
    <%--TODO 销售管理员标准左侧栏--%>
    <div><h2 class="button-href">销售管理</h2></div>
        <div class="leftLink"><a href="${pageContext.request.contextPath}/contact/list" class="button-href">合同管理</a></div>
        <div class="leftLink"><a href="${pageContext.request.contextPath}/custom/list" class="button-href">客户管理</a></div>
        <div class="leftLink"><a href="${pageContext.request.contextPath}/salesman/list" class="button-href">销售管理</a></div>
        <div class="leftLink"><a href="${pageContext.request.contextPath}/groupBy/goods" class="button-href">销售统计</a></div>
        <div class="leftLink"><a href="${pageContext.request.contextPath}/index.jsp" class="button-href">注销</a></div>
</div>
<div class="middle">
    <form class="search" id="contact" action="/contact/search" method="get">
        <div class="searchItem"> <div class="spanLabel">合同编号：</div><input name="contactId" value="" type="number"></div>
        <div class="searchItem"><div class="spanLabel">销售员名称：</div><input name="salesmanName" value="" type="text"></div>
        <div class="searchItem"><div class="spanLabel">客户名称：</div><input name="customName" value="" type="text"></div>
        <input type="submit" value="search"/>
    </form>
    <div class="taleContainer">
        <h4>合同清单</h4>
        <button><a href="${pageContext.request.contextPath }/contact/add" class="button-href">添加</a></button>
        <table>
            <c:if test="${requestScope.contacts == null}">
                没有
            </c:if>
            <tr>
                <th>ID</th>
                <th>客户</th>
                <th>销售员</th>
                <th>履行状态</th>
                <th>详情</th>
            </tr>
            <c:forEach items="${requestScope.contacts}" var="co">
                <tr>
                    <td>${co.contactId}</td>
                    <td>${co.custom.customName}</td>
                    <td>${co.salesman.salesmanName}</td>
                    <c:if test="${co.runStatus ==true&&co.notdelivery<=0}">
                        <td>履行完毕</td>
                    </c:if>
                    <c:if test="${co.runStatus ==false}">
                        <td>未履行</td>
                    </c:if>
                    <c:if test="${co.runStatus ==true&&co.notdelivery>0}">
                        <td>履行中</td>
                    </c:if>
                    <td><a href="${pageContext.request.contextPath}/contact/detail/${co.contactId}">详情</a></td>
                </tr>
            </c:forEach>
        </table>

    </div>

</div>
</body>
</html>
