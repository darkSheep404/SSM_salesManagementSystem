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

    <title>商品管理</title>
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
    <div class="leftLink"><a href="${pageContext.request.contextPath}/index.jsp" class="button-href">注销</a></div>
</div>
<%--<a href="${pageContext.request.contextPath}/goods/goodsAdd">添加</a>--%>
<div class="middle">
    <form class="search" id="goods" action="/goods/search" method="get">
        <div class="searchItem"> <div class="spanLabel">编号：</div><input name="goodsId" value="" type="number"></div>
         <div class="searchItem"><div class="spanLabel">名称：</div><input name="goodsName" value="" type="text"></div>
         <div class="searchItem"><div class="spanLabel">最小数量：</div><input name="minQuantity" value="" type="number"></div>
         <div class="searchItem"><div class="spanLabel">最大数量：</div><input name="maxQuantity" value="" type="number"></div>
         <div class="searchItem"><div class="spanLabel">最低价格：</div><input name="minPrice" value="" type="number"></div>
         <div class="searchItem"><div class="spanLabel">最高价格：</div><input name="maxPrice" value="" type="number"></div>
        <input type="submit" value="search"/>
    </form>
    <div class="taleContainer">
        <h4>商品清单</h4>
        <button>
        <a class="button-href" href="${pageContext.request.contextPath}/goods/goodsAdd">添加</a></button>
        <table>
            <c:if test="${requestScope.goods == null}">
                没有
            </c:if>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Update</th>
                <th>On_sale</th>
            </tr>
            <c:forEach items="${requestScope.goods}" var="g">
                <tr>
                    <td>${g.goodsId}</td>
                    <td>${g.name}</td>
                    <td>${g.price}</td>
                    <td>${g.quantity}</td>
                    <td>
                        <button style="width: fit-content">
                            <a href="${pageContext.request.contextPath}/goods/edit/${g.goodsId}" class="button-href">update
                            </a></button>
                    </td>
                    <c:if test="${g.onSale}">
                        <td>
                            <button style="width: fit-content">
                                <a href="${pageContext.request.contextPath}/goods/disable/${g.goodsId}"
                                   class="button-href">下架
                                </a></button>
                        </td>
                    </c:if>
                    <c:if test="${g.onSale==false}">
                        <td> <div>已下架</div></td>

                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
