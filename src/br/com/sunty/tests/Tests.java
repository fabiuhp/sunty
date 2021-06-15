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

public class Tests {
    public static void main(String[] args) {
        //Criar instrutor, categoria, curso e seção
        Instructor instructor1 = new Instructor(1L, "Fabio");
//        Instructor instructor1 = null;
//        Instructor instructor1 = new Instructor(1L, null);
//        Instructor instructor1 = new Instructor(null, "Fabio");

        Category category1 = new Category("Cursos de Java", "carreira-java");
//        Category category1 = new Category(null, "carreira-java");
//        Category category1 = new Category("Cursos de Java", null);
//        Category category1 = new Category("", "carreira-java");
//        Category category1 = new Category("Cursos de Java", "             ");

//        Course curso1 = new Course(1L, "Java Basico", "java-basico", 2, instructor1, category1);
//        Course curso1 = new Course(1L, "Java Basico", null, 2, instructor1, category1);
//        Course curso1 = new Course(1L, "Java Basico", "", 2, instructor1, category1);
        Course curso1 = new Course(1L, "Java Basico", "            ", 2, instructor1, category1);
//        Course curso1 = new Course(1L, "Java Basico", "java-basico", 2, null, category1);

        Section section1 = new Section(1L, "secao 1", "sec", curso1);

        //Criar vídeo
        Video video1 = new Video(1L, "Video inicial Java", "inicio-java", section1, "video-java");

        System.out.println(video1);
        video1.setTime(2);
        video1.setTranscription("Um video inicial sobre java");

        System.out.println(video1);

        //Criar questão
        Question question1 = new Question(1L, "O que significa POO?", "questao-poo", section1, "Pergunta 1", QuestionType.MULTIPLE_ANSWER);
        System.out.println(question1);

        //Criar explicação
        Explanation explanation1 = new Explanation(1L, "Explic 1", "explic", section1, "Texto da explicação.");
        System.out.println(explanation1);

        //Criar alternativa
        Alternative alternative1 = new Alternative(1L, "Explicacao 1 da alternativa", false, question1);
        Alternative alternative2 = new Alternative(2L, "Explicacao 2 da alternativa", true, question1);
        System.out.println(alternative1);
        System.out.println(alternative2);

        //Criar subcategoria
        SubCategory subCategory1 = new SubCategory(1L, "SubCategoria 1", "subcat-cde", category1);
        SubCategory subCategory2 = new SubCategory(2L, "SubCategoria 2", "subcat-abc", category1);
        System.out.println(subCategory1);
        System.out.println(subCategory2);
    }
}
