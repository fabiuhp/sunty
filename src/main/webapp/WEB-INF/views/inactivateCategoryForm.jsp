<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Atualizar categoria</title>
    </head>
    <body>
        <form action="/desativarCategoria" method="post">
            <input type="text" hidden name="id" value="${category.id}">
            <label>Deseja inativar a categoria ${category.name}?</label>
            <input type="submit" value="Confirmar">
        </form>
    </body>
</html>