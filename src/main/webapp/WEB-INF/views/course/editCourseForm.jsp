<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Cursos</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
    </head>
    <body>
       <div class="container cont">
           <h1 class="spacing">Editar curso</h1>
           <form action="/admin/courses/${category}/${subcategory}/${adminEditCourseForm.urlCode}" method="post">
               <input type="hidden" name="id" value="${adminEditCourseForm.id}">
               <div class="form-group">
                   <label>Nome</label>
                   <input value="${adminEditCourseForm.name}" placeholder="Digite aqui o nome do curso" class="form-control" type="text" name="name">
                   <form:errors path="adminEditCourseForm.name" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Código</label>
                   <input value="${adminEditCourseForm.urlCode}" placeholder="Por exemplo: desenvolvimento, mobile (não use letras maiúsculas, acentos ou caracteres especiais)" class="form-control" type="text" name="urlCode">
                   <form:errors path="adminEditCourseForm.urlCode" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Tempo para finalização</label>
                   <input value="${adminEditCourseForm.timeToFinishInHours}" placeholder="Tempo para finalização do curso" class="form-control" type="number" name="timeToFinishInHours">
                   <form:errors path="adminEditCourseForm.timeToFinishInHours" cssClass="text-danger"/>
               </div>
               <div class="form-group">
                   <label>Visibilidade</label>
                   <select class="form-control" name="visibility">
                       <option value="PUBLICA" ${adminEditCourseForm.visibility == 'PUBLICA' ? 'selected' : ''}>Pública</option>
                       <option value="PRIVADA" ${adminEditCourseForm.visibility == 'PRIVADA' ? '' : 'selected'}>Privada</option>
                   </select>
               </div>
               <div class="form-group">
                   <label>Público alvo</label>
                   <textarea class="form-control" placeholder="Um texto apontando para formações  para ajudar pessoas perdidas" name="targetAudience" rows="3">${adminEditCourseForm.targetAudience}</textarea>
               </div>
               <div class="form-group">
                   <label for="instructor">Instrutor</label>
                   <select id="instructor" class="form-control" name="instructorId">
                       <c:forEach items="${instructors}" var="instr">
                           <option value="${instr.id}" ${instr.id == adminEditCourseForm.id ? 'selected' : ''}>${instr.name}</option>
                       </c:forEach>
                   </select>
               </div>
               <div class="form-group">
                   <label>Ementa</label>
                   <textarea class="form-control" placeholder="Um texto apontando para formações  para ajudar pessoas perdidas" name="syllabus" rows="3">${adminEditCourseForm.syllabus}</textarea>
               </div>
               <div class="form-group">
                   <label>Habilidades desenvolvidas</label>
                   <textarea class="form-control" placeholder="Um texto apontando para formações  para ajudar pessoas perdidas" name="developedSkills" rows="3">${adminEditCourseForm.developedSkills}</textarea>
               </div>
               <div class="form-group">
                   <label for="subcategory">SubCategoria</label>
                   <select id="subcategory" class="form-control" name="subCategoryId">
                       <c:forEach items="${subCategories}" var="sc">
                           <option value="${sc.id}" ${sc.id == adminEditCourseForm.id ? 'selected' : ''}>${sc.name}</option>
                       </c:forEach>
                   </select>
               </div>
               <input class="btn btn-success" type="submit" value="Enviar">
           </form>
       </div>
      </body>
</html>