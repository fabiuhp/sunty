<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="br.com.sunty.models.category.Category" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Atualizar categoria</title>
    </head>
    <body>
        <form action="/editarCategoria" method="post">
            <input type="text" hidden name="id" value="${category.id}">
            <label>Nome</label>
            <input type="text" name="name" value="${category.name}">
            <label>UrlCode</label>
            <input type="text" name="urlCode" value="${category.urlCode}">
            <input type="submit" value="Confirmar">
        </form>
    </body>
</html>