<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/19
  Time: 22:13
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
    <title>崽崽网-买买买</title>
    <link href="css/first.css" type="text/css" rel="stylesheet">
</head>
<body>
<div><img src="image/logo.png" style="height: 60px;width: 100px"></div>
<h1 align="center">欢迎来到崽崽网，祝您购物愉快！</h1>
<fieldset>
    <legend style="font-size: 200%;color: red;font-weight: 900">欢迎</legend>
    <a href="register.do">注册</a>
    <a href="login.do">登录</a>
</fieldset>
</body>
</html>