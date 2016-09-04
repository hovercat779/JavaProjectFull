<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hovercat
  Date: 01.09.16
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update page</title>
</head>
<body>

<form action="<c:url value='/update' />" method="post">

    Password: <input type="text" name="password" value="${user.getPassword()}"/><br>
    Name: <input type="text" name="name" value="${user.getName()}"/><br>
    Role: <select name="role">
    <option value="user">user</option>
    <option value="admin">admin</option>
</select><br>
    Gender: <input type="radio" name=gender value="male"/>male
    <input type="radio" name=gender value="female"/>female<br>

    <input type="hidden" name="id" value="${user.getId()}">
    <input type="submit" value="submit"/> <br>
</form>

</body>
</html>
