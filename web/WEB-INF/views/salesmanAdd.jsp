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
    <h4>销售员添加页面</h4>
    <form id="salesman" action="/salesman/add" method="post">
        <div class="label">salesmanId</div><input id="salesmanId" name="salesmanId" type="text" value=""><br>
        <div class="label"> salesmanName</div><input id="salesmanName" name="salesmanName" type="text" value=""><br>
        <div class="label"> salesmanNamePhone</div><input id="salesmanNamePhone" name="salesmanNamePhone" type="text" value=""><br>
        <button type="submit">Submit</button>
    </form>
</div>

</body>
</html>

</head>
<body>

</body>
</html>
