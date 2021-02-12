<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/12/2
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>销售员编辑</title>
</head>
<body>
<h4>销售员编辑页面</h4>
<%--@elvariable id="salesman" type="com.dgut.ssm.bean.Salesman"--%>
<form:form modelAttribute="salesman" action="${pageContext.request.contextPath}/salesman/update" method="post">
    工号:${requestScope.salesman.salesmanId}<br>
    <form:hidden path="salesmanId"/>
    销售员姓名:<form:input path="salesmanName"/><br>
    电话号码:<form:input path="salesmanPhone"/><br>
    <input type="hidden" name="_method" value="put">
    <input type="submit">
</form:form>
</body>
</html>
