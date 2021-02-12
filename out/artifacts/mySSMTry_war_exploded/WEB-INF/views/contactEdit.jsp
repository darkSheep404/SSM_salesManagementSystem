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
    <h4>合同基本信息修改</h4>
    <form id="contact" action="/contact/update" method="post">
        <input name="contactId" value="${requestScope.contact.contactId}" type="hidden"/>
        <div class="label"><span>客户</span>
        <select name="customId" id="customId">
            <option value="${requestScope.contact.custom.customId}" selected="selected" >${requestScope.contact.custom.customName}</option>
            <c:forEach items="${requestScope.customs}" var="c">
                <option value="${c.customId}" label="c.customName">${c.customName}</option>
            </c:forEach>
        </select>
        </div>
        <div class="label">
            <span>售货员</span>
        <select name="salesmanId" id="salesmanId">
            <option value="${requestScope.contact.salesman.salesmanId}" selected="selected" >${requestScope.contact.salesman.salesmanName}</option>
            <c:forEach items="${requestScope.salemans}" var="s">
                <option value="${s.salesmanId}" label="s.salesmanName">${s.salesmanName}</option>
            </c:forEach>
        </select>
        </div>
        <br>
        <button type="submit">Submit</button>
    </form>




</div>
<%--TODO:设置添加页面的上架状态默认为true，不传递onSale值过去--%>
</body>
</html>

</head>
<body>

</body>
</html>
