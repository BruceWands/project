<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/5
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>用户主页</title>
    <link href="../../css/user.css" type="text/css" rel="stylesheet">
</head>
<body>
    <h2 style="font-family: 华文行楷">
        &nbsp;&nbsp;
        尊敬的${sessionScope.user.name}，你好！
        <br/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎来到个人主页！
        <br/>
        &nbsp;
        您的余额为：${sessionScope.user.money}元！
    </h2>
    <a href="user/rechargeView.do">充值</a>
    <a href="good/queryAllGood.do?currentPage=1">查看所有商品</a>
    <a href="userDetail/addUserDetailView.do">添加收货地址</a><br/><br/>
    <a href="userDetail/showUserDetail.do">查看收货地址</a>
    <a href="cart/showCart.do?currentPage=1">查看购物车</a>
    <a href="order/showOrder.do">查看订单</a>
    <a href="../../index.jsp">退出</a>
    <br/>
    <h4 style="color: red">
        ${requestScope.message}
    </h4>
</body>
</html>