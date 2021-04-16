<%--
  Created by IntelliJ IDEA.
  User: zgp
  Date: 2021/4/16
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/Jdbc_Servlet/servlet/UserServlet" method="post">
        用户名：<input type="text" name="username"><br>
        用户密码：<input type="password" name="password"><br>
        <input type="submit" value="submit">
    </form>
</body>
</html>
