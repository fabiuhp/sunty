package br.com.sunty.tests;

import br.com.sunty.dao.CategoryDao;
import br.com.sunty.dao.CourseDao;
import br.com.sunty.dao.SubCategoryDao;
import br.com.sunty.models.category.Category;
import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.course.Course;
import br.com.sunty.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;

public class HtmlPageGenerator {
    public static void main(String[] args) throws FileNotFoundException {
        EntityManager entityManager = JPAUtil.getEntityManager();
        generate(entityManager);
    }

    private static void generate(EntityManager entityManager) throws FileNotFoundException {
        CourseDao courseDao = new CourseDao(entityManager);
        List<Course> courses = courseDao.findAllByVisibilityIsPublic();

        CategoryDao categoryDao = new CategoryDao(entityManager);
        List<Category> categories = categoryDao.findAllByIsActiveIsTrueOrderByOrderToShowAsc();

        SubCategoryDao subCategoryDao = new SubCategoryDao(entityManager);
        List<SubCategory> subCategoryActive = subCategoryDao.findAllByIsActiveIsTrueOrderByOrderToShowAsc();
        List<SubCategory> subCategoryWithoutDescription = subCategoryDao.withoutDescription();

        File file = new File("paginaSemana5.html");

        try (PrintStream printStream = new PrintStream(file)){
            printStream.println("""
                    <html>
                        <head>
                            <meta charset="utf-8">
                            <title>Página da Semana 5</title>
                            <style>
                                .center {
                                  text-align: center;
                                }
                            </style>
                            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
                        </head>
                        <body>
                            <h1 class="center">Categorias ativas ordenadas</h1>
                            <br>
                            <table class="table table-striped">
                                <tr>
                                    <th>Id</th>
                                    <th>Nome</th>
                                    <th>Urlcode</th>
                                    <th>Descrição</th>
                                    <th>Ordem</th>
                                    <th>Cor</th>
                                </tr>
                """);

            categories.forEach(category -> printStream.println("<tr>" +
                    "<td>" + category.getId() + "</td>" +
                    "<td>" + category.getName() + "</td>" +
                    "<td>" + category.getUrlCode() + "</td>" +
                    "<td>" + category.getShortDescription() + "</td>" +
                    "<td>" + category.getOrderToShow() + "</td>" +
                    "<td style=\"background-color:"+ category.getHexHtmlColor() +"\">" + category.getHexHtmlColor() + "</td>" +
                    "</tr>"));
            printStream.println("</table><br>");

            printStream.println("""
                    <h1 class="center">Subcategorias ativas ordenadas</h1>
                    <br>
                    <table class="table table-striped">
                        <tr>
                            <th>Id</th>
                            <th>Nome</th>
                            <th>Urlcode</th>
                            <th>Descrição</th>
                            <th>Ordem</th>
                        </tr>
                """);

            subCategoryActive.forEach(subCategory -> printStream.println("<tr>" +
                    "<td>" + subCategory.getId() + "</td>" +
                    "<td>" + subCategory.getName() + "</td>" +
                    "<td>" + subCategory.getUrlCode() + "</td>" +
                    "<td>" + subCategory.getShortDescription() + "</td>" +
                    "<td>" + subCategory.getOrderToShow() + "</td>" +
                    "</tr>"));
            printStream.println("</table><br>");

            printStream.println("""
                    <h1 class="center">Todos os cursos públicos</h1>
                    <br>
                    <table class="table table-striped">
                        <tr>
                            <th>Id</th>
                            <th>Nome</th>
                            <th>Urlcode</th>
                            <th>Tempo conclusão</th>
                        </tr>
                """);

            courses.forEach(course -> printStream.println("<tr>" +
                    "<td>" + course.getId() + "</td>" +
                    "<td>" + course.getName() + "</td>" +
                    "<td>" + course.getUrlCode() + "</td>" +
                    "<td>" + course.getTimeToFinishInHours() + "</td>" +
                    "</tr>"));
            printStream.println("</table><br>");

            printStream.println("""
                    <h1 class="center">Subcategorias sem descrição</h1>
                    <br>
                    <table class="table table-striped">
                        <tr>
                            <tr>
                            <th>Id</th>
                            <th>Nome</th>
                            <th>Urlcode</th>
                            <th>Descrição</th>
                            <th>Ordem</th>
                        </tr>
                        </tr>
                """);

            subCategoryWithoutDescription.forEach(subCategory -> printStream.println("<tr>" +
                    "<td>" + subCategory.getId() + "</td>" +
                    "<td>" + subCategory.getName() + "</td>" +
                    "<td>" + subCategory.getUrlCode() + "</td>" +
                    "<td>" + subCategory.getShortDescription() + "</td>" +
                    "<td>" + subCategory.getOrderToShow() + "</td>" +
                    "</tr>"));
            printStream.println("</table><br>");

            printStream.println("""
                <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
                </body>
                </html>
                """);
        }
    }
}
