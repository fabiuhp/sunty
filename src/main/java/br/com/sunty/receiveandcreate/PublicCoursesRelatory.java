package br.com.sunty.receiveandcreate;

import br.com.sunty.dto.CourseDTO;
import br.com.sunty.jdbc.dao.CourseDAO;
import br.com.sunty.jdbc.factory.ConnectionFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PublicCoursesRelatory {
    public static void main(String[] args) throws SQLException, FileNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recoveryConnection();
        CourseDAO courseDAO = new CourseDAO(connection);

        File file = new File("paginaCursosPublicos.html");
        PrintStream printStream = new PrintStream(file);

        List<CourseDTO> courses = courseDAO.findPublicCourses();

        printStream.println("""
                    <html>
                        <head>
                            <meta charset="utf-8">
                            <title>Página de Cursos Públicos</title>
                            <style>
                                .center {
                                  text-align: center;
                                }
                            </style>
                            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
                        </head>
                        <body>
                            <h1 class="center">Cursos públicos da plataforma Sunty</h1>
                            <br>
                            <table class="table table-striped">
                                <tr>
                                    <th>Id</th>
                                    <th>Nome</th>
                                    <th>Tempo de finalização(horas)</th>
                                    <th>Id SubCategoria</th>
                                    <th>Nome da SubCategoria</th>
                                </tr>
                """);

        for (CourseDTO course : courses) {
            printStream.println("<tr>" +
                    "<td>" + course.getId() + "</td>" +
                    "<td>" + course.getName() + "</td>" +
                    "<td>" + course.getTimeToFinishInHours() + "</td>" +
                    "<td>" + course.getSubCategoryId() + "</td>" +
                    "<td>" + course.getSubCategoryName() + "</td>" +
                    "</tr>");
        }
        printStream.println("""
                </table>
                <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
                </body>
                </html>
                """);
    }
}
