<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de categorias</title>
    <style>
        .espacamento {
            margin-bottom: 10px;
            margin-top: 20px;
        }
    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
    <body>
        <h1>Categorias</h1>
        <a class="btn btn-primary" href="categories/new">Nova Categoria</a>
        <table class="table table-bordered espacamento">
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

        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
