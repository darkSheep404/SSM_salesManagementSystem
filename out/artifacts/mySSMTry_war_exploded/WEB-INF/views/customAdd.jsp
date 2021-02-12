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
    <link type="text/css" rel="styleSheet"  href="../../myForm.css" />
</head>
<body>

<div class="form-warpper">
    <h4>客户录入页面</h4>
    <form id="custom" action="/custom/add" method="post">
        <div class="label">客户编号</div><input id="customId" name="customId" type="text" value=""><br>
        <div class="label"> 姓名</div><input id="customName" name="customName" type="text" value=""><br>
        <div class="label"> 电话</div><input id="customPhone" name="customPhone" type="text" value=""><br>
        <div class="label"> 公司</div><input id="customCompany" name="customCompany" type="text" value=""><br>
        <button type="submit">Submit</button>
    </form>
</div>

</body>
</html>

</head>
<body>

</body>
</html>
