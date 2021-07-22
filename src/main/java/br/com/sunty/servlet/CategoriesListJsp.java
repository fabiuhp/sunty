package br.com.sunty.servlet;

import br.com.sunty.dao.CategoryDao;
import br.com.sunty.models.category.Category;
import br.com.sunty.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "listaCategorias", value = "/listaCategorias")
public class CategoriesListJsp extends HttpServlet {
    EntityManager entityManager = JPAUtil.getEntityManager();
    CategoryDao categoryDao = new CategoryDao(entityManager);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = categoryDao.findAll();
        req.setAttribute("categories", categories);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/categoriesList.jsp");
        requestDispatcher.forward(req, resp);
    }
}
