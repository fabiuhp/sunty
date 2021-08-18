<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de cursos</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
</head>
    <body>
        <div class="container">
            <h2>${subCategory.name}</h2>
            <h1>Course</h1>
            <a class="btn btn-primary" href="/admin/courses/new">Novo curso</a>
            <table class="table table-bordered spacing">
                <tr>
                    <th>Nome</th>
                    <th>Código</th>
                    <th>Visibilidade</th>
                    <th></th>
                </tr>
                <c:forEach items="${courses.content}" var="course">
                    <tr>
                        <td>${course.name}</td>
                        <td>${course.urlCode}</td>
                        <td>${course.visibility}</td>
                        <td><a href="/admin/courses/${categoryUrlCode}/${subCategory.name}/${course.urlCode}">Editar</a></td>
                    </tr>
                </c:forEach>
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <c:forEach begin="1" end="${courses.totalPages}" varStatus="loop">
                            <li><a href="?page=${loop.index-1}">${loop.index}</a></li>
                        </c:forEach>
                    </ul>
                </nav>
            </table>
        </div>
    </body>
</html>
