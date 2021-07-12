package br.com.sunty.jdbc.dao;

import br.com.sunty.dto.CourseDTO;
import br.com.sunty.models.course.Course;
import br.com.sunty.models.course.CourseVisibility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    private Connection connection;

    public CourseDAO(Connection connection) {
        this.connection = connection;
    }

    public void saveCourse(Course course) throws SQLException {
        String sql = """
                    INSERT INTO course(`name`, urlCode, timeToFinishInHours, visibility, targetAudience, syllabus, developedSkills, instructor_id, sub_category_id) 
                    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);
                """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, course.getName());
            preparedStatement.setString(2, course.getUrlCode());
            preparedStatement.setInt(3, course.getTimeToFinishInHours());
            preparedStatement.setString(4, String.valueOf(course.getVisibility()));
            preparedStatement.setString(5, course.getTargetAudience());
            preparedStatement.setString(6, course.getSyllabus());
            preparedStatement.setString(7, course.getDevelopedSkills());
            preparedStatement.setLong(8, course.getInstructor().getId());
            preparedStatement.setLong(9, course.getSubCategory().getId());
            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                while (resultSet.next()) {
                    course.setId(resultSet.getLong(1));
                }
            }
        }

    }

    public void upgradeAllToPublicVisibility() throws SQLException {
        String sql = "UPDATE course SET visibility=?";
        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, String.valueOf(CourseVisibility.PUBLICA));
            pstm.execute();
        }
    }

    public void delete(String urlCode) throws SQLException {
        String sql = "DELETE FROM course WHERE urlCode = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, urlCode);
            preparedStatement.execute();
            System.out.println(preparedStatement.getUpdateCount());
        }
    }

    public List<CourseDTO> findPublicCourses() throws SQLException {
        List<CourseDTO> coursesDTO = new ArrayList<>();
        String sql = """
                        SELECT c.id, c.name, c.timeToFinishInHours, s.id sub_category_id, s.name sub_category_name, i.name instructor_name FROM course c
                        JOIN instructor i ON c.instructor_id = i.id
                        JOIN sub_category s ON c.sub_category_id = s.id
                        WHERE visibility = 'PUBLICA';
                """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.execute();
            try (ResultSet resultSet = preparedStatement.getResultSet()) {
                while (resultSet.next()) {
                    CourseDTO courseDTO = new CourseDTO(
                            resultSet.getLong("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("timeToFinishInHours"),
                            resultSet.getLong("sub_category_id"),
                            resultSet.getString("sub_category_name"),
                            resultSet.getString("instructor_name")
                    );
                    coursesDTO.add(courseDTO);
                }
            }
        }
        return coursesDTO;
    }
}
