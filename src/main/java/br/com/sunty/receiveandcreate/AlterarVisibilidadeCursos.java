package br.com.sunty.receiveandcreate;

import br.com.sunty.jdbc.dao.CourseDAO;
import br.com.sunty.jdbc.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class AlterarVisibilidadeCursos {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recoveryConnection();
        CourseDAO courseDAO = new CourseDAO(connection);


        courseDAO.upgradeAllToPublicVisibility();
    }
}
