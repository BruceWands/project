<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/15
  Time: 0:21
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
    <title>充值页面</title>
</head>
<body style="text-align: center">
<div style="background-color: grey;width: 400px;margin-left: 450px;margin-top: 250px">
    <form action="user/recharge.do" method="post">
        单次充值金额为10至10000元：
        <br/><br/>
        请输入：<input type="number" name="money" min="10" max="10000" value="10" required>
        <input type="submit" value="确定">
    </form>
    <a href="user/userView.do" style="text-decoration: none">返回个人主页</a>
</div>
<h4 style="color: red">
    ${requestScope.message}
</h4>
</body>
</html>