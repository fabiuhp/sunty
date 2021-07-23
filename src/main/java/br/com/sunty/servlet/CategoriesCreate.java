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

@WebServlet(name = "novaCategoria", value = "/novaCategoria")
public class CategoriesCreate extends HttpServlet {
    EntityManager entityManager = JPAUtil.getEntityManager();
    CategoryDao categoryDao = new CategoryDao(entityManager);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Category category = new Category(req.getParameter("name"), req.getParameter("urlCode"));
        entityManager.getTransaction().begin();
        categoryDao.create(category);
        entityManager.getTransaction().commit();
        req.setAttribute("category", category);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/categoryCreatedSuccess.jsp");
        requestDispatcher.forward(req, resp);
    }
}
