<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/12/10
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
    <link type="text/css" rel="styleSheet" href="../../myForm.css"/>
</head>
<body>

<div class="form-warpper">
    <h4>合同录入</h4>
    <form id="contact" action="/contact/Insert" method="post">
        <%--客户，销售员，商品，采购数量--%>
        <div class="label"><span>客户</span>
        <select name="customId" id="customId">
            <c:forEach items="${requestScope.customs}" var="c">
                <option value="${c.customId}" label="c.customName">${c.customName}</option>
            </c:forEach>
        </select>
        </div>

        <div class="label">
            <span>售货员</span>
        <select name="salesmanId" id="salesmanId">
            <c:forEach items="${requestScope.salemans}" var="s">
                <option value="${s.salesmanId}" label="s.salesmanName">${s.salesmanName}</option>
            </c:forEach>
        </select>
        </div>
        <br>
        <button type="submit">Submit</button>
    </form>
    <%--    设置显示的值是名字，提交上去数据库？还是一起显示，提交数据库--%>



</div>
<%--TODO:设置添加页面的上架状态默认为true，不传递onSale值过去--%>
</body>
</html>

</head>
<body>

</body>
</html>
