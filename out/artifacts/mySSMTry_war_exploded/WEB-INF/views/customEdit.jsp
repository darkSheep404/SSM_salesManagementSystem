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
    <title>客户信息编辑</title>
</head>
<body>
<h4>客户信息编辑页面</h4>
<%--@elvariable id="custom" type="com.dgut.ssm.bean.Custom"--%>
<form:form modelAttribute="custom" action="${pageContext.request.contextPath}/custom/update" method="post">
    工号:${requestScope.custom.customId}<br>
    <form:hidden path="customId"/>
    客户姓名:<form:input path="customName"/><br>
    电话号码:<form:input path="customPhone"/><br>
    公司：<form:input path="customCompany"/><br>
    <input type="hidden" name="_method" value="put">
    <input type="submit">
</form:form>
</body>
</html>
