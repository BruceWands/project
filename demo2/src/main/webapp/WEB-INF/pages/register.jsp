<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/6
  Time: 18:31
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
    <title>注册界面-崽崽网</title>
    <link href="../../css/register.css" type="text/css" rel="stylesheet">
    <script src="../../resources/js/jquery-3.2.1.js"></script>
    <script>
        $(document).ready(function () {
            $("input[name='name']").blur(function () {
                $.ajax({
                    type:"get",
                    url:"user/checkRegister.do",
                    data:{name:$("input[name='name']").val()},
                    success:function (obj) {
                        if(obj=="123"){
                            alert("用户名已被占用！");
                        }
                    }
                })
            })
            $("#confirm").blur(function () {
                if($("#confirm").val()!=$("#up").val()){
                    alert("两次输入密码不一致！")
                }
            })
        })
    </script>
</head>
<body>
<fieldset>
    <legend>用户注册</legend>
    <form action="user/register.do" method="post">
        <br/>
        * 用 户 名：<input type="text" id="un" name="name" placeholder="请输入用户名" required>
        <br/><br/>
        *登录密码：<input type="password" id="up" name="pass" placeholder="6-20位字母、数字" required>
        <br/><br/>
        *确认密码：<input type="password" id="confirm" placeholder="再次输入您的登录密码" required>
        <br/><br/>
        *选择性别：<input type="radio" name="sex" value="男" checked>男
                   <input type="radio" name="sex" value="女">女
        <br/><br/>
        <input type="submit" value="注册">
        <a href="../../index.jsp" style="text-decoration: none">返回官网</a>
    </form>
</fieldset>
<h4 style="color: red">
    ${requestScope.message}
</h4>
</body>
</html>