<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Lista de categorias</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
    </head>
    <body>
       <div class="container cont">
           <h1 class="spacing">Nova categoria</h1>
           <form action="/admin/categories" method="post">
               <div class="form-group">
                   <label>Nome</label>
                   <input placeholder="Digite aqui o nome da categoria" class="form-control" type="text" name="name">
                   <form:errors path="category.name" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Código</label>
                   <input placeholder="Por exemplo: desenvolvimento, mobile (não use letras maiúsculas, acentos ou caracteres especiais)" class="form-control" type="text" name="urlCode">
                   <form:errors path="category.urlCode" cssClass="text-danger"/>
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
                   <label>Ordem</label>
                   <input placeholder="Ordem da categoria" class="form-control" type="number" name="orderToShow">
                   <form:errors path="category.orderToShow" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Guia de estudo</label>
                   <textarea class="form-control" placeholder="Um texto apontando para formações  para ajudar pessoas perdidas" name="guideText" rows="3"></textarea>
               </div>
               <div class="form-group">
                   <label>Caminho do ícone</label>
                   <input placeholder="Por exemplo: /imagens/categorias" class="form-control" type="text" name="pathImg">
                   <form:errors path="category.pathImg" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Cor em hexadecimal</label>
                   <input placeholder="Cor em hexadecimal da categoria" class="form-control" type="text" name="hexHtmlColor">
                   <form:errors path="category.hexHtmlColor" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Descrição</label>
                   <input placeholder="Por exemplo: iOS, Android, PhoneGap" class="form-control" type="text" name="shortDescription">
               </div>
               <input class="btn btn-success" type="submit" value="Enviar">
           </form>
       </div>
    </body>
</html>