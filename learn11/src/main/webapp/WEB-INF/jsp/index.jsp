<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/10/17
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index - jsp</title>
</head>
<body>
单个文件上传：<br/>
<form action="/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/>
    <input type="submit" value="提交上传"/>
</form>
<br/>
<%--多个文件上传：--%>
<%--<form action="/uploads" method="post" enctype="multipart/form-data">--%>
    <%--文件1：<input type="file" name="file"/><br/>--%>
    <%--文件2：<input type="file" name="file"/><br/>--%>
    <%--文件3：<input type="file" name="file"/><br/>--%>
    <%--<input type="submit" value="上传多个文件"/>--%>
<%--</form>--%>
</body>
</html>
