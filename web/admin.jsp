<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Data page</title>
</head>
<body>

<table border="1">
    <td>User ID</td>
    <td>Login</td>
    <td>Name</td>
    <td>Role</td>

    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.getId()}"/></td>
            <td><c:out value="${user.getLogin()}"/></td>
            <td><c:out value="${user.getName()}"/></td>
            <td><c:out value="${user.getRole()}"/></td>
        </tr>
    </c:forEach>
</table>

<form action="<c:url value="/index.jsp"/>" method="post">
    <input type="submit" value="back"/>
</form>

</body>
</html>