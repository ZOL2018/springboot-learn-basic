<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/10/12
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--<meta charset="UTF-8"> <!-- for HTML5 -->--%>
    <%--<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />--%>
    <title>jsp - login</title>
</head>
<body>
<form method="get" action="/user/login" >
    用户名：<input type="text" name="name"/><br/>
    密码：<input type="text" name="pwd"/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
