package br.com.sunty.tests;

import br.com.sunty.models.Category.Category;
import br.com.sunty.models.Category.SubCategory.SubCategory;
import br.com.sunty.models.activity.Explanation;
import br.com.sunty.models.activity.Question;
import br.com.sunty.models.activity.Video;
import br.com.sunty.models.activity.utils.QuestionType;
import br.com.sunty.models.alternative.Alternative;
import br.com.sunty.models.course.Course;
import br.com.sunty.models.instructor.Instructor;
import br.com.sunty.models.section.Section;

public class Tests {
    public static void main(String[] args) {
        //Criar instrutor, categoria, curso e seção
        Instructor instructor1 = new Instructor(1L, "Fabio");
        Category category1 = new Category(1L, "Cursos de Java", "carreira-java");
        Course curso1 = new Course(1L, "Java Basico", "java-basico", 2, instructor1, category1);
        Section section1 = new Section(1L, "secao 1", "sec", curso1);

        //Criar vídeo
        Video video1 = new Video(1L, "Video inicial Java", "inicio-java", section1, "video-java");

        System.out.println(video1.toString());
        video1.setTime(2);
        video1.setTranscription("Um video inicial sobre java");

        System.out.println(video1.toString());

        //Criar questão
        Question question1 = new Question(1L, "O que significa POO?", "questao-poo", section1, "Pergunta 1", QuestionType.MULTIPLEANSWER);
        System.out.println(question1.toString());

        //Criar explicação
        Explanation explanation1 = new Explanation(1L, "Explic 1", "explic", section1, "Texto da explicação.");
        System.out.println(explanation1.toString());

        //Criar alternativa
        Alternative alternative1 = new Alternative(1L, "Explicacao 1 da alternativa", false, question1);
        Alternative alternative2 = new Alternative(2L, "Explicacao 2 da alternativa", true, question1);
        System.out.println(alternative1.toString());
        System.out.println(alternative2.toString());

        //Criar subcategoria
        SubCategory subCategory1 = new SubCategory(1L, "SubCategoria 1", "subcat-cde", category1);
        SubCategory subCategory2 = new SubCategory(2L, "SubCategoria 2", "subcat-abc", category1);
        System.out.println(subCategory1.toString());
        System.out.println(subCategory2.toString());
    }
}
