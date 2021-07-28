<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Lista de categorias</title>
    </head>
    <body>
       <form action="/novaCategoria" method="post">
           <label>Nome</label>
           <input type="text" name="name">
           <label>UrlCode</label>
           <input type="text" name="urlCode">
           <input type="submit" value="Criar">
       </form>
    </body>
</html>