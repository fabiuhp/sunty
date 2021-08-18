<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Novo curso</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
    </head>
    <body>
       <div class="container cont">
           <h1 class="spacing">Novo curso</h1>
           <form action="/admin/courses" method="post">
               <div class="form-group">
                   <label>Nome</label>
                   <input value="${adminNewCourseForm.name}" placeholder="Digite aqui o nome do curso" class="form-control" type="text" name="name">
                   <form:errors path="adminNewCourseForm.name" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Código</label>
                   <input value="${adminNewCourseForm.urlCode}" placeholder="Por exemplo: desenvolvimento, mobile (não use letras maiúsculas, acentos ou caracteres especiais)" class="form-control" type="text" name="urlCode">
                   <form:errors path="adminNewCourseForm.urlCode" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Tempo para finalização</label>
                   <input value="${adminNewCourseForm.timeToFinishInHours}" placeholder="Tempo para finalização do curso" class="form-control" type="number" name="timeToFinishInHours">
                   <form:errors path="adminNewCourseForm.timeToFinishInHours" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Visibilidade</label>
                   <select class="form-control" name="visibility">
                       <option value="PUBLICA" selected="selected">Pública</option>
                       <option value="PRIVADA">Privada</option>
                   </select>
               </div>
               <div class="form-group">
                   <label>Público alvo</label>
                   <textarea class="form-control" placeholder="Um texto apontando para formações  para ajudar pessoas perdidas" name="targetAudience" rows="3">${adminNewCourseForm.targetAudience}</textarea>
               </div>
               <div class="form-group">
                   <label for="instructor">Instrutor</label>
                   <select id="instructor" class="form-control" name="instructorId">
                       <c:forEach items="${instructors}" var="instructor">
                           <option value="${instructor.id}">${instructor.name}</option>
                       </c:forEach>
                   </select>
               </div>
               <div class="form-group">
                   <label>Ementa</label>
                   <textarea class="form-control" placeholder="Um texto apontando para formações  para ajudar pessoas perdidas" name="syllabus" rows="3">${adminNewSubCategoryForm.name}</textarea>
               </div>
               <div class="form-group">
                   <label>Habilidades desenvolvidas</label>
                   <textarea class="form-control" placeholder="Um texto apontando para formações  para ajudar pessoas perdidas" name="developedSkills" rows="3">${adminNewSubCategoryForm.name}</textarea>
               </div>
               <div class="form-group">
                   <label for="subcategory">SubCategoria</label>
                   <select id="subcategory" class="form-control" name="subCategoryId">
                       <c:forEach items="${subCategories}" var="subcategory">
                           <option value="${subcategory.id}">${subcategory.name}</option>
                       </c:forEach>
                   </select>
               </div>
               <input class="btn btn-success" type="submit" value="Enviar">
           </form>
       </div>
    </body>
</html>