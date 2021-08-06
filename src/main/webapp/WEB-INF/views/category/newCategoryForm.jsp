<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Lista de categorias</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <style>
            .container-edited {
                width: 70%;
            }
            .space {
                margin-bottom: 30px;
                margin-top: 50px;
            }
        </style>
    </head>
    <body>
       <div class="container container-edited">
           <h1 class="space">Nova categoria</h1>
           <form action="/admin/categories" method="post">
               <div class="form-group">
                   <label>Nome</label>
                   <input placeholder="Nome da categoria" class="form-control" type="text" name="name">
                   <form:errors path="category.name" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Código</label>
                   <input placeholder="Código da categoria" class="form-control" type="text" name="urlCode">
                   <form:errors path="category.urlCode" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Descrição breve</label>
                   <input placeholder="Descrição da categoria" class="form-control" type="text" name="shortDescription">
               </div>
               <div class="form-group">
                   <label>Texto guia</label>
                   <input placeholder="Texto guia da categoria" class="form-control" type="text" name="guideText">
               </div>
               <div class="form-group">
                   <label>Ativo?</label>
                   <select class="form-control" name="active">
                       <option value="Selecione">Selecione</option>
                       <option value="true"selected="selected">Ativo</option>
                       <option value="false">Inativo</option>
                   </select>
                   <form:errors path="category.active" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Cor em hexadecimal</label>
                   <input placeholder="Cor em hexadecimal da categoria" class="form-control" type="text" name="hexHtmlColor">
                   <form:errors path="category.hexHtmlColor" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Ordem</label>
                   <input placeholder="Ordem da categoria" class="form-control" type="number" name="orderToShow">
                   <form:errors path="category.orderToShow" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Local da imagem</label>
                   <input placeholder="Local da imagem da categoria" class="form-control" type="text" name="pathImg">
                   <form:errors path="category.pathImg" cssClass="text-danger"/>
               </div>
               <input class="btn btn-success" type="submit" value="Enviar">
           </form>
       </div>
       <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>