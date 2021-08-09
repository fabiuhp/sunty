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
           <h1 class="spacing">Editar categoria</h1>
           <form action="/admin/categories/${category.urlCode}" method="post">
               <input type="hidden" name="id" value="${category.id}">
               <div class="form-group">
                   <label>Nome</label>
                   <input placeholder="Nome da categoria" class="form-control" type="text" name="name" value="${category.name}">
                   <form:errors path="category.name" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Código</label>
                   <input placeholder="Código da categoria" class="form-control" type="text" name="urlCode" value="${category.urlCode}">
                   <form:errors path="category.urlCode" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Descrição breve</label>
                   <input placeholder="Descrição breve da categoria" class="form-control" type="text" name="shortDescription" value="${category.shortDescription}">
               </div>
               <div class="form-group">
                   <label>Ativo?</label>
                   <select class="form-control" name="active" >
                       <option value="Selecione">Selecione</option>
                       <option value="true" ${category.active ? 'selected' : ''}>Ativo</option>
                       <option value="false" ${category.active ? '' : 'selected'}>Inativo</option>
                   </select>
                   <form:errors path="category.active" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Cor em hexadecimal</label>
                   <input placeholder="Cor da categoria em hexadecimal" class="form-control" type="text" name="hexHtmlColor" value="${category.hexHtmlColor}">
                   <form:errors path="category.hexHtmlColor" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Ordem</label>
                   <input placeholder="Ordem da categoria" class="form-control" type="text" name="orderToShow"  value="${category.orderToShow}">
                   <form:errors path="category.orderToShow" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Local da imagem</label>
                   <input placeholder="Local da imagem da categoria" class="form-control" type="text" name="pathImg" value="${category.pathImg}">
                   <form:errors path="category.pathImg" cssClass="text-danger"/>
               </div>
               <input class="btn btn-success" type="submit" value="Enviar">
           </form>
       </div>
      </body>
</html>