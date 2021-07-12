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

public class CriarCurso {
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
        Category category = new Category("Funcional", "funcional");
        category.setId(5L);
        SubCategory subCategory = new SubCategory("funcionalsub", "subfuncional", category);
        subCategory.setId(5L);
        Course course1 = new Course("Programação Funcional", "prog-func", 10, CourseVisibility.PRIVADA, "Eu sou o foco", instructor, "O syllabus", "skills", subCategory);
        return course1;
    }
}
