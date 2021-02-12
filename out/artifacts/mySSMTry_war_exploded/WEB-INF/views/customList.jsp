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

    <title>客户管理</title>
    <link type="text/css" rel="styleSheet"  href="../../mytable.css" />
    <link type="text/css" rel="styleSheet"  href="../../leftBar.css" />

</head>
<body>
<div class="leftBar">
    <%--TODO 销售管理员标准左侧栏--%>
    <div><h2 class="button-href">销售管理</h2> </div>
        <div class="leftLink"><a href="${pageContext.request.contextPath}/contact/list" class="button-href">合同管理</a></div>
        <div class="leftLink"><a href="${pageContext.request.contextPath}/custom/list" class="button-href">客户管理</a></div>
        <div class="leftLink"><a href="${pageContext.request.contextPath}/salesman/list" class="button-href">销售管理</a></div>
        <div class="leftLink"><a href="${pageContext.request.contextPath}/groupBy/goods" class="button-href">销售统计</a></div>
        <div class="leftLink"><a href="${pageContext.request.contextPath}/index.jsp" class="button-href">注销</a></div>
</div>
<%--<a href="${pageContext.request.contextPath}/custom/customAdd">添加</a>--%>
<div class="middle">
    <form class="search" id="custom" action="/custom/search" method="get">
        <div class="searchItem"> <div class="spanLabel">编号：</div><input name="customId" value="" type="number"></div>
        <div class="searchItem"><div class="spanLabel">名称：</div><input name="customName" value="" type="text"></div>
        <div class="searchItem"><div class="spanLabel">公司：</div><input name="customCompany" value="" type="text"></div>
        <div class="searchItem"><div class="spanLabel">电话：</div><input name="customPhone" value="" type="text"></div>
        <input type="submit" value="search"/>
    </form>
    <div class="taleContainer">
        <h4>客户列表</h4>
        <button><a class="button-href"  href="${pageContext.request.contextPath}/custom/customAdd" >添加</a></button>
        <table>
            <c:if test="${requestScope.custom == null}">
                没有
            </c:if>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Phone</th>
                <th>Company</th>
                <th>Update</th>
            </tr>
            <c:forEach items="${requestScope.custom}" var="g">
                <tr>
                    <td>${g.customId}</td>
                    <td>${g.customName}</td>
                    <td>${g.customCompany}</td>
                    <td>${g.customPhone}</td>
                    <td>
                        <button style="width: fit-content">
                            <a href="${pageContext.request.contextPath}/custom/edit/${g.customId}" class="button-href" >update
                            </a></button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
