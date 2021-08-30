<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Lista de categorias</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
    </head>
    <body>
       <div class="container cont">
           <h1 class="spacing">Editar subcategoria</h1>
           <form action="/admin/subcategories/{categoryCode}/{subcategoryCode}" method="post">
               <input type="hidden" name="id" value="${adminEditSubCategoryForm.id}">
               <div class="form-group">
                   <label>Nome</label>
                   <input placeholder="Digite aqui o nome da subcategoria" class="form-control" type="text" name="name"  value="${adminEditSubCategoryForm.name}">
                   <form:errors path="adminEditSubCategoryForm.name" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Código</label>
                   <input placeholder="Por exemplo: desenvolvimento, mobile (não use letras maiúsculas, acentos ou caracteres especiais)" class="form-control" type="text" name="urlCode" value="${adminEditSubCategoryForm.urlCode}">
                   <form:errors path="adminEditSubCategoryForm.urlCode" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Ativo?</label>
                   <select class="form-control" name="active" >
                       <option value="true" ${adminEditSubCategoryForm.active ? 'selected' : ''}>Ativo</option>
                       <option value="false" ${adminEditSubCategoryForm.active ? '' : 'selected'}>Inativo</option>
                   </select>
                   <form:errors path="adminEditSubCategoryForm.active" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Ordem</label>
                   <input placeholder="Ordem da subcategoria" class="form-control" type="number" name="orderToShow" value="${adminEditSubCategoryForm.orderToShow}">
                   <form:errors path="adminEditSubCategoryForm.orderToShow" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Guia de estudo</label>
                   <textarea class="form-control" placeholder="Um texto apontando para formações  para ajudar pessoas perdidas" name="guideText" rows="3">${adminEditSubCategoryForm.guideText}</textarea>
               </div>
               <div class="form-group">
                   <label>Descrição</label>
                   <input placeholder="Por exemplo: iOS, Android, PhoneGap" class="form-control" type="text" name="shortDescription" value="${adminEditSubCategoryForm.shortDescription}">
               </div>
               <div class="form-group">
                   <label for="category">Categoria</label>
                   <select id="category" class="form-control" name="categoryId">
                           <option value="${adminEditSubCategoryForm.categoryId}">${adminEditSubCategoryForm.categoryName}</option>
                   </select>
               </div>
               <input class="btn btn-success" type="submit" value="Enviar">
           </form>
       </div>
      </body>
</html>