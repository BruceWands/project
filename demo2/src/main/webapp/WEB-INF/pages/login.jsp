<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/5
  Time: 18:03
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
    <title>登录界面-崽崽网</title>
    <link href="../../css/login.css" type="text/css" rel="stylesheet">
</head>
<body>
<fieldset>
    <legend>用户登录</legend>
    <form action="user/login.do" method="post">
        <br/>
        <input type="text" name="name" placeholder="请输入用户名" required>
        <span id="sp1"></span>
        <br/><br/>
        <input type="password" name="pass" placeholder="请输入密码" required>
        <br/><br/>
        <input type="checkbox" name="log">记住用户名密码
        <br/><br/>
        <input type="submit" value="登录">
        <br/>
        <a href="user/autoLogin.do">自动登陆</a>
        <a href="../../index.jsp" style="text-decoration: none">返回官网</a>
    </form>
</fieldset>
<h4 style="color: red">
    ${requestScope.message}
</h4>
</body>
</html>