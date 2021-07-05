package br.com.sunty.receiveandcreate;

import br.com.sunty.models.category.Category;
import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.course.Course;
import br.com.sunty.models.instructor.Instructor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SqlCreator {

    public static void main(String[] args) throws FileNotFoundException {
        CategoryCSVReader categoryCSVReader = new CategoryCSVReader();
        List<Category> categoryList = categoryCSVReader.readerCsv("Categoria.csv");
        Map<String, Category> categoryMap = categoryList.stream().collect(Collectors.toMap(Category::getUrlCode, Function.identity()));

        SubCategoryCSVReader subCategoryCSVReader = new SubCategoryCSVReader();
        List<SubCategory> subCategoryList = subCategoryCSVReader.readerCsv(categoryMap, "SubCategoria.csv");
        Map<String, SubCategory> subCategoryMap = subCategoryList.stream().collect(Collectors.toMap(SubCategory::getUrlCode, Function.identity()));

        CourseCSVReader courseCSVReader = new CourseCSVReader();
        List<Course> courseList = courseCSVReader.readerCsv(subCategoryMap, "Curso.csv");

        File file = new File("generatedScript.sql");
        PrintStream printStream = new PrintStream(file);

        for (Category category : categoryList) {
            printStream.println(
                    "INSERT INTO category(`name`, urlCode, shortDescription, guideText, isActive, `order`, pathImg, hexHtmlColor) " +
                            "VALUES(" +
                            "'" + category.getName() + "'," +
                            "'" + category.getUrlCode() + "'," +
                            "'" + category.getShortDescription() + "'," +
                            "'" + category.getGuideText() + "'," +
                            category.getActiveAsNumber() + "," +
                            category.getOrder() + "," +
                            "'" + category.getPathImg() + "'," +
                            "'" + category.getHexHtmlColor() + "');"
            );
        }

        for (SubCategory subCategory : subCategoryList) {
            printStream.println(
                    "INSERT INTO sub_category(`name`, urlCode, shortDescription, guideText, isActive, `order`, category_id) " +
                            "SELECT '" + subCategory.getName() +"', '" +
                            subCategory.getUrlCode() + "', '" +
                            subCategory.getShortDescription() + "', '" +
                            subCategory.getGuideText() + "', " +
                            subCategory.getActiveAsNumber() + ", " +
                            subCategory.getOrder() + ", " +
                            "id from category where urlCode = '" + subCategory.getCategory().getUrlCode() + "';"
            );
        }

        //Ponto de atenção: será necessário refatorar quando for inserir dados de instrutor.
        //Por enquanto não é necessário.
        printStream.println("INSERT INTO instructor(`name`) VALUES('Fábio');");

        for (Course course : courseList) {
            printStream.println(
                    "INSERT INTO course(`name`, urlCode, timeToFinishInHours, visibility, targetAudience, syllabus, developedSkills, instructor_id, sub_category_id) " +
                            "SELECT '" + course.getName() +"', '" +
                            course.getUrlCode() + "', " +
                            course.getTimeToFinishInHours() + ", '" +
                            course.getVisibility() + "', '" +
                            course.getTargetAudience() + "', '" +
                            course.getSyllabus() + "', '" +
                            course.getDevelopedSkills() + "', " +
                            1 +
                            ", id from sub_category where urlCode = '" + course.getSubCategory().getUrlCode() + "';"
            );
        }
    }
}
