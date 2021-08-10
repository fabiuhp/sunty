<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de categorias</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
 </head>
    <body>
        <div class="container">
            <h1>Categorias</h1>
            <a class="btn btn-primary" href="categories/new">Nova Categoria</a>
            <table class="table table-bordered spacing">
                <tr>
                    <th>Nome</th>
                    <th>Código</th>
                    <th>Status</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach items="${categories}" var="category">
                    <tr>
                        <td>${category.name}</td>
                        <td>${category.urlCode}</td>
                        <td>${category.active ? 'Ativo' : 'Inativo'}</td>
                        <td><a href="/admin/subcategories/${category.urlCode}">Subcategorias</a></td>
                        <td><a href="/admin/categories/${category.urlCode}">Editar</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
