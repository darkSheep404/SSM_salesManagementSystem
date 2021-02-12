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

    <title>合同详情</title>
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
<%--<a href="${pageContext.request.contextPath}/goods/goodsAdd">添加</a>--%>
<div class="middle">
    <div class="taleContainer">
        <table>
            <tr>
                <th>ID</th>
                <th>客户</th>
                <th>销售员</th>
                <th>履行状态</th>
                <th>编辑</th>
            </tr>
                <tr>
                    <td>${requestScope.contact.contactId}</td>
                    <td>${requestScope.contact.custom.customName}</td>
                    <td>${requestScope.contact.salesman.salesmanName}</td>
                    <%--履行状态--%>
                    <c:if test="${requestScope.contact.runStatus ==true&&requestScope.contact.notdelivery<=0}">
                        <td>履行完毕</td>
                    </c:if>
                    <c:if test="${requestScope.contact.runStatus ==true&&requestScope.contact.notdelivery>0}">
                        <td>履行中</td>
                    </c:if>
                    <c:if test="${requestScope.contact.runStatus ==false}">
                        <td>未履行</td>
                    </c:if>
                    <%--update--%>
                    <c:if test="${requestScope.contact.runStatus ==false}">
                        <td><a href="${pageContext.request.contextPath}/contact/edit/${requestScope.contact.contactId}">update</a></td>
                    </c:if>
                    <c:if test="${requestScope.contact.runStatus == true}">
                        <td>已开始履行不可修改</td>
                    </c:if>
                </tr>
            <tr>
                <th>客户ID</th>
                <th>客户姓名</th>
                <th>客户联系电话</th>
                <th>客户所在公司</th>
                <th></th>
            </tr>
            <tr>
                <td>${requestScope.contact.custom.customId}</td>
                <td>${requestScope.contact.custom.customName}</td>
                <td>${requestScope.contact.custom.customPhone}</td>
                <td>${requestScope.contact.custom.customCompany}</td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <th>销售员ID</th>
                <th>销售员姓名</th>
                <th>客户联系电话</th>
                <th></th>
                <th></th>
            </tr>
            <tr>
                <td>${requestScope.contact.salesman.salesmanId}</td>
                <td>${requestScope.contact.salesman.salesmanName}</td>
                <td>${requestScope.contact.salesman.salesmanPhone}</td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </table>
    </div>


    <div class="taleContainer">
        <button><a class="button-href" href="${pageContext.request.contextPath}/contact/formAdd/${requestScope.contact.contactId}" >添加采购单</a></button>
        <c:if test="${requestScope.contact.salesForms.size()==0}">
            <span style="text-align: center">未录入采购单，请及时录入</span>
        </c:if>
        <c:if test="${requestScope.contact.salesForms!=null}">
            <table>
                <tr>
                    <th>合同ID</th>
                    <th>采购单ID</th>
                    <th>商品ID</th>
                    <th>商品数量</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${requestScope.contact.salesForms}" var="g">
                    <c:if test="${g.formId!=null}">
                    <tr>
                        <td>${g.contactId}</td>
                        <td>${g.formId}</td>
                        <td>${g.goodsId}</td>
                        <td>${g.quantity}</td>
                        <c:if test="${g.generateStatus==false}">
                            <td>
                                <button style="width: auto">
                                    <a class="button-href"
                                       href="${pageContext.request.contextPath}/contact/run/${g.formId}/${g.contactId}">生成发货单</a>
                                </button>
                            </td>
                        </c:if>
                        <c:if test="${g.generateStatus==true}">
                           <td><span style="text-align: center">已生成发货单</span></td>
                        </c:if>
                    </tr>
                    </c:if>
                </c:forEach>
            </table>
        </c:if>
    </div>

</div>
</body>
</html>
