package br.com.sunty.jdbc.dao;

import br.com.sunty.jdbc.dao.exceptions.DaoException;
import br.com.sunty.jdbc.factory.ConnectionFactory;
import br.com.sunty.models.category.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    public static void main(String[] args) throws Exception {
        try(Connection connection = new ConnectionFactory().recoveryConnection()) {
            CategoryDAO categoryDAO = new CategoryDAO(connection);
            List<Category> categories = categoryDAO.list();
            categories.forEach(System.out::println);
        }
    }

    private Connection connection;

    public CategoryDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Category> list() {
            List<Category> categories = new ArrayList<>();
            String sql = "SELECT `name`, urlCode FROM category";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        String name = resultSet.getString("name");
                        String urlCode = resultSet.getString("urlCode");
                        Category category = new Category(name, urlCode);
                        categories.add(category);
                    }
            } catch (SQLException e) {
                throw new DaoException(e.getMessage());
            }
            return categories;
    }
}
