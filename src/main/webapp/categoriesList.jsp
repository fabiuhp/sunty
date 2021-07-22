<%@ page import="br.com.sunty.models.category.Category" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Lista de categorias</title>
    </head>
    <body>
        <ul>
            <%
                List<Category> categories = (List<Category>) request.getAttribute("categories");
                for (Category category : categories) { %>
            <li>
                <%= category.getName() %>
            </li>
            <%}%>
        </ul>

    </body>
</html>
