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

@WebServlet(name = "desativarCategoria", value = "/desativarCategoria")
public class InactivateCategoryFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager entityManager = JPAUtil.getEntityManager();
        CategoryDao categoryDao = new CategoryDao(entityManager);

        Long id = Long.valueOf(req.getParameter("id"));
        Category category = categoryDao.findById(id);
        req.setAttribute("category", category);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/views/inactivateCategoryForm.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager entityManager = JPAUtil.getEntityManager();
        CategoryDao categoryDao = new CategoryDao(entityManager);

        Long id = Long.valueOf(req.getParameter("id"));

        Category category = categoryDao.findById(id);
        category.setActive(false);

        entityManager.getTransaction().begin();
        categoryDao.update(category);
        entityManager.getTransaction().commit();
        entityManager.close();

        req.setAttribute("category", category);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/views/categoryUpdatedSuccess.jsp");
        requestDispatcher.forward(req, resp);
    }
}
