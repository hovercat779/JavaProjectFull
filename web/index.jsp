<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hovercat
  Date: 24.08.16
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
Hello!

<form action="<c:url value='/profile'/>" method="post">
    Login: <input type="text" name="login" value=""/><br>
    Pass: <input type="password" name="password" value=""/><br>
    <input type="submit" value="submit"/>
</form>

<form action="<c:url value='/registration.jsp'/>" method="post">
    <input type="submit" value="registration"/>
</form>

</body>
</html>
