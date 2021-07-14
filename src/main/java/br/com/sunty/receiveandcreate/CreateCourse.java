package br.com.sunty.receiveandcreate;

import br.com.sunty.jdbc.dao.CourseDAO;
import br.com.sunty.jdbc.factory.ConnectionFactory;
import br.com.sunty.models.category.Category;
import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.course.Course;
import br.com.sunty.models.course.CourseVisibility;
import br.com.sunty.models.instructor.Instructor;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;

public class CreateCourse {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recoveryConnection();
        CourseDAO courseDAO = new CourseDAO(connection);

        Course cursoNovo = createCourse();
        courseDAO.saveCourse(cursoNovo);
    }

    private static Course createCourse() {
        Instructor instructor = new Instructor("Fábio");
        instructor.setId(1L);
        Category category = new Category("Programacao", "programacao");
        category.setId(1L);
        SubCategory subCategory = new SubCategory("Builds e Controle de versão", "builds-e-controle-de-versao", category);
        subCategory.setId(5L);
        return new Course("Curso novo", "novo-curso", 10, CourseVisibility.PRIVADA, "target audience", instructor, "O syllabus", "skills", subCategory);
    }
}
