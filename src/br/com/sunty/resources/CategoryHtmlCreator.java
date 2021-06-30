package br.com.sunty.resources;

import br.com.sunty.models.category.Category;
import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.course.Course;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CategoryHtmlCreator {

    public static void main(String[] args) throws FileNotFoundException {
        CategoryCSVReader categoryCSVReader = new CategoryCSVReader();
        List<Category> categoryList = categoryCSVReader.readerCsv("Categoria.csv");
        Map<String, Category> categoryMap = categoryList.stream().collect(Collectors.toMap(Category::getUrlCode, Function.identity()));

        SubCategoryCSVReader subCategoryCSVReader = new SubCategoryCSVReader();
        List<SubCategory> subCategoryList = subCategoryCSVReader.readerCsv(categoryMap, "SubCategoria.csv");
        Map<String, SubCategory> subCategoryMap = subCategoryList.stream().collect(Collectors.toMap(SubCategory::getUrlCode, Function.identity()));

        CourseCSVReader courseCSVReader = new CourseCSVReader();
        List<Course> courseList = courseCSVReader.readerCsv(subCategoryMap, "Curso.csv");

        File file = new File("categories.html");
        PrintStream printStream = new PrintStream(file);

        printStream.println(""" 
                <html>
                <head>
                <meta charset="utf-8">
                <title>Página de Categorias</title>
                <style>
                table, th, td {
                  border: 1px solid black;
                }
                th, td {
                  text-align:center;
                }
                th {
                    background-color: #149ce6;
                    color: white;
                }
                </style>
                </head>
                <body>
                <h1>Categorias da plataforma Sunty</h1>
                <table>
                <tr>
                <th>Nome</th>
                <th>Descrição</th>
                <th>Ícone</th>
                <th>Cor</th>
                <th>Número de cursos</th>
                <th>Total de horas dos cursos</th>
                <th>Subcategorias</th>
                </tr>
                """);

        for (Category category : categoryList) {
            printStream.println("<tr>" +
                    "<td>" + category.getName() + "</td>" +
                    "<td>" + category.getShortDescription() + "</td>" +
                    "<td>" + category.getPathImg() + "</td>" +
                    "<td>" + category.getHexHtmlColor() + "</td>" +
                    "<td>" + category.getCoursesQuantity() + "</td>" +
                    "<td>" + category.getTotalTimeToFinishAnHours() + "</td>" +
                    "<td>");
            for (SubCategory subCategory : category.getSubCategoryList()) {
                printStream.print(subCategory.getName() + "<br><br>");
                printStream.println(subCategory.getShortDescription());
                printStream.println("<br><hr>");
            }
            printStream.println("</td>");
            printStream.println("</tr>");
        }
        printStream.println("</table>");
        printStream.println("</body>");
        printStream.println("</html>");
    }
}
