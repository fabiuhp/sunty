<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de subcategorias</title>
    <style>
        .espacamento {
            margin-bottom: 10px;
            margin-top: 20px;
        }
    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
    <body>
        <div class="container">
            <h2>${category.name}</h2>
            <h1>SubCategorias</h1>
            <a class="btn btn-primary" href="categories/new">Nova SubCategoria</a>
            <table class="table table-bordered espacamento">
                <tr>
                    <th>Nome</th>
                    <th>Código</th>
                    <th>Status</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach items="${subCategoryList}" var="subcategory">
                    <tr>
                        <td>${subcategory.name}</td>
                        <td>${subcategory.urlCode}</td>
                        <td>${subcategory.active ? 'Ativo' : 'Inativo'}</td>
                        <td><a href="/admin/subcategories/${subcategory.urlCode}">Cursos</a></td>
                        <td><a href="/admin/categories/${subcategory.urlCode}">Editar</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
