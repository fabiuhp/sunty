<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Nova subcategoria</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
    </head>
    <body>
       <div class="container cont">
           <h1 class="spacing">Nova Subcategoria</h1>
           <form action="/admin/subcategories" method="post">
               <div class="form-group">
                   <label>Nome</label>
                   <input value="${adminNewSubCategoryForm.name}" placeholder="Digite aqui o nome da subcategoria" class="form-control" type="text" name="name">
                   <form:errors path="adminNewSubCategoryForm.name" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Código</label>
                   <input value="${adminNewSubCategoryForm.urlCode}" placeholder="Por exemplo: desenvolvimento, mobile (não use letras maiúsculas, acentos ou caracteres especiais)" class="form-control" type="text" name="urlCode">
                   <form:errors path="adminNewSubCategoryForm.urlCode" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Ativo?</label>
                   <select class="form-control" name="active">
                       <option value="Selecione">Selecione</option>
                       <option value="true" selected="selected">Ativo</option>
                       <option value="false">Inativo</option>
                   </select>
                   <form:errors path="adminNewSubCategoryForm.active" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Ordem</label>
                   <input value="${adminNewSubCategoryForm.orderToShow}" placeholder="Ordem da subcategoria" class="form-control" type="number" name="orderToShow">
                   <form:errors path="adminNewSubCategoryForm.orderToShow" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Guia de estudo</label>
                   <textarea class="form-control" placeholder="Um texto apontando para formações  para ajudar pessoas perdidas" name="guideText" rows="3">${adminNewSubCategoryForm.name}</textarea>
               </div>
               <div class="form-group">
                   <label>Descrição</label>
                   <input value="${adminNewSubCategoryForm.shortDescription}" placeholder="Por exemplo: iOS, Android, PhoneGap" class="form-control" type="text" name="shortDescription">
               </div>
               <div class="form-group">
                   <label for="category">Categoria</label>
                   <select id="category" class="form-control" name="categoryId">
                       <c:forEach items="${categories}" var="category">
                           <option value="${category.id}">${category.name}</option>
                       </c:forEach>
                   </select>
               </div>

               <input class="btn btn-success" type="submit" value="Enviar">
           </form>
       </div>
    </body>
</html>