<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/12/20
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>生成进货单</title>
</head>
<body>

<form name="buygoods" method="post" action="/contact/buy">
    <div>所需进货商品id：${requestScope.goodsId}</div>
    <input name="goodsId",type="hidden" value="${requestScope.goodsId}">
    <br>
    <div style="text-align: center;width: 80px;height: 40px">最小进货量：${requestScope.res}</div>
    <br>
    <div class="label">进货数量</div> <input type="text" name="num"/>
    <button>submit</button>
</form>
</body>
</html>
