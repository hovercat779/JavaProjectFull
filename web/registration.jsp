<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hovercat
  Date: 24.08.16
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration page</title>
</head>
<body>

<form action="<c:url value='/registration' />" method="post">

    Login: <input type="text" name="login" value=""/><br>
    Password: <input type="password" name="password" value=""/><br>
    Name: <input type="text" name="name" value=""/><br>
    Role: <input type="text" name="role" value=""/><br>

    <input type="submit" value="submit"/> <br>
</form>

<form action="<c:url value='/index.jsp'/>" method="post">
    <input type="submit" value="back"/>
</form>

</body>
</html>

