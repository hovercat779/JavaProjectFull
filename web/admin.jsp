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
    <td>Gender</td>
    <td>Delete user</td>
    <td>Edit user</td>

    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.getId()}"/></td>
            <td><c:out value="${user.getLogin()}"/></td>
            <td><c:out value="${user.getName()}"/></td>
            <td><c:out value="${user.getRole()}"/></td>
            <td><c:out value="${user.getGender()}"/></td>
            <td>
                <form action="<c:url value="/admin"/>" method="post">
                    <input name="method" type="hidden" value="delete">
                    <input name="id" type="hidden" value="${user.getId()}">
                    <input type="submit" value="Delete"/>
                </form>
            </td>
            <td>
                <form action="<c:url value="/admin"/>" method="post">
                    <input name="id" type="hidden" value="${user.getId()}">
                    <input name="method" type="hidden" value="update">
                    <input type="submit" value="Update"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<br>

<form action="<c:url value='/admin'/>" method="post">
    <input name="method" type="hidden" value="add">
    Login: <input type="text" name="login" value="user"/><br>
    Password: <input type="password" name="password" value="1234"/><br>
    Name: <input type="text" name="name" value="Smith"/><br>
    Role: <select name="role">
    <option value="user">user</option>
    <option value="admin">admin</option>
</select><br>
    Gender: <input type="radio" name=gender value="male"/>male
    <input type="radio" name=gender value="female"/>female<br>

    <input type="submit" value="Add new user"/> <br>
</form>
<br>


<form action="<c:url value="/index.jsp"/>" method="post">
    <input type="submit" value="back"/>
</form>

</body>
</html>