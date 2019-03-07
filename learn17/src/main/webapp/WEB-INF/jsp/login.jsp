<%--
  Created by IntelliJ IDEA.
  User: CQ03
  Date: 2019/3/7
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
<form action="/login" method="post">
    <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
    用户名：<input type="text" name="username"/><br/>
    密码：<input type="password" name="password"/><br/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
