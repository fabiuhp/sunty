package br.com.sunty.tests;

import br.com.sunty.models.category.Category;
import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.activity.Explanation;
import br.com.sunty.models.activity.Question;
import br.com.sunty.models.activity.Video;
import br.com.sunty.models.activity.QuestionType;
import br.com.sunty.models.alternative.Alternative;
import br.com.sunty.models.course.Course;
import br.com.sunty.models.instructor.Instructor;
import br.com.sunty.models.section.Section;
import br.com.sunty.resources.CategoryCSVReader;
import br.com.sunty.resources.CourseCSVReader;
import br.com.sunty.resources.SubCategoryCSVReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Tests {
    public static void main(String[] args) {
        //Criar instrutor, categoria, curso e seção
        Instructor instructor1 = new Instructor("Fabio");
//        Instructor instructor1 = null;
//        Instructor instructor1 = new Instructor(1L, null);
//        Instructor instructor1 = new Instructor(null, "Fabio");

        Category category1 = new Category("Cursos de Java", "carreira-java");
//        Category category1 = new Category(null, "carreira-java");
//        Category category1 = new Category("Cursos de Java", null);
//        Category category1 = new Category("", "carreira-java");
//        Category category1 = new Category("Cursos de Java", "             ");

        SubCategory subCategory = new SubCategory("SubCategoria1", "java-subcateg", category1);

        Course curso1 = new Course("Java Basico", "java-basico", 2, instructor1, subCategory);
//        Course curso1 = new Course(1L, "Java Basico", null, 2, instructor1, category1);
//        Course curso1 = new Course(1L, "Java Basico", "", 2, instructor1, category1);
//        Course curso1 = new Course(1L, "Java Basico", "            ", 2, instructor1, category1);
//        Course curso1 = new Course(1L, "Java Basico", "java-basico", 2, null, category1);

        Section section1 = new Section("secao 1", "sec", curso1);

        //Criar vídeo
        Video video1 = new Video("Video inicial Java", "inicio-java", section1, "video-java");

        System.out.println(video1);
        video1.setTime(2);
        video1.setTranscription("Um video inicial sobre java");

        System.out.println(video1);

        //Criar questão
        Question question1 = new Question("O que significa POO?", "questao-poo", section1, "Pergunta 1", QuestionType.MULTIPLE_ANSWER);
        System.out.println(question1);

        //Criar explicação
        Explanation explanation1 = new Explanation("Explic 1", "explic", section1, "Texto da explicação.");
        System.out.println(explanation1);

        //Criar alternativa
        Alternative alternative1 = new Alternative("Explicacao 1 da alternativa", false, question1);
        Alternative alternative2 = new Alternative("Explicacao 2 da alternativa", true, question1);
        System.out.println(alternative1);
        System.out.println(alternative2);

        //Criar subcategoria
        SubCategory subCategory1 = new SubCategory("SubCategoria 1", "subcat-cde", category1);
        SubCategory subCategory2 = new SubCategory("SubCategoria 2", "subcat-abc", category1);
        System.out.println(subCategory1);
        System.out.println(subCategory2);

        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*--*-*-*-*-*--*--*-*--*-*-*-*--*-*");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*--*-*-*-*-*--*--*-*--*-*-*-*--*-*");

        CategoryCSVReader categoryCSVReader = new CategoryCSVReader();
        List<Category> categoryList = categoryCSVReader.readerCsv("planilha-dados-escola - Categoria.csv");

        Map<String, Category> categoryMap = categoryList.stream().collect(Collectors.toMap(Category::getName, Function.identity()));

        SubCategoryCSVReader subCategoryCSVReader = new SubCategoryCSVReader();
        List<SubCategory> subCategoryList = subCategoryCSVReader.readerCsv(categoryMap, "planilha-dados-escola - Subcategoria.csv");

        Map<String, SubCategory> subCategoryMap = subCategoryList.stream().collect(Collectors.toMap(SubCategory::getUrlCode, Function.identity()));

        CourseCSVReader courseCSVReader = new CourseCSVReader();
        List<Course> courseList = courseCSVReader.readerCsv(subCategoryMap, "planilha-dados-escola - Curso.csv");

    }
}
