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

@WebServlet(name = "editarCategoria", value = "/editarCategoria")
public class EditCategoryFormServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager entityManager = JPAUtil.getEntityManager();
        CategoryDao categoryDao = new CategoryDao(entityManager);

        Long id = Long.valueOf(req.getParameter("id"));
        Category category = categoryDao.findById(id);
        req.setAttribute("category", category);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/views/editCategoryForm.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        EntityManager entityManager = JPAUtil.getEntityManager();
        CategoryDao categoryDao = new CategoryDao(entityManager);

        Long id = Long.valueOf(req.getParameter("id"));

        Category category = categoryDao.findById(id);
        category.setName(req.getParameter("name"));
        category.setUrlCode(req.getParameter("urlCode"));

        entityManager.getTransaction().begin();
        categoryDao.update(category);
        entityManager.getTransaction().commit();
        entityManager.close();

        resp.sendRedirect("/listaCategorias");
    }
}