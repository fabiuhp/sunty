<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="br.com.sunty.models.category.Category" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de categorias</title>
</head>
<body>
<h1>Lista de categorias</h1>
<ul>
    <c:forEach items="${categories}" var="category">
        <li>${category.name}</li>
    </c:forEach>
</ul>
</body>
</html>
