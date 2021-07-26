<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="br.com.sunty.models.category.Category" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de categorias</title>
</head>
    <body>
        <h1>Sucesso</h1>
        <ul>
            <p>A categoria ${category.name} foi atualizada com sucesso!</p>
        </ul>
        <a href="/listaCategorias">Listagem de categorias</a>
    </body>
</html>
