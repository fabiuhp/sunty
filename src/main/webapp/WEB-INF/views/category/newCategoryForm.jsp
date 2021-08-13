<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Nova categorias</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
    </head>
    <body>
       <div class="container cont">
           <h1 class="spacing">Nova categoria</h1>
           <form action="/admin/categories" method="post">
               <div class="form-group">
                   <label>Nome</label>
                   <input value="${adminNewCategoryForm.name}" placeholder="Digite aqui o nome da categoria" class="form-control" type="text" name="name">
                   <form:errors path="adminNewCategoryForm.name" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Código</label>
                   <input value="${adminNewCategoryForm.urlCode}" placeholder="Por exemplo: desenvolvimento, mobile (não use letras maiúsculas, acentos ou caracteres especiais)" class="form-control" type="text" name="urlCode">
                   <form:errors path="adminNewCategoryForm.urlCode" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Ativo?</label>
                   <select class="form-control" name="active">
                       <option value="true" selected="selected">Ativo</option>
                       <option value="false">Inativo</option>
                   </select>
                   <form:errors path="adminNewCategoryForm.active" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Ordem</label>
                   <input value="${adminNewCategoryForm.orderToShow}" placeholder="Ordem da categoria" class="form-control" type="number" name="orderToShow">
                   <form:errors path="adminNewCategoryForm.orderToShow" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Guia de estudo</label>
                   <textarea class="form-control" placeholder="Um texto apontando para formações  para ajudar pessoas perdidas" name="guideText" rows="3">${adminNewCategoryForm.guideText}</textarea>
               </div>
               <div class="form-group">
                   <label>Caminho do ícone</label>
                   <input value="${adminNewCategoryForm.pathImg}" placeholder="Por exemplo: /imagens/categorias" class="form-control" type="text" name="pathImg">
                   <form:errors path="adminNewCategoryForm.pathImg" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Cor em hexadecimal</label>
                   <input value="${adminNewCategoryForm.hexHtmlColor}" placeholder="Cor em hexadecimal da categoria" class="form-control" type="text" name="hexHtmlColor">
                   <form:errors path="adminNewCategoryForm.hexHtmlColor" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Descrição</label>
                   <input value="${adminNewCategoryForm.shortDescription}" placeholder="Por exemplo: iOS, Android, PhoneGap" class="form-control" type="text" name="shortDescription">
               </div>
               <input class="btn btn-success" type="submit" value="Enviar">
           </form>
       </div>
    </body>
</html>