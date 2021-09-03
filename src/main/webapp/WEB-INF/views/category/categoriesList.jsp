<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="templates" tagdir="/WEB-INF/tags/templates" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<templates:category-template>
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
</templates:category-template>