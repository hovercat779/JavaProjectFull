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
    <title>Profile page</title>
</head>
<body>

Hello, <c:out value="${user.getName()}"/>



<form action="<c:url value='/index.jsp'/>" method="post">
    <input type="submit" value="back"/>
</form>

</body>
</html>
