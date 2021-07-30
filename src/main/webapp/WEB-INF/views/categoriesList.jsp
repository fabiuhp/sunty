<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de categorias</title>
</head>
    <body>
        <h1>Lista de categorias</h1>
        <table>
            <tr>
                <th>Nome da categoria</th>
                <th>Ativo</th>
                <th>Editar</th>
                <th>Desativar</th>
            </tr>
                <c:forEach items="${categories}" var="category">
                <tr>
                    <td>${category.name}</td>
                    <td>${category.active}</td>
                    <td><a href="/editarCategoria?id=${category.id}">Editar</a></td>
                    <td><form action="/desativarCategoria" method="post">
                        <input type="text" hidden name="id" value="${category.id}">
                        <input type="submit" value="${category.active ? 'Inativar' : 'Ativar'}">
                    </form></td>
                </tr>
                </c:forEach>
        </table>
        <a href="/novaCategoria">Criar nova categoria</a>
    </body>
</html>

<%--<a href="/desativarCategoria?id=${category.id}">Desativar</a>--%>