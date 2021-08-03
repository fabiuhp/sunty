<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Lista de categorias</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <style>
            .cont {
                width: 70%;
            }
            .space {
                margin-bottom: 30px;
                margin-top: 50px;
            }
        </style>
    </head>
    <body>
       <div class="container cont">
           <h1 class="space">Nova categoria</h1>
           <form action="/admin/categories" method="post">
               <div class="form-group">
                   <label>Nome</label>
                   <input class="form-control" type="text" name="name">
               </div>
               <div class="form-group">
                   <label>UrlCode</label>
                   <input class="form-control" type="text" name="urlCode">
               </div>
               <div class="form-group">
                   <label>Descrição breve</label>
                   <input class="form-control" type="text" name="shortDescription">
               </div>
               <div class="form-group">
                   <label>Ativo?</label>
                   <select class="form-control" name="active">
                       <option value="Selecione" selected>Selecione</option>
                       <option value="true">Ativo</option>
                       <option value="false">Inativo</option>
                   </select>
               </div>
               <div class="form-group">
                   <label>Cor em hexadecimal</label>
                   <input class="form-control" type="text" name="hexHtmlColor">
               </div>
               <div class="form-group">
                   <label>Ordem</label>
                   <input class="form-control" type="text" name="orderToShow">
               </div>
               <div class="form-group">
                   <label>Local da imagem</label>
                   <input class="form-control" type="text" name="pathImg">
               </div>
               <input class="btn btn-default" type="submit" value="Criar">
           </form>
       </div>
       <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>