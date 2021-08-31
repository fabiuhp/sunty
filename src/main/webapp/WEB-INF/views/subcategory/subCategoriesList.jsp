<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="templates" tagdir="/WEB-INF/tags/templates" %>

<templates:subcategory-template>
            <h2>${category.name}</h2>
            <h1>SubCategorias</h1>
            <a class="btn btn-primary" href="new">Nova Subcategoria</a>
            <table class="table table-bordered spacing">
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
                        <td><a href="/admin/courses/${category.urlCode}/${subcategory.urlCode}/">Cursos</a></td>
                        <td><a href="/admin/subcategories/${category.urlCode}/${subcategory.urlCode}">Editar</a></td>
                    </tr>
                </c:forEach>
            </table>
</templates:subcategory-template>
