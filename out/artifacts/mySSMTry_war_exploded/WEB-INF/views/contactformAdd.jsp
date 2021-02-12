<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/12/19
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link type="text/css" rel="styleSheet"  href="../../myForm.css" />
</head>
<body>
<div class="form-warpper">
    <h4>采购单添加</h4>
    <form id="goods" action="/contact/formInsert" method="post">
        <input type="hidden" name="id" value="${requestScope.id}"/>
        <div class="label"><span>商品</span>
            <select name="goodsId" id="goodsId">
                <c:forEach items="${requestScope.goods}" var="g">
                    <option value="${g.goodsId}">${g.name}</option>
                </c:forEach>
            </select>
        </div>
        <br>
        <div class="label"> Quantity</div><input id="quantity" name="quantity" type="text" value=""><br>
        <button type="submit">Submit</button>
    </form>
</div>

</body>
</html>

</head>
<body>

</body>
</html>

