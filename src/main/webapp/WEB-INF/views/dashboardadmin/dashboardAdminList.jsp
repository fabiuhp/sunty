<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reports</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
 </head>
    <body>
        <div class="container">
            <h1>Cursos por categoria</h1>
            <table class="table table-bordered spacing">
                <tr>
                    <th>Nome</th>
                    <th>Quantidade de cursos</th>
                </tr>
                <c:forEach items="${courseProjections}" var="course">
                    <tr>
                        <td>${course.name}</td>
                        <td>${course.count}</td>
                    </tr>
                </c:forEach>
            </table>

            <h1>Instrutor com mais cursos</h1>
            <table class="table table-bordered spacing">
                <tr>
                    <th>Nome</th>
                    <th>Quantidade de cursos</th>
                </tr>
                <c:forEach items="${instructorProjections}" var="instructor">
                    <tr>
                        <td>${instructor.name}</td>
                        <td>${instructor.count}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
