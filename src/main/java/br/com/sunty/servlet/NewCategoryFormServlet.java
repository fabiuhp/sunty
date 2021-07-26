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

@WebServlet(name = "novaCategoria", value = "/novaCategoria")
public class NewCategoryFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/views/newCategoryForm.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager entityManager = JPAUtil.getEntityManager();
        CategoryDao categoryDao = new CategoryDao(entityManager);

        Category category = new Category(req.getParameter("name"), req.getParameter("urlCode"));
        entityManager.getTransaction().begin();
        categoryDao.create(category);
        entityManager.getTransaction().commit();
        entityManager.close();

//        resp.sendRedirect("/listaCategorias");
        req.setAttribute("category", category);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/views/categoryCreatedSuccess.jsp");
        requestDispatcher.forward(req, resp);
    }
}
